package com.springmvc.controllers;

import com.springmvc.entities.Produit;
import com.springmvc.services.ProuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProduitController {
    @Autowired
    ProuitService productService;

    @RequestMapping("/pageajouter")
    public String ajouterproduit() {
        return "ajouterproduit";
    }

    @RequestMapping("/ajouterproduit")
    public String saveProduit(
            @ModelAttribute("produit") Produit produit,
            @RequestParam("creationDate") String date,
            ModelMap modelMap) throws ParseException {
        // Convert the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateFormat.parse(String.valueOf(date));
        produit.setCreateat(creationDate);

        Produit savedProduct = productService.ajouterproduit(produit);
        String msg = "Produit ajouter avec id: " + savedProduct.getIdproduit();
        modelMap.addAttribute("msg", msg);
        return "ajouterproduit";
    }

    @RequestMapping("/listProduits")
    public String listProducts(
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Page<Produit> produits = productService.getAllProductsByPage(page, size);


        modelMap.addAttribute("produits", produits);
        modelMap.addAttribute("pages", new int[produits.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listesproduits";
    }

    @RequestMapping("/supprimerproduit")
    public String deleteProduct(
            @RequestParam("Idproduit") Long id,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        productService.supprimerproduit(id);
        Page<Produit> produit = productService.getAllProductsByPage(page, size);
        modelMap.addAttribute("produits", produit);
        modelMap.addAttribute("pages", new int[produit.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listedesproduits";
    }

    @RequestMapping("/pagemodifer")
    public String showUpdate(@RequestParam("Idproduit") Long id, ModelMap modelMap) {
        Produit produit = productService.getProduitbyid(id);
        modelMap.addAttribute("produit", produit);
        return "modifierproduit";
    }

    @RequestMapping("/updateproduit")
    public String updateProduct(
            @ModelAttribute("product") Produit product,
            @RequestParam("creationDate") String date,
            ModelMap modelMap) throws ParseException {
        // Convert the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateFormat.parse(String.valueOf(date));
        product.setCreateat(creationDate);

        productService.modiferproduit(product);
        Iterable<Produit> produits = productService.getProduits();
        modelMap.addAttribute("products", produits);
        return "listesproduits";
    }
}
