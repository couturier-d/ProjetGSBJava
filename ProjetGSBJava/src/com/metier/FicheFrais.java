package com.metier;

import java.util.ArrayList;
import java.util.List;

public class FicheFrais {

	String idFicheFrais;
	int mois;
	String idVisiteur;
	int nbJustificatifs;
	int montantValide;
	String dateModif;
	List <LigneFraisForfait> listeFraisForfait;
	List <LigneFraisHorsForfait> listeFraisHorsForfait;
	
	
	/**
	 * Constructeur ficheFrais
	 */
	
	public FicheFrais(int unMois, String unIdVisiteur) {
		this.mois = unMois;
		this.idVisiteur = unIdVisiteur;
		this.nbJustificatifs = 0;
		this.montantValide = 0;
		this.dateModif = null;
		this.listeFraisForfait = new ArrayList<LigneFraisForfait>();
		this.listeFraisHorsForfait = new ArrayList<LigneFraisHorsForfait>();
	}


	public String getIdFicheFrais() {
		return idFicheFrais;
	}
	public void setIdFicheFrais(String idFicheFrais) {
		this.idFicheFrais = idFicheFrais;
	}

	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}

	public String getIdVisiteur() {
		return idVisiteur;
	}
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public int getNbJustificatifs() {
		return nbJustificatifs;
	}
	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}

	public int getMontantValide() {
		return montantValide;
	}
	public void setMontantValide(int montantValide) {
		this.montantValide = montantValide;
	}

	public String getDateModif() {
		return dateModif;
	}
	public void setDateModif(String dateModif) {
		this.dateModif = dateModif;
	}

	public List<LigneFraisForfait> getListeFraisForfait() {
		return listeFraisForfait;
	}
	public void setListeFraisForfait(ArrayList<LigneFraisForfait> listeFraisForfait) {
		this.listeFraisForfait = listeFraisForfait;
	}

	public List<LigneFraisHorsForfait> getListeFraisHorsForfait() {
		return listeFraisHorsForfait;
	}
	public void setListeFraisHorsForfait(ArrayList<LigneFraisHorsForfait> listeFraisHorsForfait) {
		this.listeFraisHorsForfait = listeFraisHorsForfait;
	}

	public int getNbFraisForfait() {
		return listeFraisForfait.size();
	}
	
	public int getNbFraisHorsForfait() {
		return listeFraisHorsForfait.size();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
