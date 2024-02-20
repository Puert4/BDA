/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.cajeroview;

import com.mycompany.cajerocontrol.Verificadores;
import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeroentidades.Transaccion;
import com.mycompany.cajeropersistencia.DAOS.TransaccionDAO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author asielapodaca
 */
public class CuentaForm extends javax.swing.JDialog {
    private Conexion conexion;
    private Cuenta cuenta;
    private Verificadores verify;
    private Frame parent;
    /**
     * Creates new form TransaccionRetiroSinCuentaForm
     */
    public CuentaForm(java.awt.Frame parent, boolean modal, Conexion conexion, Cuenta cuenta) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.conexion = conexion;
        this.cuenta = cuenta;
        this.verify = new Verificadores(conexion);
        
        if(cuenta.getEstado_cuenta().equals("Activo")){
            this.txt_saldo.setText(String.valueOf(cuenta.getSaldo_mxn()));
        }else{
            this.btn_cancelar_cuenta.setVisible(false);
            this.btn_depositar.setVisible(false);
            this.btn_retiro_sin_cuenta.setVisible(false);
            this.btn_transferencia.setVisible(false);
        }
        
        //Muestra lista de operaciones
        // Lista de cuentas
        JPanel panel_cuentas = new JPanel();
        panel_cuentas.setLayout(new GridLayout(0, 1));
        ArrayList<Transaccion> lista_cuentas = TransaccionDAO.lista_operaciones_de_cuenta(cuenta.getId_cuenta());
        
