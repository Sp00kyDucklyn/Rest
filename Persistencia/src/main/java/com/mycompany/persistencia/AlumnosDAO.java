/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import Entidades.Alumno;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class AlumnosDAO {

    private ConexionBD conexion;

    public AlumnosDAO() {
        this.conexion = new ConexionBD();
    }

    public List<Alumno> listaAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql = "SELECT * FROM Alumno";
            ResultSet resultado = comandoSQL.executeQuery(querySql);

            while (resultado.next()) {
                int idAlumno = resultado.getInt("idAlumno");
                String nombre = resultado.getString("nombre");
                Alumno nuevoAlumno = new Alumno(idAlumno, nombre);
                listaAlumnos.add(nuevoAlumno);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlumnos;
    }

    public Alumno buscarPorIdAlumnoYNombre(int idAlumno, String nombre) {
        Alumno alumnoEncontrado = null;
        try {
            Connection conex = this.conexion.crearConexion();
            String querySql = "SELECT * FROM Alumno WHERE idAlumno = ? AND nombre = ?";
            PreparedStatement comandoSQL = conex.prepareStatement(querySql);
            comandoSQL.setInt(1, idAlumno);
            comandoSQL.setString(2, nombre);
            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                alumnoEncontrado = new Alumno(idAlumno, nombre);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnoEncontrado;
    }

    public List<Alumno> buscarPorNombre(String nombre) {
        List<Alumno> alumnosEncontrados = new ArrayList<>();
        try {
            Connection conex = this.conexion.crearConexion();
            String querySql = "SELECT * FROM Alumno WHERE nombre = ?";
            PreparedStatement comandoSQL = conex.prepareStatement(querySql);
            comandoSQL.setString(1, nombre);
            ResultSet resultado = comandoSQL.executeQuery();

            while (resultado.next()) {
                int idAlumno = resultado.getInt("idAlumno");
                Alumno alumno = new Alumno(idAlumno, nombre);
                alumnosEncontrados.add(alumno);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnosEncontrados;
    }

    public Alumno buscarPorIdAlumno(int idAlumno) {
        Alumno alumnoEncontrado = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql = "SELECT * FROM Alumno WHERE idAlumno =" + idAlumno;
            ResultSet resultado = comandoSQL.executeQuery(querySql);

            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                alumnoEncontrado = new Alumno(idAlumno, nombre);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnoEncontrado;
    }

    public Alumno guardar(Alumno alumno) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("INSERT INTO Alumno (nombre) VALUES ('%s')", alumno.getNombre());
            System.out.println(codigo);
            comando.executeUpdate(codigo);
            System.out.println("paso");
//            alumno.setIdAlumno(buscarId(conex));
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return alumno;
    }

    public Alumno editar(Alumno alumno) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("UPDATE Alumno SET nombre='%s' WHERE idAlumno =%d",
                    alumno.getNombre(), alumno.getId());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return alumno;
    }

    public Alumno eliminar(Alumno alumno) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("DELETE FROM Alumno WHERE idAlumno=%d", alumno.getId());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return alumno;
    }
}
