package fr.istic.taa.endomondo.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.endomondo.manager.MyManager;
import fr.istic.taa.endomondo.model.Seance;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Service<T> implements IService<T>
{

    private Class<T> type;

    public Service()
    {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create( T obj )
    {
        // Begin a transaction
        EntityTransaction tx = null;
        try
        {
            tx = MyManager.getInstance().getTransaction();
            tx.begin();
            MyManager.getInstance().persist( obj );
            tx.commit();
            return obj;
        }
        catch ( RuntimeException e )
        {
            if ( tx != null && tx.isActive() )
                tx.rollback();
            return null;
        }
    }

    public T get( int id )
    {
        return MyManager.getInstance().find( type, id );
    }

    public int remove( int id )
    {
        EntityTransaction tx = null;
        EntityManager manager = MyManager.getInstance();
        try
        {
            tx = manager.getTransaction();
            tx.begin();
            T objToDelete = (T) MyManager.getInstance().find( type, id );
            MyManager.getInstance().remove( objToDelete );
            tx.commit();
            return id;
        }
        catch ( RuntimeException e )
        {
            System.err.println(e);
        }
        return -1;
    }

    @SuppressWarnings( "unchecked" )
    public Collection<Seance> get()
    {
        Query query = MyManager.getInstance().createQuery( "SELECT e FROM " + type.getSimpleName() + " e" );
        return query.getResultList();
    }
}
