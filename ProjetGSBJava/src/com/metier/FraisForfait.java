package com.metier;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Classe FraisForfait
 * Gère les types de Frais forfaitisés
 * @author couturier-d
 *
 */
public class FraisForfait {
	private String idFraisForfait;
	private String libelleFraisForfait;
	private double montantFraisForfait;

	/**
	 * Constructeur FraisForfait
	 *  @param unLibelleFraisForfait
	 */
	public FraisForfait(String unIdFraisForfait ,String unLibelleFraisForfait, double unMontant) {
		this.idFraisForfait = unIdFraisForfait;
		this.libelleFraisForfait = unLibelleFraisForfait;
		this.montantFraisForfait = unMontant;
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
	 * accesseur montantFraisForfait
	 * @return montantFraisForfait
	 */
	public double getMontant() {
		return montantFraisForfait;
	}

	/**
	 * mutateur montantFraisForfait
	 * @param unMontant
	 */
	public void setMontant(double unMontant) {
		this.montantFraisForfait = unMontant;
	}

	/**
	 * Methode to string sur FraisForfait
	 */
	@Override
	public String toString() {
		return "libelleFraisForfait ="+libelleFraisForfait;
	}
}
