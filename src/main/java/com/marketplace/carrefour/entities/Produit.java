package com.marketplace.carrefour.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Produit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nom_Produit", nullable = false, length = 50)
    private String nom;

    private double prix;

    private String photo;

    // Default constructor required by JPA
    public Produit() {
    }

    public Produit(String nom, double prix, String photo) {
        this.nom = nom;
        this.prix = prix;
        this.photo = photo;
    }

    // Explicit getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}