package fr.ecole.tp.service;
import java.util.List;
import fr.ecole.tp.model.LigneCommande;
import fr.ecole.tp.model.Commande;

public class CommandeService {


    public static void afficherProduitsCommandes(List<Commande> commandes) {
    commandes.stream()
    .flatMap(c -> c.getLignes().stream())
    .map(LigneCommande::getProduit)
    .forEach(System.out::println);
    }

}
