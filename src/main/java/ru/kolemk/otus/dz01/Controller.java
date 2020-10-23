package ru.kolemk.otus.dz01;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("/controller")
public class Controller {

    @GET
    @Path("/health")
    public String healthCheck() {
        return "{\"status\": \"OK\"}";
    }

    @GET
    @Path("/hello")
    public String sayHello() {
        return sayHello("NA");
    }

    @GET
    @Path("/hello/{name}")
    public String sayHello(@PathParam("name") String name) {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            hostname = "[ERROR: " + e.getMessage() + "]";
        }
        return String.format("Hello, %s from %s!", name, hostname);
    }
}
