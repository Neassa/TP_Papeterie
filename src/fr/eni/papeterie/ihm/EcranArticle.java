package fr.eni.papeterie.ihm;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcranArticle extends JFrame {
    //attributs
    private JPanel panelGrammage, panelType, panelChamps, panelBoutons;
    private JLabel lblRef, lblDesignation, lblMarque, lblStock, lblPrix, lblType, lblGrammage, lblCouleur;
    private JTextField txtRef, txtDeisgnation, txtMarque, txtStock, txtPrix;
    private JComboBox<String> cboCouleur;
    private JCheckBox ck80, ck100;
    private ButtonGroup bgType;
    private JRadioButton radioRamette, radioStylo;
    private JButton btnPrevious, btnNew, btnSave, btnDelete, btnNext;




    public EcranArticle() throws HeadlessException {
        this.setTitle("Article");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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
            radioRamette.setSelected(true);
            //TODO état initial
            radioRamette.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ck80.setEnabled(true);
                    ck100.setEnabled(true);
                    cboCouleur.setEnabled(false);
                    lblCouleur.setForeground(Color.GRAY);
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
                    lblGrammage.setForeground(Color.GRAY);
                    cboCouleur.setEnabled(true);
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
        }
        return btnPrevious;
    }

    public JButton getBtnNew() {
        if (btnNew==null){
            btnNew = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/New24.gif"));
            btnNew.setIcon(icon);
        }
        return btnNew;
    }

    public JButton getBtnSave() {
        if (btnSave==null){
            btnSave = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Save24.gif"));
            btnSave.setIcon(icon);
        }
        return btnSave;
    }

    public JButton getBtnDelete() {
        if (btnDelete==null){
            btnDelete = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Delete24.gif"));
            btnDelete.setIcon(icon);
        }
        return btnDelete;
    }

    public JButton getBtnNext() {
        if (btnNext==null){
            btnNext = new JButton();
            ImageIcon icon = new ImageIcon(getClass().getResource("ressources/Forward24.gif"));
            btnNext.setIcon(icon);
        }
        return btnNext;
    }
}