package t01;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/not")
public class NotificationResource {
	
	@Inject
	private NotificationService service;
	
	@GET
	@Path("/ping")
	public Response ping() {
		return Response.ok().entity("OK").build();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		return Response.ok().entity(service.list()).build();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") String id) {
		return Response.ok().entity(service.read(id)).build();
	}

	@GET
	@Path("/create/{name}/{msg}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@PathParam("name") String name, @PathParam("msg") String msg) {
		return Response.status(201).entity(
			service.create(name, msg)
		).build();
	}
	
	@GET
	@Path("/update/{id}/{name}/{msg}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(
			@PathParam("id") String id, 
			@PathParam("name") String name, 
			@PathParam("msg") String msg) {
		return Response.status(200).entity(service.update(id, name, msg)).build();
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {
		return Response.status(200).entity(service.delete(id)).build();
	}
	
}
