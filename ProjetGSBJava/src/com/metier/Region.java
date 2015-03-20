package com.metier;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Region
 * Gère l'ensemble des regions couvertes par GSB
 * @author halleguen-py
 */
public class Region {
	
	private String idRegion;
	private String nomRegion;
	private List<Utilisateur> listeUtilisateur;

	/**
	 * Constructeur de la classe Region
	 * @param unIdRegion
	 * @param unNomRegion
	 */
	public Region(String unIdRegion, String unNomRegion) {
		super();
		this.idRegion = unIdRegion;
		this.nomRegion = unNomRegion;
		this.listeUtilisateur = new ArrayList<Utilisateur>();
	}

	/**
	 * Accesseur de l'id de l'objet Region
	 * @return idRegion
	 */
	public String getIdRegion() {
		return idRegion;
	}
	
	/**
	 * Mutateur de l'id de l'objet Region (uniquement pour hibernate)
	 * @param idRegion
	 */
	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}
	
	/**
	 * Accesseur du nom de l'objet Region
	 * @return nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}
	
	/**
	 * Mutateur du nom de l'objet Region
	 * @param nomRegion
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	
	/**
	 * Accesseur de la liste d'utilisateurs de l'objet Region
	 * @return listeUtilisateur
	 */
	public List<Utilisateur> getLesUtilisateurs() {
		return listeUtilisateur;
	}
	
	/**
	 * Mutateur de la liste d'utilisateurs de l'objet Region
	 * @param listeUtilisateur
	 */
	public void setLesUtilisateurs(List<Utilisateur> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}
	
	/**
	 * Accesseur de l'utilisateur de l'objet Region, en fonction de son index
	 * @param index
	 * @return listeUtilisateur.get(index)
	 */
	public Utilisateur getUnUtilisateur(int index) {
		return listeUtilisateur.get(index);
	}
	
	/**
	 * Accesseur de l'utilisateur de l'objet Region, en fonction de son id
	 * @param idUtilisateur
	 * @return resultat
	 */
	public Utilisateur getUnUtilisateur(String idUtilisateur) {
		Utilisateur resultat = null;
		for(Utilisateur util : listeUtilisateur) {
			if(util.getIdUtilisateur() == idUtilisateur) {
				resultat = util;
			}
		}
		return resultat;
	}

	/**
	 * Accesseur de la taille de la liste d'utilisateurs de l'objet Region
	 * @return taille
	 */
	public int getNbUtilisateurs() {
		return listeUtilisateur.size();
	}
	
	/**
	 * Méthode toString de la classe Region
	 */
	@Override
	public String toString() {
		return "Region [idRegion=" + idRegion + ", nomRegion=" + nomRegion
				+ ", listeUtilisateur=" + listeUtilisateur + "]";
	}
	
	
}
