package fr.eni.papeterie.dal.jdbc;

import fr.eni.papeterie.dal.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
    private static Connection conn;

    private static String urldb;
    private static String userdb;
    private static String passworddb;

    static {
        urldb = Settings.getProperties("url");
        userdb = Settings.getProperties("user");
        passworddb = Settings.getProperties("password");
    }

    /**
     * Permet d'obtenir une connexion à la BDD
     * @return la connexion
     */
    public static Connection getConnexion() throws SQLException {
            conn = DriverManager.getConnection(urldb,userdb, passworddb);
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
