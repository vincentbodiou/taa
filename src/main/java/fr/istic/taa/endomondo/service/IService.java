package fr.istic.taa.endomondo.service;

import java.util.Collection;

import fr.istic.taa.endomondo.model.Seance;

public interface IService<T> {

	public abstract T create(T obj);

	public abstract T get(int id);

	public abstract Collection<T> get();

	public abstract int remove(int id);

    public abstract T put( int id, T obj );

}