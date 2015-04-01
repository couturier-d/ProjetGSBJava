package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.LigneFraisForfait;
import com.metier.Region;
import com.metier.Utilisateur;

public class LigneFraisForfaitTest {

	Utilisateur utilisateur;
	Region region;
	FicheFrais fiche, fiche2;
	
	LigneFraisForfait ligneFrais;
	FraisForfait f1;
	FraisForfait f2;
	
	@Before
	public void setUp() throws Exception {
		region = new Region("1", "Pays de la Loire");
		utilisateur = new Utilisateur("Secrétaire", "S","Andre", "David", "27/03/2015", region);
		fiche = new FicheFrais("201503", utilisateur);
		fiche2 = new FicheFrais("201504", utilisateur);
		
		f1 = new FraisForfait("KM", "Frais Kilométrique", 0.62);
		f2 = new FraisForfait("ETP", "Forfait Etape", 110);
		ligneFrais = new LigneFraisForfait("KM", 36, fiche, f1);
	}

	@After
	public void tearDown() throws Exception {
		ligneFrais = null;
		f1 = null;
		f2 = null;
	}

	@Test
	public void test() {
		assertNotNull("L'instance est créée ", ligneFrais);
	}
	
	//test accesseur id
	@Test
	public void TestGetIdFraisForfait() {
		assertEquals("Test accesseur id", ligneFrais.getIdFraisForfait(), "KM");
	}
	
	//test mutateur id (pour hibernate)
	@Test
	public void testSetIdFraisForfait() {
		ligneFrais.setIdFraisForfait("ETP");
		assertEquals("Test mutateur id", ligneFrais.getIdFraisForfait(), "ETP");
	}
	
	//test accesseur quantite
	@Test
	public void testGetQuantiteFraisForfait() {
		assertEquals("Test accesseur quantite", ligneFrais.getQuantite() , 36);
	}
	
	//test mutateur quantite
	@Test
	public void testSetQuantiteFraisForfait() {
		ligneFrais.setQuantite(26);
		assertEquals("Test mutateur quantite", ligneFrais.getQuantite(), 26);
	}
	
	//test accesseur ficheFrais
	@Test
	public void testGetFicheFrais() {
		assertEquals("Test accesseur ficheFrais", ligneFrais.getFicheFrais() , fiche);
	}
	
	//test mutateur ficheFrais
	@Test
	public void testSetFicheFrais() {
		ligneFrais.setFicheFrais(fiche2); ;
		assertEquals("Test mutateur ficheFrais", ligneFrais.getFicheFrais(), fiche2);
	}
	
	//test accesseur fraisForfait
	@Test
	public void testGetFraisForfait() {
		assertEquals("Test accesseur fraisForfait", ligneFrais.getFraisForfait(), f1);
	}
	
	//test mutateur fraisForfait
	@Test
	public void testSetFraisForfait() {
		ligneFrais.setFraisForfait(f2);;
		assertEquals("Test mutateur fraisForfait", ligneFrais.getFraisForfait(), f2);
	}

}
