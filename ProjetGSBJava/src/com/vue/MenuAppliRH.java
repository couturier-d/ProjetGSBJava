package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import com.metier.Utilisateur;
import com.persistance.AccesData;

public class MenuAppliRH extends JFrame {

	private JPanel contentPane;
	char typeUtilisateur;
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
		setBounds(100, 100, 547, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		typeUtilisateur = 'S';
		
		
		switch(typeUtilisateur) {
			case 'S':
				lesUtilisateurs = AccesData.getListeUtilisateur();
				
				break;
			case 'D':
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
	}
	
	private void affichageAjoutUtilisateur() {
//		this.setContentPane(new PanelAjoutUtilisateur());
		this.revalidate();
	}
	
	private void affichageModifUtilisateur(Utilisateur unUtilisateur) {
//		this.setContentPane(new PanelModifUtilisateur(unUtilisateur));
		this.revalidate();
	}
	
	// Pannels pour Directeur RH
	
	// A compléter
	
	// Pannels pour Responsable suivi
	
	// A compléter

}
