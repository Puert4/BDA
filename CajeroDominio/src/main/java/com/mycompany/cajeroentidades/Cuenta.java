package com.mycompany.cajeroentidades;

import java.util.Objects;

/**
 *
 * @author TeLesheo
 */
public class Cuenta {

    private int id_cuenta;
    private float saldo_mxn;
    private String estado_cuenta;
    private String fecha_apertura;

    public Cuenta() {

    }

    public Cuenta(int id, float saldo_mxn, String estado, String fecha_apertura) {
        this.id_cuenta = id;
        this.saldo_mxn = saldo_mxn;
        this.estado_cuenta = estado;
        this.fecha_apertura = fecha_apertura;

    }

    public Cuenta(float saldo_mxn, String estado, String fecha_apertura) {
        this.saldo_mxn = saldo_mxn;
        this.estado_cuenta = estado;
        this.fecha_apertura = fecha_apertura;

    }

    public int getId() {
        return id_cuenta;
    }

    public void setId(int id) {
        this.id_cuenta = id;
    }

    public float getSaldo_mxn() {
        return saldo_mxn;
    }

    public void setSaldo_mxn(float saldo_mxn) {
        this.saldo_mxn = saldo_mxn;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id_cuenta;
        hash = 79 * hash + Float.floatToIntBits(this.saldo_mxn);
        hash = 79 * hash + Objects.hashCode(this.estado_cuenta);
        hash = 79 * hash + Objects.hashCode(this.fecha_apertura);
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
        final Cuenta other = (Cuenta) obj;
        if (this.id_cuenta != other.id_cuenta) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo_mxn) != Float.floatToIntBits(other.saldo_mxn)) {
            return false;
        }
        if (!Objects.equals(this.estado_cuenta, other.estado_cuenta)) {
            return false;
        }
        return Objects.equals(this.fecha_apertura, other.fecha_apertura);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("id=").append(id_cuenta);
        sb.append(", saldo_mxn=").append(saldo_mxn);
        sb.append(", estado=").append(estado_cuenta);
        sb.append(", fecha_apertura=").append(fecha_apertura);
        sb.append('}');
        return sb.toString();
    }
    
    
}
