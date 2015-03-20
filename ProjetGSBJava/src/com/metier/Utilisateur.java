package com.metier;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Utilisateur
 * Gère les utilisateurs 
 * @author halleguen-py
 */
public class Utilisateur {
	
	private String idUtilisateur;
	private String idTypeUtilisateur;
	private String nom;
	private String prenom;
	private String login;
	private String motDePasse;
	private String adresse;
	private String codePostal;
	private String ville;
	private String dateEmbauche;
	private String numeroPortable;
	private String numeroFixe;
	private String adresseMail;
	private Region region;

	/**
	 * Constructeur de la classe Utilisateur
	 * @param unIdTypeUtilisateur
	 * @param unNom
	 * @param unPrenom
	 * @param uneDateEmbauche
	 * @param uneRegion
	 */
	public Utilisateur(String unIdTypeUtilisateur, String unNom, String unPrenom, String uneDateEmbauche, Region uneRegion) {
		super();
		this.idUtilisateur = genererIdentifiant();
		this.idTypeUtilisateur = unIdTypeUtilisateur;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.login = genererLogin();
		this.motDePasse = genererMdp();
		this.adresse = null;
		this.codePostal = null;
		this.ville = null;
		this.dateEmbauche = uneDateEmbauche;
		this.numeroPortable = null;
		this.numeroFixe = null;
		this.adresseMail = genererMail();
		this.region = uneRegion;
	}

	/**
	 * Accesseur de l'id de l'objet Utilisateur
	 * @return idUtilisateur
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Mutateur de l'id de l'objet Utilisateur
	 * @param idUtilisateur
	 */
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Accesseur de l'id type de l'objet Utilisateur
	 * @return idTypeUtilisateur
	 */
	public String getIdTypeUtilisateur() {
		return idTypeUtilisateur;
	}

	/**
	 * Mutateur de l'id type de l'objet Utilisateur
	 * @param idTypeUtilisateur
	 */
	public void setIdTypeUtilisateur(String idTypeUtilisateur) {
		this.idTypeUtilisateur = idTypeUtilisateur;
	}

	/**
	 * Accesseur du nom de l'objet Utilisateur
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Mutateur du nom de l'objet Utilisateur
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseur du prenom de l'objet Utilisateur
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Mutateur du prenom de l'objet Utilisateur
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Accesseur du login de l'objet Utilisateur
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Mutateur du login de l'objet Utilisateur
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Accesseur du mot de passe de l'objet Utilisateur
	 * @return motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Mutateur du mot de passe de l'objet Utilisateur
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Accesseur de l'adresse de l'objet Utilisateur
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Mutateur de l'adresse de l'objet Utilisateur
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Accesseur du code postal de l'objet Utilisateur
	 * @return codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Mutateur du code postal de l'objet Utilisateur
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Accesseur de la ville de l'objet Utilisateur
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Mutateur de la ville de l'objet Utilisateur
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Accesseur de la date d'embauche de l'objet Utilisateur
	 * @return dateEmbauche
	 */
	public String getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * Mutateur de la date d'embauche de l'objet Utilisateur
	 * @param dateEmbauche
	 */
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * Accesseur du numéro de portable de l'objet Utilisateur
	 * @return numeroPortable
	 */
	public String getNumeroPortable() {
		return numeroPortable;
	}

	/**
	 * Mutateur du numéro de portable de l'objet Utilisateur
	 * @param numeroPortable
	 */
	public void setNumeroPortable(String numeroPortable) {
		this.numeroPortable = numeroPortable;
	}

	/**
	 * Accesseur du numéro fixe de l'objet Utilisateur
	 * @return numeroFixe
	 */
	public String getNumeroFixe() {
		return numeroFixe;
	}

	/**
	 * Mutateur du numéro fixe de l'objet Utilisateur
	 * @param numeroFixe
	 */
	public void setNumeroFixe(String numeroFixe) {
		this.numeroFixe = numeroFixe;
	}

	/**
	 * Accesseur de l'adresse mail de l'objet Utilisateur
	 * @return adresseMail
	 */
	public String getAdresseMail() {
		return adresseMail;
	}

	/**
	 * Mutateur de l'adresse mail de l'objet Utilisateur
	 * @param adresseMail
	 */
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	/**
	 * Accesseur de la région de l'objet Utilisateur
	 * @return region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Mutateur de la région de l'objet Utilisateur
	 * @param region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Générateur automatique de l'id d'un objet Utilisateur
	 * @return id
	 */
	private String genererIdentifiant() {
		// A MODIFIER!
		String id = "g";
		return id;
	}
	
	/**
	 * Générateur automatique du login d'un objet Utilisateur
	 * @return login
	 */
	private String genererLogin() {
		String login = this.prenom.substring(0, 0) + this.nom;
		return login;
	}
	
	/**
	 * Générateur automatique du mot de passe d'un objet Utilisateur
	 * @return mdp
	 */
	private String genererMdp() {
		String mdp = this.nom.substring(0, 3) + this.prenom.substring(0, 0) + this.dateEmbauche.substring(0, 3);
		return mdp;
	}
	
	/**
	 * Générateur automatique de l'adresse mail d'un objet Utilisateur
	 * @return mail
	 */
	private String genererMail() {
		String mail = this.nom + "." + this.prenom + "@gsb.fr";
		return mail;
	}
	
	/**
	 * Méthode toString de la classe Utilisateur
	 */
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur
				+ ", idTypeUtilisateur=" + idTypeUtilisateur + ", nom=" + nom
				+ ", prenom=" + prenom + ", login=" + login + ", motDePasse="
				+ motDePasse + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", dateEmbauche="
				+ dateEmbauche + ", numeroPortable=" + numeroPortable
				+ ", numeroFixe=" + numeroFixe + ", adresseMail=" + adresseMail
				+ ", region=" + region + "]";
	}

	
}