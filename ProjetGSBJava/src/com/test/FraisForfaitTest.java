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
	
	//test accesseur id
	@Test
	public void TestGetIdFraisForfait() {
		assertEquals("Test accesseur id", fraisForfait.getIdFraisForfait(), "KM");
	}
	
	//test mutateur id (pour hibernate)
	@Test
	public void testSetIdFraisForfait() {
		fraisForfait.setIdFraisForfait("FKM");
		assertEquals("Test mutateur id", fraisForfait.getIdFraisForfait(), "FKM");
	}
	
	//test accesseur libelle
	@Test
	public void testGetLibelleFraisForfait() {
		assertEquals("Test accesseur libelle", fraisForfait.getLibelleFraisForfait(), "Frais Kilométrique");
	}
	
	//test mutateur libelle
	@Test
	public void testSetLibelleFraisForfait() {
		fraisForfait.setLibelleFraisForfait("Frais au kilomètre");
		assertEquals("Test mutateur libelle", fraisForfait.getLibelleFraisForfait(), "Frais au kilomètre");
	}
	
	//test accesseur montant
	@Test
	public void testGetMontantFraisForfait() {
		assertEquals("Test accesseur montant", fraisForfait.getMontant(), 0.62, 0);
	}
	
	//test mutateur montant
	@Test
	public void testSetMontantFraisForfait() {
		fraisForfait.setMontant(0.70);
		assertEquals("Test mutateur montant", fraisForfait.getMontant(), 0.70, 0);
	}
}