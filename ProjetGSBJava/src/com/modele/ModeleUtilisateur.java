package com.modele;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.metier.Region;
import com.metier.TypeUtilisateur;
import com.metier.Utilisateur;
import com.persistance.AccesData;

public class ModeleUtilisateur extends AbstractTableModel {
	private String[] entetes = {"Utilisateur","poste", "Région", "N° Fixe" , "N° Portable", "Localisation", "Embauché le", "E-mail"};
	private List<Utilisateur> listeUtilisateur;
	private List<TypeUtilisateur> listeTypeUtilisateur;
	public ModeleUtilisateur(List<Utilisateur> laListeUtilisateur) {
		listeUtilisateur = laListeUtilisateur;
		listeTypeUtilisateur = AccesData.getListeTypeUtilisateur();
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
			// Type utilisateur
			TypeUtilisateur leType = null;
			Boolean trouve = false;
			int index = 0;
			while((trouve == false) && (index < listeTypeUtilisateur.size())) {
				if (listeTypeUtilisateur.get(index).getIdType().equals(listeUtilisateur.get(rowIndex).getIdTypeUtilisateur())) {
					leType = listeTypeUtilisateur.get(index);
					trouve = true;
				}
				index++;
			}
			return leType.getLibelleType();
		case 2:
			// Région
			return listeUtilisateur.get(rowIndex).getRegion().getNomRegion();
		case 3:
			// N° Fixe
			return listeUtilisateur.get(rowIndex).getNumeroFixe();
		case 4:
			// N° Portable
			return listeUtilisateur.get(rowIndex).getNumeroPortable();
		case 5:
			// Localisation
			return listeUtilisateur.get(rowIndex).getAdresse() + "," + listeUtilisateur.get(rowIndex).getVille() + " " + listeUtilisateur.get(rowIndex).getCodePostal();
		case 6:
			// Date embauche
			SimpleDateFormat format = new SimpleDateFormat("dd / MM / yyyy");
			return format.format(listeUtilisateur.get(rowIndex).getDateEmbauche()).toString();
		case 7:
			// E-mail
			return listeUtilisateur.get(rowIndex).getAdresseMail();
		default:
			throw new IllegalArgumentException();
		}
	}

}
