package fr.istic.taa.endomondo.resource;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.endomondo.manager.MyManager;
import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.model.Utilisateur;
import fr.istic.taa.endomondo.service.IService;
import fr.istic.taa.endomondo.service.SeanceService;

@Path("/seance")
public class SeanceRessource extends Resource<Seance> {
		
	public SeanceRessource() {
		super();
		this.service = new SeanceService();
	}
}
