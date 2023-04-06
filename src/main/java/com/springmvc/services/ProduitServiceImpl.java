package com.springmvc.services;

import com.springmvc.entities.Produit;
import com.springmvc.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProuitService {
    @Autowired
    private ProduitRepository productRepository;
    @Override
    public Produit ajouterproduit(Produit produit) {
        return productRepository.save(produit);
    }

    @Override
    public Produit modiferproduit(Produit produit) {
        return productRepository.save(produit);
    }

    @Override
    public void deleteProduit(Produit produit) {
        productRepository.delete(produit);
    }

    @Override
    public void supprimerproduit(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Produit getProduitbyid(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Produit> getProduits() {
        return productRepository.findAll();
    }

    @Override
    public Page<Produit> getAllProductsByPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }
}
