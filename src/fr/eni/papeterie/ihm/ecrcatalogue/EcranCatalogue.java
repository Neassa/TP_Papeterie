package fr.eni.papeterie.ihm.ecrcatalogue;

import javax.swing.*;
import java.awt.*;

public class EcranCatalogue extends JFrame {

    public EcranCatalogue() throws HeadlessException {
        super();

        setTitle("Catalogue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable catalogue = new JTable(new TableCatalogueModel());

        getContentPane().add(new JScrollPane(catalogue), BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args) {
        new EcranCatalogue().setVisible(true);
    }
}
