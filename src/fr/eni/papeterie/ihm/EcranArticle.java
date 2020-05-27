package fr.eni.papeterie.ihm;

import javax.swing.*;
import java.awt.*;

public class EcranArticle extends JFrame {


    //attributs champs
    private JLabel lblRef, lblDesignation, lblMarque, lblStock, lblPrix, lblType, lblGrammage, lblCouleur;
    private JTextField txtRef, txtDeisgnation, txtMarque, txtStock, txtPrix;


    public EcranArticle() throws HeadlessException {
        this.setTitle("Article");
        this.setSize(500, 600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initIHM();
    }

    private void initIHM(){
        JPanel champs = new JPanel();
        champs.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Ajouter les compsants au panel champs
        //référence
        gbc.gridy = 0;
        gbc.gridx = 0;
        champs.add(getLblRef(), gbc);

        gbc.gridx = 1;
        champs.add(getTxtRef(), gbc);

        //Désignation
        gbc.gridy = 1;
        gbc.gridx = 0;
        champs.add(getLblDesignation(), gbc);

        gbc.gridx = 1;
        champs.add(getTxtDeisgnation(), gbc);

        //Marque
        gbc.gridy = 2;
        gbc.gridx = 0;
        champs.add(getLblMarque(), gbc);

        gbc.gridx = 1;
        champs.add(getTxtMarque(), gbc);

        //Stock
        gbc.gridy = 3;
        gbc.gridx = 0;
        champs.add(getLblStock(), gbc);

        gbc.gridx = 1;
        champs.add(getTxtStock(), gbc);

        //Prix
        gbc.gridy = 4;
        gbc.gridx = 0;
        champs.add(getLblPrix(), gbc);

        gbc.gridx = 1;
        champs.add(getTxtPrix(), gbc);

        //Type
        gbc.gridy = 5;
        gbc.gridx = 0;
        champs.add(getLblType(), gbc);

        //TODO ajouter radius

        //Grammage
        gbc.gridy = 6;
        gbc.gridx = 0;
        champs.add(getLblGrammage(), gbc);

        //TODO ajouter checkbox

        //Couleur
        gbc.gridy = 7;
        gbc.gridx = 0;
        champs.add(getLblCouleur(), gbc);

        //TODO ajouter liste

        //Affecter le panel à l'écran
        this.setContentPane(champs);
    }


    public JLabel getLblRef() {
        if (lblRef==null){
            lblRef = new JLabel("Référence");
        }
        return lblRef;
    }

    public JTextField getTxtRef() {
        if (txtRef == null){
            txtRef = new JTextField(30);
        }
        return txtRef;
    }

    public JLabel getLblDesignation() {
        if (lblDesignation==null){
            lblDesignation = new JLabel("Désignation");
        }
        return lblDesignation;
    }

    public JTextField getTxtDeisgnation() {
        if (txtDeisgnation == null){
            txtDeisgnation = new JTextField(30);
        }
        return txtDeisgnation;
    }

    public JLabel getLblMarque() {
        if (lblMarque==null){
            lblMarque = new JLabel("Marque");
        }
        return lblMarque;
    }

    public JTextField getTxtMarque() {
        if (txtMarque == null){
            txtMarque = new JTextField(30);
        }
        return txtMarque;
    }

    public JLabel getLblStock() {
        if (lblStock==null){
            lblStock = new JLabel("Stock");
        }
        return lblStock;
    }

    public JTextField getTxtStock() {
        if (txtStock == null){
            txtStock = new JTextField(30);
        }
        return txtStock;
    }

    public JLabel getLblPrix() {
        if (lblPrix==null){
            lblPrix = new JLabel("Prix");
        }
        return lblPrix;
    }

    public JTextField getTxtPrix() {
        if (txtPrix == null){
            txtPrix = new JTextField(30);
        }
        return txtPrix;
    }

    private JLabel getLblType() {
        if (lblType==null){
            lblType = new JLabel("Type");
        }
        return lblType;
    }



    private JLabel getLblGrammage() {
        if (lblGrammage==null){
            lblGrammage = new JLabel("Grammage");
        }
        return lblGrammage;
    }

    private JLabel getLblCouleur() {
        if (lblCouleur==null){
            lblCouleur = new JLabel("Couleur");
        }
        return lblCouleur;
    }

}

