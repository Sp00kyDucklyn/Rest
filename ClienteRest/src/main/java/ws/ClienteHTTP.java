/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author lv1822
 */
public class ClienteHTTP {
    private HttpClient client;
    private String targetURI = "http://localhost:8080/RestMaven/resources/alumno";
    private URI target;
    public ClienteHTTP() throws URISyntaxException{
        client = HttpClient.newHttpClient();
        target = new URI(targetURI);
    }
    public String get() throws IOException, InterruptedException{
        HttpRequest req = HttpRequest.newBuilder().uri(target).GET().build();
        HttpResponse<String> res= client.send(req, HttpResponse.BodyHandlers.ofString());
        return res.body();
    }
    
}
