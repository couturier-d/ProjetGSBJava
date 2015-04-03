package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.*;

public class UtilisateurTest {
	
	Region r, r2;
	Utilisateur u, u2;
	List<FicheFrais> ensFiches = new ArrayList<FicheFrais>();
	List<FicheFrais> ensFiches2 = new ArrayList<FicheFrais>();
	FicheFrais f, f2;

	@Before
	public void setUp() throws Exception {
		r = new Region("10", "Bretagne");
		r2 = new Region("1", "Pays de la Loire");
		u = new Utilisateur("g001", "Secrétaire", "Couturier", "David", "27/03/2015", r);
		u2 = new Utilisateur("g002", "Troll", "Truillet", "Adrien", "27/03/2015", r);
		f = new FicheFrais("201503", u);
		f2 = new FicheFrais("201504", u);
		ensFiches.add(f);
		ensFiches.add(f2);
	}

	@After
	public void tearDown() throws Exception {
		f = null;
		f2 = null;
		u2 = null;
		u = null;
		r = null;
		r2 = null;
	}

	@Test
	public void testUtilisateur() {
		assertNotNull("L'instance est créée", u);
	}

	@Test
	public void testGetIdUtilisateur() {
		assertEquals("L'accesseur sur l'id fonctionne", u.getIdUtilisateur(), "g001");
	}
	
	@Test
	public void testSetIdUtilisateur() {
		u.setIdUtilisateur("g002");
		assertEquals("Le mutateur sur l'id fonctionne", u.getIdUtilisateur(), "g002");
	}
	
	@Test
	public void testGetIdTypeUtilisateur() {
		assertEquals("L'accesseur sur l'id du type d'utilisateur fonctionne", u.getIdTypeUtilisateur(), "Secrétaire");
	}
	
	@Test
	public void testSetIdTypeUtilisateur() {
		u.setIdTypeUtilisateur("Secrétaire en chef");
		assertEquals("Le mutateur sur l'id du type d'utilisateur fonctionne", u.getIdTypeUtilisateur(), "Secrétaire en chef");
	}
	
	@Test
	public void testGetNom() {
		assertEquals("L'accesseur sur le nom fonctionne", u.getNom(), "Couturier");
	}
	
	@Test
	public void testSetNom() {
		u.setNom("Hallyday");
		assertEquals("Le mutateur sur le nom fonctionne", u.getNom(), "Hallyday");
	}
	
	@Test
	public void testGetPrenom() {
		assertEquals("L'accesseur sur le prénom fonctionne", u.getPrenom(), "David");
	}
	
	@Test
	public void testSetPrenom() {
		u.setPrenom("Grand");
		assertEquals("Le mutateur sur le prénom fonctionne", u.getPrenom(), "Grand");
	}
	
	@Test
	public void testGetLogin() {
		assertEquals("L'accesseur sur le login fonctionne", u.getLogin(), null);
	}
	
	@Test
	public void testSetLogin() {
		u.setLogin("dcouturier");
		assertEquals("Le mutateur sur le login fonctionne", u.getLogin(), "dcouturier");
	}
	
	@Test
	public void testGetMotDePasse() {
		assertEquals("L'accesseur sur le mot de passe fonctionne", u.getMotDePasse(), null);
	}
	
	@Test
	public void testSetMotDePasse() {
		u.setMotDePasse("coutd2015");
		assertEquals("Le mutateur sur le mot de passe fonctionne", u.getMotDePasse(), "coutd2015");
	}
	
	@Test
	public void testGetAdresse() {
		assertEquals("L'accesseur sur l'adresse fonctionne", u.getAdresse(), null);
	}
	
	@Test
	public void testSetAdresse() {
		u.setAdresse("Saint-Louis");
		assertEquals("Le mutateur sur l'adresse fonctionne", u.getAdresse(), "Saint-Louis");
	}
	
	@Test
	public void testGetCodePostal() {
		assertEquals("L'accesseur sur le code postal fonctionne", u.getCodePostal(), null);
	}
	
	@Test
	public void testSetCodePostal() {
		u.setCodePostal("29150");
		assertEquals("Le mutateur sur le code postal fonctionne", u.getCodePostal(), "29150");
	}
	
