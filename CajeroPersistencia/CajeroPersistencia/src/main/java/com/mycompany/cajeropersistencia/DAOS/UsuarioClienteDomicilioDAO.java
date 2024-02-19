/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class UsuarioClienteDomicilioDAO implements IUsuarioClienteDomicilioDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public UsuarioClienteDomicilioDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public int[] gregar(UsuarioNuevoDTO usuarioNuevo, ClienteNuevoDTO clienteNuevo, DomicilioNuevoDTO domicilioNuevoDTO) throws PersistenciaException {

        String crearCuenta = "CALL CreateUsuarioClienteDomicilio(?,?,?,?,?,?,?,?,?,?);";

        try (Connection conexion = conexionBD.obtenerConexion(); CallableStatement comando = conexion.prepareCall(crearCuenta)) {
            comando.setString(1, usuarioNuevo.getEmail());
            comando.setString(2, usuarioNuevo.getPasscode_usuario());
            comando.setString(3, clienteNuevo.getNombres());
            comando.setString(4, clienteNuevo.getApellido_paterno());
            comando.setString(5, clienteNuevo.getApellido_materno());
            comando.setString(6, clienteNuevo.getFecha_nacimiento());
            comando.setInt(7, domicilioNuevoDTO.getCodigo_postal());
            comando.setString(8, domicilioNuevoDTO.getCalle());
            comando.setInt(9, domicilioNuevoDTO.getNumero_exterior());
            comando.setInt(10, domicilioNuevoDTO.getNumero_interior());

            // Ejecutar el procedimiento almacenado
            boolean resultado = comando.execute();

            if (resultado) {
                logger.log(Level.INFO, "Se creó la cuenta con éxito");

                // Obtener el numeroCuenta directamente con una consulta SELECT
                try (ResultSet resultSet = comando.getResultSet()) {
                    if (resultSet.next()) {
                        int id_usuario = resultSet.getInt("numeroUsuario");
                        int id_cliente = resultSet.getInt("numeroCliente");

                        int[] array = {id_usuario, id_cliente};
                        return array;
                    }
                }
            } else {
                logger.log(Level.SEVERE, "No se pudo crear la cuenta");
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al ejecutar el procedimiento almacenado", ex);
        }

        return null;
    }

}
