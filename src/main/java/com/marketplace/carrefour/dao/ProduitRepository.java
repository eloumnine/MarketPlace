package com.marketplace.carrefour.dao;

import com.marketplace.carrefour.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {


}
