package fr.ecole.tp.service;


import java.util.function.Function;

import fr.ecole.tp.model.Produit;


public class ProduitService {

    public static Function<Produit, String> nomVariable =  produit -> "[" + produit.getCategorie().toUpperCase() + "]"+ " " + produit.getNom() + " - " + produit.getPrix() + " €";
}