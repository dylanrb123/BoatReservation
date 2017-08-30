package com.dylanbannon.service.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dylanbannon.data.managers.BoatReservationManager;
import com.google.inject.Inject;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class BoatReservationResource {

  private final BoatReservationManager exampleManager;

  @Inject
  public BoatReservationResource(BoatReservationManager exampleManager) {
    this.exampleManager = exampleManager;
  }

  @GET
  @Path("/")
  public List<String> getAll() {
    return exampleManager.getAll();
  }

  @POST
  @Path("/name/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String createName(@PathParam("name") String name) {
    exampleManager.insert(name);
    return name;
  }


}
