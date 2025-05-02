package com.marketplace.carrefour;

import com.marketplace.carrefour.dao.ProduitRepository;
import com.marketplace.carrefour.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MarketplaceCarrefourApplication {

	public static void main(String[] args) {

		//SpringApplication.run(MarketplaceCarrefourApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(MarketplaceCarrefourApplication.class, args);

		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("Champo Mosetela",150,"Mosetela France"));
	}

}
