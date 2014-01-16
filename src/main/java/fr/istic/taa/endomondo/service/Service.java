package fr.istic.taa.endomondo.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.endomondo.manager.MyManager;

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
        catch ( Exception e )
        {
            e.printStackTrace();
            if ( tx != null && tx.isActive() )
                tx.rollback();
            return null;
        }
    }

    public T get( int id )
    {
        try
        {
            return MyManager.getInstance().find( type, id );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        return null;
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
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        return -1;
    }

    public Collection<T> get()
    {
        Query query = MyManager.getInstance().createQuery( "FROM " + type.getSimpleName() + " e" );
        return query.getResultList();
    }

    public T update( int id, T obj )
    {
        EntityTransaction tx = null;
        EntityManager manager = MyManager.getInstance();
        try
        {
            tx = manager.getTransaction();
            tx.begin();
            MyManager.getInstance().merge( obj );
            tx.commit();
            return obj;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        return null;

    }
}
