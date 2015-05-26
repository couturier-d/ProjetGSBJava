package com.vue;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelEnteteAppli extends JPanel {
	
	private JLabel lblWelcome;
	private JLabel lblLogoGsb;
	
	private Image logoGsb;
	
	public PanelEnteteAppli() {	
		logoGsb = new ImageIcon(this.getClass().getResource("/gsbIcon.png")).getImage();
		setLayout(new BorderLayout(0, 0));
		
		lblLogoGsb = new JLabel("");
		this.add(lblLogoGsb, BorderLayout.NORTH);
		lblLogoGsb.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoGsb.setVerticalAlignment(SwingConstants.TOP);
		lblLogoGsb.setIcon(new ImageIcon(logoGsb));
		
		lblWelcome = new JLabel("Welcome, utilisateur");
		this.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		
		if(MenuAppliRH.estConnecte){
			lblWelcome.setText("Bienvenue, " + MenuAppliRH.utilisateurConnecte.getPrenom() + " " + MenuAppliRH.utilisateurConnecte.getNom());
		}
	}
}
