package com.marketplace.carrefour.dao;

import com.marketplace.carrefour.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNom(String nom);
    Page<Produit> findByNom(String nom, Pageable pageable);

    @Query("select e from Produit e where e.nom like :x")
    Page<Produit> chercherProduits(@Param("x") String nom,
                                          Pageable pageable);

    @Query("select e from Produit e where e.prix>:x and e.prix<:y")
    List<Produit> chercherProduits(@Param("x")double d1,
                                          @Param("y")double d2);

}
