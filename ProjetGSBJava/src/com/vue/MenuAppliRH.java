package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuBar;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuAppliRH extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnUtilisateurs;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmListeUtilisateur;
	private JMenuItem mntmAjoutUtilisateur;
	private JPanel contentPane;
	private JLabel lblLogoGsb;
	
	Image logoGsb;
	
	String prenomUtilisateur;
	String nomUtilisateur;
	char typeUtilisateur;
	Boolean estConnecte;
	
	List<Utilisateur> lesUtilisateurs;
	private JLabel lblWelcome;
	private JPanel sousPanel_contenuAppli;
	private JPanel panel;
	private JPanel sousPanel_entete;
	private JPanel sousPanel_contenu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAppliRH frame = new MenuAppliRH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuAppliRH() {
		setTitle("GSB | Gestion des ressources humaines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 660);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		// Création Menu fichier
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFichier.add(mntmQuitter);
		
		// Création menu Utilisateur
		mnUtilisateurs = new JMenu("Utilisateurs");
		
			// Element Liste Utilisateur
		mntmListeUtilisateur = new JMenuItem("Liste Utilisateurs");
		mntmListeUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageListeUtilisateurs();
			}
		});
		mnUtilisateurs.add(mntmListeUtilisateur);
		
			// Element Ajout Utilisateur
		mntmAjoutUtilisateur = new JMenuItem("Ajout Utilisateurs");
		mntmAjoutUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageAjoutUtilisateur();
			}
		});
		mnUtilisateurs.add(mntmAjoutUtilisateur);
		
		
		// Simulation utilisateur en attente de gestion de la connexion
		typeUtilisateur = 'S';
		prenomUtilisateur = "Pierre-Yves";
		nomUtilisateur = "Halleguen";
		estConnecte = true;
		
		sousPanel_contenuAppli = new JPanel();
		contentPane.add(sousPanel_contenuAppli, BorderLayout.CENTER);
		sousPanel_contenuAppli.setLayout(new BorderLayout(0, 0));
		logoGsb = new ImageIcon(this.getClass().getResource("/gsbIcon.png")).getImage();
		
		sousPanel_entete = new JPanel();
		sousPanel_contenuAppli.add(sousPanel_entete, BorderLayout.NORTH);
		sousPanel_entete.setLayout(new BorderLayout(0, 0));
		
		lblLogoGsb = new JLabel("");
		sousPanel_entete.add(lblLogoGsb, BorderLayout.NORTH);
		lblLogoGsb.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoGsb.setVerticalAlignment(SwingConstants.TOP);
		lblLogoGsb.setIcon(new ImageIcon(logoGsb));
		
		lblWelcome = new JLabel("Welcome, utilisateur");
		sousPanel_entete.add(lblWelcome, BorderLayout.CENTER);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		
		sousPanel_contenu = new JPanel();
		sousPanel_contenuAppli.add(sousPanel_contenu, BorderLayout.CENTER);
		
		if(estConnecte){
			lblWelcome.setText("Bienvenue, " + prenomUtilisateur + " " + nomUtilisateur);
		}
		
		switch(typeUtilisateur) {
			case 'S':
				lesUtilisateurs = AccesData.getListeUtilisateur();
				menuBar.add(mnUtilisateurs);
				break;
			case 'D':
				lesUtilisateurs = AccesData.getListeUtilisateur();
				// A compléter
				break;
			case 'R':
				// A compléter
				break;
		}
	}
	
	// Pannels pour secrétaire
	
	private void affichageListeUtilisateurs() {
		sousPanel_contenuAppli.remove(sousPanel_contenu);
		sousPanel_contenu = new JPanel();
		sousPanel_contenuAppli.add(sousPanel_contenu, BorderLayout.CENTER);
		sousPanel_contenu.add(new PanelListeUtilisateurs(lesUtilisateurs), BorderLayout.CENTER);
		this.revalidate();
	}
	
	private void affichageAjoutUtilisateur() {
		sousPanel_contenuAppli.remove(sousPanel_contenu);
		sousPanel_contenu = new JPanel();
		sousPanel_contenuAppli.add(sousPanel_contenu, BorderLayout.CENTER);
		sousPanel_contenu.add(new PanelAjoutUtilisateur(), BorderLayout.CENTER);
		this.revalidate();
	}
	
	/*private void affichageModifUtilisateur(Utilisateur unUtilisateur) {
//		this.setContentPane(new PanelModifUtilisateur(unUtilisateur));
		this.revalidate();
	}*/
	
	// Pannels pour Directeur RH
	
	// A compléter
	
	// Pannels pour Responsable suivi
	
	// A compléter

}
