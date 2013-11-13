package fr.istic.taa.endomondo.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Manager {

	public Manager() {
		// Use persistence.xml configuration
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdEndomondo");
		// Retrieve an entity manager
		EntityManager em = emf.createEntityManager();

		// Begin a transaction
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			// Your entity becomes persistant
			// em.persist(t);
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
