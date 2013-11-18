package fr.istic.taa.endomondo.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyManager {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("endomondo");
	protected static EntityManager em = emf.createEntityManager();

	public static EntityManager getInstance() {
		if (em == null) {
			Persistence.createEntityManagerFactory("endomondo").createEntityManager();
		}
		return em;
	}	

	private MyManager() {
		super();
	}
}
