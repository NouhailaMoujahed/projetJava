/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Lachgar
 */
@Entity
@NamedQueries ( {
       @NamedQuery(name = "findByLigneCommandePK", query = "select l from LigneCommande l where l.commandePK = :lck"),
       @NamedQuery(name = "findLigneCommandeByCommande", query = "select l from LigneCommande l where l.commande = :c") 
})
public class LigneCommande implements Serializable{
    @EmbeddedId
    private LigneCommandePK commandePK;
    private double prixVente;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "produitId", insertable = false, updatable = false)
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commandeId", insertable = false, updatable = false)
    private Commande commande;

    public LigneCommande() {
    }

    public LigneCommande(int quantite, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    public LigneCommande(LigneCommandePK commandePK, double prixVente, int quantite) {
        this.commandePK = commandePK;
        this.prixVente = prixVente;
        this.quantite = quantite;
      
    }
    

    public LigneCommandePK getCommandePK() {
        return commandePK;
    }

    public void setCommandePK(LigneCommandePK commandePK) {
        this.commandePK = commandePK;
    }

    public double getPrixVente() {
        return produit.getPrix()*getQuantite();
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    
}
