package edu.poniperro.resources;

import javax.inject.Inject;
import javax.ws.rs.Path;

import edu.poniperro.repositorio.Repositorio;

@Path("/")
public class Resource {
    @Inject
    Repositorio service;
}
