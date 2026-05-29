package fr.ecole.tp;

import fr.ecole.tp.service.ProduitService;
import fr.ecole.tp.util.DataFactory;
import fr.ecole.tp.model.Produit;



import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produit p = DataFactory.getProduits().get(2);
        System.out.println(ProduitService.nomVariable.apply(p));
        ProduitService.afficherTousLesProduits(DataFactory.getProduits());
         
        

        
        
        

    }
}
