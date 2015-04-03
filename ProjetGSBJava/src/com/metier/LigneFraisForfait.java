package com.metier;

/**
 * Classe LigneFraisForfait
 * Gère les ligne de frais frofaitisés
 * @author couturier-d
 */
public class LigneFraisForfait {
	
	private String idFraisForfait; // A verifier !
	private int quantite;
	private FicheFrais ficheFrais;
	private FraisForfait fraisForfait;
	
	/**
	 * Constructeur LigneFraisForfait
	 * @param idFraisForfait
	 * @param quantite
	 * @param ficheFrais
	 * @param fraisForfait
	 */
	public LigneFraisForfait(String idFraisForfait, int quantite, FicheFrais ficheFrais, FraisForfait fraisForfait) {
		super();
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
		this.ficheFrais = ficheFrais;
		this.fraisForfait = fraisForfait;
	}
	/**
	 * accesseur idFraisForfait
	 * @return idFraisForfait
	 */
	public String getIdFraisForfait() {
		return this.idFraisForfait;
	}

	/**
	 * mutateur mois (uniquement pour hibernate)
	 * @param idFraisForfait
	 */
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	/**
	 * accesseur quantite
	 * @return quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * mutateur quantite
	 * @param quantite
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}
	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}
	
	public FraisForfait getFraisForfait() {
		return fraisForfait;
	}
	public void setFraisForfait(FraisForfait fraisForfait) {
		this.fraisForfait = fraisForfait;
	}
	
	/**
	 * Méthode toString sur LigneFraisForfait
	 */
	@Override
	public String toString() {
		return "LigneFraisForfait [idFraisForfait=" + idFraisForfait
				+ ", quantite=" + quantite + ", ficheFrais=" + ficheFrais
				+ ", fraisForfait=" + fraisForfait + "]";
	}
	
}
