package fr.istic.taa.endomondo.resource;

import javax.ws.rs.Path;

import fr.istic.taa.endomondo.model.sport.Sport;
import fr.istic.taa.endomondo.service.SportService;

@Path("/sport")
public class SportRessource extends Resource<Sport>
{
    public SportRessource() {
        super();
        this.service = new SportService();
    }
}
