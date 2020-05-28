package fr.eni.papeterie.ihm;


import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EcranArticle extends JFrame {
    //attributs
    private JPanel panelGrammage, panelType, panelChamps, panelBoutons;
    private JLabel lblRef, lblDesignation, lblMarque, lblStock, lblPrix, lblType, lblGrammage, lblCouleur;
    private JTextField txtRef, txtDesignation, txtMarque, txtStock, txtPrix;
    private JComboBox<String> cboCouleur;
    private JCheckBox ck80, ck100;
    private ButtonGroup bgType, bgGrammage;
    private JRadioButton radioRamette, radioStylo;
    private JButton btnPrevious, btnNew, btnSave, btnDelete, btnNext;
    private JOptionPane jopErreur, jopValidation;

    private Integer idActif;


    public EcranArticle() throws HeadlessException {
        this.setTitle("Gestionnaire d'article");
        this.setSize(500, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initIHM();
    }

    private void initIHM(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(getPanelChamps(), BorderLayout.NORTH);
        mainPanel.add(getPanelBoutons(), BorderLayout.SOUTH);

        //Affecter le panel à l'écran
        this.setContentPane(mainPanel);
    }

    //// PANEL CHAMPS////

    public JPanel getPanelChamps(){
        panelChamps = new JPanel();
        panelChamps.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Ajouter les compsants au panel champs
        //référence
        gbc.gridy = 0;
        gbc.gridx = 0;
        panelChamps.add(getLblRef(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getTxtRef(), gbc);

        //Désignation
        gbc.gridy = 1;
        gbc.gridx = 0;
        panelChamps.add(getLblDesignation(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getTxtDeisgnation(), gbc);

        //Marque
        gbc.gridy = 2;
        gbc.gridx = 0;
        panelChamps.add(getLblMarque(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getTxtMarque(), gbc);

        //Stock
        gbc.gridy = 3;
        gbc.gridx = 0;
        panelChamps.add(getLblStock(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getTxtStock(), gbc);

        //Prix
        gbc.gridy = 4;
        gbc.gridx = 0;
        panelChamps.add(getLblPrix(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getTxtPrix(), gbc);

        //Type
        gbc.gridy = 5;
        gbc.gridx = 0;
        panelChamps.add(getLblType(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getPanelType(), gbc);

        //Grammage
        gbc.gridy = 6;
        gbc.gridx = 0;
        panelChamps.add(getLblGrammage(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getPanelGrammage(), gbc);

        //Couleur
        gbc.gridy = 7;
        gbc.gridx = 0;
        panelChamps.add(getLblCouleur(), gbc);

        gbc.gridx = 1;
        panelChamps.add(getCboCouleur(), gbc);

        return panelChamps;
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
        if (txtDesignation == null){
            txtDesignation = new JTextField(30);
        }
        return txtDesignation;
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

    private JComboBox<String> getCboCouleur() {
        if (cboCouleur==null){
            String[] couleurs = {"bleu", "indigo","jaune", "noir", "orange", "rouge", "vert", "violet"};
            cboCouleur = new JComboBox<String>(couleurs);
            cboCouleur.setSelectedIndex(3);
        }
        return cboCouleur;
    }

    //// PANEL GRAMMAGE////

    public JPanel getPanelGrammage() {
        if (panelGrammage==null){
            panelGrammage = new JPanel();
            panelGrammage.setLayout(new BoxLayout(panelGrammage, BoxLayout.Y_AXIS));
            bgGrammage = new ButtonGroup();
            bgGrammage.add(getCk80());
            bgGrammage.add(getCk100());
            panelGrammage.add(getCk80());
            panelGrammage.add(getCk100());
        }
        return panelGrammage;
    }
    public JCheckBox getCk80() {
        if (ck80==null){
            ck80 = new JCheckBox("80 grammes");
        }
        return ck80;
    }

    public JCheckBox getCk100() {
        if (ck100==null){
            ck100 = new JCheckBox("100 grammes");
        }
        return ck100;
    }


    //// PANEL TYPE////

    public JPanel getPanelType() {
        panelType = new JPanel();
        panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
        bgType = new ButtonGroup();
        bgType.add((getRadioRamette()));
        bgType.add(getRadioStylo());
        panelType.add(getRadioRamette());
        panelType.add(getRadioStylo());
        return panelType;
    }

    public JRadioButton getRadioRamette() {
        if (radioRamette==null){
            radioRamette = new JRadioButton("Ramette");

            //TODO état initial
            radioRamette.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ck80.setEnabled(true);
                    ck100.setEnabled(true);
                }
            });

            radioRamette.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange()==ItemEvent.SELECTED){
                        ck80.setEnabled(true);
                        ck100.setEnabled(true);
                        cboCouleur.setEnabled(false);
                        lblCouleur.setForeground(Color.GRAY);
                        lblGrammage.setForeground(Color.BLACK);
                    }
                }
            });
        }
        return radioRamette;
    }

    public JRadioButton getRadioStylo() {
        if (radioStylo==null){
            radioStylo = new JRadioButton("Stylo");
            radioStylo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            radioStylo.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    lblGrammage.setForeground(Color.GRAY);
                    lblCouleur.setForeground(Color.BLACK);
                    cboCouleur.setEnabled(true);
                    bgGrammage.clearSelection();
                    ck80.setEnabled(false);
                    ck100.setEnabled(false);

                }
            });
        }
        return radioStylo;
    }

    ////// PANEL BOUTONS //////
    public JPanel getPanelBoutons() {
            if (panelBoutons == null){
                panelBoutons = new JPanel();
                panelBoutons.setLayout(new FlowLayout());
                panelBoutons.add(getBtnPrevious());
                panelBoutons.add(getBtnNew());
                panelBoutons.add(getBtnSave());
                panelBoutons.add(getBtnDelete());
                panelBoutons.add(getBtnNext());
            }
        return panelBoutons;
    }

    public JButton getBtnPrevious() {
        if (btnPrevious==null){
            btnPrevious = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Back24.gif"));
            btnPrevious.setIcon(icon);

            btnPrevious.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("click on previous");
                    GestionArticle.getInstance().previous();
                    //désactive sélection du type
                    panelType.setEnabled(false);
                    radioRamette.setEnabled(false);
                    radioStylo.setEnabled(false);
                    panelType.setForeground(Color.GRAY);
                    lblType.setForeground(Color.GRAY);
                }
            });
        }
        return btnPrevious;
    }

    public JButton getBtnNext() {
        if (btnNext==null){
            btnNext = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Forward24.gif"));
            btnNext.setIcon(icon);

            btnNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("click on next");
                    GestionArticle.getInstance().next();
                    //désactive sélection du type
                    panelType.setEnabled(false);
                    panelType.setForeground(Color.GRAY);
                    lblType.setForeground(Color.GRAY);
                }
            });
        }
        return btnNext;
    }

    public JButton getBtnNew() {
        if (btnNew==null){
            btnNew = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/New24.gif"));
            btnNew.setIcon(icon);

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionArticle.getInstance().newArt();
                panelType.setEnabled(true);
                panelType.setForeground(Color.BLACK);
            }
        });
        }
        return btnNew;
    }

    public JButton getBtnSave() {
        if (btnSave==null){
            btnSave = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Save24.gif"));
            btnSave.setIcon(icon);

            btnSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("click on save");
                    if (getTxtStock().getText().equals("")){
                        popupErreur("Entrez un stock, svp !");
                    }
                    if (getTxtPrix().getText().equals("")) {
                        popupErreur("Entrez un prix, svp !");
                    }
                    GestionArticle.getInstance().save();
                }
            });
        }
        return btnSave;
    }

    public JButton getBtnDelete() {
        if (btnDelete==null){
            btnDelete = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Delete24.gif"));
            btnDelete.setIcon(icon);

            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("click on delete");
                    GestionArticle.getInstance().delete();
                }
            });
        }
        return btnDelete;
    }

    public Article getArticle(){
        Article article = null;
        if (getRadioRamette().isSelected()){
            article = new Ramette();
            ((Ramette)article).setGrammage(getCk80().isSelected()?80:100);

        } else if (getRadioStylo().isSelected()){
            article = new Stylo();
            ((Stylo) article).setCouleur((String) getCboCouleur().getSelectedItem());
        }
        article.setIdArticle(idActif);
        article.setReference( getTxtRef().getText());
        article.setMarque(getTxtMarque().getText());
        article.setDesignation( getTxtDeisgnation().getText());
        article.setPrixUnitaire(Float.parseFloat(getTxtPrix().getText()));
        article.setQteStock(Integer.parseInt(getTxtStock().getText().trim()));
        return article;
    }

