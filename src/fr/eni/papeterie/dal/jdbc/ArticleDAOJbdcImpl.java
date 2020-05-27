package fr.eni.papeterie.dal.jdbc;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOJbdcImpl implements ArticleDAO {
    Statement stmt;
    Connection conn = null;

    private static final String TYPE_STYLO = "Stylo";
    private static final String TYPE_RAMETTE = "Ramette";

    //Requêtes SQL
    private static final String querySelectbyId = "SELECT idArticle, reference , marque, designation, prixUnitaire, qteStock, grammage, couleur, type from Articles WHERE idArticle = ?";
    private static final String queryInsert = "INSERT INTO Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String querySelectAll = "SELECT * FROM Articles";
    private static final String queryUpdate = "UPDATE Articles SET  reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur =? WHERE idArticle=?";
    private static final String queryDelete = "DELETE FROM Articles WHERE idArticle=?";

    /**
     * Permet de fermer le statement ouvert
     */
    public void closeStatement() {
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            stmt = null;
        }
    }

    //////////////////////////// CRUD ////////////////////////////

    /**
     * Permet de réaliser un INSERTe sur la table Article de la BDD PAPETERI_DB
     * et récupèrer l'id auto-généré par SQL server et modifier l'instance
     * @param art les données de l'article à ajouter
     * @throws DALException
     */
    public void insert(Article art) throws DALException {

        try {
            conn = JdbcTools.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, art.getReference(), Types.NCHAR);
            stmt.setObject(2, art.getMarque(), Types.VARCHAR);
            stmt.setObject(3, art.getDesignation(), Types.NVARCHAR);
            stmt.setObject(4, art.getPrixUnitaire(), Types.FLOAT);
            stmt.setObject(5, art.getQteStock(), Types.INTEGER);

            if (art instanceof Stylo) {
                stmt.setObject(7, ((Stylo) art).getCouleur(), Types.NVARCHAR);
                stmt.setNull(6, Types.INTEGER);
                stmt.setObject(8, art.getClass().getSimpleName(), Types.NCHAR);
            }
            if (art instanceof Ramette) {
                stmt.setObject(6, ((Ramette) art).getGrammage(), Types.INTEGER);
                stmt.setNull(7, Types.INTEGER);
                stmt.setObject(8, art.getClass().getSimpleName(), Types.NCHAR);
            }
            stmt.executeUpdate();
            //récupérer l'id de l'article
           ResultSet rs = stmt.getGeneratedKeys();
           if (rs.next()) {
               art.setIdArticle(rs.getInt(1));
           }
        } catch (SQLException throwables) {
            throw new DALException("insert a échoué", throwables);
        } finally {
            closeStatement();
            JdbcTools.closeConnexion();
        }
    }

    /**
     * Permet de réaliser un SELECT sur la table Article de la BDD PAPETERI_DB par l'id de l'article
     * @param idArticle l'id de l'article à rechercher
     * @return un select de l'article
     * @throws DALException
     */
    public Article selectById(int idArticle) throws DALException {
        Article artSelected = null;

        try {
            conn =JdbcTools.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(querySelectbyId);
            stmt.setInt(1, idArticle);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())){
                    artSelected = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getString("couleur"));
                }
                if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())){
                    artSelected = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getInt("grammage"));
                }
            }
        } catch (SQLException throwables) {
            throw new DALException("selectById a échoué", throwables);
        } finally {
            closeStatement();
            JdbcTools.closeConnexion();
        }
        return artSelected;
    }


    /**
     * Permet de réaliser un SELECT sur la table Article de la BDD PAPETERI_DB
     * @return une liste contenant tous les articles de la table
     * @throws DALException
     */
   public List<Article> selectAll() throws DALException {
        List<Article> articles = new ArrayList<>();
       try {
           conn = JdbcTools.getConnexion();
           Article art = null;
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(querySelectAll);

           while (rs.next()) {
               if ("stylo".equalsIgnoreCase(rs.getString("type").trim())){
                    art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getString("couleur"));
               }
               if ("Ramette".equalsIgnoreCase(rs.getString("type").trim())){
                   art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                           rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                           rs.getInt("grammage"));
               }
               articles.add(art);
           }
       } catch (SQLException throwables) {
           throw new DALException("selectAll a échoué", throwables);
       } finally {
           closeStatement();
           JdbcTools.closeConnexion();
       }

       return articles;
   }

   /**
    * Permet de réaliser un UPDATE sur la table Article de la BDD PAPETERI_DB
    */
    public void update(Article art) throws DALException {
        try {
            conn = JdbcTools.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(queryUpdate);
            stmt.setString(1, art.getReference());
            stmt.setString(2, art.getMarque());
            stmt.setString(3, art.getDesignation());
            stmt.setFloat(4, art.getPrixUnitaire());
            stmt.setInt(5, art.getQteStock());
            stmt.setInt(8, art.getIdArticle());

            if (art instanceof Stylo) {
                stmt.setObject(7, ((Stylo) art).getCouleur(), Types.NVARCHAR);
                stmt.setObject(6, null, Types.INTEGER);
            }
            if (art instanceof Ramette) {
                stmt.setObject(6, ((Ramette) art).getGrammage(), Types.INTEGER);
                stmt.setObject(7, null, Types.INTEGER);
            }
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throw new DALException("update a échoué", throwables);
        } finally {
            closeStatement();
            JdbcTools.closeConnexion();
        }
    }

    /**
     * Permet de réaliser un DELETE sur la table Article de la BDD PAPETERI_DB
     * @param idArticle id de l'article à suprimmer
     * @throws DALException
     */
    public void delete(int idArticle) throws DALException {
        try {
            conn = JdbcTools.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(queryDelete);
            stmt.setInt(1, idArticle);
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throw new DALException("delete a échoué", throwables);
        } finally {
            closeStatement();
            JdbcTools.closeConnexion();
        }
    }
}


