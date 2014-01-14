package fr.istic.taa.endomondo.service;

import java.util.Collection;

import javax.ws.rs.core.Response;

import fr.istic.taa.endomondo.model.Seance;
import fr.istic.taa.endomondo.model.Utilisateur;

public interface IUtilisateurService
{
    public Collection<Seance> getSeance(int id);
    public Seance createSeance(int id, Seance s);
    public int deleteSeance(int idSeance);
    public Seance updateSeance(int userId, Seance s);
    public int addFriend(int iduser, int idAmis );
}
