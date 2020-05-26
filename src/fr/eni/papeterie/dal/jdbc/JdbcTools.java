package fr.eni.papeterie.dal.jdbc;

import fr.eni.papeterie.dal.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
    private static Connection conn;


    /**
     * Permet d'obtenir une connexion à la BDD
     * @return la connexion
     */
    public static Connection getConnexion() throws SQLException {
        conn = DriverManager.getConnection(Settings.getProperties("url"), Settings.getProperties("user"), Settings.getProperties("password"));
        return conn;
    }

    /**
     * Permet de fermer la connexion
     */
    public static void closeConnexion() {
        if (conn!= null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
