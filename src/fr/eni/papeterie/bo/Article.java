package fr.eni.papeterie.bo;

public abstract class Article {
    private Integer idArticle;
    private String reference;
    private String marque;
    private String designation;
    private float prixUnitaire;
    private int qteStock;


    /**
     * Constructeur complet
     * @param idArticle id de l'article
     * @param marque la marque de l'article
     * @param ref la référence de l'article
     * @param designation la désignation de l'article
     * @param pu le prix unitaire de l'article
     * @param qte la quantité de l'articl en stock
     */
    public Article(Integer idArticle, String marque, String ref, String designation, float pu, int qte) {
        this.idArticle = idArticle;
        this.reference = ref;
        this.marque = marque;
        this.designation = designation;
        this.prixUnitaire = pu;
        this.qteStock = qte;
    }

    /**
     * Constructeur partiel
     * @param marque la marque de l'article
     * @param pu le prix unitaire de l'article
     * @param qte la quantité de l'articl en stock
     */
    public Article(String marque, float pu, int qte) {
        this.marque = marque;
        this.prixUnitaire = pu;
        this.qteStock = qte;
    }

    /**
     * Constructeur vide par défaut
     */
    public Article() {
    }

    @Override
    public String toString() {
        return "Article [" +
                "idArticle=" + idArticle +
                ", reference=" + reference +
                ", marque=" + marque +
                ", designation=" + designation+
                ", prixUnitaire=" + prixUnitaire +
                ", qteStock=" + qteStock +
                ']';
    }

    //GETTERS & SETTERS
    public Integer getIdArticle() {
        return idArticle;
    }

    public String getReference() {
        return reference;
    }

    public String getMarque() {
        return marque;
    }

    public String getDesignation() {
        return designation;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }
}
