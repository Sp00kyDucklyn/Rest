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
        return Response.ok().entity(new Alumno(1, "Diego")).build();

    }

//    @GET
//    @Path("query")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUsuarios(@QueryParam("from") int from, @QueryParam("to") int to, @QueryParam("orderBy") List body) {
////TODO return proper representation object
//
//        return Response.status(200).entity("From " + from + "to " + to + "orderBy " + body.toString()).build();
//
//    }
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuariosQuery(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") String orderBy) {

        // Verificar si se ha proporcionado el parámetro "orderBy"
        if (orderBy != null && !orderBy.isEmpty()) {
            return Response.status(200).entity("From " + from + " to " + to + " orderBy " + orderBy).build();
        } else {
            return Response.status(400).entity("El parámetro 'orderBy' es obligatorio").build();
        }
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
        return Response.status(200).entity(alumno).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarAlumno(Alumno a) {
        a.setNombre("cachado");
        return Response.ok().entity(a).build();
    }
}
