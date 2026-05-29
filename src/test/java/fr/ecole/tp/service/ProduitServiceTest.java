package fr.ecole.tp.service;

import fr.ecole.tp.model.Client;
import fr.ecole.tp.model.Commande;
import fr.ecole.tp.model.LigneCommande;
import fr.ecole.tp.model.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProduitServiceTest {

    private List<Produit> produits;

    @BeforeEach
    void setUp() {
        // Préparation des données avant CHAQUE test
        produits = List.of(
            new Produit("P1", "Clavier", "Informatique", 45.0, true),
            new Produit("P2", "Souris", "Informatique", 25.0, false),
            new Produit("P3", "Ecran", "Informatique", 250.0, false),
            new Produit("P4", "Lave-linge", "Electromenager", 599.0, true),
            new Produit("P5", "Livre Java", "Livre", 35.0, false)
        );
    }

    
    // Test 1 — Filtrage des produits en promotion
    
    @Test
    void doitFiltrerLesProduitsEnPromotion() {
        Predicate<Produit> estEnPromotion = Produit::isPromotion;

        List<Produit> resultat = produits.stream().filter(estEnPromotion).collect(Collectors.toList());

        assertEquals(2, resultat.size());
        assertTrue(resultat.stream().allMatch(Produit::isPromotion));
    }

    
    // Test 2 — Filtrage des produits prix > 100
   
    @Test
    void doitFiltrerLesProduitsAvecPrixSuperieurA100() {
        Predicate<Produit> prixSuperieurA100 = p -> p.getPrix() > 100;

        List<Produit> resultat = produits.stream().filter(prixSuperieurA100).collect(Collectors.toList());

        assertEquals(2, resultat.size());
        assertTrue(resultat.stream().allMatch(p -> p.getPrix() > 100));
    }

    
    // Test 3 — Transformation des noms en majuscules
    
    @Test
    void doitTransformerLesNomsEnMajuscules() {
        Function<Produit, String> nomMajuscule = p -> p.getNom().toUpperCase();

        List<String> noms = produits.stream().map(nomMajuscule).collect(Collectors.toList());

        assertEquals(5, noms.size());
        assertTrue(noms.contains("CLAVIER"));
        assertTrue(noms.contains("SOURIS"));
        assertTrue(noms.contains("ECRAN"));
        assertEquals("CLAVIER", nomMajuscule.apply(produits.get(0)));
    }

    
    // Test 4 — Total catalogue avec reduce
   
    @Test
    void doitCalculerLeTotalCatalogueAvecReduce() {
        double total = produits.stream().map(Produit::getPrix).reduce(0.0, Double::sum);

        // 45 + 25 + 250 + 599 + 35 = 954.0
        assertEquals(954.0, total, 0.001);
    }

    
    // Test 5 — Total catalogue avec mapToDouble().sum()
    
    @Test
    void doitCalculerLeTotalCatalogueAvecMapToDouble() {
        double total = produits.stream().mapToDouble(Produit::getPrix).sum();

        assertEquals(954.0, total, 0.001);
    }

    
    // Test 6 — Récupération des catégories uniques
    
    @Test
    void doitRecupererLesCategoriesUniques() {
        Set<String> categories = produits.stream().map(Produit::getCategorie).collect(Collectors.toSet());

        assertEquals(3, categories.size());
        assertTrue(categories.contains("Informatique"));
        assertTrue(categories.contains("Electromenager"));
        assertTrue(categories.contains("Livre"));
    }

    
    // Test 7 — Calcul du total d'une commande
    
    @Test
    void doitCalculerLeTotalDuneCommande() {
        Client client = new Client("C1", "Dupont", "dupont@mail.com");
        LigneCommande ligne1 = new LigneCommande(produits.get(0), 2); // Clavier 45 x 2 = 90
        LigneCommande ligne2 = new LigneCommande(produits.get(2), 1); // Ecran 250 x 1 = 250
        Commande commande = new Commande("CMD1", client, List.of(ligne1, ligne2));

        double total = commande.getLignes().stream()
                .mapToDouble(l -> l.getProduit().getPrix() * l.getQuantite())
                .sum();

        // 90 + 250 = 340
        assertEquals(340.0, total, 0.001);
    }

    
    // Test 8 — Vérification du produit le plus cher
    
    @Test
    void doitTrouverLeProduitLePlusCher() {
        Optional<Produit> plusCher = produits.stream().max(Comparator.comparing(Produit::getPrix));

        assertTrue(plusCher.isPresent());
        assertEquals("Lave-linge", plusCher.get().getNom());
        assertEquals(599.0, plusCher.get().getPrix(), 0.001);
    }
}