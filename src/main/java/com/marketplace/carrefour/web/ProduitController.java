package com.marketplace.carrefour.web;

import com.marketplace.carrefour.dao.ProduitRepository;
import com.marketplace.carrefour.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping(value="/index")
    public String Index(Model model,
                        @RequestParam(name="page", defaultValue="0") int p,
                        @RequestParam(name="motCle", defaultValue="") String mc) {
        Page<Produit> pageProduits =produitRepository
                .chercherProduits(mc, PageRequest.of(p, 2));
        int pagesCount = pageProduits.getTotalPages();
        int [] pages = new int[pagesCount];
        for(int i=0;i<pagesCount;i++) { pages[i] = i; }
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("motCle", mc);
        model.addAttribute("pageProduits", pageProduits);
        return "produits";
    }

    @RequestMapping(value="/form", method= RequestMethod.GET)
    public String formProduit(Model model) {
        model.addAttribute("produit",
                new Produit("exemple", 0.0, "exemple.jpg"));
        return "formProduit";
    }

    @RequestMapping(value="/enregistrerProduit", method=RequestMethod.POST)
    public String enregistrerProduit(Produit pd) throws Exception {
        produitRepository.save(pd);
        return "redirect:index";
    }

}
