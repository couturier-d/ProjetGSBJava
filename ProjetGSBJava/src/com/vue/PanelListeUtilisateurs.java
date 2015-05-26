package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PanelListeUtilisateurs extends JPanel {
	private JScrollPane scrollPane;
	public JTable table;
	public ModeleUtilisateur modele;
	
	private List<Utilisateur> listeUtilisateurs;
	
	public PanelListeUtilisateurs() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(1024, 512));
		
		listeUtilisateurs = AccesData.getListeUtilisateur();
		
		JPanel panel_entete = new JPanel();
		add(panel_entete, BorderLayout.NORTH);
		panel_entete.add(new PanelEnteteAppli());
		
		JPanel sousPanel_contenuUtilisateurs = new JPanel();
		sousPanel_contenuUtilisateurs.setForeground(Color.BLACK);
		add(sousPanel_contenuUtilisateurs, BorderLayout.CENTER);
		sousPanel_contenuUtilisateurs.setLayout(new BorderLayout(0, 0));
		
		JPanel sousPanel_listeUtilisateur = new JPanel();
		sousPanel_listeUtilisateur.setForeground(Color.BLACK);
		sousPanel_contenuUtilisateurs.add(sousPanel_listeUtilisateur, BorderLayout.CENTER);
		sousPanel_listeUtilisateur.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel("Liste des utilisateurs enregistr\u00E9s :");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setPreferredSize(new Dimension(512, 32));
		sousPanel_listeUtilisateur.add(lblTitre, BorderLayout.NORTH);
		
		modele = new ModeleUtilisateur(listeUtilisateurs);
		
		table = new JTable(modele);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(75);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(250);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 121, 1024, 256);
		scrollPane.setViewportView(table);

		sousPanel_listeUtilisateur.add(scrollPane);
	}
}
