package com.metier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

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

	@Id
	@Columns(columns = {
			@Column(name = "idVisiteur",insertable=false, updatable=false),
			@Column(name = "mois",insertable=false, updatable=false)
	})
	private String idVisiteur;
	private String mois;
	
	@ManyToOne
	@JoinColumn(name="idVisiteur",insertable=false, updatable=false)
	private Utilisateur utilisateur;
	
	@Column(name="nbJustificatifs")
	private int nbJustificatifs;
	
	@Column(name="montantValide", columnDefinition="Decimal(10,2)")
	private double montantValide;
	
	@Column(name="dateModif")
	private Date dateModif;
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name="idVisiteur", insertable=false, updatable=false),
		@JoinColumn(name="mois", insertable=false, updatable=false)})
	private List <LigneFraisForfait> listeFraisForfait;
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name="idVisiteur", insertable=false, updatable=false),
		@JoinColumn(name="mois", insertable=false, updatable=false)})
	private List <LigneFraisHorsForfait> listeFraisHorsForfait;
	
	@Column(name="idEtat")
	private String etat;
	
	/**
	 * Constructeur vide pour hibernate
	 */
	public FicheFrais() {
		super();
	}

	/**
	 * Constructeur ficheFrais
	 * @param unMois
	 * @param unUtilisateur
	 */
	public FicheFrais(String unMois, Utilisateur unUtilisateur) {
		this.mois = unMois;
		this.utilisateur = unUtilisateur;
		this.nbJustificatifs = 0;
		this.montantValide = 0.0;
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
	 * accesseur idVisiteur
	 * @return idvisiteur
	 */
	public String getIdVisiteur() {
		return idVisiteur;
	}
	
	/**
	 * mutateur idVisiteur (uniquement pour hibernate)
	 * @param idVisiteur
	 */
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
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
	public Date getDateModif() {
		return dateModif;
	}
	
	/**
	 * mutateur dateModif
	 * @param dateModif
	 */
	public void setDateModif(Date dateModif) {
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
