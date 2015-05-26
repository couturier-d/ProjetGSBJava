package com.modele;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.metier.LigneFraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.FicheFrais;
import com.metier.Utilisateur;
import com.persistance.AccesData;

public class ModeleStatsRegionMois extends AbstractTableModel {
		private String[] entetes = {"Utilisateur", "Nombre de frais hors forfait", "Montant total frais hors forfait" , "Montant total frais forfait"};
		private List<FicheFrais> listeFicheFrais;
		private int nbFraisHorsForfait;
		private double montantHorsForfait, montantForfait;
		private List<Utilisateur> listeUtilisateur;
		private List<LigneFraisHorsForfait> listeLigneFraisHorsForfait;
		private List<LigneFraisForfait> listeLigneFraisForfait;
		public ModeleStatsRegionMois(List<FicheFrais> laListeFicheFrais) {
			listeFicheFrais = laListeFicheFrais;
			listeUtilisateur = AccesData.getListeUtilisateur();
			listeLigneFraisHorsForfait = AccesData.getListeLigneFraisHorsForfait();
			listeLigneFraisForfait = AccesData.getListeLigneFraisForfait();
		}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeFicheFrais.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			// nom et prenom
			Utilisateur util = null;
			Boolean trouve = false;
			int i = 0;
			while(trouve == false && i < listeUtilisateur.size()) {
				if(listeUtilisateur.get(i).getIdUtilisateur().equals(listeFicheFrais.get(rowIndex).getIdVisiteur())) {
					util = listeUtilisateur.get(i);
					trouve = true;
				}
				i++;
			}
			return util.getNom() + " " + util.getPrenom();
		case 1:
			// Nombre frais hors forfait
			return listeFicheFrais.get(rowIndex).getNbFraisHorsForfait();
		case 2:
			// Montant frais hors forfait
			montantHorsForfait = 0;
			for(LigneFraisHorsForfait l : listeLigneFraisHorsForfait) {
				montantHorsForfait = montantHorsForfait + l.getMontant();
			}
			return montantHorsForfait;
		case 3:
			// Montant frais forfait
			montantForfait = 0;
			for(LigneFraisForfait l : listeLigneFraisForfait) {
				montantForfait = montantForfait + (l.getQuantite() * l.getFraisForfait().getMontant());
			}
			return montantForfait;
		default:
			throw new IllegalArgumentException();
		}
	}

}
