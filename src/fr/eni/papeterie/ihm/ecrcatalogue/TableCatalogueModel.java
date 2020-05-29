package fr.eni.papeterie.ihm.ecrcatalogue;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableCatalogueModel extends AbstractTableModel {
    private final List<Article> articles = new ArrayList<>();
    private final String[] entetes = {"Type", "Référence", "Marque", "Désignation", "Prix unitaire", "Stock"};

    public TableCatalogueModel() {
        super();

        articles.add(new Stylo("Bic", "BBOrange", "Bic bille Orange", 1.2f, 20, "bleu"));
        articles.add(new Stylo("Bic", "BBVert", "Bic bille Vert", 1.5f, 50, "vert"));
    }

    @Override
    public int getRowCount() {
        return articles.size();
    }


    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return entetes[columnIndex];
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return articles.get(rowIndex).getClass().getSimpleName();
            case 1:
                return articles.get(rowIndex).getMarque();
            case 2:
                return articles.get(rowIndex).getReference();
            case 3:
                return articles.get(rowIndex).getDesignation();
            case 4:
                return articles.get(rowIndex).getPrixUnitaire();
            case 5:
                return articles.get(rowIndex).getQteStock();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addArticle(Article art){
        articles.add(art);
        fireTableRowsInserted(articles.size()-1, articles.size()-1);
    }

    public void removeArtice(int rowIndex){
        articles.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
