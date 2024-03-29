package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DTO.CuentaNuevaDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import com.mycompany.cajeropersistencia.exceptions.ValidacionDTOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo 
 */
public class CuentaDAO implements ICuentaDAO {

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregar(CuentaNuevaDTO cuentaNuevaDTO) throws PersistenciaException, ValidacionDTOException {
        if (cuentaNuevaDTO == null || cuentaNuevaDTO.getSaldo_mxn() < 0) {
            throw new ValidacionDTOException("La cuenta no puede ser nula y el saldo no puede ser negativo.");
        }

        String sentenciaSQL = """
            INSERT INTO cuentas(saldo_mxn, estado_cuenta, fecha_apertura)
            VALUES (?, ?, ?);""";
        try (Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setFloat(1, cuentaNuevaDTO.getSaldo_mxn());
            comando.setString(2, cuentaNuevaDTO.getEstado_cuenta());
            comando.setString(3, cuentaNuevaDTO.getFecha_apertura());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregó {0} cuenta", numeroRegistrosInsertados);
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo guardar la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta", e);
        }
    }

    @Override
    public void cancelar(int idCuenta) throws PersistenciaException, ValidacionDTOException {
        if (idCuenta <= 0) {
            throw new ValidacionDTOException("El ID de la cuenta debe ser un número positivo.");
        }

        String sentenciaSQL = "UPDATE Cuentas SET estado = 'Cancelado' WHERE id_cuenta = ?";
        try (Connection conexion = this.conexion.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setInt(1, idCuenta);

            int numeroRegistrosCancelados = comando.executeUpdate();

            logger.log(Level.INFO, "Se canceló {0} cuenta", numeroRegistrosCancelados);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo cancelar la cuenta", ex);
            throw new PersistenciaException("No se pudo cancelar la cuenta", ex);
        }
    }

    @Override
    public ArrayList<Cuenta> lista_cuentas_del_usuario(int id_usuario) {
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
