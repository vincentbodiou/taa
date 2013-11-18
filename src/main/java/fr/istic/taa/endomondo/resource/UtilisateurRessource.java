package fr.istic.taa.endomondo.resource;

import javax.ws.rs.Path;
import fr.istic.taa.endomondo.model.Utilisateur;
import fr.istic.taa.endomondo.service.UtilisateurService;

@Path("/user")
public class UtilisateurRessource extends Resource<Utilisateur>{

	public UtilisateurRessource() {
		super();
		this.service = new UtilisateurService();
	}	
}
