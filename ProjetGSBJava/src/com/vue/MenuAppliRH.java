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
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class MenuAppliRH extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnUtilisateurs;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmListeUtilisateur;
	private JMenuItem mntmAjoutUtilisateur;
	private JPanel contentPane;
	private JPanel panel_header;
	private JPanel panel_content;
	private JLabel lblLogoGsb;
	
	Image logoGsb;
	
	String prenomUtilisateur;
	String nomUtilisateur;
	char typeUtilisateur;
	Boolean estConnecte;
	
	List<Utilisateur> lesUtilisateurs;
	private JLabel lblWelcome;
	private JPanel panel_welcome;
	private JPanel panel_logo;
	private JPanel panel_principal;
	

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
		setBounds(100, 100, 547, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		logoGsb = new ImageIcon(this.getClass().getResource("/gsbIcon.png")).getImage();
		
		panel_principal = new JPanel();
		contentPane.add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new BorderLayout(0, 0));
		
		// Panel d'entête
		panel_header = new JPanel();
		panel_principal.add(panel_header, BorderLayout.NORTH);
		panel_header.setLayout(new BorderLayout(0, 0));
		
		lblLogoGsb = new JLabel("");
		lblLogoGsb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_header.add(lblLogoGsb, BorderLayout.NORTH);
		lblLogoGsb.setVerticalAlignment(SwingConstants.TOP);
		lblLogoGsb.setIcon(new ImageIcon(logoGsb));
		
		lblWelcome = new JLabel("Welcome, utilisateur");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		panel_header.add(lblWelcome, BorderLayout.SOUTH);
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		
		// Panel de contenu
		panel_content = new JPanel();
		panel_principal.add(panel_content, BorderLayout.SOUTH);
		
		panel_welcome = new JPanel();
		panel_content.add(panel_welcome);
		panel_welcome.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		panel_logo = new JPanel();
		panel_content.add(panel_logo);
		panel_logo.setLayout(new BoxLayout(panel_logo, BoxLayout.X_AXIS));
		panel_header.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_logo, lblLogoGsb, panel_welcome, lblWelcome}));
		
		if (estConnecte) {
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
//		this.setContentPane(new PanelListeUtilisateur(lesUtilisateurs));
		this.revalidate();
		System.out.println("affichageListeUtilisateurs");
	}
	
	private void affichageAjoutUtilisateur() {
//		this.setContentPane(new PanelAjoutUtilisateur());
		this.revalidate();
		System.out.println("affichageAjoutUtilisateur");
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
