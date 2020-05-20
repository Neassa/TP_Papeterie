package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private float montant;
    private List<Ligne> lignesPanier;

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


    public Panier() {
        lignesPanier = new ArrayList<>();
    }


    public float getMontant() {
        return montant;
    }

    public Ligne getLigne(int index) {
        return lignesPanier.get(index);
    }

    public List<Ligne> getLignesPanier() {
        return lignesPanier;
    }

    public void addLigne(Article article, int qte) {
        Ligne ligneAAjouter = new Ligne(article, qte);
        lignesPanier.add(ligneAAjouter);

    }

    public void updateLigne(int index, int newQte) {
            this.getLigne(index).setQte(newQte);
    }

    public void removeLigne(int index) {
        lignesPanier.remove(index);
    }
}
