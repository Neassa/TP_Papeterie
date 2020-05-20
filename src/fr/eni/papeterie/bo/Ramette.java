package fr.eni.papeterie.bo;


public class Ramette extends Article{
    private int grammage;

    /**
     * Constructeur hérité de la classe Article
     */
    public Ramette() {
        super();
    }

    /**
     * Constructeur complet avec héritage de la classe Article
     * @param idArticle id de l'article
     * @param marque la marque de l'article
     * @param ref la référence de l'article
     * @param designation la désignation de l'article
     * @param pu le prix unitaire de l'article
     * @param qte la quantité de l'article en stock
     * @param grammage le grammage de la ramette
     */
    public Ramette(Integer idArticle, String marque, String ref, String designation, float pu, int qte, int grammage) {
        super(idArticle, marque, ref, designation, pu, qte);
        this.grammage = grammage;
    }

    /**
     * Constructeur partiel avec héritage de la classe Article
     * @param marque la marque de l'article
     * @param pu le prix unitaire de l'article
     * @param qte la quantité de l'article en stock
     * @param grammage le grammage de la ramette
     */
    public Ramette(String marque, float pu, int qte, int grammage) {
        super(marque, pu, qte);
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return super.toString() + " Ramette [" +
                "grammage=" + grammage +
                ']';
    }

    // GETTERS & SETTERS
    public int getGrammage() {
        return grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }
}
