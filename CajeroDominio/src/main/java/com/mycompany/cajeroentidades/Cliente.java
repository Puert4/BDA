package com.mycompany.cajeroentidades;

import java.util.Objects;

/**
 *
 * @author TeLesheo
 */
public class Cliente {

    private int id_cliente;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento;

    public Cliente() {

    }

    public Cliente(int id, String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento) {
        this.id_cliente = id;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;

    }

    public Cliente(String nombres, String apellido_paterno, String apellido_materno, String fecha_nacimiento) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id) {
        this.id_cliente = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_cliente;
        hash = 41 * hash + Objects.hashCode(this.nombres);
        hash = 41 * hash + Objects.hashCode(this.apellido_paterno);
        hash = 41 * hash + Objects.hashCode(this.apellido_materno);
        hash = 41 * hash + Objects.hashCode(this.fecha_nacimiento);
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
        final Cliente other = (Cliente) obj;
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellido_paterno, other.apellido_paterno)) {
            return false;
        }
        if (!Objects.equals(this.apellido_materno, other.apellido_materno)) {
            return false;
        }
        return Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(id_cliente);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellido_paterno=").append(apellido_paterno);
        sb.append(", apellido_materno=").append(apellido_materno);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append('}');
        return sb.toString();
    }

}
