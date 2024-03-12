/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class ConexionBD implements IConexionBD{
private final String Server ="localhost:3306";
private final String BASE_DATOS ="Rest";
private final String CONEXION= "jdbc:mysql://"+Server+"/"+BASE_DATOS;
private final String USUARIO = "root";
private final String CONTRASEÑA ="1234";      
    @Override
    
    public Connection crearConexion() throws SQLException {
        Connection conexion;
        conexion = DriverManager.getConnection(CONEXION,USUARIO,CONTRASEÑA);
        return conexion;  
    }

}
