package com.mycompany.cajeroentidades;

/**
 *
 * @author TeLesheo
 */
public class Transferencias extends Transaccion {

    private int id_transferencia;
    private int id_remitente;
    private int id_destino;

    /**
     *
     */
    public Transferencias() {
      
    }

    public Transferencias(int id_transaccion, String fecha_hora, float cantidad, int id_remitente, int id_destino) {
        super(id_transaccion, fecha_hora, cantidad);
        this.id_remitente = id_remitente;
        this.id_destino = id_destino;
    }

    public Transferencias(String fecha_hora, float cantidad, int id_remitente, int id_destino) {
        super(fecha_hora, cantidad);
        this.id_remitente = id_remitente;
        this.id_destino = id_destino;
    }

    public int getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(int id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public int getId_remitente() {
        return id_remitente;
    }

    public void setId_remitente(int id_remitente) {
        this.id_remitente = id_remitente;
    }

    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
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
        hash = 17 * hash + this.id_transferencia;
        hash = 17 * hash + this.id_remitente;
        hash = 17 * hash + this.id_destino;
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
        final Transferencias other = (Transferencias) obj;
        if (this.id_transferencia != other.id_transferencia) {
            return false;
        }
        if (this.id_remitente != other.id_remitente) {
            return false;
        }
        return this.id_destino == other.id_destino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencias{");
        sb.append("id_transferencia=").append(id_transferencia);
        sb.append(", id_remitente=").append(id_remitente);
        sb.append(", id_destino=").append(id_destino);
        sb.append('}');
        return sb.toString();
    }
    
    
}
