package fr.eni.papeterie.dal.jdbc;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOJbdcImpl {
    String url = "jdbc:sqlserver://LAPTOP-N49RLD68:1433;databaseName=PAPETERIE_DB";
    Connection conn;
    Statement stmt;

    private static final String querySelectbyId = "SELECT idArticle, reference , marque, designation, prixUnitaire, qteStock, grammage, couleur, type from Articles WHERE idArticle = ?";
    private static final String queryInsert = "INSERT INTO Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String querySelectAll = "SELECT * FROM Articles";

    public Connection getConnexion() {
        try {
            conn = DriverManager.getConnection(url, "sa", "Alistair18");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }


    public void insert(Article art) throws DALException {
        getConnexion();

        try {
            PreparedStatement stmt = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, art.getReference(), Types.NCHAR);
            stmt.setObject(2, art.getMarque(), Types.VARCHAR);
            stmt.setObject(3, art.getDesignation(), Types.NVARCHAR);
            stmt.setObject(4, art.getPrixUnitaire(), Types.FLOAT);
            stmt.setObject(5, art.getQteStock(), Types.INTEGER);

            if (art instanceof Stylo) {
                stmt.setObject(7, ((Stylo) art).getCouleur(), Types.NVARCHAR);
                stmt.setObject(6, null, Types.INTEGER);
                stmt.setObject(8, art.getClass().getSimpleName(), Types.NCHAR);
            }
            if (art instanceof Ramette) {
                stmt.setObject(6, ((Ramette) art).getGrammage(), Types.INTEGER);
                stmt.setObject(7, null, Types.INTEGER);
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
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                stmt = null;
            }
            if (conn!= null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
        getConnexion();
        try {
            PreparedStatement stmt = conn.prepareStatement(querySelectbyId);
            stmt.setInt(1, idArticle);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if ("stylo".equalsIgnoreCase(rs.getString("type").trim())){
                    artSelected = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getString("couleur"));
                }
                if ("Ramette".equalsIgnoreCase(rs.getString("type").trim())){
                    artSelected = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                            rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                            rs.getInt("grammage"));
                }
            }
        } catch (SQLException throwables) {
            throw new DALException("selectById a échoué", throwables);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return artSelected;
    }



   public List<Article> selectAll() throws DALException {
        getConnexion();
        List<Article> liste = new ArrayList<>();
       try {
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
                   new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
                           rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
                           rs.getInt("grammage"));
               }
               liste.add(art);
           }
       } catch (SQLException throwables) {
           throw new DALException("selectAll a échoué", throwables);
       } finally {
           if (stmt!= null){
               try {
                   stmt.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
               stmt = null;
           }
           if (conn!= null){
               try {
                   conn.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
       }

       return liste;
   }

    /*public void update(Article a1) {
    UPDATE Articles SET idArticle = ?, reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur =?
    }

    public void delete(Integer idArticle) {
    }*/
}


