package com.farsiman.sistema_de_viajes.view;

import com.farsiman.sistema_de_viajes.controller.*;
import com.farsiman.sistema_de_viajes.model.*;
import java.awt.Color;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Component
public class RegistrarViajesView extends javax.swing.JFrame {

    @Autowired
    SucursalController sucursalControl;
    @Autowired
    ColaboradorController colaboradorControl;
    @Autowired
    TransportistaController transportistaControl;
    @Autowired
    SucursalColaboradorController sucursalColaboradorControl;
    @Autowired
    ViajeController viajeControl;
    @Autowired
    ApplicationContext context; // contenedor para inyectar las clases Views dentro del contexto de Spring
    @Autowired
    private Usuario usuarioSession;// variable para manejar sesion de usuario

    //Se crea la variable local ya que cada ves que ocurre el evento de seleccion en la tabla de colaboradores el codigo se reinica.
    double kmsAcumulados = 0.0;

    DefaultTableModel tableModelColaboradoresSucursal = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tableModelColaboradoresSeleccionados = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public RegistrarViajesView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioSession = usuario;
        // Inicializa la vista usando el usuario
        initView();
    }

    private void initView() {
        //reseteo de datos para cada LogOut
        sucursalesCmb.removeAllItems();
        configureSucursalesComboBox();
        configureTransportistasComboBox();
        configureColaboradoresTableModel();
        configureColaboradoresSeleccionadosTableModel();

        if (usuarioSession == null) {
            throw new IllegalStateException("UsuarioSession no ha sido inyectado.");
        }
        usuarioTxtField.setText(usuarioSession.getNombre());

    }

    private void configureSucursalesComboBox() {
        List<Sucursal> listSucursales = sucursalControl.getSucursales();

        for (Sucursal sucursal : listSucursales) {
            sucursalesCmb.addItem(sucursal.getNombre());
        }
    }

    private void configureTransportistasComboBox() {
        List<Transportista> listTransportistas = transportistaControl.getTransportistas();

        for (Transportista transportista : listTransportistas) {
            transportistaCmb.addItem(transportista.getNombre());
        }
    }

    private void configureColaboradoresTableModel() {
        tableModelColaboradoresSucursal.setColumnCount(0);
        tableModelColaboradoresSucursal.setRowCount(0);

        JTableHeader header = colaboradoresTable.getTableHeader();
        header.setBackground(Color.gray);
        colaboradoresTable.setForeground(Color.white);
        tableModelColaboradoresSucursal.addColumn("Id");
        tableModelColaboradoresSucursal.addColumn("Kms de Distancia");
        tableModelColaboradoresSucursal.addColumn("Colaborador nombre");
        tableModelColaboradoresSucursal.addColumn("Colaborador Id");

        colaboradoresTable.setModel(tableModelColaboradoresSucursal);
    }

    private void configureColaboradoresSeleccionadosTableModel() {
        tableModelColaboradoresSeleccionados.setColumnCount(0);
        tableModelColaboradoresSeleccionados.setRowCount(0);

        JTableHeader header = colaboradoresSeleccionadostable.getTableHeader();
        header.setBackground(Color.gray);
        colaboradoresSeleccionadostable.setForeground(Color.white);
        tableModelColaboradoresSeleccionados.addColumn("Id");
        tableModelColaboradoresSeleccionados.addColumn("Nombre");
        tableModelColaboradoresSeleccionados.addColumn("Apellido");

        colaboradoresSeleccionadostable.setModel(tableModelColaboradoresSeleccionados);
    }

    private void showMessage(String message, String type, String title) {
        JOptionPane optionPane = new JOptionPane(message);
        if (type.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (type.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    private double validarKilometros(String kmsText) {
        if (kmsText != null && !kmsText.isEmpty()) {
            try {
                return Double.parseDouble(kmsText);
            } catch (NumberFormatException e) {
                showMessage("Formato de kilómetros inválido", "Error", "Kilómetros inválido");
                return -1;
            }
        } else {
            showMessage("El campo de kilómetros está vacío", "Error", "Kilómetros inválido");
            return -1;
        }
    }

    private Transportista asignarTransportista() {
        String nombreTransportista = String.valueOf(transportistaCmb.getSelectedItem());
        if (nombreTransportista != null) {
            return transportistaControl.getTransportista(nombreTransportista);
        } else {
            showMessage("No se ha seleccionado ningun transportista", "Error", "Transportista null");
            return null;
        }
    }

    private SucursalColaborador asignarSucursal() {
        String nombreSucursal = String.valueOf(sucursalesCmb.getSelectedItem());
        if (nombreSucursal != null) {
            return sucursalColaboradorControl.getSucursalColaborador(nombreSucursal);
        } else {
            showMessage("No se ha seleccionado ninguna sucursal", "Error", "Sucursal null");
            return null;
        }
    }

    private List<Colaborador> obtenerColaboradoresSeleccionados() {
        List<Long> listIdColaboradores = new ArrayList<>();
        for (int i = 0; i < colaboradoresSeleccionadostable.getRowCount(); i++) {
            Long idColaborador = (Long) colaboradoresSeleccionadostable.getValueAt(i, 0);
            listIdColaboradores.add(idColaborador);
        }
        return colaboradorControl.getColaboradores(listIdColaboradores);
    }

    private boolean validarDisponibilidadTransportista(Date fecha, Transportista transportista) {
        boolean isViajeTransportistaSameDate = viajeControl.isTransportistaAvailable(fecha, transportista);
        if (!isViajeTransportistaSameDate) {
            showMessage("El transportista ya tiene un viaje registrado en esta fecha", "Error", "Viaje duplicado");
            return false;
        }
        return true;
    }

    private boolean validarDisponibilidadColaboradores(Date fecha, List<Colaborador> listColaboradoresTotalViaje) {
        boolean isColaboradorInViajeSameDate = viajeControl.isColaboradorAvailable(fecha, listColaboradoresTotalViaje);
        if (!isColaboradorInViajeSameDate) {
            showMessage("No se puede registrar 2 viajes el mismo dia para un colaborador", "Error", "No se puedo registrar Viaje");
            return false;
        }
        return true;
    }

    private void guardarViaje(Date fecha, SucursalColaborador sucursalColaborador, Transportista transportista,
            List<Colaborador> listColaboradoresTotalViaje, double kmsTotal) {
        boolean isViajeTrue = viajeControl.saveViaje(fecha, sucursalColaborador, transportista, listColaboradoresTotalViaje, usuarioSession, kmsTotal);
        if (isViajeTrue) {
            showMessage("Viaje registrado Exitosamente", "Info", "Viaje Guardado");
        } else {
            showMessage("Viaje no registrado", "Error", "Viaje no guardado");
        }
    }

    private void agregarColaboradorATabla(SucursalColaborador sucursalColaborador) {
        kmsAcumulados += sucursalColaborador.getDistancia();
        kmTxtField.setText(String.valueOf(kmsAcumulados));

        tableModelColaboradoresSeleccionados.addRow(new Object[]{
            sucursalColaborador.getColaborador().getId(),
            sucursalColaborador.getColaborador().getNombre(),
            sucursalColaborador.getColaborador().getApellido()
        });
    }

    private boolean colaboradorYaSeleccionado(Long colaboradorId) {
        for (int i = 0; i < tableModelColaboradoresSeleccionados.getRowCount(); i++) {
            Long idEnTabla = (Long) tableModelColaboradoresSeleccionados.getValueAt(i, 0);
            if (colaboradorId.equals(idEnTabla)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        barraSuperiorPanel = new javax.swing.JPanel();
        tituloEsquinaLabel1 = new javax.swing.JLabel();
        tituloEsquinaLabel2 = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        usuarioTxtField = new javax.swing.JTextField();
        colaboradoresSeleccionadosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colaboradoresSeleccionadostable = new javax.swing.JTable();
        transportistaLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        registrarBtn = new javax.swing.JPanel();
        ingresarLabel = new javax.swing.JLabel();
        transportistaCmb = new javax.swing.JComboBox<>();
        sucursalesCmb = new javax.swing.JComboBox<>();
        kmsLabel = new javax.swing.JLabel();
        kmTxtField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        colaboradoresTable = new javax.swing.JTable();
        buscaBtn = new javax.swing.JPanel();
        buscarLabel = new javax.swing.JLabel();
        SucursalesSeleccionadosLabel = new javax.swing.JLabel();
        menuDerechoPanel = new javax.swing.JPanel();
        asignarSucursalBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        registrarViajesBtn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        reportesBtn = new javax.swing.JPanel();
        reportesLabel = new javax.swing.JLabel();
        fechaJDate = new com.toedter.calendar.JDateChooser();
        logoutBtn = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(0, 51, 51));
        background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraSuperiorPanel.setBackground(new java.awt.Color(51, 51, 51));
        barraSuperiorPanel.setForeground(new java.awt.Color(51, 51, 51));

        tituloEsquinaLabel1.setBackground(new java.awt.Color(255, 255, 255));
        tituloEsquinaLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        tituloEsquinaLabel1.setForeground(new java.awt.Color(204, 204, 204));
        tituloEsquinaLabel1.setText("Sistema de viajes");

        tituloEsquinaLabel2.setBackground(new java.awt.Color(255, 255, 255));
        tituloEsquinaLabel2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        tituloEsquinaLabel2.setForeground(new java.awt.Color(204, 204, 204));
        tituloEsquinaLabel2.setText("Registrar Viajes");

        usuarioLabel.setForeground(new java.awt.Color(204, 204, 204));
        usuarioLabel.setText("Usuario:");

        usuarioTxtField.setBackground(new java.awt.Color(51, 51, 51));
        usuarioTxtField.setForeground(new java.awt.Color(255, 255, 255));
        usuarioTxtField.setBorder(null);
        usuarioTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraSuperiorPanelLayout = new javax.swing.GroupLayout(barraSuperiorPanel);
        barraSuperiorPanel.setLayout(barraSuperiorPanelLayout);
        barraSuperiorPanelLayout.setHorizontalGroup(
            barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addComponent(tituloEsquinaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(tituloEsquinaLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(usuarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        barraSuperiorPanelLayout.setVerticalGroup(
            barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tituloEsquinaLabel1)
                .addComponent(tituloEsquinaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        background.add(barraSuperiorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 30));

        colaboradoresSeleccionadosLabel.setBackground(new java.awt.Color(255, 255, 255));
        colaboradoresSeleccionadosLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        colaboradoresSeleccionadosLabel.setForeground(new java.awt.Color(204, 204, 204));
        colaboradoresSeleccionadosLabel.setText("Colaboradores seleccionados para el viaje");
        background.add(colaboradoresSeleccionadosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, 20));

        colaboradoresSeleccionadostable.setBackground(new java.awt.Color(51, 51, 51));
        colaboradoresSeleccionadostable.setForeground(new java.awt.Color(255, 255, 255));
        colaboradoresSeleccionadostable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(colaboradoresSeleccionadostable);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 700, 100));

        transportistaLabel.setBackground(new java.awt.Color(255, 255, 255));
        transportistaLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        transportistaLabel.setForeground(new java.awt.Color(204, 204, 204));
        transportistaLabel.setText("Transportista:");
        background.add(transportistaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        fechaLabel.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(204, 204, 204));
        fechaLabel.setText("Fecha: ");
        background.add(fechaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, -1));

        registrarBtn.setBackground(new java.awt.Color(51, 51, 51));
        registrarBtn.setForeground(new java.awt.Color(102, 102, 102));
        registrarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarBtnMouseClicked(evt);
            }
        });

        ingresarLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        ingresarLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresarLabel.setText("REGISTRAR");
        ingresarLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout registrarBtnLayout = new javax.swing.GroupLayout(registrarBtn);
        registrarBtn.setLayout(registrarBtnLayout);
        registrarBtnLayout.setHorizontalGroup(
            registrarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarBtnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ingresarLabel)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        registrarBtnLayout.setVerticalGroup(
            registrarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ingresarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 100, 20));

        transportistaCmb.setBackground(new java.awt.Color(51, 51, 51));
        transportistaCmb.setForeground(new java.awt.Color(255, 255, 255));
        background.add(transportistaCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 150, 20));

        sucursalesCmb.setBackground(new java.awt.Color(51, 51, 51));
        sucursalesCmb.setForeground(new java.awt.Color(255, 255, 255));
        sucursalesCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucursalesCmbActionPerformed(evt);
            }
        });
        background.add(sucursalesCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 190, 20));

        kmsLabel.setForeground(new java.awt.Color(204, 204, 204));
        kmsLabel.setText("Kilometros acum.");
        background.add(kmsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, -1, -1));

        kmTxtField.setEditable(false);
        kmTxtField.setBackground(new java.awt.Color(51, 51, 51));
        kmTxtField.setForeground(new java.awt.Color(255, 255, 255));
        background.add(kmTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 50, 20));

        colaboradoresTable.setBackground(new java.awt.Color(51, 51, 51));
        colaboradoresTable.setForeground(new java.awt.Color(255, 255, 255));
        colaboradoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        colaboradoresTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colaboradoresTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(colaboradoresTable);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 700, 100));

        buscaBtn.setBackground(new java.awt.Color(51, 51, 51));
        buscaBtn.setForeground(new java.awt.Color(204, 204, 204));
        buscaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscaBtnMouseClicked(evt);
            }
        });

        buscarLabel.setForeground(new java.awt.Color(255, 255, 255));
        buscarLabel.setText("Buscar");

        javax.swing.GroupLayout buscaBtnLayout = new javax.swing.GroupLayout(buscaBtn);
        buscaBtn.setLayout(buscaBtnLayout);
        buscaBtnLayout.setHorizontalGroup(
            buscaBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscaBtnLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(buscarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        buscaBtnLayout.setVerticalGroup(
            buscaBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscaBtnLayout.createSequentialGroup()
                .addComponent(buscarLabel)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        background.add(buscaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 70, 20));

        SucursalesSeleccionadosLabel.setBackground(new java.awt.Color(255, 255, 255));
        SucursalesSeleccionadosLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        SucursalesSeleccionadosLabel.setForeground(new java.awt.Color(204, 204, 204));
        SucursalesSeleccionadosLabel.setText("Seleccione la Sucursal:");
        background.add(SucursalesSeleccionadosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 20));

        menuDerechoPanel.setBackground(new java.awt.Color(51, 51, 51));
        menuDerechoPanel.setForeground(new java.awt.Color(51, 51, 51));
        menuDerechoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignarSucursalBtn.setBackground(new java.awt.Color(51, 51, 51));
        asignarSucursalBtn.setForeground(new java.awt.Color(51, 51, 51));
        asignarSucursalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignarSucursalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignarSucursalBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asignarSucursalBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asignarSucursalBtnMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asignar Sucursal");

        javax.swing.GroupLayout asignarSucursalBtnLayout = new javax.swing.GroupLayout(asignarSucursalBtn);
        asignarSucursalBtn.setLayout(asignarSucursalBtnLayout);
        asignarSucursalBtnLayout.setHorizontalGroup(
            asignarSucursalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignarSucursalBtnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        asignarSucursalBtnLayout.setVerticalGroup(
            asignarSucursalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignarSucursalBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuDerechoPanel.add(asignarSucursalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        registrarViajesBtn.setBackground(new java.awt.Color(51, 51, 51));
        registrarViajesBtn.setForeground(new java.awt.Color(51, 51, 51));
        registrarViajesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarViajesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarViajesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarViajesBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registrarViajesBtnMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registrar Viajes");

        javax.swing.GroupLayout registrarViajesBtnLayout = new javax.swing.GroupLayout(registrarViajesBtn);
        registrarViajesBtn.setLayout(registrarViajesBtnLayout);
        registrarViajesBtnLayout.setHorizontalGroup(
            registrarViajesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarViajesBtnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        registrarViajesBtnLayout.setVerticalGroup(
            registrarViajesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarViajesBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuDerechoPanel.add(registrarViajesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 120, -1));

        reportesBtn.setBackground(new java.awt.Color(51, 51, 51));
        reportesBtn.setForeground(new java.awt.Color(51, 51, 51));
        reportesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportesBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportesBtnMouseExited(evt);
            }
        });

        reportesLabel.setBackground(new java.awt.Color(204, 204, 204));
        reportesLabel.setForeground(new java.awt.Color(204, 204, 204));
        reportesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportesLabel.setText("Reportes");

        javax.swing.GroupLayout reportesBtnLayout = new javax.swing.GroupLayout(reportesBtn);
        reportesBtn.setLayout(reportesBtnLayout);
        reportesBtnLayout.setHorizontalGroup(
            reportesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportesBtnLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(reportesLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportesBtnLayout.setVerticalGroup(
            reportesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportesBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportesLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuDerechoPanel.add(reportesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 120, -1));

        background.add(menuDerechoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, 120));

        fechaJDate.setBackground(new java.awt.Color(51, 51, 51));
        fechaJDate.setForeground(new java.awt.Color(255, 255, 255));
        background.add(fechaJDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 150, 20));

        logoutBtn.setBackground(new java.awt.Color(51, 0, 0));
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        logoutLabel.setBackground(new java.awt.Color(204, 204, 204));
        logoutLabel.setForeground(new java.awt.Color(204, 204, 204));
        logoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutLabel.setText("LOGOUT");

        javax.swing.GroupLayout logoutBtnLayout = new javax.swing.GroupLayout(logoutBtn);
        logoutBtn.setLayout(logoutBtnLayout);
        logoutBtnLayout.setHorizontalGroup(
            logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutBtnLayout.setVerticalGroup(
            logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel)
                .addContainerGap())
        );

        background.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtFieldActionPerformed

    private void sucursalesCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucursalesCmbActionPerformed

    }//GEN-LAST:event_sucursalesCmbActionPerformed

    private void buscaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscaBtnMouseClicked
        tableModelColaboradoresSucursal.setColumnCount(0);
        tableModelColaboradoresSucursal.setRowCount(0);
        tableModelColaboradoresSeleccionados.setColumnCount(0);
        tableModelColaboradoresSeleccionados.setRowCount(0);
        kmTxtField.setText("");
        configureColaboradoresTableModel();
        configureColaboradoresSeleccionadosTableModel();
        kmsAcumulados = 0.0;

        String nombre = String.valueOf(sucursalesCmb.getSelectedItem());

        if (nombre != null) {
            List<SucursalColaborador> listSucursalColaborador = sucursalColaboradorControl.getSucursalColaboradores();
            if (listSucursalColaborador != null) {
                for (SucursalColaborador sucursalColaborador : listSucursalColaborador) {
                    if (sucursalColaborador.getSucursal().getNombre().equals(nombre)) {
                        tableModelColaboradoresSeleccionados.addRow(new Object[]{sucursalColaborador.getId(), sucursalColaborador.getDistancia(), sucursalColaborador.getColaborador().getNombre(), sucursalColaborador.getColaborador().getId()});

                    }
                }
            }
        }
    }//GEN-LAST:event_buscaBtnMouseClicked

    private void colaboradoresTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colaboradoresTableMouseClicked
        // Obtener el ID del colaborador seleccionado de la tabla de colaboradores
        Long colaboradorSucursalId = (Long) colaboradoresTable.getValueAt(colaboradoresTable.getSelectedRow(), 0);
        final double DISTANCIA_KMS_MAX = 100.0;
        // Obtener el objeto SucursalColaborador
        SucursalColaborador sucursalColaborador = sucursalColaboradorControl.getSucursalColaboradorByIdSucursal(colaboradorSucursalId);

        if (sucursalColaborador != null) {
            Long colaboradorId = sucursalColaborador.getColaborador().getId();

            // Verificar si el colaborador ya está en la tabla de seleccionados
            boolean exists = colaboradorYaSeleccionado(sucursalColaborador.getColaborador().getId());
            
            // Si no existe, agregar a la tabla de seleccionados
            if (!exists) {
                if ((kmsAcumulados + sucursalColaborador.getDistancia()) <= DISTANCIA_KMS_MAX) {
                    agregarColaboradorATabla(sucursalColaborador);
                } else {
                    showMessage("Este usuario acumula mas del límite de kms permitidos por viaje, kms totál del viaje no puede ser mayor a 100 kms", "Error", "No se agregó Colaborador");
                }
            } else {
                showMessage("Usuario ya existe en la lista del viaje", "Error", "No se puede agregar este usuario");
            }
        }
    }//GEN-LAST:event_colaboradoresTableMouseClicked

    private void asignarSucursalBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMouseEntered
        asignarSucursalBtn.setBackground(Color.gray);
    }//GEN-LAST:event_asignarSucursalBtnMouseEntered

    private void asignarSucursalBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMouseExited
        asignarSucursalBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_asignarSucursalBtnMouseExited

    private void registrarViajesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMouseEntered
        registrarViajesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_registrarViajesBtnMouseEntered

    private void registrarViajesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMouseExited
        registrarViajesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_registrarViajesBtnMouseExited

    private void registrarViajesBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMousePressed
        RegistrarViajesView registrarViajesView = context.getBean(RegistrarViajesView.class);
        registrarViajesView.setUsuario(usuarioSession);
        registrarViajesView.setVisible(true);
        registrarViajesView.setLocationRelativeTo(null);
    }//GEN-LAST:event_registrarViajesBtnMousePressed

    private void reportesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseClicked
        ReportesView reportesView = context.getBean(ReportesView.class);
        reportesView.setUsuario(usuarioSession);
        reportesView.setVisible(true);
        reportesView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_reportesBtnMouseClicked

    private void reportesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseEntered
        reportesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_reportesBtnMouseEntered

    private void reportesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseExited
        reportesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_reportesBtnMouseExited

    private void asignarSucursalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMouseClicked
        AdministrarSucursalesView administrarSucursalesView = context.getBean(AdministrarSucursalesView.class);
        administrarSucursalesView.setVisible(true);
        administrarSucursalesView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_asignarSucursalBtnMouseClicked

    private void registrarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnMouseClicked

        if (!usuarioSession.getRol().equals("gerenteTienda")) {
            showMessage("Solo el Gerente de Tienda pueden registrar un viaje", "Error", "No se puede crear el viaje");
            return;
        }

        Date fecha = fechaJDate.getDate();
        double kmsTotal = validarKilometros(kmTxtField.getText());
        if (kmsTotal < 0) {
            return; // Retorna si hay error en la validación
        }
        Transportista transportista = asignarTransportista();
        if (transportista == null) {
            return; // Retorna si hay error en la asignación
        }
        SucursalColaborador sucursalColaborador = asignarSucursal();
        if (sucursalColaborador == null) {
            return; // Retorna si hay error en la asignación
        }
        List<Colaborador> listColaboradoresTotalViaje = obtenerColaboradoresSeleccionados();
        if (listColaboradoresTotalViaje.isEmpty()) {
            showMessage("No se han seleccionado colaboradores", "Error", "Colaboradores vacíos");
            return;
        }

        if (!validarDisponibilidadTransportista(fecha, transportista)) {
            return;
        }
        if (!validarDisponibilidadColaboradores(fecha, listColaboradoresTotalViaje)) {
            return;
        }

        guardarViaje(fecha, sucursalColaborador, transportista, listColaboradoresTotalViaje, kmsTotal);

    }//GEN-LAST:event_registrarBtnMouseClicked

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        usuarioSession.logOut();
        LoginView loginView = context.getBean(LoginView.class);
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SucursalesSeleccionadosLabel;
    private javax.swing.JPanel asignarSucursalBtn;
    private javax.swing.JPanel background;
    private javax.swing.JPanel barraSuperiorPanel;
    private javax.swing.JPanel buscaBtn;
    private javax.swing.JLabel buscarLabel;
    private javax.swing.JLabel colaboradoresSeleccionadosLabel;
    private javax.swing.JTable colaboradoresSeleccionadostable;
    private javax.swing.JTable colaboradoresTable;
    private com.toedter.calendar.JDateChooser fechaJDate;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel ingresarLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kmTxtField;
    private javax.swing.JLabel kmsLabel;
    private javax.swing.JPanel logoutBtn;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel menuDerechoPanel;
    private javax.swing.JPanel registrarBtn;
    private javax.swing.JPanel registrarViajesBtn;
    private javax.swing.JPanel reportesBtn;
    private javax.swing.JLabel reportesLabel;
    private javax.swing.JComboBox<String> sucursalesCmb;
    private javax.swing.JLabel tituloEsquinaLabel1;
    private javax.swing.JLabel tituloEsquinaLabel2;
    private javax.swing.JComboBox<String> transportistaCmb;
    private javax.swing.JLabel transportistaLabel;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioTxtField;
    // End of variables declaration//GEN-END:variables
}
