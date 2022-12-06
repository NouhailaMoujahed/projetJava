/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Rania
 */
@Entity
@NamedQuery(name = "findByEmail", query = "select c from Client c where c.email = :email ")
public class Client extends User implements Serializable {

    private String nom, prenom, telephone;
    private String addresse;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Commande>commandes;

    public Client() {
    }

    public Client(String nom, String prenom, String telephone, String addresse, String email, String password) {
        super(email, password);
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.addresse = addresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return  this.nom + " " + this.prenom ;
    }
    
    
}
