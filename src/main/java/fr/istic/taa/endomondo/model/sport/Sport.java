package fr.istic.taa.endomondo.model.sport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import fr.istic.taa.endomondo.model.Seance;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Sport
{
    @Id
    @GeneratedValue
    private int id;
    
    private String nom;
    
    @OneToOne (mappedBy="sport")
    protected Seance seance;
   

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom( String nom )
    {
        this.nom = nom;
    }
    
    public Seance getSeance()
    {
        return seance;
    }

    public void setSeance( Seance seance )
    {
        this.seance = seance;
    }
}
