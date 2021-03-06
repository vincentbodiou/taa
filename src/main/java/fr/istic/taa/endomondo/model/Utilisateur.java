package fr.istic.taa.endomondo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Cascade;


@SuppressWarnings("serial")
@Entity
public class Utilisateur implements Serializable
{	
	@Id
	@GeneratedValue
	private int id;
	
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
	
	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "user")
	private Collection<Seance> seance;
	
	//pas de mapped by pour les self referencing => ce qui permet de créer une "table d'association"
	@OneToMany
	private Collection<Utilisateur> amis;
	
    public Utilisateur(){}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@JsonManagedReference
	public Collection<Seance> getSeance() {
		return seance;
	}

	public void setSeance(Collection<Seance> seance) {
		this.seance = seance;
	}

    public Collection<Utilisateur> getAmis()
    {
        return amis;
    }

    public void setAmis( Collection<Utilisateur> amis )
    {
        this.amis = amis;
    }

}

