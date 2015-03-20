package com.metier;

/**
 * Classe FraisForfait
 * G�re les types de Frais forfaitis�s
 * @author couturier-d
 *
 */
public class FraisForfait {
	private String idFraisForfait;
	private String libelleFraisForfait;
	
	/**
	 * Constructeur FraisForfait
	 */
	public FraisForfait(String unLibelleFraisForfait) {
		this.libelleFraisForfait = unLibelleFraisForfait;
	}

	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	public String getLibelleFraisForfait() {
		return libelleFraisForfait;
	}

	public void setLibelleFraisForfait(String libelleFraisForfait) {
		this.libelleFraisForfait = libelleFraisForfait;
	}

	@Override
	public String toString() {
		return "libelleFraisForfait ="+libelleFraisForfait;
	}
	
	

}
