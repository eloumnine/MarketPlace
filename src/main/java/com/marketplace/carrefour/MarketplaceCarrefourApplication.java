package com.marketplace.carrefour;

import com.marketplace.carrefour.dao.ProduitRepository;
import com.marketplace.carrefour.entities.Produit;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class MarketplaceCarrefourApplication {

	// Définition du logger
	private static final Logger logger = LoggerFactory.getLogger(MarketplaceCarrefourApplication.class);


	public static void main(String[] args) {

		//SpringApplication.run(MarketplaceCarrefourApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(MarketplaceCarrefourApplication.class, args);

		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);

		// Ajouter des produits de test
		produitRepository.save(new Produit("Table", 150, "Photo Table"));
		produitRepository.save(new Produit("Chaise", 40, "Photo Chaise"));
		produitRepository.save(new Produit("PC Portable", 10900, "Photo PC"));
		produitRepository.save(new Produit("Ramette", 40, "Photo Ramette"));

		// Tester la pagination
		Page<Produit> prod1 = produitRepository.findAll(PageRequest.of(0, 5));
		//prod1.forEach(p->System.out.println("Nom du produit est : " + p.getNom()));
		prod1.forEach(p -> logger.info("Nom du produit est : {}", p.getNom()));

		// Tester la recherche par pattern
		Page<Produit> prod2 = produitRepository.chercherProduits("T%", PageRequest.of(0, 5));
		//prod2.forEach(p->System.out.println("Nom du produit est : " + p.getNom()));
		prod2.forEach(p -> logger.info("Nom du produit commençant par T : {}", p.getNom()));

		// Tester la recherche par nom exact
		List<Produit> list = produitRepository.findByNom("Chaise");
		//list.forEach(p->System.out.println(" ====> " + p.getNom()));
		list.forEach(p -> logger.info("Produit trouvé : {}", p.getNom()));
	}

}
