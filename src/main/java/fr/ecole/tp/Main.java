package fr.ecole.tp;

import fr.ecole.tp.service.ProduitService;
import fr.ecole.tp.service.CommandeService;
import fr.ecole.tp.util.DataFactory;
import fr.ecole.tp.model.Produit;

import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                List<Produit> produits = DataFactory.getProduits();
                Scanner scanner = new Scanner(System.in);
                int choix = -1;

                while (choix != 0) {
                        System.out.println("\n=== CATALOGUE CONSOLE ===\n");
                        System.out.println("1. Afficher tous les produits");
                        System.out.println("2. Afficher les produits triés par prix croissant");
                        System.out.println("3. Afficher les produits d'une catégorie");
                        System.out.println("4. Rechercher les produits en promotion");
                        System.out.println("5. Afficher les noms des produits en majuscules");
                        System.out.println("6. Afficher les 3 produits les plus chers");
                        System.out.println("7. Calculer le prix total du catalogue");
                        System.out.println("8. Afficher les catégories uniques");
                        System.out.println("9. Afficher les commandes avec leurs produits");
                        System.out.println("10. Calculer le total de chaque commande");
                        System.out.println("11. Vérifier si tous les produits ont un prix positif");
                        System.out.println("12. Démonstration parallelStream");
                        System.out.println("0. Quitter");
                        System.out.print("\nVotre choix : ");

                        choix = scanner.nextInt();

                        switch (choix) {
                                case 1:
                                        ProduitService.afficherTousLesProduits(produits);
                                        break;
                                case 2:
                                        ProduitService.TriAvecComparator(produits);
                                        break;
                                case 3:
                                        ProduitService.ProduitsParCategorie(produits, "Informatique");
                                        break;
                                case 4:
                                        ProduitService.ProduitsEnPromotion(produits);
                                        break;
                                case 5:
                                        ProduitService.TransformationMap(produits);
                                        break;
                                case 6:
                                        ProduitService.AfficherLimit(produits);
                                        break;
                                case 7:
                                        ProduitService.PrixTotal(produits);
                                        break;
                                case 8:
                                        ProduitService.AvecDistinct(produits);
                                        break;
                                case 9:
                                        CommandeService.afficherProduitsCommandes(DataFactory.getCommandes());
                                        break;
                                case 10:
                                        CommandeService.totalToutesCommande(DataFactory.getCommandes());
                                        break;
                                case 11:
                                        ProduitService.Traitement(produits);
                                        break;
                                case 12:
                                        System.out.println("Démonstration parallelStream à implémenter");
                                        break;
                                case 0:
                                        System.out.println("Au revoir !");
                                        break;
                                default:
                                        System.out.println("Choix invalide");
                        }
                }
                scanner.close();
        }
}