	@Test
	public void testGetVille() {
		assertEquals("L'accesseur sur la ville fonctionne", u.getVille(), null);
	}
	
	@Test
	public void testSetVille() {
		u.setVille("Chateaulin");
		assertEquals("Le mutateur sur la ville fonctionne", u.getVille(), "Chateaulin");
	}
	
	@Test
	public void testGetDateEmbauche() {
		assertEquals("L'accesseur sur la date d'embauche fonctionne", u.getDateEmbauche(), "27/03/2015");
	}
	
	@Test
	public void testSetDateEmbauche() {
		u.setDateEmbauche("31/03/2015");
		assertEquals("Le mutateur sur la date d'embauche fonctionne", u.getDateEmbauche(), "31/03/2015");
	}
	
	@Test
	public void testGetNumeroPortable() {
		assertEquals("L'accesseur sur le numéro de portable fonctionne", u.getNumeroPortable(), null);
	}
	
	@Test
	public void testSetNumeroPortable() {
		u.setNumeroPortable("0699019802");
		assertEquals("Le mutateur sur le numéro de portable fonctionne", u.getNumeroPortable(), "0699019802");
	}
	
	@Test
	public void testGetNumeroFixe() {
		assertEquals("L'accesseur sur le numéro fixe fonctionne", u.getNumeroFixe(), null);
	}
	
	@Test
	public void testSetNumeroFixe() {
		u.setNumeroFixe("0297039604");
		assertEquals("Le mutateur sur le numéro fixe fonctionne", u.getNumeroFixe(), "0297039604");
	}
	
	@Test
	public void testGetAdresseMail() {
		assertEquals("L'accesseur sur l'adresse mail fonctionne", u.getAdresseMail(), null);
	}
	
	@Test
	public void testSetAdresseMail() {
		u.setAdresseMail("couturier-david@gsb.fr");
		assertEquals("Le mutateur sur l'adresse mail fonctionne", u.getAdresseMail(), "couturier-david@gsb.fr");
	}
	
	@Test
	public void testGetRegion() {
		assertEquals("L'accesseur sur la région fonctionne", u.getRegion(), r);
	}
	
	@Test
	public void testSetRegion() {
		u.setRegion(r2);
		assertEquals("Le mutateur sur la région fonctionne", u.getRegion(), r2);
	}
	
	@Test
	public void testGetLesFichesFrais() {
		assertEquals("L'accesseur sur la liste de fiches de frais fonctionne", u.getLesFichesFrais().size(), 0);
	}
	
	@Test
	public void testSetLesFichesFrais() {
		ensFiches2.add(f);
		u.setLesFichesFrais(ensFiches2);
		assertEquals("Le nombre d'utilisateurs dans la nouvelle liste est correct", u.getLesFichesFrais().size(), 1);
		assertEquals("L'accesseur sur la liste de fiches de frais fonctionne", u.getLesFichesFrais().get(0), f);	
	}
	
	@Test
	public void testGetUneFicheFraisId() {
		u.setLesFichesFrais(ensFiches);
		assertEquals("La 1ere fiche de frais est correcte", u.getUneFicheFrais(0), f);
		assertEquals("L'accesseur sur une fiche de frais en fonction de l'id fonctionne", u.getUneFicheFrais(1), f2);
	}

	@Test
	public void testGetUneFicheFraisMois() {
		u.setLesFichesFrais(ensFiches);
		assertEquals("Le test sur une fiche de frais inexistant fonctionne", u.getUneFicheFrais("201401"), null);
		assertEquals("La 1ere fiche de frais est correcte", u.getUneFicheFrais("201503"), f);
		assertEquals("L'accesseur sur une fiche de frais en fonction du mois fonctionne", u.getUneFicheFrais("201504"), f2);
	}
	
	@Test
	public void testGetNbFicheFrais() {
		u.setLesFichesFrais(ensFiches);
		assertEquals("Le cas où aucune fiche de frais n'existe est traité", u2.getNbFicheFrais(), 0);
		assertEquals("L'accesseur sur le nombre de fiches de frais fonctionne", u.getNbFicheFrais(), 2);
	}
}
