package fr.istic.taa.endomondo.resource;

import javax.ws.rs.Path;
import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.service.SeanceService;

@Path("/seance")
public class SeanceRessource extends Resource<Seance> {
		
	public SeanceRessource() {
		super();
		this.service = new SeanceService();
	}
}
