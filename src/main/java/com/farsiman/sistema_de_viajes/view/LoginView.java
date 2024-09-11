package com.farsiman.sistema_de_viajes.view;

import com.farsiman.sistema_de_viajes.controller.UsuarioController;
import java.awt.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Component
public class LoginView extends javax.swing.JFrame {

    @Autowired
    UsuarioController usuarioControl;
    @Autowired
    AdministrarSucursalesView administrarSucursalesView;

    public LoginView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        loginIconLabel = new javax.swing.JLabel();
        contraseniaLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        usuarioTxtField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        contraseniaTxtField = new javax.swing.JPasswordField();
        ingresarBtn = new javax.swing.JPanel();
        ingresarLabel = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(0, 51, 51));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logginLogo.png"))); // NOI18N
        background.add(loginIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 158, 154));

        contraseniaLabel.setBackground(new java.awt.Color(255, 255, 255));
        contraseniaLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        contraseniaLabel.setForeground(new java.awt.Color(255, 255, 255));
        contraseniaLabel.setText("Contraseña");
        background.add(contraseniaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 107, -1));

        usuarioLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        usuarioLabel.setText("Usuario");
        background.add(usuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 83, -1));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 260, 12));

        usuarioTxtField.setBackground(new java.awt.Color(0, 50, 51));
        usuarioTxtField.setForeground(new java.awt.Color(102, 102, 102));
        usuarioTxtField.setText("Ingrese su nombre de usuario");
        usuarioTxtField.setBorder(null);
        usuarioTxtField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioTxtFieldMousePressed(evt);
            }
        });
        usuarioTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtFieldActionPerformed(evt);
            }
        });
        background.add(usuarioTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 260, 27));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 260, 12));

        contraseniaTxtField.setBackground(new java.awt.Color(0, 50, 51));
        contraseniaTxtField.setForeground(new java.awt.Color(102, 102, 102));
        contraseniaTxtField.setText("**********");
        contraseniaTxtField.setBorder(null);
        contraseniaTxtField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contraseniaTxtFieldMousePressed(evt);
            }
        });
        background.add(contraseniaTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 260, -1));

        ingresarBtn.setBackground(new java.awt.Color(51, 51, 51));
        ingresarBtn.setForeground(new java.awt.Color(102, 102, 102));
        ingresarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ingresarBtnMousePressed(evt);
            }
        });

        ingresarLabel.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        ingresarLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresarLabel.setText("INGRESAR");
        ingresarLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ingresarBtnLayout = new javax.swing.GroupLayout(ingresarBtn);
        ingresarBtn.setLayout(ingresarBtnLayout);
        ingresarBtnLayout.setHorizontalGroup(
            ingresarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresarBtnLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ingresarLabel)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ingresarBtnLayout.setVerticalGroup(
            ingresarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingresarBtnLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(ingresarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(ingresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 110, 30));

        tituloLabel.setBackground(new java.awt.Color(255, 255, 255));
        tituloLabel.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(204, 204, 204));
        tituloLabel.setText("Sistema de viajes");
        background.add(tituloLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtFieldActionPerformed

    private void usuarioTxtFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioTxtFieldMousePressed
        if (usuarioTxtField.getText().equals("Ingrese su nombre de usuario")) {
            usuarioTxtField.setText("");
            usuarioTxtField.setForeground(Color.WHITE);
        }
        if (String.valueOf(contraseniaTxtField.getPassword()).isEmpty()) {
            contraseniaTxtField.setText("**********");
            contraseniaTxtField.setForeground(Color.GRAY);
        }

    }//GEN-LAST:event_usuarioTxtFieldMousePressed

    private void contraseniaTxtFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseniaTxtFieldMousePressed
        if (String.valueOf(contraseniaTxtField.getPassword()).equals("**********")) {
            contraseniaTxtField.setText("");
            contraseniaTxtField.setForeground(Color.WHITE);
        }
        if (usuarioTxtField.getText().isEmpty()) {
            usuarioTxtField.setText("Ingrese su nombre de usuario");
            usuarioTxtField.setForeground(Color.GRAY);
        }

    }//GEN-LAST:event_contraseniaTxtFieldMousePressed

    private void ingresarBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarBtnMousePressed
        String nombre = usuarioTxtField.getText();
        String contrasenia = String.valueOf(contraseniaTxtField.getPassword());

        boolean result = usuarioControl.validUsuario(nombre, contrasenia);

        if (result) {
            administrarSucursalesView.setVisible(true);
            System.out.println("Se ha validado el usuario");
        }

    }//GEN-LAST:event_ingresarBtnMousePressed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel contraseniaLabel;
    private javax.swing.JPasswordField contraseniaTxtField;
    private javax.swing.JPanel ingresarBtn;
    private javax.swing.JLabel ingresarLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel loginIconLabel;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioTxtField;
    // End of variables declaration//GEN-END:variables
}
