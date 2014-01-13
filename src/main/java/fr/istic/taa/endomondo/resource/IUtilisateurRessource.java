package fr.istic.taa.endomondo.resource;

import javax.ws.rs.core.Response;

import fr.istic.taa.endomondo.model.Seance;

public interface IUtilisateurRessource
{
    public Response getSeance(int id );
    public Response createSeance(int id, Seance s);
    public Response deleteSeance(int idUser, int idSeance);
    public Response updateSeance(int idUser, Seance s);
}
