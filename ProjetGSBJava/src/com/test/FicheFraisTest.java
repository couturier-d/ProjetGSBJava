package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.Region;
import com.metier.Utilisateur;

public class FicheFraisTest {

	Utilisateur utilisateur, utilisateur2;
	Region region;
	FicheFrais fiche1;
	
	@Before
	public void setUp() throws Exception {
		region = new Region("1", "Pays de la Loire");
		utilisateur = new Utilisateur("Secrétaire", "Andre", "David", "27/03/2015", region);
		utilisateur2 = new Utilisateur("Secrétaire", "Smith", "John", "28/03/2015", region);
		fiche1 = new FicheFrais("201503", utilisateur);
	}

	@After
	public void tearDown() throws Exception {
		fiche1 = null;
	}

	//test de l'instanciation
	@Test
	public void testFicheFrais() {
		assertNotNull("L'instance est créée ", fiche1);
	}
	
	//test accesseur mois
	@Test
	public void testGetMois() {
		assertEquals("Test accesseur mois", fiche1.getMois(), "201503");
	}
	
	//test mutateur mois (pour hibernate)
	@Test
	public void testSetMois() {
		fiche1.setMois("201504");
		assertEquals("Test accesseur mois", fiche1.getMois(), "201504");
	}
	
	//test accesseur idVisiteur
	@Test
	public void testGetUtilisateur() {
		assertEquals("Test accesseur idVisiteur", fiche1.getUtilisateur(), utilisateur);
	}
	
	//test mutateur idVisiteur (pour hibernate)
	@Test
	public void testSetIdVisiteur() {
		fiche1.setUtilisateur(utilisateur2);
		assertEquals("Test accesseur idVisiteur", fiche1.getUtilisateur(), utilisateur2);
	}
	
	
	//test accesseur nbJustificatifs
	@Test
	public void testGetNbJustificatifs() {
		assertEquals("Test accesseur nbJustificatifs", fiche1.getNbJustificatifs(), 0);
	}
	
	//test mutateur nbJustificatifs
	@Test
	public void testSetNbJustificatifs() {
		fiche1.setNbJustificatifs(2);
		assertEquals("Test accesseur nbJustificatifs", fiche1.getNbJustificatifs(), 2);
	}
	
	

	
}
