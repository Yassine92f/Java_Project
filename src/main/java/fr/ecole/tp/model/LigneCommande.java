package fr.ecole.tp.model;

public class LigneCommande {

    private final Produit produit;
    private final int quantite;




    public LigneCommande(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }


    public String getProduit() {
        return produit.getNom();
    }

    public int getQuantite() {
        return quantite;
    }
}