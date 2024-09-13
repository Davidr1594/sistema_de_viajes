package com.farsiman.sistema_de_viajes.view;

import com.farsiman.sistema_de_viajes.controller.*;
import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.model.Sucursal;
import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import jakarta.annotation.PostConstruct;
import java.awt.Color;
import java.util.List;
import java.util.Optional;
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
public class AdministrarSucursalesView extends javax.swing.JFrame {

    @Autowired
    private SucursalController sucursalControl;
    @Autowired
    private ColaboradorController colaboradorControl;
    @Autowired
    private SucursalColaboradorController sucursalColaboradorController;

    @Autowired
    ApplicationContext context;

    private Long sucursalId;
    private Long colaboradorId;

    DefaultTableModel tableModelSucursal = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel tableModelColaboradores = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public AdministrarSucursalesView() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @PostConstruct
    private void initView() {
        configureSucursalesTableHeader();
        addSucursalesToTable();

        configureColaboradoresTableHeader();
        addColaboradoresToTable();
    }

    private void configureSucursalesTableHeader() {
        JTableHeader header = sucursalesTable.getTableHeader();
        header.setBackground(Color.gray);
        sucursalesTable.setForeground(Color.white);
        tableModelSucursal.addColumn("Id");
        tableModelSucursal.addColumn("Nombre");
        tableModelSucursal.addColumn("Direccion");

        sucursalesTable.setModel(tableModelSucursal);
    }

    private void configureColaboradoresTableHeader() {
        JTableHeader header = sucursalesTable.getTableHeader();
        header.setBackground(Color.gray);
        colaboradoresTable.setForeground(Color.white);
        tableModelColaboradores.addColumn("Id");
        tableModelColaboradores.addColumn("Nombre");
        tableModelColaboradores.addColumn("Apellido");

        colaboradoresTable.setModel(tableModelColaboradores);
    }

    private void addSucursalesToTable() {
        List<Sucursal> listSucursales = sucursalControl.getSucursales();

        for (Sucursal sucursal : listSucursales) {
            tableModelSucursal.addRow(new Object[]{sucursal.getId(), sucursal.getNombre(), sucursal.getDireccion()});
        }

    }

