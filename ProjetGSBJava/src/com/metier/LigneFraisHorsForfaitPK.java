package com.metier;
import javax.persistence.Embeddable;
@Embeddable
public class LigneFraisHorsForfaitPK implements java.io.Serializable {
	private int idLigneFraisHorsForfait;
	private FicheFrais ficheFrais;
	// constructeur vide
	public LigneFraisHorsForfaitPK() {
		super();
	}
	
	public LigneFraisHorsForfaitPK(int idLigneFraisHorsForfait, FicheFrais ficheFrais) {
		this.idLigneFraisHorsForfait = idLigneFraisHorsForfait;
		this.ficheFrais = ficheFrais;
	}
	
	public int getIdLigneFraisHorsForfait() {
		return idLigneFraisHorsForfait;
	}

	public void setIdLigneFraisHorsForfait(int idFraisHorsForfait) {
		this.idLigneFraisHorsForfait = idFraisHorsForfait;
	}
	
	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}
	
	public boolean equals(Object obj) {
		boolean resultat = false;
		if (obj == this) {
			resultat = true;
		} else {
			if (!(obj instanceof FicheFraisPK)) {
				resultat = false;
			} else {
				LigneFraisHorsForfaitPK autre = (LigneFraisHorsForfaitPK) obj;
				if ((Integer.toString(idLigneFraisHorsForfait).equals(autre.idLigneFraisHorsForfait)) && (ficheFrais.equals(autre.ficheFrais))) {
					resultat = true;
				} else {
					resultat = false;
				}
			}
		}
		return resultat;
	}
	
	public int hashCode() {
		return (Integer.toString(idLigneFraisHorsForfait) + ficheFrais).hashCode();
	}
}