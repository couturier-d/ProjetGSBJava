package com.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelStatsRegionMois extends JPanel {
	
	private JPanel panel_entete, panel_contenu, panel_titre_contenu;
	
	
	public PanelStatsRegionMois() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(768, 256));
		
		panel_entete = new JPanel();
		add(panel_entete, BorderLayout.NORTH);
		panel_entete.add(new PanelEnteteAppli());
		
		panel_contenu = new JPanel();
		add(panel_contenu, BorderLayout.CENTER);
		panel_contenu.setLayout(new BorderLayout(0, 0));
		
		panel_titre_contenu = new JPanel();
		panel_contenu.add(panel_titre_contenu, BorderLayout.NORTH);
		
		JLabel lblRecherche = new JLabel("Rechercher par région et par mois :");
		panel_titre_contenu.add(lblRecherche);
	}

}
