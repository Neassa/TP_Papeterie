package fr.eni.papeterie.bo;

public class Stylo extends Article{
    private String couleur;

    /**
     * Constructeur
     * @param idArticle
     * @param marque
     * @param ref
     * @param designation
     * @param pu
     * @param qte
     */
    public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur) {
        super(idArticle, marque, ref, designation, pu, qte);
        this.couleur = couleur;
    }

    /**
     * Constructeur
     * @param marque
     * @param pu
     * @param qte
     */
    public Stylo(String marque, float pu, int qte, String couleur) {
        super(marque, pu, qte);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return  super.toString() + " Stylo [" +
                "couleur=" + couleur  +
                ']';
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
