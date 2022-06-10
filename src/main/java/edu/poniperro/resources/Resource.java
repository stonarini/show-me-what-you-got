package edu.poniperro.resources;

import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.poniperro.domain.MagicalItem;
import edu.poniperro.service.ServiceItem;

@Path("/")
public class Resource {
    @Inject
    ServiceItem service;

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
        Optional<MagicalItem> item = service.getOneItemByName(name);
        return item.isPresent() ? Response.ok(item).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createItem(@Valid MagicalItem item) {
        service.createOneItem(item.getName(), item.getQuality(), item.getType());
        return Response.status(Response.Status.CREATED).entity(service.getOneItem(item)).build();
    }
}
