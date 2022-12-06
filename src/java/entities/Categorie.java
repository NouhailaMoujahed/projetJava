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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author RANIA
 */
@Entity
public class Categorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Produit>produits;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Categorie> sCategs;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    
    public Categorie(String nom, Categorie categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
}
