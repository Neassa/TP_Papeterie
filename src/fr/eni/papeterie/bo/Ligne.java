package fr.eni.papeterie.bo;

public class Ligne {
    protected int qte;
    private Article article;

    /**
     * Constructeur de la classe Ligne
     * @param article l'article référencé dans la ligne
     * @param qte la quantité sélectionnée
     */
    public Ligne(Article article, int qte) {
        this.qte = qte;
        this.article = article;
    }

    @Override
    public String toString() {
        return "Ligne [" +
                "qte=" + qte +
                ", article=" + article +
                ']';
    }

    //GETTERS & SETTERS
    public int getQte() {
        return qte;
    }

    public Article getArticle() {
        return article;
    }

    public float getPrix() {
        return this.article.getPrixUnitaire();
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    private void setArticle(Article article) {
        this.article = article;
    }

}
