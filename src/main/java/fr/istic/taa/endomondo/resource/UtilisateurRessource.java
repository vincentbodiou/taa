package fr.istic.taa.endomondo.resource;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.endomondo.model.Utilisateur;


@Path("/user")
public class UtilisateurRessource {

    private List<Utilisateur> listeUser = new ArrayList<Utilisateur>();
    	
    public UtilisateurRessource() {
        for (int i = 0; i < 1; i++) {
        	listeUser.add(new Utilisateur("bodiou", "vincent", new Date(180),75, 185, "M", "vincent", "vincent@taa.com"  ));        	
        }
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("search/{nom}")
    public Utilisateur getUser(@PathParam("nom") String nom) {		
    	
    	/*Iterator<Utilisateur> it = listeUser.iterator();
    	while(it.hasNext())
    	{
    		Utilisateur u = it.next();
    		if(u.getNom() == nom)
    			return u;
    	}*/
		return new Utilisateur("bodiou", "vincent", new Date(180),75, 185, "M", "vincent", "vincent@taa.com"  );   	
    }    
}
