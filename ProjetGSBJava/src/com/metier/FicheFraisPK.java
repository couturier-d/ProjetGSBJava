package com.metier;
import javax.persistence.Embeddable;
@Embeddable
public class FicheFraisPK implements java.io.Serializable {
	private String idVisiteur;
	private String mois;
	// constructeur vide
	public FicheFraisPK() {
		super();
	}
	
	public FicheFraisPK(String idVisiteur, String mois) {
		this.idVisiteur = idVisiteur;
		this.mois = mois;
	}
	
	public String getIdVisiteur() {
		return idVisiteur;
	}
	
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	
	public String getMois() {
		return mois;
	}
	
	public void setMois(String mois) {
		this.mois = mois;
	}
	
	public boolean equals(Object obj) {
		boolean resultat = false;
		if (obj == this) {
			resultat = true;
		} else {
			if (!(obj instanceof FicheFraisPK)) {
				resultat = false;
			} else {
				FicheFraisPK autre = (FicheFraisPK) obj;
				if ((idVisiteur.equals(autre.idVisiteur)) && (mois.equals(autre.mois))) {
					resultat = true;
				} else {
					resultat = false;
				}
			}
		}
		return resultat;
	}
	
	public int hashCode() {
		return (idVisiteur + mois).hashCode();
	}
}