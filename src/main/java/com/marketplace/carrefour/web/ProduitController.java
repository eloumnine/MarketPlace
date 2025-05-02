package com.marketplace.carrefour.web;

import com.marketplace.carrefour.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping(value = "/index")
    public String index(){
        return "produits";
    }
}
