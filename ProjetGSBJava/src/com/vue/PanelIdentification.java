package com.vue;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JButton;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class PanelIdentification extends JPanel {
	private JPanel sousPanel_entete;
	private JPanel sousPanel_contenu;
	private JLabel lblTitre;
	private JLabel lblMdp;
	private JLabel lblLogin;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JPanel sousPanelLogin;
	private JPanel sousPanelMdp;
	private JButton btnValider;
	
	private List<Utilisateur> listeUtilisateur;
	
	public PanelIdentification() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(512, 384));
		listeUtilisateur = AccesData.getListeUtilisateur();
		
		this.sousPanel_entete = new JPanel();
		add(this.sousPanel_entete);
		sousPanel_entete.add(new PanelEnteteAppli());
		
		this.sousPanel_contenu = new JPanel();
		add(this.sousPanel_contenu);
		this.sousPanel_contenu.setLayout(null);
		
		this.lblTitre = new JLabel("Veuillez vous connecter :");
		this.lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblTitre.setBounds(122, 31, 233, 32);
		this.sousPanel_contenu.add(this.lblTitre);
		
		this.sousPanelLogin = new JPanel();
		this.sousPanelLogin.setBounds(100, 100, 300, 30);
		this.sousPanel_contenu.add(this.sousPanelLogin);
		
		this.lblLogin = new JLabel("Login :");
		this.sousPanelLogin.add(this.lblLogin);
		
		this.txtLogin = new JTextField();
		this.sousPanelLogin.add(this.txtLogin);
		this.txtLogin.setColumns(10);
		
		this.sousPanelMdp = new JPanel();
		this.sousPanelMdp.setBounds(100, 150, 300, 60);
		this.sousPanel_contenu.add(this.sousPanelMdp);
		
		this.lblMdp = new JLabel("Mot de passe :");
		this.sousPanelMdp.add(this.lblMdp);
		
		this.passwordField = new JPasswordField();
		this.passwordField.setColumns(15);
		this.sousPanelMdp.add(this.passwordField);
		
		this.btnValider = new JButton("Valider");
		this.btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valider();
			}
		});
		this.btnValider.setBounds(175, 250, 89, 23);
		this.sousPanel_contenu.add(this.btnValider);
	}
	
	public void valider() {
		Boolean trouve = false;
		int index = 0;
		
		String login = txtLogin.getText();
		String mdp = passwordField.getText();
		
		while((trouve == false) && (index < listeUtilisateur.size())) {
			if ((listeUtilisateur.get(index).getLogin().equals(login)) && (listeUtilisateur.get(index).getMotDePasse().equals(mdp))) {
				System.out.println("Identifiants valides !");
				trouve = true;
				MenuAppliRH.estConnecte = true;
				MenuAppliRH.utilisateurConnecte = listeUtilisateur.get(index);
			} else {
				System.out.println("Identifiants invalides !");
			}
			index++;
		}
	}
}
