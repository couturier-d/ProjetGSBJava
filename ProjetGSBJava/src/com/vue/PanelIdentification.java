package com.vue;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

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
	private JOptionPane alert = new JOptionPane();
	
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
			// Recherche utilisateur correspondant au login
			if (listeUtilisateur.get(index).getLogin().equals(login)) {
				// Vérification du bon type d'utilisateur
				if ((listeUtilisateur.get(index).getIdTypeUtilisateur().toString().equals("S")) || (listeUtilisateur.get(index).getIdTypeUtilisateur().toString().equals("D")) 
						|| (listeUtilisateur.get(index).getIdTypeUtilisateur().toString().equals("R"))) {
					// Vérification du mot de passe
					if (listeUtilisateur.get(index).getMotDePasse().equals(mdp)) {
						System.out.println("Identifiants valides.");
						trouve = true;
						MenuAppliRH.estConnecte = true;
						MenuAppliRH.utilisateurConnecte = listeUtilisateur.get(index);
						redirection();
					} else {
						JOptionPane.showMessageDialog(this, "Mot de passe incorrect !", "Accès refusé", JOptionPane.ERROR_MESSAGE);
						System.out.println("Mot de passe incorrecte !");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Vous n'êtes pas autorisé à utiliser cette application !", "Accès refusé", JOptionPane.ERROR_MESSAGE);
					System.out.println("Accès refusé. Vous n'êtes aps autorisé à utiliser cette application !");
				}
			}
			index++;
		}
		if (trouve == false) {
			JOptionPane.showMessageDialog(this, "Cet utilisateur n'existe pas !", "Accès refusé", JOptionPane.ERROR_MESSAGE);
			System.out.println("Cet utilisateur n'existe pas !");
		}
	}
	public void redirection() {
		Window window = SwingUtilities.windowForComponent(this);
		if (window instanceof JFrame) {
			JFrame frame = (JFrame) window;
	 
			((MenuAppliRH) frame).redirection();
		}
	}
}
