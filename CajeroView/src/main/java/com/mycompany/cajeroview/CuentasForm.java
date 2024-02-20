/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cajeroview;

import com.mycompany.cajerocontrol.StoredProcedures;
import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DAOS.CuentaDAO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author TeLesheo
 */
public class CuentasForm extends javax.swing.JFrame {
    private Conexion conexion;
    private int id_usuario;
    private StoredProcedures sp;
    private CuentaDAO cuentaDAO;
    /**
     * Creates new form CuentasForm
     */
    public CuentasForm(Conexion conexion, int id_usuario) {
        initComponents();
        this.conexion = conexion;
        this.cuentaDAO = new CuentaDAO(conexion);
        this.id_usuario = id_usuario;
        sp = new StoredProcedures(conexion);
        
        // Lista de cuentas
        JPanel panel_cuentas = new JPanel();
        panel_cuentas.setLayout(new GridLayout(0, 1));
        ArrayList<Cuenta> lista_cuentas = cuentaDAO.lista_cuentas_del_usuario(this.id_usuario);
        
        for (Cuenta cuenta : lista_cuentas) {
            JPanel panel_cuenta = new JPanel(new BorderLayout());
            JLabel label_cuenta = new JLabel(cuenta.getNumero_cuenta());
            JButton btnVerInfo = new JButton("Ver cuenta");
            btnVerInfo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aquí puedes implementar la lógica para ver la información de la cuenta
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        contenedor_lista_cuentas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_crear_cuenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_perfil = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_cerrar_sesion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(17, 31, 77));
        jPanel2.setMinimumSize(new java.awt.Dimension(750, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor_lista_cuentas.setBackground(new java.awt.Color(242, 244, 247));
        contenedor_lista_cuentas.setLayout(new java.awt.BorderLayout());
        jPanel2.add(contenedor_lista_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 650, 350));

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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Avenir Next Condensed", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("0.00");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, 48));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Avenir Next Condensed", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Saldo total de cuentas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 48));

        btn_crear_cuenta.setBackground(new java.awt.Color(0, 194, 206));
        btn_crear_cuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_crear_cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_crear_cuentaMouseClicked(evt);
            }
        });
        btn_crear_cuenta.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Galvji", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear cuenta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 38, 14, 38);
        btn_crear_cuenta.add(jLabel1, gridBagConstraints);

        jPanel1.add(btn_crear_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        btn_perfil.setBackground(new java.awt.Color(0, 194, 206));
        btn_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_perfilMouseClicked(evt);
            }
        });
        btn_perfil.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Galvji", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Perfil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 38, 14, 38);
        btn_perfil.add(jLabel3, gridBagConstraints);

        jPanel1.add(btn_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        btn_cerrar_sesion.setBackground(new java.awt.Color(140, 198, 195));
        btn_cerrar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cerrar_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cerrar_sesionMouseClicked(evt);
            }
        });
        btn_cerrar_sesion.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Galvji", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cerrar sesión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 38, 14, 38);
        btn_cerrar_sesion.add(jLabel4, gridBagConstraints);

        jPanel1.add(btn_cerrar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 170));

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

    private void btn_ver_cuentaActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    private void btn_crear_cuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crear_cuentaMouseClicked
        sp.crear_cuenta(id_usuario);
        this.dispose();
        CuentasForm cuentasForm = new CuentasForm(conexion, id_usuario);
        cuentasForm.setVisible(true);
        cuentasForm.setVisible(true);
        cuentasForm.setVisible(true);
        cuentasForm.setVisible(true);
        
        
        

    }//GEN-LAST:event_btn_crear_cuentaMouseClicked

    private void btn_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_perfilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_perfilMouseClicked

    private void btn_cerrar_sesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cerrar_sesionMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_cerrar_sesionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_cerrar_sesion;
    private javax.swing.JPanel btn_crear_cuenta;
    private javax.swing.JPanel btn_perfil;
    private javax.swing.JPanel contenedor_lista_cuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
