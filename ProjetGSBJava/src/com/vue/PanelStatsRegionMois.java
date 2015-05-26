package com.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.metier.FicheFrais;
import com.metier.Region;
import com.metier.Utilisateur;
import com.modele.ModeleStatsRegionMois;
import com.persistance.AccesData;

public class PanelStatsRegionMois extends JPanel {
	private JScrollPane scrollPane;
	public JTable table;
	public ModeleStatsRegionMois modele;
	private JComboBox<String> cbxRegion, cbxMois;
	private JPanel panel_entete, panel_contenu, panel_titre_contenu;
	
	private List<Region> listeRegion;
	private List<String> listeMois;
	private List<FicheFrais> listeFiches;
	private List<Utilisateur> listeUtilisateur;
	
	private String[] mois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	private String libelleMois, numMois, numAnnee;
	
	public PanelStatsRegionMois() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(768, 256));
		
		panel_entete = new JPanel();
		add(panel_entete, BorderLayout.NORTH);
		panel_entete.add(new PanelEnteteAppli());
		
		listeRegion = AccesData.getListeRegion();
		listeFiches = AccesData.getListeFicheFrais();
		listeMois = new ArrayList<String>();
		
		panel_contenu = new JPanel();
		add(panel_contenu, BorderLayout.CENTER);
		panel_contenu.setLayout(new BorderLayout(0, 0));
		
		panel_titre_contenu = new JPanel();
		panel_contenu.add(panel_titre_contenu, BorderLayout.NORTH);
		
		JLabel lblRecherche = new JLabel("Rechercher par région et par mois :");
		panel_titre_contenu.add(lblRecherche);
		
		JPanel sousPanel_recherche = new JPanel();
		panel_contenu.add(sousPanel_recherche, BorderLayout.CENTER);
		sousPanel_recherche.setBorder(new LineBorder(new Color(0, 0, 0)));
		sousPanel_recherche.setLayout(new GridLayout(5, 2, 0, 0));
		
		cbxRegion = new JComboBox<String>();
		cbxRegion.setBounds(150, 15, 150, 20);
		sousPanel_recherche.add(cbxRegion);
		for(Region r : listeRegion) {
			cbxRegion.addItem(r.getNomRegion());
		}
		cbxRegion.setSelectedIndex(-1);
		
		cbxMois = new JComboBox<String>();
		cbxMois.setBounds(150, 15, 150, 20);
		sousPanel_recherche.add(cbxMois);
		for(FicheFrais f : listeFiches) {
			numMois = (f.getMois().substring(4, 5));
			libelleMois = mois[Integer.parseInt(numMois)+1];
			numAnnee  = f.getMois().substring(0, 3);
			listeMois.add(numAnnee + numMois);
			cbxMois.addItem(libelleMois + " " + numAnnee);
		}
		cbxMois.setSelectedIndex(-1);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Region laRegion = listeRegion.get(cbxRegion.getSelectedIndex());
				String leMois = listeMois.get(cbxMois.getSelectedIndex());
				rechercherUtilisateur(laRegion, leMois);
			}
		});
		
		sousPanel_recherche.add(btnRechercher);
		
		JPanel sousPanel_resultat = new JPanel();
		panel_contenu.add(sousPanel_resultat, BorderLayout.SOUTH);
		sousPanel_resultat.setBorder(new LineBorder(new Color(0, 0, 0)));
		sousPanel_resultat.setLayout(new GridLayout(5, 2, 0, 0));
		
		modele = new ModeleStatsRegionMois(listeFiches);
		
		table = new JTable(modele);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(75);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 121, 1024, 256);
		scrollPane.setViewportView(table);

		sousPanel_resultat.add(scrollPane);
	}
	
	public void rechercherUtilisateur(Region laRegion, String leMois) {
		listeFiches = new ArrayList<FicheFrais>();
		listeUtilisateur = AccesData.getListeUtilisateur();
		for (Utilisateur u : listeUtilisateur) {
			if (u.getRegion().getIdRegion().equals(laRegion.getIdRegion())) {
				for(FicheFrais f : u.getLesFichesFrais()) {
					if((f.getMois().equals(leMois))) {
						listeFiches.add(f);
					}
				}
			}
		}
		modele = new ModeleStatsRegionMois(listeFiches);
		table.revalidate();
	}

}
