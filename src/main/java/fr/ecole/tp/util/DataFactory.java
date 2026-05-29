package fr.ecole.tp.util;

import fr.ecole.tp.model.Client;
import fr.ecole.tp.model.Commande;
import fr.ecole.tp.model.LigneCommande;
import fr.ecole.tp.model.Produit;

import java.util.List;

public class DataFactory {

    public static List<Produit> getProduits() {
        return List.of(
                new Produit("P01", "Clavier mécanique", "Informatique", 89.99, false),
                new Produit("P02", "Souris ergonomique", "Informatique", 49.95, true),
                new Produit("P03", "Écran 27 pouces 4K", "Informatique", 549.00, false),
                new Produit("P04", "Hub USB-C 7 ports", "Informatique", 34.90, true),

                new Produit("P05", "Casque sans fil Pro", "Audio", 189.00, false),
                new Produit("P06", "Enceinte Bluetooth", "Audio", 79.00, false),
                new Produit("P07", "Micro de bureau cardioïde", "Audio", 129.90, true),

                new Produit("P08", "Lampe de bureau LED", "Bureau", 44.50, false),
                new Produit("P09", "Support écran réglable", "Bureau", 62.00, false),
                new Produit("P10", "Tapis de souris XL", "Bureau", 19.99, false),

                new Produit("P11", "SSD externe 1 To", "Stockage", 99.00, true),
                new Produit("P12", "Clé USB 3.1 256 Go", "Stockage", 22.50, false)
        );
    }

    public static List<Client> getClients() {
        return List.of(
                new Client("C01", "Alice Martin", "alice.martin@exemple.fr"),
                new Client("C02", "Bruno Lefebvre", "bruno.lefebvre@exemple.fr"),
                new Client("C03", "Chloé Dupont", "chloe.dupont@exemple.fr"),
                new Client("C04", "David Renard", "david.renard@exemple.fr")
        );
    }

    public static List<Commande> getCommandes() {
        List<Produit> produits = getProduits();
        List<Client> clients = getClients();

        Produit clavier = produits.get(0);
        Produit souris = produits.get(1);
        Produit ecran = produits.get(2);
        Produit hubUsb = produits.get(3);
        Produit casque = produits.get(4);
        Produit enceinte = produits.get(5);
        Produit micro = produits.get(6);
        Produit lampe = produits.get(7);
        Produit support = produits.get(8);
        Produit ssd = produits.get(10);
        Produit cleUsb = produits.get(11);

        Client alice = clients.get(0);
        Client bruno = clients.get(1);
        Client chloe = clients.get(2);
        Client david = clients.get(3);

        return List.of(
                new Commande("CMD-001", alice, List.of(
                        new LigneCommande(ecran, 1),
                        new LigneCommande(clavier, 1),
                        new LigneCommande(souris, 1),
                        new LigneCommande(support, 1)
                )),

                new Commande("CMD-002", bruno, List.of(
                        new LigneCommande(casque, 1),
                        new LigneCommande(micro, 1),
                        new LigneCommande(enceinte, 1)
                )),

                new Commande("CMD-003", chloe, List.of(
                        new LigneCommande(ssd, 2),
                        new LigneCommande(cleUsb, 3)
                )),

                new Commande("CMD-004", david, List.of(
                        new LigneCommande(lampe, 1)
                )),

                new Commande("CMD-005", alice, List.of(
                        new LigneCommande(hubUsb, 2),
                        new LigneCommande(cleUsb, 1)
                ))
        );
    }
}