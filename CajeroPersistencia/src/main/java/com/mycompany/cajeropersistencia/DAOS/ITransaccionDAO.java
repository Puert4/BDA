/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Transaccion;
import java.util.ArrayList;

/**
 *
 * @author TeLesheo
 */
public interface ITransaccionDAO {
    public ArrayList<Transaccion> lista_operaciones_de_cuenta(int id_cuenta);
}
