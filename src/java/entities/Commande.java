/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lachgar
 */
@Entity
@NamedQueries ( {
       @NamedQuery(name = "getPanier", query = "select c from Commande c where c.status = 'en cours' or c.status = 'en traitement'"),
       @NamedQuery(name = "getOrder", query = "select c from Commande c where c.status = 'en traitement'") 
})


public class Commande implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Facture facture;
    private String status;

    public Commande() {
    }

    public Commande(Date date, Client client, Facture facture) {
        this.date = date;
        this.client = client;
        this.facture = facture;
    }

    public Commande(Date date, Client client,  String status) {
        this.date = date;
        this.client = client;
        this.status = status;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date=" + date + ", client=" + client + ", facture=" + facture + ", status=" + status + '}';
    }

    
 

}
