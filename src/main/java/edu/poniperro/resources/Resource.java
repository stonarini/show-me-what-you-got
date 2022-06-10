package edu.poniperro.resources;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.poniperro.domain.MagicalItem;
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

    @GET
    @Path("item/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("name") String name) {
        Optional<MagicalItem> item = service.loadItem(name);
        return item.isPresent() ? Response.ok(item).build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
