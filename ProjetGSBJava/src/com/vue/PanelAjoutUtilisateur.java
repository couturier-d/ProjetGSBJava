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
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;

public class PanelAjoutUtilisateur extends JPanel {
	private JTextField txtPrenom;
	private JTextField txtNumFixe;
	private JTextField txtNom;
	private JTextField txtDateEmbauche;
	private JTextField txtAdresse;
	private JTextField txtNumPortable;
	private JTextField txtCodePostal;
	private JTextField txtVille;
	private JComboBox<String> cbxTypeUtilisateur;
	private JComboBox<String> cbxRegion;
	private JPanel sousPanel_entete;
	
	private List<Utilisateur> listeUtilisateur;
	private List<TypeUtilisateur> listeTypeUtilisateur;
	private List<Region> listeRegion;
	
	public PanelAjoutUtilisateur() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(768, 256));
		
		sousPanel_entete = new JPanel();
		add(sousPanel_entete, BorderLayout.NORTH);
		sousPanel_entete.add(new PanelEnteteAppli());
		
		listeUtilisateur = AccesData.getListeUtilisateur();
		listeTypeUtilisateur = AccesData.getListeTypeUtilisateur();
		listeRegion = AccesData.getListeRegion();
		
		JPanel sousPanel_contenu = new JPanel();
		add(sousPanel_contenu, BorderLayout.CENTER);
		sousPanel_contenu.setLayout(new BorderLayout(0, 0));
		
		JPanel sousPanel_titre_contenu = new JPanel();
		sousPanel_contenu.add(sousPanel_titre_contenu, BorderLayout.NORTH);
		
		JLabel lblFicheDuNouvel = new JLabel("Fiche du nouvel utilisateur :");
		sousPanel_titre_contenu.add(lblFicheDuNouvel);
		
		JPanel sousPanel_formulaire_ajout = new JPanel();
		sousPanel_contenu.add(sousPanel_formulaire_ajout, BorderLayout.CENTER);
		sousPanel_formulaire_ajout.setBorder(new LineBorder(new Color(0, 0, 0)));
		sousPanel_formulaire_ajout.setLayout(new GridLayout(5, 2, 0, 0));
		
		JPanel sousPanelTypeUtilisateur = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelTypeUtilisateur);
		sousPanelTypeUtilisateur.setLayout(null);
		
		JLabel lblTypeUtilisateur = new JLabel("Type utilisateur");
		lblTypeUtilisateur.setBounds(10, 15, 100, 14);
		sousPanelTypeUtilisateur.add(lblTypeUtilisateur);
		
		cbxTypeUtilisateur = new JComboBox<String>();
		cbxTypeUtilisateur.setBounds(150, 15, 150, 20);
		sousPanelTypeUtilisateur.add(cbxTypeUtilisateur);
		for(TypeUtilisateur t : listeTypeUtilisateur) {
			cbxTypeUtilisateur.addItem(t.getLibelleType());
		}
		cbxTypeUtilisateur.setSelectedIndex(-1);
		
		JPanel sousPanelRegion = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelRegion);
		sousPanelRegion.setLayout(null);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(10, 15, 100, 14);
		sousPanelRegion.add(lblRegion);
		
		cbxRegion = new JComboBox<String>();
		cbxRegion.setBounds(150, 15, 150, 20);
		sousPanelRegion.add(cbxRegion);
		for(Region r : listeRegion) {
			cbxRegion.addItem(r.getNomRegion());
		}
		cbxRegion.setSelectedIndex(-1);
		
		JPanel sousPanelNom = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelNom);
		sousPanelNom.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 15, 100, 14);
		sousPanelNom.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(150, 15, 100, 20);
		sousPanelNom.add(txtNom);
		txtNom.setColumns(10);
		
		JPanel sousPanelPrenom = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelPrenom);
		sousPanelPrenom.setLayout(null);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(10, 15, 100, 14);
		sousPanelPrenom.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(150, 15, 100, 20);
		sousPanelPrenom.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JPanel sousPanelAdresse = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelAdresse);
		sousPanelAdresse.setLayout(null);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 15, 100, 14);
		sousPanelAdresse.add(lblAdresse);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(150, 15, 100, 20);
		sousPanelAdresse.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JPanel sousPanelVille = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelVille);
		sousPanelVille.setLayout(null);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(10, 15, 100, 14);
		sousPanelVille.add(lblVille);
		
		txtVille = new JTextField();
		txtVille.setBounds(150, 15, 100, 20);
		sousPanelVille.add(txtVille);
		txtVille.setColumns(10);
		
		JPanel sousPanelDateEmbauche = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelDateEmbauche);
		sousPanelDateEmbauche.setLayout(null);
		
		JLabel lblDateEmbauche = new JLabel("Date d'embauche *");
		lblDateEmbauche.setBounds(10, 15, 120, 14);
		sousPanelDateEmbauche.add(lblDateEmbauche);
		
		txtDateEmbauche = new JTextField();
		txtDateEmbauche.setBounds(150, 15, 100, 20);
		sousPanelDateEmbauche.add(txtDateEmbauche);
		txtDateEmbauche.setColumns(10);
		
		JPanel sousPanelCodePostal = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelCodePostal);
		sousPanelCodePostal.setLayout(null);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(10, 15, 100, 14);
		sousPanelCodePostal.add(lblCodePostal);
		
		txtCodePostal = new JTextField();
		txtCodePostal.setBounds(150, 15, 100, 20);
		sousPanelCodePostal.add(txtCodePostal);
		txtCodePostal.setColumns(10);
		
		JPanel sousPanelNumFixe = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelNumFixe);
		sousPanelNumFixe.setLayout(null);
		
		JLabel lblNumFixe = new JLabel("N\u00B0 Fixe *");
		lblNumFixe.setBounds(10, 15, 100, 14);
		sousPanelNumFixe.add(lblNumFixe);
		
		txtNumFixe = new JTextField();
		txtNumFixe.setBounds(150, 15, 100, 20);
		sousPanelNumFixe.add(txtNumFixe);
		txtNumFixe.setColumns(10);
		
		JPanel sousPanelNumPortable = new JPanel();
		sousPanel_formulaire_ajout.add(sousPanelNumPortable);
		sousPanelNumPortable.setLayout(null);
		
		JLabel lblNumPortable = new JLabel("N\u00B0 Portable *");
		lblNumPortable.setBounds(10, 15, 100, 14);
		sousPanelNumPortable.add(lblNumPortable);
		
		txtNumPortable = new JTextField();
		txtNumPortable.setBounds(150, 15, 100, 20);
		sousPanelNumPortable.add(txtNumPortable);
		txtNumPortable.setColumns(10);
		
		JPanel sousPanel_boutons_formulaire = new JPanel();
		sousPanel_contenu.add(sousPanel_boutons_formulaire, BorderLayout.SOUTH);
		sousPanel_boutons_formulaire.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valider();
			}
		});
		sousPanel_boutons_formulaire.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSansEspaces = new JLabel("* Sans espaces.        ** Au format aaaa-mm-jj        ");
		sousPanel_boutons_formulaire.add(lblSansEspaces);
		sousPanel_boutons_formulaire.add(btnValider);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reinitialiserFormulaire();
			}
		});
		sousPanel_boutons_formulaire.add(btnEffacer);
	}
	
	public Boolean verifierChaine(String laChaine) {
		Boolean resultat = false;
		if ((laChaine != "") && (laChaine != null)) {
			resultat = true;
		} else {
			System.out.println("Erreur valeure obligatoire !");
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
				System.out.println(e.getMessage());
			}
		} else System.out.println("Numero inccorect --> " + leNumero.length());
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
				System.out.println(e.getMessage());
			}
		}
		return resultat;
	}
	
	public Boolean verifierDate(String laDate) {
		Boolean resultat = false;
		if(laDate.length() == 10) {
			try {
				Date dateEmbauche = ConvertDate.toDate(laDate);
				resultat = true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Erreur : date inccorecte !");
		}
		
		return resultat;
	}
	
	public static String suppressionAccents(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
	}
	
	public void valider() {
		Character leTypeUtilisateur = listeTypeUtilisateur.get(cbxTypeUtilisateur.getSelectedIndex()).getIdType();
		String nom = suppressionAccents(this.txtNom.getText()).replace(" ", "-");
		String prenom = suppressionAccents(this.txtPrenom.getText()).replace(" ", "-");
		String stringDateEmbauche = this.txtDateEmbauche.getText();
		Region region = listeRegion.get(cbxRegion.getSelectedIndex());
		String adresse = this.txtAdresse.getText();
		String ville = this.txtVille.getText();
		String codePostal = this.txtCodePostal.getText();
		String numPortable = this.txtNumPortable.getText();
		String numFixe = this.txtNumFixe.getText();
		
		if ((verifierChaine(this.txtNom.getText())) && (verifierChaine(this.txtPrenom.getText())) 
				&& (verifierDate(this.txtDateEmbauche.getText()))) {
			try {
				Date dateEmbauche = ConvertDate.toDate(stringDateEmbauche);
				// Génération auto de l'id, du login, du mdp et de l'adresse mail
				String identifiant = GenerationDonneesUtilisateur.genererIdentifiant();
				String email = GenerationDonneesUtilisateur.genererAdresseMail(nom, prenom);
				String login = GenerationDonneesUtilisateur.genererLogin(nom, prenom);
				String mdp = GenerationDonneesUtilisateur.genererMDP(nom, stringDateEmbauche);
				
				if (!verifierNumeroTel(numPortable)) numPortable = "";
				if (!verifierNumeroTel(numFixe)) numFixe = "";
				
				if ((leTypeUtilisateur != null) && (region != null) && (verifierChaine(adresse)) 
						&& (verifierChaine(ville)) && (verifierChaine(codePostal))) {
					// Création de l'objet utilisateur
					Utilisateur nouvelUtilisateur = new Utilisateur(identifiant, leTypeUtilisateur, nom, prenom, dateEmbauche,
							region, login, mdp, numPortable, numFixe, email, adresse, codePostal, ville);
					// Ajout en base de données
					if (!AccesData.addUtilisateur(nouvelUtilisateur)) {
						System.out.println("Echec de l'ajout !");
					}
					System.out.println(nouvelUtilisateur.toString());
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		
	}
	
	public void reinitialiserFormulaire() {
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