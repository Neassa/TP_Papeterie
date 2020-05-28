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


    /**
     * Permet d'ajouter un article au catalogue
     * @param a nouvel article
     * @throws BLLException
     */
    public void addArticle(Article a) throws BLLException {
        if(a.getIdArticle()!=null){
            throw new BLLException("Cet article existe déjà.");
        }
        try {
            validerArticle(a);
            daoArticles.insert(a);
        } catch (DALException e) {
            throw new BLLException("Echec de addArticle", e);
        }
    }

    /**
     * Permet de modifier un article dans le catalogue
     * @param a article à modifier
     * @throws BLLException
     */
    public void updateArticle(Article a) throws BLLException {

        try {
            validerArticle(a);
            daoArticles.update(a);
        } catch (DALException e) {
            throw new BLLException("Echec de updateArticle" + a, e);
        }

    }

    /**
     * Permet de supprimer un article dans le catalogue
     * @param a article à supprimer
     * @throws BLLException
     */
    public void removeArticle(Article a) throws BLLException {
        try {
            daoArticles.delete(a.getIdArticle());
        } catch (DALException e) {
            throw new BLLException("Echec de removeArticle" + a, e);
        }
    }

    /**
     * Permet de valider ou non un article
     * Vérifie la présence des attributs
     * Vérifie que le grammage est positif
     * Vérifie que le stock est positif
     * Si un article n'est pas valide, une exception BLLException est levée
     * @param a article à valider
     * @throws BLLException
     */
    public void validerArticle(Article a) throws BLLException {
    boolean valide = true;
    StringBuffer sb = new StringBuffer();

        //vérifie la présence des attributs
        if (a.getReference()==null || a.getReference().trim().length()==0
                || a.getMarque()==null || a.getMarque().trim().length()==0
                || a.getDesignation()==null || a.getDesignation().trim().length()==0) {
            sb.append("La référence, la marque et la désignation sont obligatoire.\n");
            valide = false;
        }
        //vérifie que grammage => 0
        if (a instanceof Ramette && ((Ramette) a).getGrammage()<=0) {
            sb.append("Le grmmage doit être strictement positif");
            valide = false;
        }
        //vérifie l'attribut couleur
        if (a instanceof Stylo && ((Stylo) a).getCouleur()==null) {
            sb.append("La couleur est obligatoire pour un stylo");
            valide = false;
        }
        //vérifie que qteStock => 0
        if (a.getQteStock()<=0 || a.getQteStock()==0) {
            valide = false;
        }
        if (!valide) {
            throw new BLLException(" l'article n'est pas validé. " + sb.toString());
        }

    }

    /**
     * Permet de récupérer un article par son id
     * @param index id de l'article à récupérer
     * @return l'article dont l'id est en paramètre
     * @throws BLLException
     */
    public Article getArticle(int index) throws BLLException {
        Article art = null;
        try {
            art = daoArticles.selectById(index);
        } catch (DALException e) {
            throw new BLLException("Erreur de récupération de l'article", e);
        }
        return art;
    }
}
