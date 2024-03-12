/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.clienterest;

import Entidades.Alumno;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ws.ClienteAlumnos;
import ws.ClienteHTTP;

/**
 *
 * @author lv1822
 */
public class ClienteRest {

    public static void main(String[] args) {
        
//        frmMenu menu = new frmMenu();
//        menu.setVisible(true);
//        
            ClienteAlumnos cliente = new ClienteAlumnos();
//            ClienteHTTP cliente1 = new ClienteHTTP();
            System.out.println("------------------------");
            Alumno[] response1 = cliente.getJson(Alumno[].class);
            for (Alumno alumno : response1) {
                System.out.println(alumno);
            }
            
            System.out.println("---Buscar Por nombre------");
            Alumno[] response2 = cliente.getUsuariosQuery(Alumno[].class,"","Diego");
            for (Alumno alumno : response2) {
                System.out.println(alumno);
            }
            System.out.println("---Buscar Por ID------");
            Alumno response3 = cliente.getUsuariosQuery(Alumno.class,"1",null);
            System.out.println(response3);
            System.out.println("---Agregar------------");
            Alumno alumnoNuevo = new Alumno("Carmen Hernandez");
            cliente.addAlumno(alumnoNuevo);
            System.out.println("---Actualiza------------");
            Alumno alumnoActualiza = new Alumno(1,"Carmen Hernandez");
            cliente.actualizarAlumno(alumnoActualiza);
            
            
//            System.out.println("------------------------");
////            System.out.println(cliente1.get());
//            System.out.println("------------------------");
////            
//            String response2 = cliente.getJson(String.class);
//            Gson g = new Gson();
//            Alumno[] listaAlumnos= g.fromJson (response2, Alumno[].class);
//            
//            for (Alumno listaAlumno : listaAlumnos) {
//                System.out.println(listaAlumno);
//            }
//            System.out.println("-------------------");
//            Alumno enviar = new  Alumno("s");
//            Response response3 = cliente.addAlumno(enviar);
//            String regreso = response3.readEntity(String.class);
//            Alumno a2 = g.fromJson(regreso, Alumno.class);
//            System.out.println(a2);
            
            
            
         

    }
}
