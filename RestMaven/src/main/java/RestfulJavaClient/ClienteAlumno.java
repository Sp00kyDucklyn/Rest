/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package RestfulJavaClient;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:AlumnoResources [alumno]<br>
 * USAGE:
 * <pre>
 *        ClienteAlumno client = new ClienteAlumno();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author lv1822
 */
public class ClienteAlumno {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestMaven/resources";

    public ClienteAlumno() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("alumno");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(MediaType.APPLICATION_JSON).put(jakarta.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
    }

    public Response addAlumno(Object requestEntity) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).post(jakarta.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
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
