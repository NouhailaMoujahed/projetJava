/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Admin;
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
public class AdminService implements IDao<Admin> {

    @Override
    public boolean create(Admin o) {
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
    public boolean delete(Admin o) {
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
    public boolean update(Admin o) {
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
    public Admin findById(int id) {
         Admin admin = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            admin  = (Admin) session.get(Admin.class, id); 
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return admin;    }

    @Override
    public List<Admin> findAll() {
        List<Admin> admins = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            admins  =  session.createQuery("from Admin").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return admins;
    }
     public boolean validate(String email, String password) {

        Transaction tx = null;
        Admin admin = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            tx = session.beginTransaction();
            // get an user object
            admin = (Admin) session.createQuery("FROM Admin A WHERE A.email = :email").setParameter("email", email)
                .uniqueResult();

            if (admin != null && admin.getPassword().equals(password)) {
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
    
    
}

