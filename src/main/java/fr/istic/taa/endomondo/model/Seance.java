package fr.istic.taa.endomondo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

import fr.istic.taa.endomondo.model.sport.Sport;

@SuppressWarnings("serial")
@Entity
public class Seance implements Serializable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String duree;	
	private double distance;	
	private String vitesse;	
	private String calories;	
	private Date date;
	private String titre;

	

    @OneToOne
	private Sport sport;
	
    @ManyToOne
	private Utilisateur user;
		
	public Seance(int id,String duree, double distance, String vitesse,
			String calories, Date date){
		super();
		this.setId(id);
		this.duree = duree;
		this.distance = distance;
		this.vitesse = vitesse;
		this.calories = calories;
		this.date = date;
	}
	
    public Seance() {}
	
    @JsonBackReference
    public Utilisateur getUser()
    {
        return user;
    }

    public void setUser( Utilisateur user )
    {
        this.user = user;
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

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	   
    public String getTitre()
    {
        return titre;
    }

    public void setTitre( String titre )
    {
        this.titre = titre;
    }
    
    public Sport getSport()
    {
        return sport;
    }

    public void setSport( Sport sport )
    {
        this.sport = sport;
    }

}

