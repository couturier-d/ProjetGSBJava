package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.border.LineBorder;

import com.metier.Region;
import com.metier.TypeUtilisateur;
import com.metier.Utilisateur;
import com.persistance.AccesData;
import com.util.ConvertDate;
import com.util.GenerationDonneesUtilisateur;

import java.awt.Color;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelModifUtilisateur extends JPanel {
	private JTextField txtPrenom;
	private JTextField txtNumFixe;
	private JTextField txtNom;
	private JTextField txtDateEmbauche;
	private JTextField txtAdresse;
	private JTextField txtNumPortable;
	private JTextField txtCodePostal;
	private JTextField txtVille;
	private JComboBox<String> cbxUtilisateur;
	private JComboBox<String> cbxTypeUtilisateur;
	private JComboBox<String> cbxRegion;
	
	private List<Utilisateur> listeUtilisateur;
	private List<TypeUtilisateur> listeTypeUtilisateur;
	private List<Region> listeRegion;
	private JTextField txtIdUtilisateur;
	private JTextField txtLogin;
	
	Utilisateur unUtilisateur;
	
	public PanelModifUtilisateur() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(768, 512));
		
		JPanel panel_entete = new JPanel();
		add(panel_entete, BorderLayout.NORTH);
		panel_entete.add(new PanelEnteteAppli());
		
		listeUtilisateur = AccesData.getListeUtilisateur();
		listeTypeUtilisateur = AccesData.getListeTypeUtilisateur();
		listeRegion = AccesData.getListeRegion();
		
		JPanel panel_contenu = new JPanel();
		add(panel_contenu, BorderLayout.CENTER);
		panel_contenu.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_titre_contenu = new JPanel();
		panel_contenu.add(panel_titre_contenu, BorderLayout.NORTH);
		
		JLabel lblUtilisateur = new JLabel("Edition de l'utilisateur :");
		panel_titre_contenu.add(lblUtilisateur);
		
		cbxUtilisateur = new JComboBox<String>();
		cbxUtilisateur.setEditable(true);
		panel_titre_contenu.add(cbxUtilisateur);
		for(Utilisateur u : listeUtilisateur) {
			cbxUtilisateur.addItem(u.getNom() + " " + u.getPrenom());
		}
		cbxUtilisateur.setSelectedIndex(-1);
		
		JPanel panel_formulaire_edit = new JPanel();
		panel_contenu.add(panel_formulaire_edit, BorderLayout.CENTER);
		panel_formulaire_edit.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_formulaire_edit.setLayout(new GridLayout(7, 2, 0, 0));
		
		JPanel panelTypeUtilisateur = new JPanel();
		panel_formulaire_edit.add(panelTypeUtilisateur);
		panelTypeUtilisateur.setLayout(null);
		
		JLabel lblTypeUtilisateur = new JLabel("Type utilisateur");
		lblTypeUtilisateur.setBounds(10, 15, 100, 14);
		panelTypeUtilisateur.add(lblTypeUtilisateur);
		
		cbxTypeUtilisateur = new JComboBox<String>();
		cbxTypeUtilisateur.setEnabled(false);
		cbxTypeUtilisateur.setBounds(150, 15, 150, 20);
		panelTypeUtilisateur.add(cbxTypeUtilisateur);
		for(TypeUtilisateur t : listeTypeUtilisateur) {
			cbxTypeUtilisateur.addItem(t.getLibelleType());
		}
		cbxTypeUtilisateur.setSelectedIndex(-1);
		
		JPanel panelRegion = new JPanel();
		panel_formulaire_edit.add(panelRegion);
		panelRegion.setLayout(null);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(10, 15, 100, 14);
		panelRegion.add(lblRegion);
		
		cbxRegion = new JComboBox<String>();
		cbxRegion.setEditable(true);
		cbxRegion.setBounds(150, 15, 150, 20);
		panelRegion.add(cbxRegion);
		for(Region r : listeRegion) {
			cbxRegion.addItem(r.getNomRegion());
		}
		cbxRegion.setSelectedIndex(-1);
		
		JPanel panelNom = new JPanel();
		panel_formulaire_edit.add(panelNom);
		panelNom.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 15, 100, 14);
		panelNom.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(150, 15, 100, 20);
		panelNom.add(txtNom);
		txtNom.setColumns(10);
		
		JPanel panelPrenom = new JPanel();
		panel_formulaire_edit.add(panelPrenom);
		panelPrenom.setLayout(null);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(10, 15, 100, 14);
		panelPrenom.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setEditable(false);
		txtPrenom.setBounds(150, 15, 100, 20);
		panelPrenom.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JPanel panelIdUtilisateur = new JPanel();
		panel_formulaire_edit.add(panelIdUtilisateur);
		panelIdUtilisateur.setLayout(null);
		
		JLabel lblIdUtilisateur = new JLabel("ID Utilisateur");
		lblIdUtilisateur.setBounds(10, 15, 100, 14);
		panelIdUtilisateur.add(lblIdUtilisateur);
		
		txtIdUtilisateur = new JTextField();
		txtIdUtilisateur.setEditable(false);
		txtIdUtilisateur.setBounds(150, 15, 100, 20);
		panelIdUtilisateur.add(txtIdUtilisateur);
		txtIdUtilisateur.setColumns(10);
		
		JPanel panel = new JPanel();
		panel_formulaire_edit.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 15, 100, 14);
		panel.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setBounds(150, 15, 100, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JPanel panelAdresse = new JPanel();
		panel_formulaire_edit.add(panelAdresse);
		panelAdresse.setLayout(null);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 15, 100, 14);
		panelAdresse.add(lblAdresse);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(150, 15, 100, 20);
		panelAdresse.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JPanel panelVille = new JPanel();
		panel_formulaire_edit.add(panelVille);
		panelVille.setLayout(null);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(10, 15, 100, 14);
		panelVille.add(lblVille);
		
		txtVille = new JTextField();
		txtVille.setBounds(150, 15, 100, 20);
		panelVille.add(txtVille);
		txtVille.setColumns(10);
		
		JPanel panelCodePostal = new JPanel();
		panel_formulaire_edit.add(panelCodePostal);
		panelCodePostal.setLayout(null);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(10, 15, 100, 14);
		panelCodePostal.add(lblCodePostal);
		
		txtCodePostal = new JTextField();
		txtCodePostal.setBounds(150, 15, 100, 20);
		panelCodePostal.add(txtCodePostal);
		txtCodePostal.setColumns(10);
		
		JPanel panelDateEmbauche = new JPanel();
		panel_formulaire_edit.add(panelDateEmbauche);
		panelDateEmbauche.setLayout(null);
		
		JLabel lblDateEmbauche = new JLabel("Date d'embauche");
		lblDateEmbauche.setBounds(10, 15, 100, 14);
		panelDateEmbauche.add(lblDateEmbauche);
		
		txtDateEmbauche = new JTextField();
		txtDateEmbauche.setEditable(false);
		txtDateEmbauche.setBounds(150, 15, 100, 20);
		panelDateEmbauche.add(txtDateEmbauche);
		txtDateEmbauche.setColumns(10);
		
		JPanel panelNumFixe = new JPanel();
		panel_formulaire_edit.add(panelNumFixe);
		panelNumFixe.setLayout(null);
		
		JLabel lblNumFixe = new JLabel("N\u00B0 Fixe");
		lblNumFixe.setBounds(10, 15, 100, 14);
		panelNumFixe.add(lblNumFixe);
		
		txtNumFixe = new JTextField();
		txtNumFixe.setBounds(150, 15, 100, 20);
		panelNumFixe.add(txtNumFixe);
		txtNumFixe.setColumns(10);
		
		JPanel panelNumPortable = new JPanel();
		panel_formulaire_edit.add(panelNumPortable);
		panelNumPortable.setLayout(null);
		
		JLabel lblNumPortable = new JLabel("N\u00B0 Portable");
		lblNumPortable.setBounds(10, 15, 100, 14);
		panelNumPortable.add(lblNumPortable);
		
		txtNumPortable = new JTextField();
		txtNumPortable.setBounds(150, 15, 100, 20);
		panelNumPortable.add(txtNumPortable);
		txtNumPortable.setColumns(10);
		
		JPanel panel_boutons_formulaire = new JPanel();
		panel_contenu.add(panel_boutons_formulaire, BorderLayout.SOUTH);
		panel_boutons_formulaire.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valider();
			}
		});
		
		JLabel lblNewLabel = new JLabel("* Sans espaces.        ** Au format aaaa-mm-jj        ");
		panel_boutons_formulaire.add(lblNewLabel);
		panel_boutons_formulaire.add(btnValider);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reinitialiserFormulaire();
			}
		});
		panel_boutons_formulaire.add(btnEffacer);
		
		cbxUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unUtilisateur = listeUtilisateur.get(cbxUtilisateur.getSelectedIndex());
				
				System.out.println("Sélection d'un utilisateur !");
				System.out.println(unUtilisateur.toString());
				
				actualiserChamps(unUtilisateur);
				
			}
		});
	}
	
	public void actualiserChamps(Utilisateur unUtilisateur) {
		cbxTypeUtilisateur.setSelectedIndex(1);
		
		int indexType = 0;
		Boolean typeTrouve = false;
		while ((typeTrouve == false) && (indexType < listeTypeUtilisateur.size())) {
			if (listeTypeUtilisateur.get(indexType).getIdType().equals(unUtilisateur.getIdTypeUtilisateur())) {
				cbxTypeUtilisateur.setSelectedIndex(indexType);
				typeTrouve = true;
			}
			indexType++;
		}
		
		int indexRegion = 0;
		Boolean Regiontrouve = false;
		while ((Regiontrouve == false) && (indexRegion < listeRegion.size())) {
			if (listeRegion.get(indexRegion).getIdRegion().toString() == unUtilisateur.getRegion().getIdRegion().toString()) {
				cbxRegion.setSelectedIndex(indexRegion);
				Regiontrouve = true;
			}
			indexRegion++;
		}
		
	    txtPrenom.setText(unUtilisateur.getPrenom());
		txtNom.setText(unUtilisateur.getNom());
		txtIdUtilisateur.setText(unUtilisateur.getIdUtilisateur());
		txtLogin.setText(unUtilisateur.getLogin());
		txtAdresse.setText(unUtilisateur.getAdresse());
		txtVille.setText(unUtilisateur.getVille());
		txtCodePostal.setText(unUtilisateur.getCodePostal());
		SimpleDateFormat format = new SimpleDateFormat("dd / MM / yyyy");
		txtDateEmbauche.setText(format.format(unUtilisateur.getDateEmbauche()).toString());
		txtNumFixe.setText(unUtilisateur.getNumeroFixe());
		txtNumPortable.setText(unUtilisateur.getNumeroPortable());
	}
	
	public Boolean verifierChaine(String laChaine) {
		Boolean resultat = false;
		if ((!laChaine.equals("")) && (laChaine != null)) {
			resultat = true;
		}
		return resultat;
	}
	
	public Boolean verifierNumeroTel(String leNumero) {
		Boolean resultat = false;
		if (leNumero.length() == 10) {
			try {
				Integer.decode(leNumero);
				resultat = true;
			}
			catch(NumberFormatException e) {
				resultat = false;
			}
		}
		return resultat;
	}
	
	public Boolean verifierCodePostal() {
		Boolean resultat = false;
		if (this.txtCodePostal.getText().length() == 5) 
		{
			try {
				Integer.decode(this.txtCodePostal.getText());
				resultat = true;
			}
			catch(NumberFormatException e) {
				resultat = false;
			}
		}
		return resultat;
	}
	
	public Boolean verifierDate(String laDate) {
		Boolean resultat = false;
		try {
			Date date = ConvertDate.toDate(laDate);
			resultat = true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public static String suppressionAccents(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
	}
	
	public void valider() {
		//Récupréation de svaleures du formulaire
		Region region = listeRegion.get(cbxRegion.getSelectedIndex());
		String adresse = this.txtAdresse.getText();
		String ville = this.txtVille.getText();
		String codePostal = this.txtCodePostal.getText();
		String numPortable = this.txtNumPortable.getText();
		String numFixe = this.txtNumFixe.getText();
		
		
		//Vérification des valeures
		if (region != null) unUtilisateur.setRegion(region);
		if (verifierChaine(adresse)) unUtilisateur.setAdresse(adresse);
		if (verifierChaine(ville)) {unUtilisateur.setVille(ville);}
		if (verifierChaine(codePostal)) unUtilisateur.setCodePostal(codePostal);
		if (verifierNumeroTel(numPortable)) unUtilisateur.setNumeroPortable(numPortable);
		if (verifierNumeroTel(numPortable)) unUtilisateur.setNumeroFixe(numFixe);
		
		if (AccesData.updateUtilisateur(unUtilisateur)) {
			
		}
		System.out.println(unUtilisateur.toString());
	}
	
	public void reinitialiserFormulaire() {
		cbxUtilisateur.setSelectedIndex(-1);
		cbxTypeUtilisateur.setSelectedIndex(-1);
		cbxRegion.setSelectedIndex(-1);
		txtNom.setText(null);
		txtPrenom.setText(null);
		txtDateEmbauche.setText(null);
		txtAdresse.setText(null);
		txtVille.setText(null);
		txtCodePostal.setText(null);
		txtNumFixe.setText(null);
		txtNumPortable.setText(null);
	}
}