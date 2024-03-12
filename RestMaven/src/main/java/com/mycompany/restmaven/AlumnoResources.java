/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.restmaven;

import Entidades.Alumno;
import com.mycompany.persistencia.AlumnosDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author lv1822
 */
@Path("alumno")
@RequestScoped
public class AlumnoResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnoResources
     */
    public AlumnoResources() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.restmaven.AlumnoResources
     *
     * @return an instance of com.mycompany.restmaven.resources.Alumno
     */
    /**
     * Retrieves representation of an instance of
     * com.mycompany.rest.AlumnoResource
     *
     * @return an instance of com.mycompany.rest.resources.Alumno
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        AlumnosDAO alumnosDAO = new AlumnosDAO();

        List<Alumno> alumnos = alumnosDAO.listaAlumnos();

        return Response.ok().entity(alumnos.toArray(new Alumno[alumnos.size()])).build();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        //TODO return proper representation object
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        Alumno alumno = alumnosDAO.buscarPorIdAlumno(id);
        if (alumno != null) {
            return Response.status(200).entity(alumno).build();
        }
        return Response.status(404).build();

    }

    @GET
@Path("/query")
@Produces(MediaType.APPLICATION_JSON)
public Response getUsuariosQuery(
        @QueryParam("id") Integer id,
        @QueryParam("nombre") String nombre) {

    if (id != null && nombre != null && !nombre.isEmpty()) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        Alumno alumno = alumnosDAO.buscarPorIdAlumnoYNombre(id, nombre);
        if (alumno != null) {
            return Response.status(Response.Status.OK).entity(alumno).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    if (id != null) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        Alumno alumno = alumnosDAO.buscarPorIdAlumno(id);
        if (alumno != null) {
            return Response.status(Response.Status.OK).entity(alumno).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    if (nombre != null && !nombre.isEmpty()) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        List<Alumno> alumnos = alumnosDAO.buscarPorNombre(nombre);
        if (!alumnos.isEmpty()) {
            return Response.status(Response.Status.OK).entity(alumnos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    return Response.status(400).entity("Se debe proporcionar al menos un parámetro 'id' o 'nombre'").build();

}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAlumno(Alumno alumno) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        alumnosDAO.guardar(alumno);
        
        return Response.status(200).entity(alumno).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(int id) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        Alumno alumno = new Alumno(id);
        alumnosDAO.eliminar(alumno);
        return Response.status(Response.Status.OK).entity(alumno).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarAlumno(Alumno a) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        Alumno nuevo = alumnosDAO.editar(a);
        return Response.status(Response.Status.OK).entity(nuevo).build();
    }
}
