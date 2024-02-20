/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeroentidades;

import java.util.Objects;

/**
 *
 * @author TeLesheo
 */
public class Transaccion {

    //public, private
    int id_transaccion;
    int id_cuenta;
    String fecha_hora;
    float cantidad;

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, String fecha_hora, float cantidad, int id_cuenta) {
        this.id_transaccion = id_transaccion;
        this.fecha_hora = fecha_hora;
        this.cantidad = cantidad;
        this.id_cuenta = id_cuenta;
    }

    public Transaccion(String fecha_hora, float cantidad) {
        this.id_transaccion = id_transaccion;
        this.fecha_hora = fecha_hora;
        this.cantidad = cantidad;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_transaccion;
        hash = 37 * hash + Objects.hashCode(this.fecha_hora);
        hash = 37 * hash + Float.floatToIntBits(this.cantidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaccion other = (Transaccion) obj;
        if (this.id_transaccion != other.id_transaccion) {
            return false;
        }
        if (Float.floatToIntBits(this.cantidad) != Float.floatToIntBits(other.cantidad)) {
            return false;
        }
        return Objects.equals(this.fecha_hora, other.fecha_hora);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("id_transaccion=").append(id_transaccion);
        sb.append(", fecha_hora=").append(fecha_hora);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

}
