package com.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.util.ConvertDate;

public class LigneFraisHorsForfaitTest {

	Utilisateur utilisateur;
	Region region;
	Date date, date2, date3;
	FicheFrais fiche, fiche2;
	
	LigneFraisHorsForfait ligneFrais;
	FraisForfait f1;
	FraisForfait f2;
	
	@Before
	public void setUp() throws Exception {
		region = new Region("1", "Pays de la Loire");
		date = ConvertDate.toDate("27/03/2015");
		date2 = ConvertDate.toDate("18/05/2015");
		date2 = ConvertDate.toDate("19/05/2015");
		utilisateur = new Utilisateur("Secrétaire", 'S',"Andre", "David", date, region);
		fiche = new FicheFrais("201503", utilisateur);
		fiche2 = new FicheFrais("201504", utilisateur);
		
		ligneFrais = new LigneFraisHorsForfait(1, "Restaurant avec practicien", date2, 50, fiche);
	}

	@After
	public void tearDown() throws Exception {
		region = null;
		utilisateur = null;
		fiche = null;
		fiche2 = null;
		
		ligneFrais = null;
	}

	@Test
	public void test() {
		assertNotNull("Création nouvelle LigneFraisHorsForfait ", ligneFrais);
	}
	
	//test accesseur id
	@Test
	public void TestGetIdFraisForfait() {
		assertEquals("Test accesseur id", ligneFrais.getIdLigneFraisHorsForfait(), 1);
	}
	
	//test mutateur id (pour hibernate)
	@Test
	public void testSetIdFraisForfait() {
		ligneFrais.setIdLigneFraisHorsForfait(2);
		assertEquals("Test mutateur id", ligneFrais.getIdLigneFraisHorsForfait(), 2);
	}

	
	//test accesseur Libelle
	@Test
	public void testGetLibelleeFraisForfait() {
		assertEquals("Test accesseur quantite", ligneFrais.getLibelleFraisHorsForfait() , "Restaurant avec practicien");
	}
	
	//test mutateur Libelle
	@Test
	public void testSetLibelleFraisForfait() {
		ligneFrais.setLibelleFraisHorsForfait("Location voiture");
		assertEquals("Test mutateur quantite", ligneFrais.getLibelleFraisHorsForfait(), "Location voiture");
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
	
	//test accesseur date
	@Test
	public void testGetDateFraisForfait() {
		assertEquals("Test accesseur quantite", ligneFrais.getDate() , date2);
	}
	
	//test mutateur date
	@Test
	public void testSetDateFraisForfait() {
		ligneFrais.setDate(date3);
		assertEquals("Test mutateur quantite", ligneFrais.getDate(), date3);
	}
	
	//test accesseur montant
	@Test
	public void testGetMontantFraisForfait() {
		assertEquals("Test accesseur quantite", ligneFrais.getMontant() , 50, 0);
	}
		
	//test mutateur montant
	@Test
	public void testSetMontantFraisForfait() {
		ligneFrais.setMontant(60);
		assertEquals("Test mutateur quantite", ligneFrais.getMontant(), 60, 0);
	}
	
}