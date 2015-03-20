package com.metier;

/**
 * Classe FraisForfait
 * Gère les types de Frais forfaitisés
 * @author couturier-d
 *
 */
public class FraisForfait {
	private String idFraisForfait;
	private String libelleFraisForfait;
	
	/**
	 * Constructeur FraisForfait
	 *  @param unLibelleFraisForfait
	 */
	public FraisForfait(String unLibelleFraisForfait) {
		this.libelleFraisForfait = unLibelleFraisForfait;
	}

	/**
	 * accesseur idFraisForfait
	 * @return idFraisForfait
	 */
	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	/**
	 * mutateur idFraisForfait (uniquement pour hibernate)
	 * @param idFraisForfait
	 */
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	/**
	 * accesseur libelleFraisForfait
	 * @return libelleFraisForfait
	 */
	public String getLibelleFraisForfait() {
		return libelleFraisForfait;
	}

	/**
	 * mutateur libelleFraisForfait
	 * @param libelleFraisForfait
	 */
	public void setLibelleFraisForfait(String libelleFraisForfait) {
		this.libelleFraisForfait = libelleFraisForfait;
	}

	/**
	 * Methode to string sur FraisForfait
	 */
	@Override
	public String toString() {
		return "libelleFraisForfait ="+libelleFraisForfait;
	}
	
	

}