        for (Cuenta cuenta : lista_cuentas) {
            JPanel panel_cuenta = new JPanel(new BorderLayout());
            JLabel label_cuenta = new JLabel(cuenta.getNumero_cuenta());
            JButton btnVerInfo = new JButton("Ver cuenta");
            btnVerInfo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn_ver_cuentaActionPerformed(e,cuenta);
                }
            });
            panel_cuenta.add(label_cuenta, BorderLayout.CENTER);
            panel_cuenta.add(btnVerInfo, BorderLayout.EAST);
            panel_cuentas.add(panel_cuenta);
        }
        JScrollPane scrollPane = new JScrollPane(panel_cuentas);
        this.contenedor_lista_cuentas.removeAll();
        this.contenedor_lista_cuentas.add(scrollPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_tipo_operacion = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        contenedor_lista_cuentas = new javax.swing.JPanel();
        jsp_historial_operaciones = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_saldo = new javax.swing.JLabel();
        txt_numero_cuenta = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbtn_deposito = new javax.swing.JRadioButton();
        rbtn_retiro_sin_cuenta = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbtn_deposito1 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jcb_rango_fechas = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jdc_fecha_desde = new com.toedter.calendar.JDateChooser();
        jdc_fecha_hasta = new com.toedter.calendar.JDateChooser();
        btn_cancelar_cuenta = new javax.swing.JButton();
        btn_depositar = new javax.swing.JButton();
        btn_retiro_sin_cuenta = new javax.swing.JButton();
        btn_transferencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(17, 31, 77));
        jPanel2.setMinimumSize(new java.awt.Dimension(750, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor_lista_cuentas.setBackground(new java.awt.Color(242, 244, 247));

        jsp_historial_operaciones.setBackground(new java.awt.Color(242, 244, 247));
        jsp_historial_operaciones.setBorder(null);

        javax.swing.GroupLayout contenedor_lista_cuentasLayout = new javax.swing.GroupLayout(contenedor_lista_cuentas);
        contenedor_lista_cuentas.setLayout(contenedor_lista_cuentasLayout);
        contenedor_lista_cuentasLayout.setHorizontalGroup(
            contenedor_lista_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsp_historial_operaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        contenedor_lista_cuentasLayout.setVerticalGroup(
            contenedor_lista_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_lista_cuentasLayout.createSequentialGroup()
                .addComponent(jsp_historial_operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(contenedor_lista_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 650, 250));

        jPanel1.setBackground(new java.awt.Color(0, 114, 179));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MXN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 48));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Avenir Next Condensed", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("$");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 48));

        txt_saldo.setBackground(new java.awt.Color(255, 255, 255));
        txt_saldo.setFont(new java.awt.Font("Avenir Next Condensed", 0, 36)); // NOI18N
        txt_saldo.setForeground(new java.awt.Color(255, 255, 255));
        txt_saldo.setText("0.00 CANCELADA");
        jPanel1.add(txt_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, 48));

        txt_numero_cuenta.setBackground(new java.awt.Color(255, 255, 255));
        txt_numero_cuenta.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        txt_numero_cuenta.setForeground(new java.awt.Color(255, 255, 255));
        txt_numero_cuenta.setText("xxx-xxx");
        jPanel1.add(txt_numero_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, 48));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Saldo total de cuenta:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 48));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Historial de operaciones");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 48));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Número de cuenta:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, 48));

        jPanel3.setBackground(new java.awt.Color(0, 114, 179));

        grupo_tipo_operacion.add(rbtn_deposito);
        rbtn_deposito.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        rbtn_deposito.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_deposito.setText("Deposito");
        rbtn_deposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtn_depositoMouseClicked(evt);
            }
        });
        rbtn_deposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_depositoActionPerformed(evt);
            }
        });

        grupo_tipo_operacion.add(rbtn_retiro_sin_cuenta);
        rbtn_retiro_sin_cuenta.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        rbtn_retiro_sin_cuenta.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_retiro_sin_cuenta.setText("Retiro sin cuenta");
        rbtn_retiro_sin_cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtn_retiro_sin_cuentaMouseClicked(evt);
            }
        });
        rbtn_retiro_sin_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_retiro_sin_cuentaActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de operación");

        grupo_tipo_operacion.add(rbtn_deposito1);
        rbtn_deposito1.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        rbtn_deposito1.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_deposito1.setSelected(true);
        rbtn_deposito1.setText("Todos");
        rbtn_deposito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtn_deposito1MouseClicked(evt);
            }
        });
        rbtn_deposito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_deposito1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtn_deposito)
                    .addComponent(rbtn_retiro_sin_cuenta)
                    .addComponent(jLabel3)
                    .addComponent(rbtn_deposito1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtn_deposito1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtn_deposito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtn_retiro_sin_cuenta)
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 130, 120));

        jPanel4.setBackground(new java.awt.Color(0, 114, 179));

        jcb_rango_fechas.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        jcb_rango_fechas.setForeground(new java.awt.Color(255, 255, 255));
        jcb_rango_fechas.setText("Rango de fechas");
        jcb_rango_fechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_rango_fechasActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Desde:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Avenir Next Condensed", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hasta:");

        jdc_fecha_desde.setBackground(new java.awt.Color(255, 255, 255));
        jdc_fecha_desde.setDateFormatString("dd/MM/yyyy");

        jdc_fecha_hasta.setBackground(new java.awt.Color(255, 255, 255));
        jdc_fecha_hasta.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_rango_fechas)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jdc_fecha_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jcb_rango_fechas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jdc_fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jdc_fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 210, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 170));

        btn_cancelar_cuenta.setBackground(new java.awt.Color(140, 198, 195));
        btn_cancelar_cuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar_cuenta.setForeground(new java.awt.Color(0, 0, 0));
        btn_cancelar_cuenta.setText("Cancelar cuenta");
        btn_cancelar_cuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_cuentaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cancelar_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 160, 40));

        btn_depositar.setBackground(new java.awt.Color(0, 194, 206));
        btn_depositar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_depositar.setForeground(new java.awt.Color(0, 0, 0));
        btn_depositar.setText("Depositar");
        btn_depositar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_depositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_depositarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_depositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 160, 40));

        btn_retiro_sin_cuenta.setBackground(new java.awt.Color(0, 194, 206));
        btn_retiro_sin_cuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_retiro_sin_cuenta.setForeground(new java.awt.Color(0, 0, 0));
        btn_retiro_sin_cuenta.setText("Retiro sin cuenta");
        btn_retiro_sin_cuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_retiro_sin_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retiro_sin_cuentaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_retiro_sin_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 160, 40));

        btn_transferencia.setBackground(new java.awt.Color(0, 194, 206));
        btn_transferencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_transferencia.setForeground(new java.awt.Color(0, 0, 0));
        btn_transferencia.setText("Transferencia");
        btn_transferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transferenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 160, 40));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_retiro_sin_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_retiro_sin_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_retiro_sin_cuentaActionPerformed

    private void rbtn_depositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_depositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_depositoActionPerformed

    private void jcb_rango_fechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_rango_fechasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_rango_fechasActionPerformed

    private void btn_cancelar_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_cuentaActionPerformed
        JOptionPane.showMessageDialog(null, verify.cancelar_cuenta(cuenta));
        this.dispose();
        cuenta.setEstado_cuenta("Cancelado");
        CuentaForm cuentaForm = new CuentaForm(parent, true, conexion, cuenta);
        cuentaForm.setVisible(true);
    }//GEN-LAST:event_btn_cancelar_cuentaActionPerformed

    private void btn_depositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_depositarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_depositarActionPerformed

    private void btn_retiro_sin_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retiro_sin_cuentaActionPerformed
        TransaccionRetiroSinCuenta TRSC = new TransaccionRetiroSinCuenta(this, true, conexion, cuenta);
        TRSC.setVisible(true);
    }//GEN-LAST:event_btn_retiro_sin_cuentaActionPerformed

    private void btn_transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transferenciaActionPerformed

    private void rbtn_retiro_sin_cuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_retiro_sin_cuentaMouseClicked
        
    }//GEN-LAST:event_rbtn_retiro_sin_cuentaMouseClicked

    private void rbtn_depositoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_depositoMouseClicked
        
    }//GEN-LAST:event_rbtn_depositoMouseClicked

    private void rbtn_deposito1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_deposito1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_deposito1MouseClicked

    private void rbtn_deposito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_deposito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_deposito1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar_cuenta;
    private javax.swing.JButton btn_depositar;
    private javax.swing.JButton btn_retiro_sin_cuenta;
    private javax.swing.JButton btn_transferencia;
    private javax.swing.JPanel contenedor_lista_cuentas;
    private javax.swing.ButtonGroup grupo_tipo_operacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JCheckBox jcb_rango_fechas;
    private com.toedter.calendar.JDateChooser jdc_fecha_desde;
    private com.toedter.calendar.JDateChooser jdc_fecha_hasta;
    private javax.swing.JScrollPane jsp_historial_operaciones;
    private javax.swing.JRadioButton rbtn_deposito;
    private javax.swing.JRadioButton rbtn_deposito1;
    private javax.swing.JRadioButton rbtn_retiro_sin_cuenta;
    private javax.swing.JLabel txt_numero_cuenta;
    private javax.swing.JLabel txt_saldo;
    // End of variables declaration//GEN-END:variables
}
