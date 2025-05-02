package com.marketplace.carrefour.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Produit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Attribute
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom_Produit", nullable = false, length = 50)
    private String nom;
    private double prix;
    private String photo;

    public Produit(String nom, double prix, String photo) {
        this.nom = nom;
        this.prix = prix;
        this.photo = photo;
    }
}
