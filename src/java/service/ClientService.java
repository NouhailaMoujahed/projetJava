/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Client;
import entities.Produit;
import entities.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author RANIA
 */
public class ClientService implements IDao<Client> {

    @Override
    public boolean create(Client o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;     
    }

    @Override
    public boolean delete(Client o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;     
    }

    @Override
    public boolean update(Client o) {
       Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;     
    }

    @Override
    public Client findById(int id) {
         Client client = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            client  = (Client) session.get(Client.class, id); 
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return client;    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            clients  =  session.createQuery("from Client").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return clients;
    }
    public boolean validate(String email, String password) {

        Transaction tx = null;
        Client client = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            tx = session.beginTransaction();
            // get an user object
            client = (Client) session.createQuery("FROM Client C WHERE C.email = :email").setParameter("email", email)
                .uniqueResult();

            if (client != null && client.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }} finally {
            session.close();
        }
        return false;
    }
    public int nbrClient(){
        ClientService cs = new ClientService();
        int nbr = 0;
        for(Client c: cs.findAll()){
            
            nbr++;
        }
        return nbr;
    }
    public Client findByEmail(String email) {
        Client client = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            client = (Client) session.getNamedQuery("findByEmail").setParameter("email", email).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return client;
    }
    public List<Produit> listAll() {
         List<Produit> produits = null;
         Session session = null;
         Transaction tx = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             tx = session.beginTransaction();
             produits = session.getNamedQuery("find").list();
             tx.commit();
         } catch (HibernateException e) {
             if (tx != null) {
                 tx.rollback();
             }
         } finally {
             session.close();
         }
         return produits;
}
}
