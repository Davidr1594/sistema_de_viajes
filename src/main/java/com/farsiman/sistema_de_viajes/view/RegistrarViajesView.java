package com.farsiman.sistema_de_viajes.view;

import com.farsiman.sistema_de_viajes.controller.ColaboradorController;
import com.farsiman.sistema_de_viajes.controller.SucursalColaboradorController;
import com.farsiman.sistema_de_viajes.controller.SucursalController;
import com.farsiman.sistema_de_viajes.controller.TransportistaController;
import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.model.Sucursal;
import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import com.farsiman.sistema_de_viajes.model.Transportista;
import jakarta.annotation.PostConstruct;
import java.awt.Color;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
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
    ApplicationContext context;

    //variable sucursal global
    Sucursal sucursalSeleccionadaGlobal;
    //Variable para acumular y restringir los Kms de un viaje
    double kmsAcumulados = 0.0;

    DefaultTableModel tableModel = new DefaultTableModel();
    DefaultTableModel tableModelColaboradoresSeleccionados = new DefaultTableModel();

    public RegistrarViajesView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @PostConstruct
    private void initView() {
        configureSucursalesCmb();
        configureTransportistasCmb();
        configureColaboradoresTableHeader();
        configureColaboradoresSeleccionadosTableHeader();

    }

    private void configureSucursalesCmb() {
        List<Sucursal> listSucursales = sucursalControl.getSucursales();

        for (Sucursal sucursal : listSucursales) {
            sucursalesCmb.addItem(sucursal.getNombre());
        }
    }

    private void configureTransportistasCmb() {
        List<Transportista> listTransportistas = transportistaControl.getTransportistas();

        for (Transportista transportista : listTransportistas) {
            transportistaCmb.addItem(transportista.getNombre());
        }
    }

    private void configureColaboradoresTableHeader() {
        JTableHeader header = colaboradoresTable.getTableHeader();
        header.setBackground(Color.gray);
        colaboradoresTable.setForeground(Color.white);
        tableModel.addColumn("Id");
        tableModel.addColumn("Distancia");
        tableModel.addColumn("Colaborador nombre");
        tableModel.addColumn("Colaborador Id");

        colaboradoresTable.setModel(tableModel);
    }

    private void configureColaboradoresSeleccionadosTableHeader() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        barraSuperiorPanel = new javax.swing.JPanel();
        tituloEsquinaLabel1 = new javax.swing.JLabel();
        tituloEsquinaLabel2 = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        colaboradoresSeleccionadosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colaboradoresSeleccionadostable = new javax.swing.JTable();
        transportistaLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        fechaTxtField = new javax.swing.JTextField();
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

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(usuarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        barraSuperiorPanelLayout.setVerticalGroup(
            barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloEsquinaLabel1)
                    .addComponent(tituloEsquinaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        background.add(barraSuperiorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 30));

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

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 630, 100));

        transportistaLabel.setBackground(new java.awt.Color(255, 255, 255));
        transportistaLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        transportistaLabel.setForeground(new java.awt.Color(204, 204, 204));
        transportistaLabel.setText("Transportista:");
        background.add(transportistaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        fechaLabel.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(204, 204, 204));
        fechaLabel.setText("Fecha: ");
        background.add(fechaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        fechaTxtField.setBackground(new java.awt.Color(51, 51, 51));
        background.add(fechaTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 150, 20));

        registrarBtn.setBackground(new java.awt.Color(51, 51, 51));
        registrarBtn.setForeground(new java.awt.Color(102, 102, 102));
        registrarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        background.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 100, 20));

        transportistaCmb.setBackground(new java.awt.Color(51, 51, 51));
        transportistaCmb.setForeground(new java.awt.Color(255, 255, 255));
        background.add(transportistaCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 150, 20));

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

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 630, 100));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void sucursalesCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucursalesCmbActionPerformed

        int selectedIndex = sucursalesCmb.getSelectedIndex();
        if (selectedIndex >= 0) {
            Sucursal sucursalSeleccionada = sucursalControl.getSucursales().get(selectedIndex);
            sucursalSeleccionadaGlobal = sucursalSeleccionada;
        }

    }//GEN-LAST:event_sucursalesCmbActionPerformed

    private void buscaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscaBtnMouseClicked
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        tableModelColaboradoresSeleccionados.setColumnCount(0);
        tableModelColaboradoresSeleccionados.setRowCount(0);
        configureColaboradoresTableHeader();
        configureColaboradoresSeleccionadosTableHeader();

        String nombre = String.valueOf(sucursalesCmb.getSelectedItem());

        List<SucursalColaborador> listColaboradores = sucursalSeleccionadaGlobal.getSucursalColaboradores();
        for (SucursalColaborador sucursalColaborador : listColaboradores) {
            if (sucursalColaborador.getSucursal().getNombre().equals(nombre)) {
                tableModel.addRow(new Object[]{sucursalColaborador.getId(), sucursalColaborador.getDistancia(), sucursalColaborador.getColaborador().getNombre(), sucursalColaborador.getColaborador().getId()});
            }
    }//GEN-LAST:event_buscaBtnMouseClicked
    }
    private void colaboradoresTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colaboradoresTableMouseClicked
// Obtener el ID del colaborador seleccionado de la tabla de colaboradores
        Long colaboradorSucursalId = (Long) colaboradoresTable.getValueAt(colaboradoresTable.getSelectedRow(), 0);

// Obtener el objeto SucursalColaborador
        SucursalColaborador sucursalColaborador = sucursalColaboradorControl.getSucursalColaboradorByIdSucursal(colaboradorSucursalId);

        if (sucursalColaborador != null) {
            Long colaboradorId = sucursalColaborador.getColaborador().getId();

            // Verificar si el colaborador ya está en la tabla de seleccionados
            boolean exists = false;
            for (int i = 0; i < tableModelColaboradoresSeleccionados.getRowCount(); i++) {
                Long idEnTabla = (Long) tableModelColaboradoresSeleccionados.getValueAt(i, 0);
                if (colaboradorId.equals(idEnTabla)) {
                    exists = true;
                    break;
                }
            }

            // Si no existe, agregar a la tabla de seleccionados
            if (!exists) {
                if ((kmsAcumulados + sucursalColaborador.getDistancia()) <= 100) {
                    kmsAcumulados = kmsAcumulados + sucursalColaborador.getDistancia();
                    kmTxtField.setText(String.valueOf(kmsAcumulados));

                    tableModelColaboradoresSeleccionados.addRow(new Object[]{
                        colaboradorId,
                        sucursalColaborador.getColaborador().getNombre(),
                        sucursalColaborador.getColaborador().getApellido()
                    });
                } else {
                    showMessage("Este usuario acumula mas del límite de kms permitidos por viaje, kms totál del viaje no puede ser mayor a 100 kms", "Warning", "No se agregó Colaborador");
                }
            } else {
                showMessage("Usuario ya existe en la lista del viaje", "Warning", "No se puede agregar este usuario");
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
        registrarViajesView.setVisible(true);
    }//GEN-LAST:event_registrarViajesBtnMousePressed

    private void reportesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseClicked
        ReportesView reportesView = context.getBean(ReportesView.class);
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
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JTextField fechaTxtField;
    private javax.swing.JLabel ingresarLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField kmTxtField;
    private javax.swing.JLabel kmsLabel;
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
    // End of variables declaration//GEN-END:variables
}
