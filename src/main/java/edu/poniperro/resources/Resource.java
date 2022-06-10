package edu.poniperro.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.poniperro.repositorio.Repositorio;

@Path("/")
public class Resource {
    @Inject
    Repositorio service;

    @GET
    @Path("itemcrudos")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getItemCrudos() {
        return Response.ok("CRUD de Items!").build();
    }
}
