package com.metier;

public class LigneFraisForfaitPK implements java.io.Serializable {
	private String idVisiteur;
	private String mois;
	private String idFraisForfait;
	// constructeur vide
	public LigneFraisForfaitPK() {
		super();
	}
	public LigneFraisForfaitPK(String idVisiteur, String mois, String idFraisForfait) {
		this.idVisiteur = idVisiteur;
		this.mois = mois;
		this.idFraisForfait = idFraisForfait;
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
	
	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}
	
	public boolean equals(Object obj) {
		boolean resultat = false;
		if (obj == this) {
				resultat = true;
		}
		else
		{
			if (!(obj instanceof LigneFraisForfaitPK)) {
				resultat = false;
			}
			else
			{
				LigneFraisForfaitPK autre = (LigneFraisForfaitPK) obj;
				if ((idVisiteur.equals(autre.idVisiteur)) && (mois.equals(autre.mois) && (idFraisForfait.equals(autre.idFraisForfait))))
				{
					resultat = true;
				}
				else
				{
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
