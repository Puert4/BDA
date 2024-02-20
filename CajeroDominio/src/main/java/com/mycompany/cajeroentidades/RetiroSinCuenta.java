/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeroentidades;

/**
 *
 * @author TeLesheo
 */
public class RetiroSinCuenta extends Transaccion {

    private int codigo;
    private String folio;
    private String estado;

    public RetiroSinCuenta(int codigo, String folio, String estado, int id_transaccion, String fecha_hora, float cantidad, String tipo, int id_cuenta) {
        super(id_transaccion, fecha_hora, cantidad, tipo, id_cuenta);
        this.codigo = codigo;
        this.folio = folio;
        this.estado = estado;
    }

    public RetiroSinCuenta(int codigo, String folio, String estado, String fecha_hora, float cantidad) {
        super(fecha_hora, cantidad);
        this.codigo = codigo;
        this.folio = folio;
        this.estado = estado;
    }
}
