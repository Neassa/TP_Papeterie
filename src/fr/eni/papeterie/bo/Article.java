package fr.eni.papeterie.bo;

public abstract class Article {
    private Integer idArticle;
    private String reference;
    private String marque;
    private String designation;
    private float prixUnitaire;
    private int qteStock;


    /**
     * Constructeur
     * @param idArticle
     * @param marque
     * @param ref
     * @param designation
     * @param pu
     * @param qte
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
     * Constructeur
     * @param marque
     * @param pu
     * @param qte
     */
    public Article(String marque, float pu, int qte) {
        this.marque = marque;
        this.prixUnitaire = pu;
        this.qteStock = qte;
    }

    public Article() {

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
}
