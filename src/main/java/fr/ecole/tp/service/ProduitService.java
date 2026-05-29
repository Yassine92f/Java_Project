package fr.ecole.tp.service;


import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import fr.ecole.tp.model.Produit;


public class ProduitService {

    // Fonctionnalité 2
    public static Function<Produit, String> nomVariable =  produit -> "[" + produit.getCategorie().toUpperCase() + "]"+ " " + produit.getNom() + " - " + produit.getPrix() + " €";


    // Fonctionnalité 3

    public static void Filtrage(List<Produit> listeProduits) {
        Predicate<Produit> estEnPromotion = produit -> produit.isPromotion() == true;
        Predicate<Produit> prixSuperieurA100 = produit -> produit.getPrix() > 100;
        Predicate<Produit> categorieInformatique = produit -> produit.getCategorie().equals("Informatique");

        System.out.println("Produits en promotion :");
        listeProduits.stream().filter(estEnPromotion).forEach(System.out::println);

        System.out.println("Produits à plus de 100 € :");
        listeProduits.stream().filter(prixSuperieurA100).forEach(System.out::println);

        System.out.println("Produits informatique :");
        listeProduits.stream().filter(categorieInformatique).forEach(System.out::println);

    }

    // Fonctionnalité 4

    public static void FiltrageMultiple(List<Produit> listeProduits) {
        Predicate<Produit> estEnPromotion = produit -> produit.isPromotion() == true;
        Predicate<Produit> prixSuperieurA100 = produit -> produit.getPrix() > 100;
        System.out.println("Produits en promotion et dont le prix est supérieur a 100:");
        listeProduits.stream().filter(estEnPromotion).filter(prixSuperieurA100).forEach(System.out::println);

    }


    // Fonctionnalité 5
    public static void TransformationMap(List<Produit> listeProduits) {
        listeProduits.stream()
                .map(Produit::getNom)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // Fonctionnalité 6
    public static void TriAvecComparator(List<Produit> listeProduits) {

        System.out.println("par prix croissant");
        listeProduits.stream().sorted(Comparator.comparing(Produit::getPrix)).forEach(System.out::println);

        System.out.println("par prix décroissant");
        listeProduits.stream().sorted(Comparator.comparing(Produit::getPrix).reversed()).forEach(System.out::println);

        System.out.println("par catégorie puis par nom");
        listeProduits.stream().sorted(Comparator.comparing(Produit::getCategorie).thenComparing(Produit::getNom)).forEach(System.out::println);

    }


    // Fonctionnalité 7

    public static void AvecDistinct(List<Produit> listeProduits) {

        System.out.println("Afficher toutes les catégories uniques avec distinct()");

        listeProduits.stream().map(Produit::getCategorie).distinct().forEach(System.out::println);
    }


    public static void AvecSet(List<Produit> listeProduits) {

        System.out.println("Afficher toutes les catégories uniques avec Collectors.toSet()");
        listeProduits.stream().map(Produit::getCategorie).collect(Collectors.toSet()).forEach(System.out::println);

    }

    // Fonctionnalité 8

    public static void AfficherLimit(List<Produit> listeProduits) {
        System.out.println("Afficher les 3 produits les plus chers");
        listeProduits.stream().sorted(Comparator.comparing(Produit::getPrix).reversed()).limit(3).forEach(System.out::println);

    }

    // Fonctionnalité 9

    public static void Pagination(List<Produit> listeProduits) {
        int Page = 5;

        System.out.println("Page 1");
        listeProduits.stream().limit(Page).forEach(System.out::println);
        System.out.println("Page 2");
        listeProduits.stream().skip(Page).limit(Page).forEach(System.out::println);
    }

    // Fonctionnalité 10

    public static void PrixTotal(List<Produit> listeProduits) {
        double prixTotal = listeProduits.stream().map(Produit::getPrix).reduce(0.0, Double::sum);
        System.out.println("Le prix total du catalogue(Avec reduce) est de : " + prixTotal + " €");

    }

    // Fonctionnalité 11

    public static void PrixTotalAvecMap(List<Produit> listeProduits) {
        double prixTotal = listeProduits.stream().mapToDouble(Produit::getPrix).sum();
        System.out.println("Le prix total du catalogue(Avec Map) est de : " + prixTotal + " €");

    }

    // Fonctionnalité 12


    public static void Traitement(List<Produit> listeProduits) {

        boolean result = listeProduits.stream().anyMatch(Produit::isPromotion);
        System.out.println("existe t-il un produit en promotion : " + result);

        boolean prixPositif = listeProduits.stream().allMatch(p -> p.getPrix() > 0);
        System.out.println("tout les produits ont-ils un prix positif : " + prixPositif);


        listeProduits.stream().filter(p -> p.getCategorie().equals("Informatique")).findFirst().ifPresent(p -> System.out.println("Premier produit Informatique : " + p));
        listeProduits.stream().max(Comparator.comparing(Produit::getPrix)).ifPresent(p -> System.out.println("Produit le plus cher : " + p));;
    }
}



