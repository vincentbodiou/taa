package fr.istic.taa.endomondo.model;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class Seance
{	
	private int id;
	private String duree;	
	private double distance;	
	private String vitesse;
	private String calories;	
	private Date date;	
	private List<Utilisateur> utilisateur;	

		
	
	public Seance(int id,String duree, double distance, String vitesse,
			String calories, Date date, List<Utilisateur> utilisateur){
		super();
		this.setId(id);
		this.duree = duree;
		this.distance = distance;
		this.vitesse = vitesse;
		this.calories = calories;
		this.date = date;
		this.utilisateur = utilisateur;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public String getVitesse() {
		return vitesse;
	}


	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}


	public String getCalories() {
		return calories;
	}


	public void setCalories(String calories) {
		this.calories = calories;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}

