package fr.istic.taa.endomondo.manager;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.endomondo.model.Seance;

public class ManagerHelper {

	public ManagerHelper() {
		// Use persistence.xml configuration
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-Endomondo");
		// Retrieve an entity manager
		EntityManager em = emf.createEntityManager();

		Seance s = new Seance(0,"duree", 120, "vitesse", "40Kcal", new Date(200));
		
		// Begin a transaction
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			// Your entity becomes persistant
			em.persist(s);
			tx.commit(); // do the flush automatically
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e; // or display error message
		} finally {
			em.close();
		}
		emf.close(); // close at application end

	}

}
