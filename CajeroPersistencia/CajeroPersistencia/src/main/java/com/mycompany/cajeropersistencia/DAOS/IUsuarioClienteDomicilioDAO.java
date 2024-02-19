/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;

/**
 *
 * @author TeLesheo
 */
public interface IUsuarioClienteDomicilioDAO {
    
    int [] gregar(UsuarioNuevoDTO usuarioNuevo,ClienteNuevoDTO clienteNUevo,DomicilioNuevoDTO domicilioNuevo) throws PersistenciaException;
}
