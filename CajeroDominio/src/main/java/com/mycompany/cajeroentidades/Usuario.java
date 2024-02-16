package com.mycompany.cajeroentidades;

import java.util.Objects;

/**
 *
 * @author TeLesheo
 */
public class Usuario {

    private int id_usuario;
    private String passcode_usuario;
    private String email;

    public Usuario() {
    }

    public Usuario(int id, String passcode, String email) {
        this.id_usuario = id;
        this.passcode_usuario = passcode;
        this.email = email;

    }

    public Usuario(String passcode, String email) {
        this.id_usuario = id_usuario;
        this.passcode_usuario = passcode;
        this.email = email;

    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id) {
        this.id_usuario = id;
    }

    public String getPasscode_usuario() {
        return passcode_usuario;
    }

    public void setPasscode_usuario(String passcode_usuario) {
        this.passcode_usuario = passcode_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_usuario;
        hash = 79 * hash + Objects.hashCode(this.passcode_usuario);
        hash = 79 * hash + Objects.hashCode(this.email);
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
        final Usuario other = (Usuario) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        if (!Objects.equals(this.passcode_usuario, other.passcode_usuario)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id=").append(id_usuario);
        sb.append(", passcode=").append(passcode_usuario);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
    
    
}
