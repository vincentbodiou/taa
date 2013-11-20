package fr.istic.taa.endomondo.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.service.SeanceService;

@Path("/seance")
public class SeanceRessource extends Resource<Seance> {
		
	public SeanceRessource() {
		super();
		this.service = new SeanceService();
	}
	
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Seance> list() {
        return listeSeance;
    }
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("search/{id}")
	public Seance getSeance(@PathParam("id") int id) {
		return listeSeance.get(id);   		
	}	
	
    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Seance deleteById(@PathParam("id") int id) {
        return listeSeance.remove(id);
    }
	
}
