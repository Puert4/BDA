/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.cajeroview;

import com.mycompany.cajeropersistencia.conexion.Conexion;

/**
 *
 * @author asielapodaca
 */
public class LogInForm extends javax.swing.JDialog {
private Conexion conexion;
    /**
     * Creates new form LogInForm
     */
    public LogInForm(java.awt.Frame parent, boolean modal, Conexion conexion) {
        super(parent, modal);
        initComponents();
        this.conexion = conexion;
    }

    public void LogIn() {
        String correo = txt_email.getText();
        String passcode = txt_passcode.getText();
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_passcode = new javax.swing.JPasswordField();
        btn_iniciar_sesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_registrate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(17, 31, 77));
        jPanel2.setMinimumSize(new java.awt.Dimension(750, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 500));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(242, 244, 247));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 48));

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 278, 44));

        txt_passcode.setBackground(new java.awt.Color(255, 255, 255));
        txt_passcode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_passcode.setToolTipText("Contraseña");
        txt_passcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passcodeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_passcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 280, 47));

        btn_iniciar_sesion.setBackground(new java.awt.Color(0, 194, 206));
        btn_iniciar_sesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_iniciar_sesion.setForeground(new java.awt.Color(242, 244, 247));
        btn_iniciar_sesion.setText("Iniciar Sesion");
        btn_iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_sesionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 125, 38));

        jLabel3.setText("¿Eres nuevo?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        btn_registrate.setForeground(new java.awt.Color(0, 153, 255));
        btn_registrate.setText("Registrate");
        btn_registrate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registrateMouseClicked(evt);
            }
        });
        jPanel1.add(btn_registrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Inicio de sesion de usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 48));

        jLabel4.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Correo electrónico");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, 48));

        jPanel2.add(jPanel1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_passcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passcodeActionPerformed

    private void btn_iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_sesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciar_sesionActionPerformed

    private void btn_registrateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_registrateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar_sesion;
    private javax.swing.JLabel btn_registrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_passcode;
    // End of variables declaration//GEN-END:variables
}
