package com.mycompany.cajeroentidades;

import java.util.Objects;

/**
 *
 * @author TeLesheo
 */
public class DomicilioCliente {

    private String id_domicilio;
    private String calle;
    private int numero_interior;
    private int numero_exterior;
    private int id_cliente;
    private int codigo_postal;

    public DomicilioCliente() {

    }

    public DomicilioCliente(String domicilio, String calle, int numero_interior, int numero_exterior, int id_cliente, int codigo_postal) {
        this.id_domicilio = id_domicilio;
        this.calle = calle;
        this.numero_interior = numero_interior;
        this.numero_exterior = numero_exterior;
        this.id_cliente = id_cliente;
        this.codigo_postal = codigo_postal;
    }

    public DomicilioCliente(String calle, int numero_interior, int numero_exterior, int id_cliente, int codigo_postal) {
        this.calle = calle;
        this.numero_interior = numero_interior;
        this.numero_exterior = numero_exterior;
        this.id_cliente = id_cliente;
        this.codigo_postal = codigo_postal;
    }

    public String getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(String id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(int numero_interior) {
        this.numero_interior = numero_interior;
    }

    public int getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id_domicilio);
        hash = 13 * hash + Objects.hashCode(this.calle);
        hash = 13 * hash + this.numero_interior;
        hash = 13 * hash + this.numero_exterior;
        hash = 13 * hash + this.id_cliente;
        hash = 13 * hash + this.codigo_postal;
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
        final DomicilioCliente other = (DomicilioCliente) obj;
        if (this.numero_interior != other.numero_interior) {
            return false;
        }
        if (this.numero_exterior != other.numero_exterior) {
            return false;
        }
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (this.codigo_postal != other.codigo_postal) {
            return false;
        }
        if (!Objects.equals(this.id_domicilio, other.id_domicilio)) {
            return false;
        }
        return Objects.equals(this.calle, other.calle);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomicilioCliente{");
        sb.append("id_domicilio=").append(id_domicilio);
        sb.append(", calle=").append(calle);
        sb.append(", numero_interior=").append(numero_interior);
        sb.append(", numero_exterior=").append(numero_exterior);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append(", codigo_postal=").append(codigo_postal);
        sb.append('}');
        return sb.toString();
    }

}
