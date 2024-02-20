package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DTO.CuentaNuevaDTO;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import com.mycompany.cajeropersistencia.exceptions.ValidacionDTOException;
import java.util.ArrayList;

/**
 *
 * @author TeLesheo
 */
public interface ICuentaDAO {

    void agregar(CuentaNuevaDTO cuentaNuevaDTO) throws PersistenciaException, ValidacionDTOException;

    void cancelar(int idCuenta) throws PersistenciaException, ValidacionDTOException;
    
    public ArrayList<Cuenta> lista_cuentas_del_usuario(int id_usuario);
}
