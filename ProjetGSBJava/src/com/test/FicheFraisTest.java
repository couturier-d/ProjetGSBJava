package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;

public class FicheFraisTest {

	FicheFrais fiche1;
	
	@Before
	public void setUp() throws Exception {
		fiche1 = new FicheFrais(201503, "a17");
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
		assertEquals("Test accesseur mois", fiche1.getMois(), 201503);
	}
	
	//test mutateur mois (pour hibernate)
	@Test
	public void testSetMois() {
		fiche1.setMois(201504);
		assertEquals("Test accesseur mois", fiche1.getMois(), 201504);
	}
	
	//test accesseur idVisiteur
	@Test
	public void testGetIdVisiteur() {
		assertEquals("Test accesseur idVisiteur", fiche1.getIdVisiteur(), "a17");
	}
	
	//test mutateur idVisiteur (pour hibernate)
	@Test
	public void testsetIdVisiteur() {
		fiche1.setIdVisiteur("a18");
		assertEquals("Test accesseur idVisiteur", fiche1.getIdVisiteur(), "a18");
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
