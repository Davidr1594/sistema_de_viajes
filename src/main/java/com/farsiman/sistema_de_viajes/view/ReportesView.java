
package com.farsiman.sistema_de_viajes.view;

import java.awt.Color;

/**
 *
 * @author david
 */
public class ReportesView extends javax.swing.JFrame {

 
    public ReportesView() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        menuDerechoPanel = new javax.swing.JPanel();
        asignarSucursalBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        verAsignacionesBtn = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        registrarViajesBtn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        verViajesBtn = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        reportesBtn = new javax.swing.JPanel();
        reportesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colaboradoresTable = new javax.swing.JTable();
        textoInformaticoSeleccionLabel = new javax.swing.JLabel();
        kmTxtField = new javax.swing.JTextField();
        asignarBtn = new javax.swing.JPanel();
        ingresarLabel = new javax.swing.JLabel();
        sucursalSeleccionadaTxtField1 = new javax.swing.JTextField();
        fechaLabel2 = new javax.swing.JLabel();
        fechaLabel3 = new javax.swing.JLabel();
        sucursalSeleccionadaTxtField2 = new javax.swing.JTextField();
        fechaLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

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
                .addGap(128, 128, 128)
                .addComponent(tituloEsquinaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(usuarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background.add(barraSuperiorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 30));

        menuDerechoPanel.setBackground(new java.awt.Color(51, 51, 51));
        menuDerechoPanel.setForeground(new java.awt.Color(51, 51, 51));

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
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        asignarSucursalBtnLayout.setVerticalGroup(
            asignarSucursalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, asignarSucursalBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        verAsignacionesBtn.setBackground(new java.awt.Color(51, 51, 51));
        verAsignacionesBtn.setForeground(new java.awt.Color(51, 51, 51));
        verAsignacionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verAsignacionesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verAsignacionesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verAsignacionesBtnMouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ver Asignaciones");

        javax.swing.GroupLayout verAsignacionesBtnLayout = new javax.swing.GroupLayout(verAsignacionesBtn);
        verAsignacionesBtn.setLayout(verAsignacionesBtnLayout);
        verAsignacionesBtnLayout.setHorizontalGroup(
            verAsignacionesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verAsignacionesBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        verAsignacionesBtnLayout.setVerticalGroup(
            verAsignacionesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, verAsignacionesBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

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
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registrarViajesBtnLayout.setVerticalGroup(
            registrarViajesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarViajesBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        verViajesBtn.setBackground(new java.awt.Color(51, 51, 51));
        verViajesBtn.setForeground(new java.awt.Color(51, 51, 51));
        verViajesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verViajesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verViajesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verViajesBtnMouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ver Viajes");

        javax.swing.GroupLayout verViajesBtnLayout = new javax.swing.GroupLayout(verViajesBtn);
        verViajesBtn.setLayout(verViajesBtnLayout);
        verViajesBtnLayout.setHorizontalGroup(
            verViajesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verViajesBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        verViajesBtnLayout.setVerticalGroup(
            verViajesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, verViajesBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout menuDerechoPanelLayout = new javax.swing.GroupLayout(menuDerechoPanel);
        menuDerechoPanel.setLayout(menuDerechoPanelLayout);
        menuDerechoPanelLayout.setHorizontalGroup(
            menuDerechoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(asignarSucursalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(verAsignacionesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(verViajesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDerechoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registrarViajesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuDerechoPanelLayout.setVerticalGroup(
            menuDerechoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDerechoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asignarSucursalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verAsignacionesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarViajesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verViajesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background.add(menuDerechoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 110, 180));

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
        jScrollPane1.setViewportView(colaboradoresTable);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 670, 140));

        textoInformaticoSeleccionLabel.setBackground(new java.awt.Color(255, 255, 255));
        textoInformaticoSeleccionLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        textoInformaticoSeleccionLabel.setForeground(new java.awt.Color(255, 255, 255));
        textoInformaticoSeleccionLabel.setText("Cantidad todal a pagar:");
        background.add(textoInformaticoSeleccionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        kmTxtField.setBackground(new java.awt.Color(51, 51, 51));
        background.add(kmTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 130, 20));

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

        background.add(asignarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 100, 20));

        sucursalSeleccionadaTxtField1.setBackground(new java.awt.Color(51, 51, 51));
        background.add(sucursalSeleccionadaTxtField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 130, 20));

        fechaLabel2.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel2.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel2.setText("al");
        background.add(fechaLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        fechaLabel3.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel3.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel3.setText("Seleccione un Transportista: ");
        background.add(fechaLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        sucursalSeleccionadaTxtField2.setBackground(new java.awt.Color(51, 51, 51));
        background.add(sucursalSeleccionadaTxtField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 130, 20));

        fechaLabel4.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel4.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        fechaLabel4.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel4.setText("Rando de fecha desde: ");
        background.add(fechaLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        background.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 180, 20));

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

    private void asignarSucursalBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMousePressed

    }//GEN-LAST:event_asignarSucursalBtnMousePressed

    private void asignarSucursalBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMouseEntered
        asignarSucursalBtn.setBackground(Color.gray);
    }//GEN-LAST:event_asignarSucursalBtnMouseEntered

    private void asignarSucursalBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarSucursalBtnMouseExited
        asignarSucursalBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_asignarSucursalBtnMouseExited

    private void verAsignacionesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAsignacionesBtnMouseEntered
        verAsignacionesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_verAsignacionesBtnMouseEntered

    private void registrarViajesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMouseEntered
        registrarViajesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_registrarViajesBtnMouseEntered

    private void registrarViajesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarViajesBtnMouseExited
        registrarViajesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_registrarViajesBtnMouseExited

    private void verViajesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verViajesBtnMouseEntered
        verViajesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_verViajesBtnMouseEntered

    private void verViajesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verViajesBtnMouseExited
        verViajesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_verViajesBtnMouseExited

    private void reportesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseEntered
        reportesBtn.setBackground(Color.gray);
    }//GEN-LAST:event_reportesBtnMouseEntered

    private void reportesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesBtnMouseExited
        reportesBtn.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_reportesBtnMouseExited

    private void verAsignacionesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAsignacionesBtnMouseExited
        verAsignacionesBtn.setBackground(new java.awt.Color(51, 51, 51)); 
    }//GEN-LAST:event_verAsignacionesBtnMouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable colaboradoresTable;
    private javax.swing.JLabel fechaLabel2;
    private javax.swing.JLabel fechaLabel3;
    private javax.swing.JLabel fechaLabel4;
    private javax.swing.JLabel ingresarLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField kmTxtField;
    private javax.swing.JPanel menuDerechoPanel;
    private javax.swing.JPanel registrarViajesBtn;
    private javax.swing.JPanel reportesBtn;
    private javax.swing.JLabel reportesLabel;
    private javax.swing.JTextField sucursalSeleccionadaTxtField1;
    private javax.swing.JTextField sucursalSeleccionadaTxtField2;
    private javax.swing.JLabel textoInformaticoSeleccionLabel;
    private javax.swing.JLabel tituloEsquinaLabel1;
    private javax.swing.JLabel tituloEsquinaLabel2;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JPanel verAsignacionesBtn;
    private javax.swing.JPanel verViajesBtn;
    // End of variables declaration//GEN-END:variables
}
