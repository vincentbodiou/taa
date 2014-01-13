package fr.istic.taa.endomondo.service;

import java.util.Collection;

import fr.istic.taa.endomondo.model.Seance;

public interface IUtilisateurService
{
    public Collection<Seance> getSeance(int id);
    public Seance createSeance(int id, Seance s);
    public int deleteSeance(int idSeance);
    public int updateSeance(int userId, Seance s);
}
