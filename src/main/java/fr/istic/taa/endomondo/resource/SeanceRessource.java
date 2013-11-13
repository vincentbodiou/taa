package fr.istic.taa.endomondo.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.endomondo.model.Seance;

@Path("/seance")
public class SeanceRessource {

	private List<Seance> listeSeance;
		
	public SeanceRessource()
	{
		listeSeance = new ArrayList<Seance>();
		listeSeance.add(new Seance(0,"duree", 120, "vitesse", "40Kcal", null,null));
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("search/{id}")
	public Seance getSeance(@PathParam("id") int id) {
		
		Iterator<Seance> it = listeSeance.iterator();
    	while(it.hasNext())
    	{
    		Seance s = it.next();
    		if(s.getId() == id)
    			return s;
    	}
		return null;   		
	}
	
	
	
}
