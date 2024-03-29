/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cajeroview;

import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.CuentaNuevaDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.IConexion;

/**
 *
 * @author TeLesheo
 */
public class CuentasForm extends javax.swing.JFrame {

    private UsuarioNuevoDTO usuarioNuevo;
    private IConexion conexionBD;

    /**
     * Creates new form CuentasForm
     */
    public CuentasForm(IConexion conexionBD, UsuarioNuevoDTO usuarioNuevo) {
        initComponents();
        this.conexionBD = conexionBD;
        this.usuarioNuevo = usuarioNuevo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_crear_cuenta = new javax.swing.JButton();
        btn_cerrar_sesion = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btn_retiro_sin_cuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_crear_cuenta.setText("Crear Cuenta");
        btn_crear_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_cuentaActionPerformed(evt);
            }
        });

        btn_cerrar_sesion.setText("Cerrar Sesion");

        btn_retiro_sin_cuenta.setText("Crear Retirno Sin Cuenta");
        btn_retiro_sin_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retiro_sin_cuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(328, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_crear_cuenta)
                        .addGap(55, 55, 55)
                        .addComponent(btn_cerrar_sesion)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_retiro_sin_cuenta)
                        .addGap(70, 70, 70))))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear_cuenta)
                    .addComponent(btn_cerrar_sesion))
                .addGap(58, 58, 58)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btn_retiro_sin_cuenta)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crear_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_cuentaActionPerformed
        // TODO add your handling code here:
        CrearCuentaForm crearCuentaForm = new CrearCuentaForm(conexionBD, usuarioNuevo);
        crearCuentaForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_crear_cuentaActionPerformed

    private void btn_retiro_sin_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retiro_sin_cuentaActionPerformed
        // TODO add your handling code here:
        CrearRetiroSinCuenta crearRetiroSIncuenta = new CrearRetiroSinCuenta(conexionBD,usuarioNuevo);
        crearRetiroSIncuenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_retiro_sin_cuentaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CuentasForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar_sesion;
    private javax.swing.JButton btn_crear_cuenta;
    private javax.swing.JButton btn_retiro_sin_cuenta;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
