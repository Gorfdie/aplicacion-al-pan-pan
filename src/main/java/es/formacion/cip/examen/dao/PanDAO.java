package es.formacion.cip.examen.dao;

import es.formacion.cip.examen.entity.Pan;
import es.formacion.cip.examen.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PanDAO {

    private Session sesion;
    private Transaction tx;



    public long addPan(Pan pan)
    {
        long id = 0;

        try
        {
            initTransacction();
            id = (Long)sesion.save(pan);
            tx.commit();
        }catch(HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }finally
        {
            sesion.close();
        }
        return id;
    }

    public void updatePan(Pan pan) throws HibernateException
    {
        try
        {
            initTransacction();
            sesion.update(pan);
            tx.commit();
        }catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }finally
        {
            sesion.close();
        }
    }

    public void deletePan(Pan pan) throws HibernateException
    {
        try
        {
            initTransacction();
            sesion.delete(pan);
            tx.commit();
        } catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }finally
        {
            sesion.close();
        }
    }


    public Pan getPan(long idPan) throws HibernateException
    {
        Pan pan = null;

        try
        {
            initTransacction();
            pan = (Pan) sesion.get(Pan.class, idPan);
        } finally
        {
            sesion.close();
        }
        return pan;
    }

    public List<Pan> listPan() throws HibernateException
    {
        List<Pan> list = null;

        try
        {
            initTransacction();
            list = sesion.createQuery("from Pan").list();
        }finally
        {
            sesion.close();
        }

        return list;
    }

    private void initTransacction() throws HibernateException
    {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

}

