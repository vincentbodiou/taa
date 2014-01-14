package fr.istic.taa.endomondo.resource;

import javax.ws.rs.Path;

import fr.istic.taa.endomondo.model.sport.Nautique;
import fr.istic.taa.endomondo.service.NautiqueService;

@Path("/Nautique")
public class NautiqueRessource extends Resource<Nautique>
{
    public NautiqueRessource() {
        super();
        this.service = new NautiqueService();
    }
}
