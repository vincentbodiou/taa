package fr.istic.taa.endomondo.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.model.Utilisateur;
import fr.istic.taa.endomondo.service.IUtilisateurService;
import fr.istic.taa.endomondo.service.UtilisateurService;

@Path( "/user" )
public class UtilisateurRessource extends Resource<Utilisateur> implements IUtilisateurRessource
{

    private IUtilisateurService servUser;
    
    public UtilisateurRessource()
    {
        super();
        this.service = new UtilisateurService();
        //on utilise servUser pour éviter les cast par la suite
        servUser=(UtilisateurService) this.service;
    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}/seance" )
    public Response getSeance( @PathParam( "id" ) int id )
    {
        return buildResponseOk(servUser.getSeance(id) );
    }
    
    @OPTIONS
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}/seance" )
    public Response getSeanceOpt( @PathParam( "id" ) int id )
    {
        return buildResponseOk(servUser.getSeance(id) );
    }

    @POST
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}/seance" )
    public Response createSeance(@PathParam( "id" ) int id, Seance s )
    {
        return buildResponseOk(servUser.createSeance( id, s ));
    }
    
    @DELETE
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id_user}/seance/{id_seance}" )
    public Response deleteSeance( @PathParam( "id_user" ) int iduser,@PathParam( "id_seance" ) int idSeance )
    {
        System.out.println("on passe par le delete");
        return buildResponseOk(servUser.deleteSeance( idSeance ));
    }
    
    @POST
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id_user}/seance/{id_seance}" )
    public Response updateSeance( @PathParam( "id_user" ) int iduser, Seance s )
    {
        System.out.println("on passe par le update");
        return buildResponseOk(servUser.updateSeance(iduser, s ));
    }
    
    
    

}
