package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.Region;
import com.metier.Utilisateur;

public class FicheFraisTest {

	Utilisateur utilisateur, utilisateur2;
	Region region;
	FicheFrais fiche1;
	
	@Before
	public void setUp() throws Exception {
		region = new Region("1", "Pays de la Loire");
		utilisateur = new Utilisateur("Secrétaire", "S","Andre", "David", "27/03/2015", region);
		utilisateur2 = new Utilisateur("Secrétaire", "S","Smith", "John", "28/03/2015", region);
		
		fiche1 = new FicheFrais("201503", utilisateur);
		ArrayList<FraisForfait> lesFraisForfait = new ArrayList<FraisForfait>();
		
		/*FraisForfait fraisF1;
		FraisForfait fraisF1;
		FraisForfait fraisF1;
		FraisForfait fraisF1;
		
		FraisHorsForfait fraisF1;*/
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
	public void testSetUtilisateur() {
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
	
	//test accesseur montantValide
	@Test
	public void testGetMontantValide() {
		assertEquals("Test accesseur montantValide", fiche1.getMontantValide(), 0, 1000000);
	}
	
	//test mutateur montantValide
	@Test
	public void testSetMontantValide() {
		fiche1.setMontantValide(1000);
		assertEquals("Test accesseur montantValide", fiche1.getMontantValide(), 1000, 0);
	}
	
	//test accesseur dateModif
	@Test
	public void testGetDateModif() {
		assertEquals("Test accesseur montantValide", fiche1.getDateModif(), null);
	}
	
	//test mutateur montantValide
	@Test
	public void testSetDateModif() {
		fiche1.setDateModif("30/03/2015");
		assertEquals("Test accesseur montantValide", fiche1.getDateModif(), "30/03/2015");
	}
	
	//test accesseur etat
	@Test
	public void testGetEtat() {
		assertEquals("Test accesseur montantValide", fiche1.getEtat(), "CR");
	}
	
	//test mutateur etat
	@Test
	public void testSetEtat() {
		fiche1.setEtat("CL");
		assertEquals("Test accesseur montantValide", fiche1.getEtat(), "CL");
	}
	
	// test accesseur liste LigneFraisForfait
	@Test
	public void testGetListeFraisForfait() {
		
	}
	
}