//////// AFFICHAGE ////////

    public void afficherNouveau(){
        Ramette art = new Ramette(null, "reference", "marque",
                "désignation", 1, 1, 80);
        afficherArticle(art);
        //FIXME améliorer la sélection par défaut
        radioRamette.setSelected(true);
    }

    public void afficherArticle(Article art){

        idActif = art.getIdArticle();
        System.out.println(idActif);
        getTxtRef().setText(art.getReference());
        getTxtDeisgnation().setText(art.getDesignation());
        getTxtMarque().setText(art.getMarque());
        getTxtStock().setText(String.valueOf(art.getQteStock()));
        getTxtPrix().setText(String.valueOf(art.getPrixUnitaire()));
        if (art instanceof Ramette){
            radioRamette.setSelected(true);
            if (((Ramette) art).getGrammage() == 80){
                ck80.setSelected(true);
            } else if(((Ramette) art).getGrammage() == 100)
                ck100.setSelected(true);
        }
        if (art instanceof Stylo){
            radioStylo.setSelected(true);
            //sélectionne la couleur
            getCboCouleur().setSelectedItem(((Stylo) art).getCouleur());
        }
    }

    public void popupErreur(String message){
        jopErreur = new JOptionPane();
        jopErreur.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void popupValidation(String message){
        jopValidation = new JOptionPane();
        jopValidation.showMessageDialog(this, message, "Validation", JOptionPane.INFORMATION_MESSAGE);

    }
}