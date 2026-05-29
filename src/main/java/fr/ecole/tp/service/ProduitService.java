package fr.ecole.tp.service;


import java.util.function.Function;

import fr.ecole.tp.model.Produit;
import java.util.List;
import java.util.function.Consumer;



public class ProduitService {

    public static Function<Produit, String> nomVariable =  produit -> "[" + produit.getCategorie().toUpperCase() + "]"+ " " + produit.getNom() + " - " + produit.getPrix() + " €";



    public static void afficherTousLesProduits(List<Produit> produits) {
        Consumer<Produit> afficherProduit = System.out::println;
        produits.forEach(afficherProduit);
    }
}



