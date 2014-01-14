package fr.istic.taa.endomondo.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.endomondo.manager.MyManager;
import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.model.Utilisateur;

public class UtilisateurService extends Service<Utilisateur> implements IUtilisateurService {

	public UtilisateurService() {
		super();
	}	
	
	public Collection<Seance> getSeance(int id)
	{	   
	        Query query = MyManager.getInstance().createQuery( "select e FROM Seance as e where e.user="+id );
	        return query.getResultList();	    
	}

	@Override
    public Seance createSeance( int id, Seance seance )
    {
	    EntityTransaction tx = null;
        EntityManager manager = MyManager.getInstance();
        try
        {
            tx = manager.getTransaction();
            tx.begin();
            Utilisateur user = (Utilisateur) MyManager.getInstance().find( Utilisateur.class, id );
            user.getSeance().add( seance );
            seance.setUser( user );
            manager.persist( seance );
            manager.persist( user );
            tx.commit();
            return seance;
        }
        catch ( RuntimeException e )
        {
            System.err.println( e );
        }
        return null;
    }

	
    @Override
    public int deleteSeance( int idSeance )
    {
        EntityTransaction tx = null;
        EntityManager manager = MyManager.getInstance();
        try
        {
            tx = manager.getTransaction();
            tx.begin();
            Seance objToDelete = (Seance) MyManager.getInstance().find( Seance.class, idSeance );
            MyManager.getInstance().remove( objToDelete );
            tx.commit();
            return 0;
        }
        catch ( RuntimeException e )
        {
            System.err.println( e );
        }
        return -1;
    }

    @Override
    public Seance updateSeance(int userId, Seance s )
    {
        EntityTransaction tx = null;
        EntityManager manager = MyManager.getInstance();
        try
        {
            tx = manager.getTransaction();
            tx.begin();
            Seance objToUpdate = (Seance) MyManager.getInstance().find( Seance.class, s.getId() );
            objToUpdate.setCalories( s.getCalories() );
            objToUpdate.setDate( s.getDate() );
            objToUpdate.setDistance( s.getDistance() );
            objToUpdate.setDuree( s.getDuree() );
            objToUpdate.setTitre( s.getTitre() );
            objToUpdate.setVitesse( s.getVitesse() );
            tx.commit();
            return s;
        }
        catch ( RuntimeException e )
        {
            System.err.println( e );
        }
        return null;
    }

    @Override
    public int addFriend( int iduser, int idAmis )
    {
        EntityTransaction tx = null;
        EntityManager manager = MyManager.getInstance();
        try
        {
            tx = manager.getTransaction();
            tx.begin();
            Utilisateur userToAdd = (Utilisateur) MyManager.getInstance().find( Utilisateur.class, idAmis );
            Utilisateur user = (Utilisateur) MyManager.getInstance().find( Utilisateur.class, iduser );
            
            user.getAmis().add( userToAdd );
            tx.commit();
            return 0;
        }
        catch ( RuntimeException e )
        {
            System.err.println( e );
        }
        return -1;
    }

}
