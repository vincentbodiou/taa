package fr.istic.taa.endomondo.model.sport;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Nautique")
public class Nautique extends Sport implements Serializable
{
    private String marqueBateau;
    
    public String getMarqueBateau()
    {
        return marqueBateau;
    }

    public void setMarqueBateau( String marqueBateau )
    {
        this.marqueBateau = marqueBateau;
    }
}
