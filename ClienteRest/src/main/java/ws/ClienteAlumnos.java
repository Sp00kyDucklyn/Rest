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
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("alumno");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
    }

    public Response addAlumno(Object requestEntity) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsuariosQuery(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("query");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getJson(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
