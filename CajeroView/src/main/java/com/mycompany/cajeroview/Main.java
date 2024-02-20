/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.cajeroview;

import com.mycompany.cajeropersistencia.conexion.Conexion;

/**
 *
 * @author asielapodaca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        PaginaPrincipalForm index = new PaginaPrincipalForm(conexion);
        index.setVisible(true);
    }
    
}
