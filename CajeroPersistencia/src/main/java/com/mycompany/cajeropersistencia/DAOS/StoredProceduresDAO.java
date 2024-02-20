/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author asielapodaca
 */
public class StoredProceduresDAO {
    private Conexion conexion;

    public StoredProceduresDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public int crear_usuario_cliente_domicilio(UsuarioNuevoDTO usuarioNuevo, ClienteNuevoDTO clienteNuevo, DomicilioNuevoDTO domicilioNuevo){
        try (Connection connection = conexion.obtenerConexion()) {
            String procedureCall = "{call CreateUsuarioClienteDomicilio(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(procedureCall);
            
            // Configura los parámetros del procedimiento almacenado
            statement.setString(1, usuarioNuevo.getEmail());
            statement.setString(2, usuarioNuevo.getPasscode_usuario());
            statement.setString(3, clienteNuevo.getNombres());
            statement.setString(4, clienteNuevo.getApellido_paterno());
            statement.setString(5, clienteNuevo.getApellido_materno());
            statement.setDate(6, java.sql.Date.valueOf(clienteNuevo.getFecha_nacimiento()));
            statement.setInt(7, domicilioNuevo.getCodigo_postal());
            statement.setString(8, domicilioNuevo.getCalle());
            statement.setInt(9, domicilioNuevo.getNumero_exterior());
            statement.setInt(10, domicilioNuevo.getNumero_interior());

            // Ejecuta el procedimiento almacenado
            statement.execute();

            // Obtiene los resultados
            ResultSet rs = statement.getResultSet();
            if (rs.next()) {
                int numeroUsuario = rs.getInt("numeroUsuario");
                int numeroCliente = rs.getInt("numeroCliente");
                System.out.println("Usuario creado con ID: " + numeroUsuario);
                System.out.println("Cliente creado con ID: " + numeroCliente);
                
                return numeroUsuario; // id_usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public void crear_cuenta(int id_usuario){
        try (Connection connection = conexion.obtenerConexion()) {
            String procedureCall = "{call CrearCuentaUsuario(?)}";
            CallableStatement statement = connection.prepareCall(procedureCall);
            
            // Configura los parámetros del procedimiento almacenado
            statement.setInt(1, id_usuario);

            // Ejecuta el procedimiento almacenado
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String crear_retiro_sin_cuenta(Cuenta cuenta, float cantidad){
        try (Connection connection = conexion.obtenerConexion()) {
            String procedureCall = "{call AgregarTransaccion(?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(procedureCall);
            
            // Configura los parámetros del procedimiento almacenado
            statement.setFloat(1, cantidad);
            statement.setInt(2, cuenta.getId_cuenta());
            statement.setString(3, "RetiroSinCuenta");

            // Ejecuta el procedimiento almacenado
            statement.execute();

            // Obtiene los resultados
            ResultSet rs = statement.getResultSet();
            if (rs.next()) {
                String folio = rs.getString("folio");
                String codigo = rs.getString("codigo");
                System.out.println("Folio " + folio);
                System.out.println("Codigo " + codigo);
                
                return "Folio: "+folio+", Código: "+codigo+", recuerda que esta operación solo será valida dentro de 10 minutos";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return "No se pudo hacer la operación";
    }
}
