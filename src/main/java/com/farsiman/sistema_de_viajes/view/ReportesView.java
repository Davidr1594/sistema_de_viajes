package com.farsiman.sistema_de_viajes.view;

import com.farsiman.sistema_de_viajes.controller.SucursalColaboradorController;
import com.farsiman.sistema_de_viajes.controller.TransportistaController;
import com.farsiman.sistema_de_viajes.controller.ViajeController;
import com.farsiman.sistema_de_viajes.model.Transportista;
import com.farsiman.sistema_de_viajes.model.Viaje;
import jakarta.annotation.PostConstruct;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class ReportesView extends javax.swing.JFrame {

    @Autowired
    TransportistaController transportistaControl;
    @Autowired
    ApplicationContext context;
    @Autowired
    SucursalColaboradorController sucursalColaboradoresControl;
    @Autowired
    ViajeController viajeControl;


    DefaultTableModel tableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ReportesView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @PostConstruct
    private void initView() {

        configureTransportistaCmb();
        configureViajeTableHeader();

    }

    private void configureTransportistaCmb() {
        List<Transportista> listTransportistas = transportistaControl.getTransportistas();

        for (Transportista transportista : listTransportistas) {
            transportistasCmb.addItem(transportista.getNombre());
        }
    }

    private void configureViajeTableHeader() {

        JTableHeader header = reportesTable.getTableHeader();
        header.setBackground(Color.gray);
        reportesTable.setForeground(Color.white);
        tableModel.addColumn("Viaje ID");
        tableModel.addColumn("Transportista Nombre");
        tableModel.addColumn("Sucursal Nombre");
        tableModel.addColumn("Distancia Total");
        tableModel.addColumn("tarifa por KM");
        tableModel.addColumn("Fecha de viaje");

        reportesTable.setModel(tableModel);

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

    private void setTableEditableOff(DefaultTableModel table) {
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacemos todas las celdas no editables
                return false;
            }
        };
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
        jScrollPane1 = new javax.swing.JScrollPane();
        reportesTable = new javax.swing.JTable();
        textoInformaticoSeleccionLabel = new javax.swing.JLabel();
        totalPagarTxtField = new javax.swing.JTextField();
        asignarBtn = new javax.swing.JPanel();
        ingresarLabel = new javax.swing.JLabel();
        fechaLabel2 = new javax.swing.JLabel();
        fechaLabel3 = new javax.swing.JLabel();
        fechaLabel4 = new javax.swing.JLabel();
        transportistasCmb = new javax.swing.JComboBox<>();
        menuDerechoPanel = new javax.swing.JPanel();
        asignarSucursalBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        registrarViajesBtn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        reportesBtn = new javax.swing.JPanel();
        reportesLabel = new javax.swing.JLabel();
        fechaFinalJDate = new com.toedter.calendar.JDateChooser();
        fechaInicioJDate = new com.toedter.calendar.JDateChooser();
        buscarBtn = new javax.swing.JPanel();
        ingresarLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        tituloEsquinaLabel2.setText("Reportes");

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
                .addGap(187, 187, 187)
                .addComponent(tituloEsquinaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(usuarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        barraSuperiorPanelLayout.setVerticalGroup(
            barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tituloEsquinaLabel1)
                .addComponent(tituloEsquinaLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(barraSuperiorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barraSuperiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background.add(barraSuperiorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 30));

        reportesTable.setBackground(new java.awt.Color(51, 51, 51));
        reportesTable.setForeground(new java.awt.Color(255, 255, 255));
        reportesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(reportesTable);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 670, 140));

        textoInformaticoSeleccionLabel.setBackground(new java.awt.Color(255, 255, 255));
        textoInformaticoSeleccionLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        textoInformaticoSeleccionLabel.setForeground(new java.awt.Color(255, 255, 255));
        textoInformaticoSeleccionLabel.setText("Cantidad todal a pagar:");
        background.add(textoInformaticoSeleccionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        totalPagarTxtField.setBackground(new java.awt.Color(51, 51, 51));
        totalPagarTxtField.setForeground(new java.awt.Color(255, 255, 255));
        background.add(totalPagarTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 60, 20));

        asignarBtn.setBackground(new java.awt.Color(51, 51, 51));
        asignarBtn.setForeground(new java.awt.Color(102, 102, 102));
        asignarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        background.add(asignarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 100, 20));

        fechaLabel2.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel2.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel2.setText("al");
        background.add(fechaLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 10, -1));

        fechaLabel3.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel3.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel3.setText("Seleccione un Transportista: ");
        background.add(fechaLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        fechaLabel4.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel4.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel4.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel4.setText("Rango de fecha desde: ");
        background.add(fechaLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        transportistasCmb.setBackground(new java.awt.Color(51, 51, 51));
        transportistasCmb.setForeground(new java.awt.Color(204, 204, 204));
        background.add(transportistasCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 180, 20));

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

        fechaFinalJDate.setBackground(new java.awt.Color(51, 51, 51));
        fechaFinalJDate.setForeground(new java.awt.Color(255, 255, 255));
        background.add(fechaFinalJDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 120, 20));

        fechaInicioJDate.setBackground(new java.awt.Color(51, 51, 51));
        fechaInicioJDate.setForeground(new java.awt.Color(255, 255, 255));
        background.add(fechaInicioJDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 120, 20));

        buscarBtn.setBackground(new java.awt.Color(51, 51, 51));
        buscarBtn.setForeground(new java.awt.Color(102, 102, 102));
        buscarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarBtnMouseClicked(evt);
            }
        });

        ingresarLabel1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        ingresarLabel1.setForeground(new java.awt.Color(255, 255, 255));
        ingresarLabel1.setText("Buscar");
        ingresarLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout buscarBtnLayout = new javax.swing.GroupLayout(buscarBtn);
        buscarBtn.setLayout(buscarBtnLayout);
        buscarBtnLayout.setHorizontalGroup(
            buscarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingresarLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buscarBtnLayout.setVerticalGroup(
            buscarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ingresarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, 20));

        jLabel2.setText("L.");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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

    private void asignarSucursalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMouseClicked
        AdministrarSucursalesView administrarSucursalesView = context.getBean(AdministrarSucursalesView.class);
        administrarSucursalesView.setVisible(true);
        administrarSucursalesView.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_asignarSucursalBtnMouseClicked

    private void registrarViajesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMouseClicked
        RegistrarViajesView registrarViajesView = context.getBean(RegistrarViajesView.class);
        registrarViajesView.setVisible(true);
        registrarViajesView.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_registrarViajesBtnMouseClicked

    private void buscarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarBtnMouseClicked
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        configureViajeTableHeader();

        Date fechaInicio = fechaInicioJDate.getDate();
        Date fechaFinal = fechaFinalJDate.getDate();
        
        double totalKmsAcumulados = 0;
        
        String transportistaNombre = String.valueOf(transportistasCmb.getSelectedItem());

        if (fechaInicio != null && fechaFinal != null) {
            if (transportistaNombre != null) {
                List<Viaje> listViajes = viajeControl.getViajesBetweenDate(fechaInicio, fechaFinal);
                for (Viaje viaje : listViajes) {
                    if (viaje.getTransportista().getNombre().equals(transportistaNombre)) {
                        tableModel.addRow(new Object[]{viaje.getId(), viaje.getTransportista().getNombre(), viaje.getSucursalColaborador().getSucursal().getNombre(), viaje.getDistanciaTotal(), viaje.getTransportista().getTarifaPorKM(), viaje.getFecha()});
                        totalKmsAcumulados += viaje.getDistanciaTotal();
                        totalPagarTxtField.setText(String.valueOf(totalKmsAcumulados * viaje.getTransportista().getTarifaPorKM()));
                    }
                }
            }
        } else {
            showMessage("Fechas no ingresadas", "Error", "Fecha no valida");
        }


    }//GEN-LAST:event_buscarBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asignarBtn;
    private javax.swing.JPanel asignarSucursalBtn;
    private javax.swing.JPanel background;
    private javax.swing.JPanel barraSuperiorPanel;
    private javax.swing.JPanel buscarBtn;
    private com.toedter.calendar.JDateChooser fechaFinalJDate;
    private com.toedter.calendar.JDateChooser fechaInicioJDate;
    private javax.swing.JLabel fechaLabel2;
    private javax.swing.JLabel fechaLabel3;
    private javax.swing.JLabel fechaLabel4;
    private javax.swing.JLabel ingresarLabel;
    private javax.swing.JLabel ingresarLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel menuDerechoPanel;
    private javax.swing.JPanel registrarViajesBtn;
    private javax.swing.JPanel reportesBtn;
    private javax.swing.JLabel reportesLabel;
    private javax.swing.JTable reportesTable;
    private javax.swing.JLabel textoInformaticoSeleccionLabel;
    private javax.swing.JLabel tituloEsquinaLabel1;
    private javax.swing.JLabel tituloEsquinaLabel2;
    private javax.swing.JTextField totalPagarTxtField;
    private javax.swing.JComboBox<String> transportistasCmb;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
