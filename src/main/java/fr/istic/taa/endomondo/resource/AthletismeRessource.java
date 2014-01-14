package fr.istic.taa.endomondo.resource;

import javax.ws.rs.Path;

import fr.istic.taa.endomondo.model.sport.Athletisme;
import fr.istic.taa.endomondo.service.AthletismeService;

@Path("/Athle")
public class AthletismeRessource extends Resource<Athletisme>
{
    public AthletismeRessource()
    {
        super();
        this.service = new AthletismeService();
    }
}
