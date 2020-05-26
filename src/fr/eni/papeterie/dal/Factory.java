package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJbdcImpl;

public class Factory {

    public static ArticleDAO getArticleDAO() {
        return new ArticleDAOJbdcImpl();
    }
}
