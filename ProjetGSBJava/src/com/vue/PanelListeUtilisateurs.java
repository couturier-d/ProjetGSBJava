package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.metier.Region;
import com.metier.Utilisateur;
import com.modele.ModeleUtilisateur;
import com.persistance.AccesData;

import javax.swing.JButton;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PanelListeUtilisateurs extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	public ModeleUtilisateur modele;
	private JComboBox<String> cbxFiltreUtilisateur_region;
	private JTextField txtSearchUtilisateur_id;
	private JTextField txtSearchUtilisateur_nom;
	private JTextField txtSearchUtilisateur_prenom;
	
	private JLabel lblFiltreUtilisateur_region, lblFiltreUtilisateur_id, lblFiltreUtilisateur_nom, lblFiltreUtilisateur_prenom;
	
	private List<Utilisateur> listeUtilisateurs;
	private List<Region> listeRegions;
	
	public PanelListeUtilisateurs(List<Utilisateur> lesUtilisateurs) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(1024, 512));
		
		listeUtilisateurs = lesUtilisateurs;
		listeRegions = AccesData.getListeRegion();
		
		modele = new ModeleUtilisateur(listeUtilisateurs);
		
		// Gestion des filtres de recherche
		
		JPanel sousPanel_contenuUtilisateurs = new JPanel();
		sousPanel_contenuUtilisateurs.setForeground(Color.BLACK);
		add(sousPanel_contenuUtilisateurs, BorderLayout.CENTER);
		sousPanel_contenuUtilisateurs.setLayout(new BorderLayout(0, 0));
		
		JPanel sousPanel_searchUtilisateur = new JPanel();
		sousPanel_searchUtilisateur.setForeground(Color.BLACK);
		sousPanel_contenuUtilisateurs.add(sousPanel_searchUtilisateur, BorderLayout.NORTH);
		sousPanel_searchUtilisateur.setLayout(new BorderLayout(0, 0));
		
		// Entête du panel
		
		JPanel sousPanel_searchUtilisateur_entete = new JPanel();
		sousPanel_searchUtilisateur.add(sousPanel_searchUtilisateur_entete, BorderLayout.NORTH);
		
		JLabel lblALaRecherche = new JLabel("A la recherche d'un visiteur particulier ?");
		sousPanel_searchUtilisateur_entete.add(lblALaRecherche);
		
		// Filtres de recherche
		
		JPanel sousPanel_searchUtilisateur_filtres = new JPanel();
		sousPanel_searchUtilisateur.add(sousPanel_searchUtilisateur_filtres, BorderLayout.CENTER);
		
		lblFiltreUtilisateur_region = new JLabel("R\u00E9gion :");
		sousPanel_searchUtilisateur_filtres.add(lblFiltreUtilisateur_region);
		
		cbxFiltreUtilisateur_region = new JComboBox<String>();
		sousPanel_searchUtilisateur_filtres.add(cbxFiltreUtilisateur_region);
//		cbxFiltreUtilisateur_region.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (cbxFiltreUtilisateur_region.getSelectedIndex()!= -1) 	{
////				String idRegion = listeRegions.get(cbxFiltreUtilisateur_region.getSelectedIndex()).getIdRegion();
////						! ! ! Récupération des utilisateurs d'une région ! ! !
////				listeUtilisateurs = AccesData.getListeUtilisateur();
//				//modele = new ModeleUtilisateur(listeUtilisateurs);
////				table.setModel(modele);
//				 // réactualisation de la table
////				table.revalidate();
//				
//				}
//			}
//		});
		
		for(Region r: listeRegions)
		{
			cbxFiltreUtilisateur_region.addItem(r.getNomRegion());
		}
		
		cbxFiltreUtilisateur_region.setSelectedIndex(0);
		
		lblFiltreUtilisateur_id = new JLabel("ID :");
		sousPanel_searchUtilisateur_filtres.add(lblFiltreUtilisateur_id);
		
		txtSearchUtilisateur_id = new JTextField();
		sousPanel_searchUtilisateur_filtres.add(txtSearchUtilisateur_id);
		txtSearchUtilisateur_id.setColumns(4);
		
		lblFiltreUtilisateur_nom = new JLabel("Nom :");
		sousPanel_searchUtilisateur_filtres.add(lblFiltreUtilisateur_nom);
		
		txtSearchUtilisateur_nom = new JTextField();
		sousPanel_searchUtilisateur_filtres.add(txtSearchUtilisateur_nom);
		txtSearchUtilisateur_nom.setColumns(10);
		
		// Champ de recheerche par prénom
		
		lblFiltreUtilisateur_prenom = new JLabel("Prenom :");
		sousPanel_searchUtilisateur_filtres.add(lblFiltreUtilisateur_prenom);
		
		txtSearchUtilisateur_prenom = new JTextField();
		sousPanel_searchUtilisateur_filtres.add(txtSearchUtilisateur_prenom);
		txtSearchUtilisateur_prenom.setColumns(10);
		
		// Boutons de validation de la recherche
		
		JPanel sousPanel_searchUtilisateur_bouttons = new JPanel();
		sousPanel_searchUtilisateur.add(sousPanel_searchUtilisateur_bouttons, BorderLayout.SOUTH);
		
		JButton btnSearchUtilisateur_id = new JButton("Rechercher par ID");
		sousPanel_searchUtilisateur_bouttons.add(btnSearchUtilisateur_id);
		
		JButton btnSearchUtilisateur_nomPrenom = new JButton("Rechercher par nom prenom");
		sousPanel_searchUtilisateur_bouttons.add(btnSearchUtilisateur_nomPrenom);
		
		JPanel sousPanel_listeUtilisateur = new JPanel();
		sousPanel_listeUtilisateur.setForeground(Color.BLACK);
		sousPanel_contenuUtilisateurs.add(sousPanel_listeUtilisateur, BorderLayout.CENTER);
		sousPanel_listeUtilisateur.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRsultatDeLa = new JLabel("R\u00E9sultat de la recherche :");
		lblRsultatDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		sousPanel_listeUtilisateur.add(lblRsultatDeLa, BorderLayout.NORTH);
		sousPanel_listeUtilisateur.add(getScrollPane());
	}		
	
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(54, 121, 768, 256);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable(modele);
			table.setSize(1024, 512);
		}
		return table;
	}	
}
