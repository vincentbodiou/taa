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
import fr.istic.taa.endomondo.service.UtilisateurService;

@Path("/user")
public class UtilisateurRessource extends Resource<Utilisateur>{

	public UtilisateurRessource() {
		super();
		this.service = new UtilisateurService();
	}	
}
