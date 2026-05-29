package fr.ecole.tp.model;

public class Produit {
    private  String id;
    private  String nom;
    private String categorie;
    private  double prix;
    private  boolean promotion;

    public Produit(String id, String nom, String categorie, double prix, boolean promotion) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.promotion = promotion;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isPromotion() {
        return promotion;
    }

    @Override
    public String toString() {
        return "[" + categorie.toUpperCase() + "] " + nom + " - " + prix + " €";
    }
}
