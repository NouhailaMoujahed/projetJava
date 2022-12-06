/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Client;
import entities.Commande;
import entities.Facture;
import entities.LigneCommande;
import entities.Produit;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author RANIA
 */
public class CommandeService implements IDao<Commande>{
   
     
    @Override
    public boolean create(Commande o) {
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
    public boolean delete(Commande o) {
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
    public boolean update(Commande o) {
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
    public Commande findById(int id) {
         Commande commande = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commande  = (Commande) session.get(Commande.class, id); 
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return commande;    }

    @Override
    public List<Commande> findAll() {
        List<Commande> commandes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commandes  =  session.createQuery("from Commande").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return commandes;
    }
    
    public List<Commande> findByClient(Client c){
        List<Commande> commandes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commandes  =  session.createQuery("from Commande cd where cd.client = "+c).list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return commandes;
        
    }
    public List<Commande> findByFacture(Facture f){
        List<Commande> commandes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commandes  =  session.createQuery("from Commande cd where cd.facture = "+f).list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return commandes;
        
    }
    public int nbrCommande(){
        CommandeService cs = new CommandeService();
        int nbr = 0;
        for(Commande c: cs.findAll()){
            
            nbr++;
        }
        return nbr;
    }
  
    private ArrayList<LigneCommande> items= new ArrayList<LigneCommande>();

    
    public void addItem(int id, int qte, int idC){
         CommandeService cs= new CommandeService();
        boolean flag = true;
        for(LigneCommande lp:items){
            if(lp.getProduit().getId()==id){
                lp.setQuantite(lp.getQuantite()+qte);
                flag=false;
                break;
            }
        }
        if(flag){
            Session s = HibernateUtil.getSessionFactory().openSession();
            Produit pr = (Produit) s.get(Produit.class, id);
            LigneCommande lp = new LigneCommande(qte,pr,cs.findById(idC));
            items.add(lp);
        }
        
    }

 LigneService ls= new LigneService();
        public void augmenterQte(int id) {
        
      for(LigneCommande lp: items){
            if(lp.getProduit().getId()==id){
                lp.setQuantite(lp.getQuantite()+1);
                
                break;
            }
        }  
    }
     public void diminuerQte(int id) {
        
      for(LigneCommande lp: items){
            if(lp.getProduit().getId()==id){
                lp.setQuantite(lp.getQuantite()-1);
                if(lp.getQuantite()==0){
                    ls.findAll().remove(lp);
                }
                
                break;
            }
        }  
    }
     
    public Double total(){
        Double t = 0.0;
        for(LigneCommande lp : items){
          t+=lp.getProduit().getPrix()*lp.getQuantite();
        }
        return t;
    }
     public Commande getPanier() {
        Commande commande = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commande = (Commande) session.getNamedQuery("getPanier").uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return commande;
    }
      public Commande getOrder() {
        Commande commande = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commande = (Commande) session.getNamedQuery("getOrder").uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return commande;
    }

    
}
 

