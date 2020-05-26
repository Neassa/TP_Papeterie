package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

import java.util.List;

public class CatalogueManager {
    private static ArticleDAO daoArticles;

    /**
     * Constructeur
     * @throws BLLException
     */
    public CatalogueManager() throws BLLException{
        daoArticles = DAOFactory.getArticleDAO();
    }

    /**
     * Permet de créer une instance de Catalogue
     * @return
     * @throws BLLException
     */
    public List<Article> getCatalogue() throws BLLException {
        List<Article> articles = null;
        try {
            articles = daoArticles.selectAll();
        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException("Erreur de récupération du catalogue", e);
        }
        return articles;
    }


    public void addArticle(Article art) throws BLLException {
        if(art.getIdArticle()!=null){
            throw new BLLException("Cet article existe déjà.");
        }

        try {
            validerArticle(art);
            daoArticles.insert(art);
        } catch (DALException e) {
            throw new BLLException("Echec de addArticle", e);
        }
    }

    public void updateArticle(int index) {


    }

    public void removeArticle(Article a) {

    }

    public void validerArticle(Article a) throws BLLException {
    boolean valide = true;

        //vérifie la présence des attributs
        if (a.getReference()==null || a.getMarque()==null ||
        a.getDesignation()==null) {
            valide = false;
        }
        //vérifie que grammage => 0
        if (a instanceof Ramette && ((Ramette) a).getGrammage()<=0) {
            valide = false;
        }
        //vérifie l'attribut couleur
        if (a instanceof Stylo && ((Stylo) a).getCouleur()==null) {
            valide = false;
        }
        //vérifie que qteStock => 0
        if (a.getQteStock()<=0) {
            valide = false;
        }
        if (!valide) {
            throw new BLLException("l'article n'est pas validé");
        }

    }
    public void getArticle(int index) {

    }
}
