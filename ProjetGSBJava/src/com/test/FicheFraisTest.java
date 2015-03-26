package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;

public class FicheFraisTest {

	FicheFrais uneFicheFrais;
	
	@Before
	public void setUp() throws Exception {
		uneFicheFrais = new FicheFrais(201503, "a17");
	}

	@After
	public void tearDown() throws Exception {
		uneFicheFrais = null;
	}

	//test de l'instanciation
	@Test
	public void testFicheFrais() {
		assertNotNull("L'instance est créée", uneFicheFrais);
	}
	
	//test accesseur mois
	@Test
	public void testGetMois() {
		assertEquals("Test accesseur mois", uneFicheFrais.getMois(), 201503);
	}
	
	//test mutateur mois
	@Test
	public void testGetIdVisiteur() {
		assertEquals("Test accesseur idVisiteur", uneFicheFrais.getIdVisiteur(), "a17");
	}

	
}
