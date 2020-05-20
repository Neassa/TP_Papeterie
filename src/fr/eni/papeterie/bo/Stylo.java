package fr.eni.papeterie.bo;

public class Stylo extends Article{
    private String couleur;

    /**
     * Constructeur complet avec héritage de la classe Article
     * @param idArticle id de l'article
     * @param marque la marque de l'article
     * @param ref la référence de l'article
     * @param designation la désignation de l'article
     * @param pu le prix unitaire de l'article
     * @param qte la quantité de l'article en stock
     */
    public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur) {
        super(idArticle, marque, ref, designation, pu, qte);
        this.couleur = couleur;
    }

    /**
     * Constructeur partiel avec héritage de la classe Article
     * @param marque la marque de l'article
     * @param pu le prix unitaire de l'article
     * @param qte la quantité de l'article en stock
     */
    public Stylo(String marque, float pu, int qte, String couleur) {
        super(marque, pu, qte);
        this.couleur = couleur;
    }

    /**
     * MAJ constructeur pour test AppliTestDAL
     * @param marque
     * @param ref
     * @param designation
     * @param pu
     * @param qte
     * @param bleu
     */
    public Stylo(String marque, String ref, String designation, float pu, int qte, String bleu) {
        super(null, marque, ref, designation, pu, qte);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return  super.toString() + " Stylo [" +
                "couleur=" + couleur  +
                ']';
    }

    // GETTERS & SETTERS
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
