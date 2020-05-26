package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJbdcImpl;

public class DAOFactory {

    public static ArticleDAO getArticleDAO() {
        return new ArticleDAOJbdcImpl();
    }
}
