package bddinterface;


public class Produit {
    public int id;
    public String nom;
    public int prix;

    Produit(int id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
    
    public int getId(){
        return this.id; 
    }
    
    public String getNom(){
        return this.nom; 
    }
    
    public int getPrix(){
        return this.prix; 
    }
}
