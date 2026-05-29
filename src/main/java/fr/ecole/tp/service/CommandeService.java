package fr.ecole.tp.service;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import fr.ecole.tp.model.LigneCommande;
import fr.ecole.tp.model.Produit;
import fr.ecole.tp.model.Commande;

public class CommandeService {


    public static void afficherProduitsCommandes(List<Commande> commandes) {

    commandes.stream().flatMap(c -> c.getLignes().stream()).map(LigneCommande::getProduit).forEach(System.out::println);
    
    }


    // Fonctionnalité 14
    public static double totalCommande (Commande commande) {
        BiFunction<Produit, Integer, Double> calculLigne = (produit, quantite) -> produit.getPrix() * quantite;
        double total = commande.getLignes().stream().mapToDouble(ligne -> calculLigne.apply(ligne.getProduit(), ligne.getQuantite())).sum();

        return total;
    }

    public static void totalToutesCommande (List<Commande> commandes) {
        for (Commande commande : commandes) {
            double total = totalCommande(commande);
            System.out.println("Total de la commande : " + total + " €");
        }
    }

    //Fonctionnalité 15
    public static void mapString (List<Commande> commandes) {
        Map<String, Double> totalParCommande = commandes.stream().collect(Collectors.toMap(Commande::getId, CommandeService::totalCommande));
        totalParCommande.forEach((id, total) ->
            System.out.println("Commande " + id + " : " + total + " €"));

    }


}

    
