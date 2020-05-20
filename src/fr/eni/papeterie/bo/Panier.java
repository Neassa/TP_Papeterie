package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private float montant;
    private List<Ligne> lignesPanier;

    /**
     * Constructeur de la classe Panier
     */
    public Panier() {
        lignesPanier = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuffer bf =new StringBuffer();
        bf.append("Panier : \n\n");
        for (Ligne ligne : lignesPanier) {
            if (ligne != null) {
                bf.append("ligne " + lignesPanier.indexOf(ligne) + " :\t");
                bf.append(ligne.toString());
                bf.append("\n");
            } else break;
        }
        bf.append("\nValeur du panier : " + getMontant());
        bf.append("\n\n");
        return bf.toString();
    }

    // GETTERS & SETTERS
    public float getMontant() {
        return montant;
    }

    public Ligne getLigne(int index) {
        return lignesPanier.get(index);
    }

    public List<Ligne> getLignesPanier() {
        return lignesPanier;
    }

    /**
     * Permet d'ajouter une ligne dans la list lignesPanier
     * @param article l'article de la ligne à ajouter
     * @param qte la quantité de cet article à mettre dans ce panier
     */
    public void addLigne(Article article, int qte) {
        Ligne ligneAAjouter = new Ligne(article, qte);
        lignesPanier.add(ligneAAjouter);
    }

    /**
     * Mettre à jour la quantité d'une ligne dans lignesPanier
     * @param index l'index de la ligne à modifier
     * @param newQte la nouvelle quantité
     */
    public void updateLigne(int index, int newQte) {
            this.getLigne(index).setQte(newQte);
    }

    /**
     * Retirer une ligne de lignesPanier
     * @param index l'index de la ligne à retirer
     */
    public void removeLigne(int index) {
        lignesPanier.remove(index);
    }
}
