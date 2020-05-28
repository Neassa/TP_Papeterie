package fr.eni.papeterie.ihm;

import com.sun.javafx.geom.Vec4d;
import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

import java.util.List;

public class GestionArticle {
    //artibut
    private List<Article> catalogue;
    private CatalogueManager cm;
    private int indexCatalogue;
    private EcranArticle ecranArt;

    private static GestionArticle instance;

    /**
     * Constructeur
     * initialise le catalogue en mémoire
     */
    private GestionArticle() {
        if (cm==null){
            try {
                cm = new CatalogueManager();
                catalogue = cm.getCatalogue();
            } catch (BLLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retourne une instance synchronisée de GestionArticle
     * @return
     */
    public static synchronized GestionArticle getInstance() {
        if (instance==null){
            instance = new GestionArticle();
        }
        return instance;
    }

    /**
     * Lance l'écran d'application
     */
    public void run(){
        ecranArt = new EcranArticle();
        ecranArt.setVisible(true);

        //affichage à l'ouverture de l'app
        if (catalogue.size() > 0){
            indexCatalogue = 0;
            ecranArt.afficherArticle(catalogue.get(indexCatalogue));
        } else {
            ecranArt.afficherNouveau();
        }
    }

    public void previous(){
        //afficher un article
        if (indexCatalogue > 0) {
            indexCatalogue--;
            ecranArt.afficherArticle(catalogue.get(indexCatalogue));
        }
    }

    public void next(){
        //afficher un article
        if (indexCatalogue < catalogue.size() - 1) {
            indexCatalogue++;
            ecranArt.afficherArticle(catalogue.get(indexCatalogue));
        }
    }

    public void newArt(){
        indexCatalogue = catalogue.size();
        ecranArt.afficherNouveau();
    }


    public void save(){
        Article artSelect = ecranArt.getArticle();
        try {
            if (artSelect.getIdArticle()==null){
                cm.addArticle(artSelect);
                System.out.println("ajout : " + artSelect);
                ecranArt.popupValidation("Enregistrement effectuée");
            } else {
                cm.updateArticle(artSelect);
                System.out.println("mise à jour : " + artSelect);
                catalogue.set(indexCatalogue, artSelect);//maj catalogue suite à l'update
                ecranArt.popupValidation("Mise à jour effectuée");
            }
        } catch (BLLException e) {
            e.printStackTrace();
            ecranArt.popupErreur("Enregistrement impossible");
        }
    }


    public void delete(){
        try {
            cm.removeArticle(catalogue.get(indexCatalogue));
            catalogue.remove(indexCatalogue);
            System.out.println("suppression : " + catalogue.get(indexCatalogue));
            ecranArt.popupValidation("Suppression effectuée");
        } catch (BLLException e) {
            ecranArt.popupErreur("Suppression impossible");
            e.printStackTrace();
        }

        if (indexCatalogue < catalogue.size()){
            //afficher article
            ecranArt.afficherArticle(catalogue.get(indexCatalogue));
        } else if (indexCatalogue > 0){
            indexCatalogue--;
            ecranArt.afficherArticle(catalogue.get(indexCatalogue));
        } else {
            ecranArt.afficherNouveau();
        }
    }
}
