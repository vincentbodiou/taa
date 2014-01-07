package fr.istic.taa.endomondo.service;

import java.util.Collection;

import javax.persistence.Query;

import fr.istic.taa.endomondo.manager.MyManager;
import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.model.Utilisateur;

public class UtilisateurService extends Service<Utilisateur> {

	public UtilisateurService() {
		super();
	}	
	
	public Collection<Seance> getSeance(int id)
	{	   
	        Query query = MyManager.getInstance().createQuery( "select e FROM Seance as e where e.user="+id );
	        return query.getResultList();	    
	}

}
