package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;

public class CatalogueManager {
    private static CatalogueManager instance;

    public static CatalogueManager getInstance() {
        if (instance == null) {
            instance = new CatalogueManager();
        }
        return instance;
    }

    public CatalogueManager() {

    }

    public void addArticle(Article art) {
    }

    public boolean getCatalogue() {
        return true;
    }
}
