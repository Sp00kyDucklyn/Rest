/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package ws;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:AlumnoResources [alumno]<br>
 * USAGE:
 * <pre>
 *        ClienteAlumnos client = new ClienteAlumnos();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author lv1822
 */
public class ClienteAlumnos {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestMaven/resources";

    public ClienteAlumnos() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("alumno");
    }

    public Response actualizarAlumno(Object requestEntity) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response addAlumno(Object requestEntity) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

//    public <T> T getUsuariosQuery(Class<T> responseType, String id, String nombre) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        if (id != null && !id.isEmpty()) {
//            resource = resource.queryParam("id", id);
//        }
//        if (nombre != null && !nombre.isEmpty()) {
//            resource = resource.queryParam("nombre", nombre);
//        }
//        resource = resource.path("query");
//        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
//    }
    public <T> T getUsuariosQuery(Class<T> responseType, String id, String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.queryParam("id", id);

        resource = resource.queryParam("nombre", nombre);

        resource = resource.path("query");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response delete() throws ClientErrorException {
        return webTarget.request().delete(Response.class);
    }

    public Response eliminarPorId(String idAlumno) throws ClientErrorException {
        
            WebTarget resource = webTarget.path(idAlumno);
            return resource.request().delete(Response.class);
         
        
    }

    public <T> T getJson(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }

}
