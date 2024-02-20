/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajerocontrol;

import com.mycompany.cajeroentidades.Cliente;
import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DAOS.CuentaDAO;
import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import com.mycompany.cajeropersistencia.exceptions.ValidacionDTOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class Verificadores {

    private final IConexion conexion;
    private CuentaDAO cuentaDAO;
    private static final Logger LOG = Logger.getLogger(Verificadores.class.getName());
    
    public Verificadores(IConexion conexion) {
        this.conexion = conexion;
        this.cuentaDAO = new CuentaDAO(conexion);
    }

    /**
     * Verifies if the email and passcode exist and correspond to the same user
     * in the database.
     *
     * @param correo The email to verify.
     * @param passcode The passcode to verify.
     * @return true if the email and passcode exist and correspond to the same
     * user, false otherwise.
     */
    public int verificarCredenciales(String correo, String passcode) {
        // SQL query to select the user ID from the usuarios table where the email and password match
        String sql = "SELECT id_usuario FROM usuarios WHERE email = ? AND passcode = ?";

        try (
                // Establishing a database connection and creating a prepared statement
                Connection conexionBD = conexion.obtenerConexion(); PreparedStatement preparedStatement = conexionBD.prepareStatement(sql)) {
            // Setting the email and password as parameters of the prepared statement
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, passcode);

            try (
                    // Executing the query and retrieving the result set
                    ResultSet result = preparedStatement.executeQuery()) {
                // Checking if the result set has at least one row
                if (result.next()) {
                    // Retrieving the user ID from the result set
                    return result.getInt("id_usuario");
                }
            }
        } catch (SQLException e) {
            // Handling SQLException by printing the stack trace for debugging
            e.printStackTrace();
            // Returning a value (-1) indicating failure in verifying credentials
        }
        // Returning -1 if an SQLException occurs or if no matching rows are found
        return -1;
    }

    /**
     * Verifies if an email already exists in the database.
     *
     * @param correo The email to verify.
     * @return true if the email already exists, false otherwise.
     */
    public boolean verificarEmailExistente(String correo) {
        String sql = "SELECT COUNT(*) AS total FROM usuarios WHERE email = ?";
        try (Connection conexionBD = conexion.obtenerConexion(); PreparedStatement preparedStatement = conexionBD.prepareStatement(sql)) {
            preparedStatement.setString(1, correo);
            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    int total = result.getInt("total");
                    return total > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception properly
        }
        return false;
    }
    
    public String verificar_retiro_sin_cuenta(String folio, String codigo){
        // SQL query to select the user ID from the usuarios table where the email and password match
        
        String sql = "SELECT id_transaccion FROM RetirosSinCuenta WHERE folio = ? AND codigo = ?";

        try (
            // Establishing a database connection and creating a prepared statement
            Connection conexionBD = conexion.obtenerConexion();
            PreparedStatement preparedStatement = conexionBD.prepareStatement(sql)) {
            // Setting the email and password as parameters of the prepared statement
            preparedStatement.setString(1, folio);
            preparedStatement.setString(2, codigo);

            try (
                    // Executing the query and retrieving the result set
                    ResultSet result = preparedStatement.executeQuery()) {
                // Checking if the result set has at least one row
                if (result.next()) {
                    
                    try {
                        return validar_retiro(folio, codigo);
                    } catch (PersistenciaException ex) {
                        Logger.getLogger(Verificadores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        } catch (SQLException e) {
            // Handling SQLException by printing the stack trace for debugging
            e.printStackTrace();
            // Returning a value (-1) indicating failure in verifying credentials
        }
        // Returning -1 if an SQLException occurs or if no matching rows are found
        return "No se encontró esta operación";
    }
    
    public String validar_retiro(String folio, String codigo) throws PersistenciaException {

        String sentenciaSQL = "UPDATE RetirosSinCuenta SET estado = 'Cobrado' WHERE folio = ? AND codigo = ?";
        try (
            Connection conexion = this.conexion.obtenerConexion();
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, folio);
            comando.setString(2, codigo);

            int numeroRegistrosInsertados = comando.executeUpdate();
            
            return "Se ha retirado el dinero";
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el retiro sin cuenta", ex);
            throw new PersistenciaException("No se pudo actualizar el retiro sin cuent", ex);
        }
    }
    
    public String cancelar_cuenta(Cuenta cuenta){
        if(cuenta.getSaldo_mxn() != 0){
            return "Debes vaciar el saldo de la cuenta para poder cancelar.";
        }
        try {
            cuentaDAO.cancelar(cuenta.getId_cuenta());
        } catch (PersistenciaException ex) {
            Logger.getLogger(Verificadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidacionDTOException ex) {
            Logger.getLogger(Verificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "El estado de la cuenta ha cambiado a cancelado.";
    }
}
