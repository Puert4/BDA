/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class TransferenciaDAO implements ITransferenciaDAO{

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public TransferenciaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void transferencia(float cantidad, int cuenta_origen, int cuenta_destino) throws PersistenciaException {
        
    }

}
