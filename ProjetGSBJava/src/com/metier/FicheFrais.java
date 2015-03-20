package com.metier;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe FicheFrais
 * Gère les fiches de frais des utilisateurs
 * @author couturier-d
 *
 */
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

	/**
	 * accesseur idFicheFrais
	 * @returnidFicheFrais
	 */
	public String getIdFicheFrais() {
		return idFicheFrais;
	}
	
	/**
	 * mutateur idFicheFrais (uniquement pour hibernate)
	 * @param idFicheFrais
	 */
	public void setIdFicheFrais(String idFicheFrais) {
		this.idFicheFrais = idFicheFrais;
	}

	/**
	 * accesseur mois
	 * @return mois
	 */
	public int getMois() {
		return mois;
	}
	
	/**
	 * mutateur mois
	 * @param mois
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * accesseur idVisiteur
	 * @return v
	 */
	public String getIdVisiteur() {
		return idVisiteur;
	}
	
	/**
	 * mutateur idVisiteur
	 * @param idVisiteur
	 */
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	
	/**
	 * accesseur nbJustificatifs
	 * @return nbJustificatifs
	 */
	public int getNbJustificatifs() {
		return nbJustificatifs;
	}
	
	/**
	 * mutateur nbJustificatifs
	 * @param nbJustificatifs
	 */
	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}

	/**
	 * accesseur montantValide
	 * @return montantValide
	 */
	public int getMontantValide() {
		return montantValide;
	}
	
	/**
	 * mutateur montantValide
	 * @param montantValide
	 */
	public void setMontantValide(int montantValide) {
		this.montantValide = montantValide;
	}

	/**
	 * accesseur dateModif
	 * @return dateModif
	 */
	public String getDateModif() {
		return dateModif;
	}
	
	/**
	 * mutateur dateModif
	 * @param dateModif
	 */
	public void setDateModif(String dateModif) {
		this.dateModif = dateModif;
	}

	/**
	 * mutateur listeFraisForfait
	 * @return listeFraisForfait
	 */
	public List<LigneFraisForfait> getListeFraisForfait() {
		return listeFraisForfait;
	}
	
	/**
	 * mutateur listeFraisForfait
	 * @param listeFraisForfait
	 */
	public void setListeFraisForfait(ArrayList<LigneFraisForfait> listeFraisForfait) {
		this.listeFraisForfait = listeFraisForfait;
	}

	/**
	 * accesseur listeFraisHorsForfait
	 * @return listeFraisHorsForfait
	 */
	public List<LigneFraisHorsForfait> getListeFraisHorsForfait() {
		return listeFraisHorsForfait;
	}
	
	/**
	 * mutateur listeFraisHorsForfait
	 * @param listeFraisHorsForfait
	 */
	public void setListeFraisHorsForfait(ArrayList<LigneFraisHorsForfait> listeFraisHorsForfait) {
		this.listeFraisHorsForfait = listeFraisHorsForfait;
	}

	/**
	 * retourne le nombre de ligne de FraisForfait
	 * @return nbLignesFraisForfait
	 */
	public int getNbFraisForfait() {
		return listeFraisForfait.size();
	}
	
	/**
	 * retourne le nombre de ligne de FraisHorsForfait
	 * @return nbLignesFraisHorsForfait
	 */
	public int getNbFraisHorsForfait() {
		return listeFraisHorsForfait.size();
	}

	/**
	 * Methode to string sur FicheFrais
	 */
	@Override
	public String toString() {
		return "FicheFrais [idFicheFrais=" + idFicheFrais + ", mois=" + mois
				+ ", idVisiteur=" + idVisiteur + ", nbJustificatifs="
				+ nbJustificatifs + ", montantValide=" + montantValide
				+ ", dateModif=" + dateModif + ", listeFraisForfait="
				+ listeFraisForfait + ", listeFraisHorsForfait="
				+ listeFraisHorsForfait + "]";
	}
}
