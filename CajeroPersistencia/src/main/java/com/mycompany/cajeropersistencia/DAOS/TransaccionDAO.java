/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeroentidades.Transaccion;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class TransaccionDAO implements ITransaccionDAO{

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public TransaccionDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    
    @Override
    public ArrayList<Transaccion> lista_operaciones_de_cuenta() {
        ArrayList<Cuenta> lista_cuentas = new ArrayList<>();
        try (Connection connection = conexion.obtenerConexion()) {
            // Consulta SQL para obtener todas las cuentas del usuario
            String sql = "SELECT * FROM Cuentas WHERE id_usuario = "+id_usuario+";";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Itera sobre el resultado y muestra la información de cada cuenta
            while (rs.next()) {
                Cuenta cuenta = new Cuenta(
                        rs.getInt("id_cuenta"),
                        rs.getString("numero_cuenta"),
                        rs.getFloat("saldo_mxn"),
                        rs.getString("estado"),
                        rs.getDate("fecha_apertura").toString()
                );
                lista_cuentas.add(cuenta);
            }
            return lista_cuentas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
