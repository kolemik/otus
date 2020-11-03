package ru.kolemik.otus.dz02;

import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
@Path("/kolemik")
public class Controller {

    @PersistenceContext(unitName = "persistenceUnit")
    EntityManager em;

    @GET
    @Path("/users")
    @Metered(name = "allUsers", description = "Return all users from database")
    public List getAll() {
        List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
        return users != null ? users : Collections.emptyList();
    }

    @GET
    @Path("/user/{id}")
    public User findById(@PathParam("id") Long id) {
        return em.find(User.class, id);
    }

    @PUT
    @Path("/user/{id}")
    @Transactional
    public User update(User user) {
        em.merge(user);
        em.flush();
        return user;
    }

    @PUT
    @Path("/user")
    @Transactional
    public Long create(User user) {
        em.persist(user);
        em.flush();
        return user.getId();
    }

    @DELETE
    @Path("/user")
    @Transactional
    public void delete(User user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
        em.flush();
    }
    
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
