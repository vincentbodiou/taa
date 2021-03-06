package fr.istic.taa.endomondo.resource;

import javax.ws.rs.core.Response;

//Operation CRUD
public interface IResource<T> {

	public abstract Response get();

	public abstract Response get(int id);

	public abstract Response create(T obj);
	
	public abstract Response delete(int id);
	
	public abstract Response put( int id, T obj );

}