    private void addColaboradoresToTable() {
        List<Colaborador> listColaboradores = colaboradorControl.getColaboradores();

        for (Colaborador colaborador : listColaboradores) {
            tableModelColaboradores.addRow(new Object[]{colaborador.getId(), colaborador.getNombre(), colaborador.getApellido()});
        }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        barraSuperiorPanel = new javax.swing.JPanel();
        tituloEsquinaLabel1 = new javax.swing.JLabel();
        tituloEsquinaLabel2 = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        usuarioTxtField = new javax.swing.JTextField();
        usuarioLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        menuDerechoPanel = new javax.swing.JPanel();
        asignarSucursalBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        registrarViajesBtn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        reportesBtn = new javax.swing.JPanel();
        reportesLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colaboradoresTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        sucursalesTable = new javax.swing.JTable();
        colaboradorSeleccionadoLabel = new javax.swing.JLabel();
        textoInformaticoSeleccionLabel = new javax.swing.JLabel();
        sucursalSeleccionadaLabel = new javax.swing.JLabel();
        colaboradorSeleccionadoTxtField = new javax.swing.JTextField();
        sucursalSeleccionadaTxtField = new javax.swing.JTextField();
        kmLabel = new javax.swing.JLabel();
        kmTxtField = new javax.swing.JTextField();
        asignarBtn = new javax.swing.JPanel();
        ingresarLabel = new javax.swing.JLabel();

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
        tituloEsquinaLabel2.setText("Administrar Sucursales");

        usuarioLabel.setForeground(new java.awt.Color(204, 204, 204));
        usuarioLabel.setText("Usuario:");

        usuarioTxtField.setEditable(false);
        usuarioTxtField.setBackground(new java.awt.Color(51, 51, 51));
        usuarioTxtField.setForeground(new java.awt.Color(255, 255, 255));
        usuarioTxtField.setBorder(null);
        usuarioTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtFieldActionPerformed(evt);
            }
        });

        usuarioLabel1.setForeground(new java.awt.Color(204, 204, 204));
        usuarioLabel1.setText("Usuario:");

        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraSuperiorPanelLayout = new javax.swing.GroupLayout(barraSuperiorPanel);
        barraSuperiorPanel.setLayout(barraSuperiorPanelLayout);
        barraSuperiorPanelLayout.setHorizontalGroup(
            barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                        .addComponent(tituloEsquinaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(tituloEsquinaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                        .addGap(738, 738, 738)
                        .addComponent(usuarioLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        barraSuperiorPanelLayout.setVerticalGroup(
            barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloEsquinaLabel1)
                    .addComponent(tituloEsquinaLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background.add(barraSuperiorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 30));

        menuDerechoPanel.setBackground(new java.awt.Color(51, 51, 51));
        menuDerechoPanel.setForeground(new java.awt.Color(51, 51, 51));
        menuDerechoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignarSucursalBtn.setBackground(new java.awt.Color(51, 51, 51));
        asignarSucursalBtn.setForeground(new java.awt.Color(51, 51, 51));
        asignarSucursalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignarSucursalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asignarSucursalBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asignarSucursalBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                asignarSucursalBtnMousePressed(evt);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarViajesBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarViajesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarViajesBtnMouseExited(evt);
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

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Colaboradores");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sucursales");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, 20));

        colaboradoresTable.setBackground(new java.awt.Color(51, 51, 51));
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
        jScrollPane1.setViewportView(colaboradoresTable);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 320, 220));

        sucursalesTable.setBackground(new java.awt.Color(51, 51, 51));
        sucursalesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        sucursalesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sucursalesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sucursalesTable);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 340, 220));

        colaboradorSeleccionadoLabel.setBackground(new java.awt.Color(255, 255, 255));
        colaboradorSeleccionadoLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        colaboradorSeleccionadoLabel.setForeground(new java.awt.Color(255, 255, 255));
        colaboradorSeleccionadoLabel.setText("Colaborador: ");
        background.add(colaboradorSeleccionadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, -1, -1));

        textoInformaticoSeleccionLabel.setBackground(new java.awt.Color(255, 255, 255));
        textoInformaticoSeleccionLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        textoInformaticoSeleccionLabel.setForeground(new java.awt.Color(255, 255, 255));
        textoInformaticoSeleccionLabel.setText("Seleccione una sucursal y seleccione un colaborador para hacer la asignación.");
        background.add(textoInformaticoSeleccionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        sucursalSeleccionadaLabel.setBackground(new java.awt.Color(255, 255, 255));
        sucursalSeleccionadaLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        sucursalSeleccionadaLabel.setForeground(new java.awt.Color(255, 255, 255));
        sucursalSeleccionadaLabel.setText("Sucursal:");
        background.add(sucursalSeleccionadaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        colaboradorSeleccionadoTxtField.setEditable(false);
        colaboradorSeleccionadoTxtField.setBackground(new java.awt.Color(51, 51, 51));
        colaboradorSeleccionadoTxtField.setForeground(new java.awt.Color(255, 255, 255));
        colaboradorSeleccionadoTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colaboradorSeleccionadoTxtFieldActionPerformed(evt);
            }
        });
        background.add(colaboradorSeleccionadoTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 130, 20));

        sucursalSeleccionadaTxtField.setEditable(false);
        sucursalSeleccionadaTxtField.setBackground(new java.awt.Color(51, 51, 51));
        sucursalSeleccionadaTxtField.setForeground(new java.awt.Color(255, 255, 255));
        background.add(sucursalSeleccionadaTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 130, 20));

        kmLabel.setBackground(new java.awt.Color(255, 255, 255));
        kmLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        kmLabel.setForeground(new java.awt.Color(255, 255, 255));
        kmLabel.setText("KMs de distancia:");
        background.add(kmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

        kmTxtField.setBackground(new java.awt.Color(51, 51, 51));
        kmTxtField.setForeground(new java.awt.Color(255, 255, 255));
        background.add(kmTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 130, 20));

        asignarBtn.setBackground(new java.awt.Color(51, 51, 51));
        asignarBtn.setForeground(new java.awt.Color(102, 102, 102));
        asignarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignarBtnMouseClicked(evt);
            }
        });

        ingresarLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        ingresarLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresarLabel.setText("ASIGNAR");
        ingresarLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout asignarBtnLayout = new javax.swing.GroupLayout(asignarBtn);
        asignarBtn.setLayout(asignarBtnLayout);
        asignarBtnLayout.setHorizontalGroup(
            asignarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignarBtnLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ingresarLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        asignarBtnLayout.setVerticalGroup(
            asignarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, asignarBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ingresarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(asignarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colaboradorSeleccionadoTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colaboradorSeleccionadoTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colaboradorSeleccionadoTxtFieldActionPerformed

    private void asignarSucursalBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMousePressed

    }//GEN-LAST:event_asignarSucursalBtnMousePressed

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

    private void reportesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseEntered
        reportesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_reportesBtnMouseEntered

    private void reportesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseExited
        reportesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_reportesBtnMouseExited

    private void usuarioTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtFieldActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void sucursalesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sucursalesTableMouseClicked
        sucursalSeleccionadaTxtField.setText(String.valueOf(sucursalesTable.getValueAt(sucursalesTable.getSelectedRow(), 1)));
        this.sucursalId = (Long) sucursalesTable.getValueAt(sucursalesTable.getSelectedRow(), 0);

    }//GEN-LAST:event_sucursalesTableMouseClicked

    private void colaboradoresTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colaboradoresTableMouseClicked

        colaboradorSeleccionadoTxtField.setText(String.valueOf(colaboradoresTable.getValueAt(colaboradoresTable.getSelectedRow(), 1)));
        this.colaboradorId = (Long) colaboradoresTable.getValueAt(colaboradoresTable.getSelectedRow(), 0);

    }//GEN-LAST:event_colaboradoresTableMouseClicked

    private void asignarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarBtnMouseClicked
        String sucursal = sucursalSeleccionadaTxtField.getText();
        String colaborador = colaboradorSeleccionadoTxtField.getText();
        String kmText = kmTxtField.getText(); // Capturar el texto del campo de kilómetros

        if (kmText.isEmpty()) {
            showMessage("Falta un campo por seleccionar", "Error", "Campos incompletos");
        } else {
            try {
                double kms = Double.parseDouble(kmText); // Intentar convertir a double

                // Validar que los kilómetros estén en el rango permitido
                if (kms <= 0 || kms > 50.00) {
                    showMessage("Kms no pueden ser 0 o ser mayor a 50 kms", "Error", "Kms no valido");
                } else {
                    if (!sucursal.equals("") && !colaborador.equals("")) {
                        // Verificar si ya existe la relación entre la sucursal y el colaborador
                        boolean existsRelation = sucursalColaboradorController.existsRelation(sucursalId, colaboradorId);

                        if (existsRelation) {
                            showMessage("La relación ya existe entre el colaborador y la sucursal", "Error", "Duplicado");
                        } else {
                            // Si no existe, guardar la nueva relación
                            sucursalColaboradorController.saveRelationSucursalColaborador(sucursalId, colaboradorId, kms);
                            showMessage("Relación asignada", "Info", "Completado");
                        }
                    } else {
                        showMessage("Falta un campo", "Error", "Campos incompletos");
                    }
                }
            } catch (NumberFormatException e) {
                showMessage("No es un número válido", "Error", "Dato incorrecto");
            }
        }
    }//GEN-LAST:event_asignarBtnMouseClicked

    private void registrarViajesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMouseClicked
        RegistrarViajesView registrarViajesView = context.getBean(RegistrarViajesView.class
        );
        registrarViajesView.setVisible(true);
        registrarViajesView.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_registrarViajesBtnMouseClicked

    private void reportesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseClicked
        ReportesView reportesView = context.getBean(ReportesView.class
        );
        reportesView.setVisible(true);
        reportesView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_reportesBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asignarBtn;
    private javax.swing.JPanel asignarSucursalBtn;
    private javax.swing.JPanel background;
    private javax.swing.JPanel barraSuperiorPanel;
    private javax.swing.JLabel colaboradorSeleccionadoLabel;
    private javax.swing.JTextField colaboradorSeleccionadoTxtField;
    private javax.swing.JTable colaboradoresTable;
    private javax.swing.JLabel ingresarLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel kmLabel;
    private javax.swing.JTextField kmTxtField;
    private javax.swing.JPanel menuDerechoPanel;
    private javax.swing.JPanel registrarViajesBtn;
    private javax.swing.JPanel reportesBtn;
    private javax.swing.JLabel reportesLabel;
    private javax.swing.JLabel sucursalSeleccionadaLabel;
    private javax.swing.JTextField sucursalSeleccionadaTxtField;
    private javax.swing.JTable sucursalesTable;
    private javax.swing.JLabel textoInformaticoSeleccionLabel;
    private javax.swing.JLabel tituloEsquinaLabel1;
    private javax.swing.JLabel tituloEsquinaLabel2;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JLabel usuarioLabel1;
    private javax.swing.JTextField usuarioTxtField;
    // End of variables declaration//GEN-END:variables
}
