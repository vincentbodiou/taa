package fr.istic.taa.endomondo.model.sport;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Athle")
public class Athletisme extends Sport
{
    private String chaussure;
    
   
    public String getChaussure()
    {
        return chaussure;
    }

    public void setChaussure( String chaussure )
    {
        this.chaussure = chaussure;
    }
}

