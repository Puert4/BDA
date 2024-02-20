/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajerocontrol;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DAOS.CuentaDAO;
import com.mycompany.cajeropersistencia.DAOS.StoredProceduresDAO;
import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;

/**
 *
 * @author asielapodaca
 */
public class StoredProcedures{
    private Conexion conexion;
    private StoredProceduresDAO spDAO;
    private CuentaDAO cuentaDAO;

    public StoredProcedures(Conexion conexion){
        this.conexion = conexion;
        spDAO = new StoredProceduresDAO(conexion);
        cuentaDAO = new CuentaDAO(conexion);
    }
    
    public int crear_usuario_cliente_domicilio(UsuarioNuevoDTO usuarioNuevo, ClienteNuevoDTO clienteNuevo, DomicilioNuevoDTO domicilioNuevo){
        return spDAO.crear_usuario_cliente_domicilio(usuarioNuevo, clienteNuevo, domicilioNuevo);
    }
    
    public void crear_cuenta(int id_usuario){
        spDAO.crear_cuenta(id_usuario);
    }
    
    public String crear_retiro_sin_cuenta(Cuenta cuenta, float cantidad){
        return spDAO.crear_retiro_sin_cuenta(cuenta, cantidad);
    }
}
