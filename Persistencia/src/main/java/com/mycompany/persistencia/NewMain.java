/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.persistencia;

import Entidades.Alumno;
import java.util.List;

/**
 *
 * @author diego
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();

        // Prueba de listar alumnos
        System.out.println("Lista de alumnos:");
        
        List<Alumno> listaAlumnos = alumnosDAO.listaAlumnos();
        
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno.getId()+ ": " + alumno.getNombre());
        }

    }
    
}
