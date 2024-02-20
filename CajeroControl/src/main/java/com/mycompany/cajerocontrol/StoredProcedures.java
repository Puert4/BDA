/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajerocontrol;

import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;

/**
 *
 * @author asielapodaca
 */
public class StoredProcedures {
    private Conexion conexion;

    public StoredProcedures(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public void crear_usuario_cliente_domicilio(UsuarioNuevoDTO usuarioNuevo, ClienteNuevoDTO clienteNuevo, DomicilioNuevoDTO domicilioNuevo){
        
    }
}
