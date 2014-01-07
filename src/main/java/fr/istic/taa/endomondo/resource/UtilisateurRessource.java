package fr.istic.taa.endomondo.resource;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.endomondo.model.Utilisateur;
import fr.istic.taa.endomondo.service.UtilisateurService;

@Path( "/user" )
public class UtilisateurRessource extends Resource<Utilisateur> implements IUtilisateurRessource
{

    private UtilisateurService servUser;
    
    public UtilisateurRessource()
    {
        super();
        this.service = new UtilisateurService();
        //on utilise servUser pour éviter les cast par la suite
        servUser=(UtilisateurService) this.service;
    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}/seances" )
    public Response getSeance( @PathParam( "id" ) int id )
    {
        return Response.ok(servUser.getSeance(id) )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @OPTIONS
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{id}/seances" )
    public Response getSeanceOpt( @PathParam( "id" ) int id )
    {
        return Response.ok(servUser.getSeance(id) )
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
}
