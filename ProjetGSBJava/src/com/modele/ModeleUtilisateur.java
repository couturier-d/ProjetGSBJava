package com.modele;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.metier.Utilisateur;

public class ModeleUtilisateur extends AbstractTableModel {
	private String[] entetes = {"Utilisateur", "Région", "N° Fixe" , "N° Portable", "Localisation", "Embauché le", "E-mail"};
	private List<Utilisateur> listeUtilisateur;
	public ModeleUtilisateur(List<Utilisateur> laListeUtilisateur) {
		listeUtilisateur = laListeUtilisateur;
	}

	@Override
	public int getRowCount() {
		return listeUtilisateur.size();
	}
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			// nom et prenom
			return listeUtilisateur.get(rowIndex).getNom() + " " + listeUtilisateur.get(rowIndex).getPrenom();
		case 1:
			// Région
			return listeUtilisateur.get(rowIndex).getRegion().getNomRegion();
		case 2:
			// N° Fixe
			return listeUtilisateur.get(rowIndex).getNumeroFixe();
		case 3:
			// N° Portable
			return listeUtilisateur.get(rowIndex).getNumeroPortable();
		case 4:
			// Localisation
			return listeUtilisateur.get(rowIndex).getAdresse() + "," + listeUtilisateur.get(rowIndex).getVille() + " " + listeUtilisateur.get(rowIndex).getCodePostal();
		case 5:
			// Date embauche
			SimpleDateFormat format = new SimpleDateFormat("dd / MM / yyyy");
			return format.format(listeUtilisateur.get(rowIndex).getDateEmbauche()).toString();
		case 6:
			// E-mail
			return listeUtilisateur.get(rowIndex).getAdresseMail();
		default:
			throw new IllegalArgumentException();
		}
	}

}
