package com.metier;

/**
 * Classe LigneFraisForfait
 * Gère les ligne de frais frofaitisés
 * @author couturier-d
 *
 */
public class LigneFraisForfait {
	
	int mois;
	String idVisiteur;
	FraisForfait idFraisForfait;
	int quantite;
	
	/**
	 * Constructeur LigneFraisForfait
	 * @param mois
	 * @param idVisiteur
	 * @param idFraisForfait
	 * @param quantite
	 */
	public LigneFraisForfait(int mois, String idVisiteur, FraisForfait idFraisForfait, int quantite) {
		super();
		this.mois = mois;
		this.idVisiteur = idVisiteur;
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
	}
	/**
	 * accesseur mois
	 * @return mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * mutateur mois (uniquement pour hibernate)
	 * @param mois
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * accesseur idVisiteur
	 * @return idVisiteur
	 */
	public String getIdVisiteur() {
		return idVisiteur;
	}

	/**
	 * mutateur idVisiteur (unqiuement pour hibernate)
	 * @param idVisiteur
	 */
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	/**
	 * accesseur idFraisForfait
	 * @return idFraisForfait
	 */
	public FraisForfait getIdFraisForfait() {
		return idFraisForfait;
	}

	/**
	 * mutateur idFraisForfait
	 * @param idFraisForfait
	 */
	public void setIdFraisForfait(FraisForfait idFraisForfait) {
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
	
	/**
	 * Méthode toString sur LigneFraisForfait
	 */
	@Override
	public String toString() {
		return "LigneFraisForfait [mois=" + mois + ", idVisiteur=" + idVisiteur
				+ ", idFraisForfait=" + idFraisForfait + ", quantite="
				+ quantite + "]";
	}
	
	
	
}
