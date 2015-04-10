package com.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Classe FicheFrais
 * Gère les fiches de frais des utilisateurs
 * @author couturier-d
 */
@Entity
@Table (name="fichefrais")
@IdClass(FicheFraisPK.class)
@Embeddable
public class FicheFrais implements Serializable {

	
	private String mois;
	private Utilisateur utilisateur;
	private int nbJustificatifs;
	private double montantValide;
	private String dateModif;
	private List <LigneFraisForfait> listeFraisForfait;
	private List <LigneFraisHorsForfait> listeFraisHorsForfait;
	private String etat;
	
	/**
	 * Constructeur ficheFrais
	 * @param unMois
	 * @param unUtilisateur
	 */
	public FicheFrais(String unMois, Utilisateur unUtilisateur) {
		this.mois = unMois;
		this.utilisateur = unUtilisateur;
		this.nbJustificatifs = 0;
		this.montantValide = 0;
		this.dateModif = null;
		this.etat = "CR";
		this.listeFraisForfait = new ArrayList<LigneFraisForfait>();
		this.listeFraisHorsForfait = new ArrayList<LigneFraisHorsForfait>();
	}

	/**
	 * accesseur mois
	 * @return mois
	 */
	public String getMois() {
		return mois;
	}
	
	/**
	 * mutateur mois (uniquement pour hibernate)
	 * @param mois
	 */
	public void setMois(String mois) {
		this.mois = mois;
	}

	/**
	 * accesseur utilisateur
	 * @return utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	
	/**
	 * mutateur utilisateur
	 * @param unUtilisateur
	 */
	public void setUtilisateur(Utilisateur unUtilisateur) {
		this.utilisateur = unUtilisateur;
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
	public double getMontantValide() {
		return montantValide;
	}
	
	/**
	 * mutateur montantValide
	 * @param montantValide
	 */
	public void setMontantValide(double montantValide) {
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
	 * accesseur etat
	 * @return etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * mutateur etat
	 * @param etat
	 */
	public void setEtat(String etat) {
		this.etat = etat;
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
	public void setListeFraisForfait(List<LigneFraisForfait> listeFraisForfait) {
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
	public void setListeFraisHorsForfait(List<LigneFraisHorsForfait> listeFraisHorsForfait) {
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
		return "FicheFrais [mois=" + mois + ", utilisateur=" + utilisateur.toString()
				+ ", nbJustificatifs=" + nbJustificatifs + ", montantValide="
				+ montantValide + ", dateModif=" + dateModif + "]";
	}
}
