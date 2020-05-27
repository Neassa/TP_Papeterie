package fr.eni.papeterie.dal;

import fr.eni.papeterie.bo.Article;

import java.util.List;

public interface ArticleDAO {

    //// CRUD ////
    public void insert(Article art) throws DALException;

    public void update(Article art) throws DALException;

    public Article selectById(int idArticle) throws DALException;

    public List<Article> selectAll() throws DALException;

    public void delete(int idArticle) throws DALException;
}
