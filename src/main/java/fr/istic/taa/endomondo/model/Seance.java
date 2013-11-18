package fr.istic.taa.endomondo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.*;

@Entity
public class Seance implements Serializable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "duree", nullable = true)
	private String duree;	
	@Column(name = "distance", nullable = true)
	private double distance;	
	@Column(name = "vitesse", nullable = true)
	private String vitesse;
	@Column(name = "calories", nullable = true)
	private String calories;	
	@Column(name = "date", nullable = true)
	private Date date;	
	//private Set<Utilisateur> utilisateur;	
	
	public Seance(int id,String duree, double distance, String vitesse,
			String calories, Date date){
		super();
		this.setId(id);
		this.duree = duree;
		this.distance = distance;
		this.vitesse = vitesse;
		this.calories = calories;
		this.date = date;
		//this.utilisateur = utilisateur;
	}
	
	public Seance() {}


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


//	public Set<Utilisateur> getUtilisateur() {
//		return utilisateur;
//	}
//
//
//	public void setUtilisateur(Set<Utilisateur> utilisateur) {
//		this.utilisateur = utilisateur;
//	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}

