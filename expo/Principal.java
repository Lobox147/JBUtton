/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.expo;

/**
 *
 * @author esaul
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Punto [] figura = {
            new Punto (100,100),
            new Punto (200,100),
            new Punto (200,50),
            new Punto (300,150),
            new Punto (200,250),
            new Punto (200,200),
            new Punto (100,200),
            new Punto (100,100)
        };
        //Crear instancia de ventana
        new Ventana("Transformaciones geometricas", figura);
    }
    
}
