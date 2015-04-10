package com.metier;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

/**
 * Classe LigneFraisForfait
 * Gère les ligne de frais frofaitisés
 * @author couturier-d
 */
@Entity
@Table (name="lignefraisforfait")
@IdClass(LigneFraisForfaitPK.class)
@Embeddable
public class LigneFraisForfait {
	
	@Id
	@Columns(columns = {
			@Column(name = "idVisiteur",insertable=false, updatable=false),
			@Column(name = "mois",insertable=false, updatable=false),
			@Column(name = "id",insertable=false, updatable=false)
	})
	private String idVisiteur;
	private String mois;
	private String idFraisForfait;
	
	@Column(name="quantite")
	private int quantite;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idVisiteur"),
		@JoinColumn(name="mois")
	})
	private FicheFrais ficheFrais;
	
	@ManyToOne
	@JoinColumn(name="id")
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
