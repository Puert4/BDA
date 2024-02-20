package com.mycompany.cajeropersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class Conexion implements IConexion {
    
   
    final String cadenaConexion = "jdbc:mysql://localhost/Banco";
    final String usuario = "root";
    //final String password = "julian";
    final String password = "3Tristestigres";
    static final Logger logger = Logger.getLogger(Conexion.class.getName());


    @Override
    public Connection obtenerConexion() throws SQLException {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
            logger.log(Level.INFO, "Conexion Establecida {0}", cadenaConexion);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al conectar con la base de datos: {0}", ex.getMessage());
            throw ex; // Re-lanzar la excepción para que el código que llama pueda manejarla apropiadamente
        }
        return conexion;
    }
    
}