package fr.istic.taa.endomondo.resource;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.endomondo.service.IService;


public abstract class Resource<T> implements IResource<T>
{

    protected IService<T> service;

    @SuppressWarnings( "unchecked" )
    @OPTIONS
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response getOpt()
    {
        return Response.ok((Collection<T>) service.get() )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @SuppressWarnings( "unchecked" )
    @GET
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response get()
    {
        return Response.ok((Collection<T>) service.get() )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "search/{id}" )
    public Response get( @PathParam( "id" ) int id )
    {
        return Response.ok(service.get(id) )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @OPTIONS
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "search/{id}" )
    public Response getOpt( @PathParam( "id" ) int id )
    {
        return Response.ok(service.get(id) )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @POST
    @Consumes( { MediaType.APPLICATION_JSON } )
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response create( T obj )
    {
        return Response.ok(service.create(obj) )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

    @DELETE
    @Path( "delete/{id}" )
    @Produces( { MediaType.APPLICATION_JSON } )
    public int delete( @PathParam( "id" ) int id )
    {
        return service.remove( id );
    }

   
}