package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DTO.CuentaNuevaDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import com.mycompany.cajeropersistencia.exceptions.ValidacionDTOException;

/**
 *
 * @author TeLesheo
 */
public interface ICuentaDAO {

    Cuenta agregar(CuentaNuevaDTO cuentaNuevaDTO, int id_usuario) throws PersistenciaException, ValidacionDTOException;

    boolean cancelar(int idCuenta) throws PersistenciaException, ValidacionDTOException;
}
