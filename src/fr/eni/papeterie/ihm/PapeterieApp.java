package fr.eni.papeterie.ihm;

import javax.swing.*;

public class PapeterieApp {

    public static void main(String[] args) {

        //Executer l'écran princpal dans un thread spécifique
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestionArticle.getInstance().run();
            }
        });
    }
}
