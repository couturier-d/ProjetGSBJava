package com.metier;

public class LigneFraisHorsForfait {

	private int idFraisHorsForfait;
	private String libelleFraisHorsForfait;
	private String date;
	private int montant;
	private FicheFrais ficheFrais;
	
	public LigneFraisHorsForfait(int unIdFraisHorsForfait, String unLibelleFraisHorsForfait, String uneDate, int unMontant, FicheFrais laFicheFrais) {
		super();
		this.idFraisHorsForfait = unIdFraisHorsForfait;
		this.libelleFraisHorsForfait = unLibelleFraisHorsForfait;
		this.date = uneDate;
		this.montant = unMontant;
		this.ficheFrais = laFicheFrais;
	}

	public int getIdFraisHorsForfait() {
		return idFraisHorsForfait;
	}

	public void setIdFraisHorsForfait(int idFraisHorsForfait) {
		this.idFraisHorsForfait = idFraisHorsForfait;
	}

	public String getLibelleFraisHorsForfait() {
		return libelleFraisHorsForfait;
	}

	public void setLibelleFraisHorsForfait(String libelleFraisHorsForfait) {
		this.libelleFraisHorsForfait = libelleFraisHorsForfait;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
