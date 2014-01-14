package fr.istic.taa.endomondo.model.sport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import fr.istic.taa.endomondo.model.Seance;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({  
    @Type(value = Athletisme.class),  
    @Type(value = Nautique.class)
    })  
public abstract class Sport
{
    @Id
    @GeneratedValue
    private int id;
    
    private String nom;
    
    @OneToOne (mappedBy="sport")
    @JsonBackReference
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
