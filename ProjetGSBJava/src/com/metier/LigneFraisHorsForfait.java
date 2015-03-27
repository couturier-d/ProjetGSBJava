package com.metier;

/**
 * Classe LigneFraisHorsForfait
 * Gère l'ensemble des frais non forfaitisés
 * @author halleguen-py
 */
public class LigneFraisHorsForfait {

	private int idFraisHorsForfait;
	private String libelleFraisHorsForfait;
	private String date;
	private int montant;
	private FicheFrais ficheFrais;
	
	/**
	 * Constructeur de la classe LigneFraisHorsForfait
	 * @param unIdFraisHorsForfait
	 * @param unLibelleFraisHorsForfait
	 * @param uneDate
	 * @param unMontant
	 * @param laFicheFrais
	 */
	public LigneFraisHorsForfait(int unIdFraisHorsForfait, String unLibelleFraisHorsForfait, String uneDate, int unMontant, FicheFrais laFicheFrais) {
		super();
		this.idFraisHorsForfait = unIdFraisHorsForfait;
		this.libelleFraisHorsForfait = unLibelleFraisHorsForfait;
		this.date = uneDate;
		this.montant = unMontant;
		this.ficheFrais = laFicheFrais;
	}

	/**
	 * Accesseur de l'id de l'objet LigneFraisHorsForfait
	 * @return idFraisHorsForfait
	 */
	public int getIdFraisHorsForfait() {
		return idFraisHorsForfait;
	}

	/**
	 * Mutateur de l'id de l'objet LigneFraisHorsForfait
	 * @param idFraisHorsForfait
	 */
	public void setIdFraisHorsForfait(int idFraisHorsForfait) {
		this.idFraisHorsForfait = idFraisHorsForfait;
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
	public String getDate() {
		return date;
	}

	/**
	 * Mutateur de la date de l'objet LigneFraisHorsForfait
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Accesseur du montant de l'objet LigneFraisHorsForfait
	 * @return montant
	 */
	public int getMontant() {
		return montant;
	}

	/**
	 * Mutateur du montant de l'objet LigneFraisHorsForfait
	 * @param montant
	 */
	public void setMontant(int montant) {
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
				+ idFraisHorsForfait + ", libelleFraisHorsForfait="
				+ libelleFraisHorsForfait + ", date=" + date + ", montant="
				+ montant + "]";
	}
	
}