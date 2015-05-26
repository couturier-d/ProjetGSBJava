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

public class MenuAppliRH extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnUtilisateurs;
	private JMenu mnStats;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmListeUtilisateur;
	private JMenuItem mntmAjoutUtilisateur;
	private JMenuItem mntmModifUtilisateur;
	private JMenuItem mntmStatsRegionMois;
	private JMenuItem mntmStatsMois;
	private JPanel contentPane;
	
	public static String prenomUtilisateur;
	public static String nomUtilisateur;
	public static char typeUtilisateur;
	public static Boolean estConnecte;
	
	List<Utilisateur> lesUtilisateurs;
	
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
		setBounds(100, 100, 1024, 512);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		mntmAjoutUtilisateur = new JMenuItem("Ajouter un utilisateur");
		mntmAjoutUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageAjoutUtilisateur();
			}
		});
		mnUtilisateurs.add(mntmAjoutUtilisateur);
		
		// Element Modifier Utilisateur
		mntmModifUtilisateur = new JMenuItem("Modifier un utilisateur");
		mntmModifUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageModifUtilisateur();
			}
		});
		mnUtilisateurs.add(mntmModifUtilisateur);
		
		this.getContentPane().setLayout(null);
		
		// Création menu Stats
		mnStats = new JMenu("Statistiques");
		
			// Element Stats par région et par mois
		mntmStatsRegionMois = new JMenuItem("Statistiques par région et par mois");
		mntmStatsRegionMois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageStatsRegionMois();
			}
		});
		mnStats.add(mntmStatsRegionMois);
		
			// Element Stats par mois
		mntmStatsMois = new JMenuItem("Statistiques par mois");
		mntmStatsMois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichageStatsMois();
			}
		});
		mnStats.add(mntmStatsMois);
		
		// Simulation utilisateur en attente de gestion de la connexion
		
		prenomUtilisateur = "Helene";
		nomUtilisateur = "Moal";
		typeUtilisateur = 'S';
		estConnecte = true;
		
		switch(typeUtilisateur) {
			case 'S':
				lesUtilisateurs = AccesData.getListeUtilisateur();
				menuBar.add(mnUtilisateurs);
				affichageListeUtilisateurs();
				break;
			case 'D':
				lesUtilisateurs = AccesData.getListeUtilisateur();
				affichageListeUtilisateurs();
				break;
			case 'R':
				affichageStatsRegionMois();
				break;
		}
	}
	
	// Panels pour secrétaire
	
	private void affichageListeUtilisateurs() {
		lesUtilisateurs = AccesData.getListeUtilisateur();
		this.setContentPane(new PanelListeUtilisateurs(lesUtilisateurs));
		this.revalidate();
	}
	
	private void affichageAjoutUtilisateur() {
		this.setContentPane(new PanelAjoutUtilisateur());
		this.revalidate();
	}
	
	private void affichageModifUtilisateur() {
		this.setContentPane(new PanelModifUtilisateur());
		this.revalidate();
	}
	
	
	// Panels pour Responsable suivi
	
	private void affichageStatsRegionMois() {
		this.setContentPane(new PanelStatsRegionMois());
		this.revalidate();
	}
	
	private void affichageStatsMois() {
		this.setContentPane(new PanelStatsMois());
		this.revalidate();
	}

}
