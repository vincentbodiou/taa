package fr.istic.taa.endomondo.resource;

import java.util.Collection;

public interface IResource<T> {

	public abstract Collection<T> get();

	public abstract T get(int id);

	public abstract T create(T obj);

}