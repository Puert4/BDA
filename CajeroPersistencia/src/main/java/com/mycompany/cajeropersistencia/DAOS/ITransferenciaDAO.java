/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;

/**
 *
 * @author TeLesheo
 */
public interface ITransferenciaDAO {
    public void  transferencia(float cantidad, int cuenta_origen, int cuenta_destino)throws PersistenciaException;
}
