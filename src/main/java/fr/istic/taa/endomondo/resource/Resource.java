package fr.istic.taa.endomondo.resource;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.endomondo.service.IService;

public abstract class Resource<T> implements IResource<T>
{

    protected IService<T> service;

    @OPTIONS
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response getOpt()
    {
        return buildResponseOk( (Collection<T>) service.get() );
    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response get()
    {
        return buildResponseOk( (Collection<T>) service.get() );
    }
    
    @GET
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}" )
    public Response get( @PathParam( "id" ) int id )
    {
        T r = service.get( id );
        if ( r == null )
            return Response.status( 204 ).build(); // ou 404

        return buildResponseOk( r );
    }

    @OPTIONS
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}" )
    public Response getOpt( @PathParam( "id" ) int id )
    {
        T r = service.get( id );
        if ( r == null )
            return Response.status( 204 ).build(); // ou 404

        return buildResponseOk( r );
    }

    @POST
    @Consumes( { MediaType.APPLICATION_JSON } )
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response create( T obj )
    {
        T res = service.create( obj );

        if ( res == null )
            return Response.status( 400 ).build();

        return buildResponseOk( res );
    }

    @DELETE
    @Path( "/{id}" )
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response delete( @PathParam( "id" ) int id )
    {
        if ( service.remove( id ) > 0 )
            return Response.ok().build();
        else
            return Response.status( 400 ).build();
    }

    @PUT
    @Path( "/{id}" )
    @Produces( { MediaType.APPLICATION_JSON } )
    public Response put( @PathParam( "id" ) int id, T obj )
    {
        return Response.ok( service.put( id, obj ) ).build();
    }
    
    protected Response buildResponseOk(Object o)
    {
        return Response.ok(o)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
        .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }

}