package fr.eni.papeterie.test;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestSerial {

    public static void main(String[] args) {

        Article a1 = new Stylo( "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");

        //écrire et lire des objets
        try {
            FileOutputStream fos = new FileOutputStream(new File("articles.txt"));
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(a1);
            System.out.println("Object sérialisé");
            os.close();
            System.out.println("Fermeture");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
