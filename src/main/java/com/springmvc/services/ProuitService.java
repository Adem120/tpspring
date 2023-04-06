package com.springmvc.services;

import com.springmvc.entities.Produit;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProuitService {
    Produit ajouterproduit(Produit product);
    Produit modiferproduit(Produit product);
    void deleteProduit(Produit product);
    void supprimerproduit(Long id);
    Produit getProduitbyid(Long id);
    List<Produit> getProduits();
    Page<Produit> getAllProductsByPage(int page, int size);
}
