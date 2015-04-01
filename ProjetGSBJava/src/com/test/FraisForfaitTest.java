package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FraisForfait;

public class FraisForfaitTest {

	FraisForfait fraisForfait;
	
	@Before
	public void setUp() throws Exception {
		fraisForfait = new FraisForfait("KM", "Frais Kilométrique", 0.62);
	}

	@After
	public void tearDown() throws Exception {
		fraisForfait = null;
	}

	@Test
	public void test() {
		assertNotNull("L'instance est créée ", fraisForfait);
	}
	
	//test accesseur libelle
	@Test
	public void TestGetIdFraisForfait() {
		assertEquals("Test accesseur mois", fraisForfait.getIdFraisForfait(), "KM");
	}
	
	//test mutateur libelle (pour hibernate)
	@Test
	public void testSetIdFraisForfait() {
		fraisForfait.setLibelleFraisForfait("FKM");
		assertEquals("Test accesseur mois", fraisForfait.getLibelleFraisForfait(), "FKM");
	}
	
	//test accesseur libelle
	@Test
	public void testGetLibelleFraisForfait() {
		assertEquals("Test accesseur mois", fraisForfait.getLibelleFraisForfait(), "Frais Kilométrique");
	}
	
	//test mutateur libelle
	@Test
	public void testSetLibelleFraisForfait() {
		fraisForfait.setLibelleFraisForfait("Frais au kilomètre");
		assertEquals("Test accesseur mois", fraisForfait.getLibelleFraisForfait(), "Frais au kilomètre");
	}
	
	//test accesseur montant
	@Test
	public void testGetMontantFraisForfait() {
		assertEquals("Test accesseur mois", fraisForfait.getMontant(), 0.62, 0);
	}
	
	//test mutateur montant
	@Test
	public void testSetMontantFraisForfait() {
		fraisForfait.setMontant(0.70);
		assertEquals("Test accesseur mois", fraisForfait.getMontant(), 0.70, 0);
	}

}
