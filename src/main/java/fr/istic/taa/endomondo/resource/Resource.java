package fr.istic.taa.endomondo.resource;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.endomondo.service.IService;

public abstract class Resource<T> implements IResource<T> {

	protected IService<T> service;

	@SuppressWarnings("unchecked")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<T> get() {
		return (Collection<T>) service.get();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("search/{id}")
	public T get(@PathParam("id") int id) {
		return (T) service.get(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public T create(T obj) {
		return (T) service.create(obj);
	}

	@DELETE
	@Path("delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public int delete(@PathParam("id") int id) {
		return service.remove(id);
	}
}