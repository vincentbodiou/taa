package fr.istic.taa.endomondo.model.sport;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Nautique")
public class Nautique extends Sport
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
