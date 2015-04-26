package com.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe LigneFraisHorsForfait
 * Gère l'ensemble des frais non forfaitisés
 * @author halleguen-py
 */
@Entity
@Table (name="lignefraisHorsforfait")
public class LigneFraisHorsForfait {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int idLigneFraisHorsForfait;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idVisiteur", insertable=false, updatable=false),
		@JoinColumn(name="mois", insertable=false, updatable=false)})
	private FicheFrais ficheFrais;
	
	@Column(name="libelle")
	private String libelleFraisHorsForfait;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="montant", columnDefinition="Decimal(10,2)")
	private double montant;
	
	/**
	 * Constructeur vide pour hibernate
	 */
	public LigneFraisHorsForfait() {
		super();
	}

	/**
	 * Constructeur de la classe LigneFraisHorsForfait
	 * @param unIdFraisHorsForfait
	 * @param unLibelleFraisHorsForfait
	 * @param uneDate
	 * @param unMontant
	 * @param laFicheFrais
	 */
	public LigneFraisHorsForfait(int unIdFraisHorsForfait, String unLibelleFraisHorsForfait, Date uneDate, double unMontant, FicheFrais laFicheFrais) {
		super();
		this.idLigneFraisHorsForfait = unIdFraisHorsForfait;
		this.libelleFraisHorsForfait = unLibelleFraisHorsForfait;
		this.date = uneDate;
		this.montant = unMontant;
		this.ficheFrais = laFicheFrais;
	}

	/**
	 * Accesseur de l'id de l'objet LigneFraisHorsForfait
	 * @return idFraisHorsForfait
	 */
	public int getIdLigneFraisHorsForfait() {
		return idLigneFraisHorsForfait;
	}

	/**
	 * Mutateur de l'id de l'objet LigneFraisHorsForfait
	 * @param idFraisHorsForfait
	 */
	public void setIdLigneFraisHorsForfait(int idFraisHorsForfait) {
		this.idLigneFraisHorsForfait = idFraisHorsForfait;
	}

	/**
	 * Accesseur du libelle de l'objet LigneFraisHorsForfait
	 * @return libelleFraisHorsForfait
	 */
	public String getLibelleFraisHorsForfait() {
		return libelleFraisHorsForfait;
	}

	/**
	 * Mutateur du libelle de l'objet LigneFraisHorsForfait
	 * @param libelleFraisHorsForfait
	 */
	public void setLibelleFraisHorsForfait(String libelleFraisHorsForfait) {
		this.libelleFraisHorsForfait = libelleFraisHorsForfait;
	}

	/**
	 * Accesseur de la date de l'objet LigneFraisHorsForfait
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Mutateur de la date de l'objet LigneFraisHorsForfait
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Accesseur du montant de l'objet LigneFraisHorsForfait
	 * @return montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Mutateur du montant de l'objet LigneFraisHorsForfait
	 * @param montant
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Accesseur de la fiche de frais de l'objet LigneFraisHorsForfait
	 * @return ficheFrais
	 */
	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	/**
	 * Mutateur de la fiche de frais de l'objet LigneFraisHorsForfait
	 * @param ficheFrais
	 */
	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	/**
	 * Méthode toString de la classe LigneFraisHorsForfait
	 */
	@Override
	public String toString() {
		return "LigneFraisHorsForfait [idFraisHorsForfait="
				+ idLigneFraisHorsForfait + ", libelleFraisHorsForfait="
				+ libelleFraisHorsForfait + ", date=" + date + ", montant="
				+ montant + "]";
	}
	
}