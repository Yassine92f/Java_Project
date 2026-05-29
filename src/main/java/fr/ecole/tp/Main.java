package fr.ecole.tp;

import fr.ecole.tp.service.ProduitService;
import fr.ecole.tp.util.DataFactory;
import fr.ecole.tp.model.Produit;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produit> produits = DataFactory.getProduits();

        // Fonctionnalité 2
        Produit p = DataFactory.getProduits().get(0);
        System.out.println(ProduitService.nomVariable.apply(p));

        // Fonctionnalité 3
        ProduitService.Filtrage(produits);

        // Fonctionnalité 4
        ProduitService.FiltrageMultiple(produits);

        // Fonctionnalité 5
        ProduitService.TransformationMap(produits);


        // Fonctionnalité 6
        ProduitService.TriAvecComparator(produits);

        // Fonctionnalité 7
        ProduitService.AvecDistinct(produits);
        ProduitService.AvecSet(produits);

        // Fonctionnalité 8

        ProduitService.AfficherLimit(produits);

        // Fonctionnalité 9
        ProduitService.Pagination(produits);


        // Fonctionnalité 10
        ProduitService.PrixTotal(produits);

        // Fonctionnalité 11
        ProduitService.PrixTotalAvecMap(produits);

        // Fonctionnalité 12

        ProduitService.Traitement(produits);



    }
}
