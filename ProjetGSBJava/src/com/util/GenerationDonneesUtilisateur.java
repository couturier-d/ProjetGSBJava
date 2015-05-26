package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.metier.Utilisateur;
import com.persistance.AccesData;

public class GenerationDonneesUtilisateur {
	public static String genererLogin(String unNom, String unPrenom) {
			unNom = unNom.toLowerCase();
			unPrenom.toLowerCase();
			String[] prenom = unPrenom.split(" ");
			String prenomAbrege = "";
			
			for(int i = 0; i < prenom.length; i++) {
				prenomAbrege = prenomAbrege + Character.toString(prenom[i].charAt(0));
			}
			
			String login = unNom + "-" + prenomAbrege;
			System.out.println("Génération d'un login : " + login);
			return login;
	}
	
	public static String genererIdentifiant() {
		List<Utilisateur>  lesUtilisateurs = AccesData.getListeUtilisateur();
		String maxId ="g000";
		
		// si il y a déjà des utilisateurs, on cherche le plus grand id
		if (lesUtilisateurs.size() > 0) 
		{
			// Création et remplissage du hashMap
			HashMap<String, Integer> lettres = new HashMap<String, Integer>();
			String[] lesLettres = {"a", "b", "c", "d", "e", "f", "g","h","i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
			int i = 0;
			while (i < lesLettres.length) {
				lettres.put(lesLettres[i], i);
				i++;
			}
			
			// Parcours de recherche de la valeure maximale
			for(Utilisateur u : lesUtilisateurs) {
				String idU = u.getIdUtilisateur();
				int indexMax = lettres.get(Character.toString(maxId.charAt(0)));
				int indexU = lettres.get(Character.toString(idU.charAt(0)));
				
				// Si l'id est plus grand alors on le prend
				if(indexU > indexMax) {
					maxId = idU + 1;
				}
			}
			
			// recherche de la deux partie de l'id sur 3 chiffres
			if (maxId.substring(1, 3) == "999") {
				// on augmente l'id d'une lettre
				maxId = lesLettres[lettres.get(maxId) + 1] + "000";
			}
		}
		
		System.out.println("Génération d'un identifiant : " + maxId);
		return maxId;
	}
	
	public static String genererMDP(String unNom, String laDateEmbauche) {
		String mdp = "my" + unNom.charAt(0) + unNom.charAt(1) + unNom.charAt(2) + laDateEmbauche.charAt(5)
				+ laDateEmbauche.charAt(6) + laDateEmbauche.charAt(8) + laDateEmbauche.charAt(9);
		System.out.println("Génération d'un mot de passe : " + mdp);
		return mdp;
	}
	
	public static String genererAdresseMail(String unNom, String unPrenom) {
		String adresseMail = unNom.toLowerCase() + "." + unPrenom.toLowerCase() + "@gsb.fr";
		System.out.println("Génération d'un e-mail : " + adresseMail);
		return adresseMail;
	}
}
