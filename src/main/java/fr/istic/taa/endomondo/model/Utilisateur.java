package fr.istic.taa.endomondo.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class Utilisateur
{	
	private double id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private double poids;
	private int taille;
	private String sexe;
	private String pseudo;
	private String facebook;
	private String twitter;
	private String mail;
	private Set<Seance> seance;
	private Set<Utilisateur> amis;
	
	public Utilisateur(String nom, String prenom, Date date, double poids, int taille,
			String sexe, String pseudo, String mail){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pseudo = pseudo;
		this.sexe = sexe;
		this.dateNaissance = date;
		this.poids = poids;
		this.taille = taille;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<Seance> getSeance() {
		return seance;
	}

	public void setSeance(Set<Seance> seance) {
		this.seance = seance;
	}

	public Set<Utilisateur> getAmis() {
		return amis;
	}

	public void setAmis(Set<Utilisateur> amis) {
		this.amis = amis;
	}

}

