package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe TypeUtilisateur
 * @author Couturier-d
 *
 */
@Entity
@Table (name="typeutilisateur")
public class TypeUtilisateur {
	@Id
	@Column(name="idTypeUtilisateur")
	private Character idType;
	
	@Column(name="libelleTypeUtilisateur")
	private String libelleType;
	
	/**
	 * Constructeur vide pour hibernate
	 */
	public TypeUtilisateur() {
		super();
	}
	
	/**
	 * Constructeur de la classe TypeUtilisateur
	 * @param unIdType
	 * @param unLibelleType
	 */
	public TypeUtilisateur (Character unIdType, String unLibelleType) {
		super();
		this.idType = unIdType;
		this.libelleType = unLibelleType;
	}
	
	/**
	 * Accesseur idType
	 * @return idTypeUtilisateur
	 */
	public Character getIdType() {
		return idType;
	}
	
	/**
	 * Mutateur idType
	 * @param idType
	 */
	public void setIdType(Character idType) {
		this.idType = idType;
	}

	/**
	 * Accesseur libelleType
	 * @return libelleTypeUtilisateur
	 */
	public String getLibelleType() {
		return libelleType;
	}

	/**
	 * Mutateur libelleType
	 * @param libelleType
	 */
	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}

	@Override
	public String toString() {
		return "TypeUtilisateur [idType=" + idType + ", libelleType="
				+ libelleType + "]";
	}
	
}
