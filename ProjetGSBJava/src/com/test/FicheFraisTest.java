package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.LigneFraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.util.ConvertDate;

public class FicheFraisTest {

	Utilisateur utilisateur, utilisateur2;
	Region region;
	Date date1;
	Date date2;
	
	FicheFrais fiche;
	
	FraisForfait f1, f2, f3, f4;
	
	LigneFraisForfait fraisF1, fraisF2, fraisF3, fraisF4, fraisF5, fraisF6, fraisF7, fraisF8;
	LigneFraisHorsForfait fraisHF1, fraisHF2, fraisHF3, fraisHF4, fraisHF5;
	
	ArrayList<LigneFraisForfait> lesFraisForfait1, lesFraisForfait2;
	ArrayList<LigneFraisHorsForfait> lesFraisHorsForfait1, lesFraisHorsForfait2;
	
	@Before
	public void setUp() throws Exception {
		region = new Region("1", "Pays de la Loire");
		date1 = ConvertDate.toDate("27/03/2015");
		date2 = ConvertDate.toDate("28/03/2015");
		utilisateur = new Utilisateur("g01", 'S', "Andre", "David", date1, region);
		utilisateur2 = new Utilisateur("g02", 'S',"Smith", "John", date2, region);
		
		fiche = new FicheFrais("201503", utilisateur);
		
		f1 = new FraisForfait("KM", "Frais Kilométrique", 0.62);
		f2 = new FraisForfait("ETP", "Forfait Etape", 110);
		f3 = new FraisForfait("NUI", "Nuitée Hôtel", 80);
		f4 = new FraisForfait("REP", "Repas Restaurant", 25);

		fraisF1 = new LigneFraisForfait("KM", 511, fiche, f1);
		fraisF2 = new LigneFraisForfait("ETP", 6, fiche, f2);
		fraisF3 = new LigneFraisForfait("NUI", 8, fiche, f3);
		fraisF4 = new LigneFraisForfait("REP", 11, fiche, f4);
		fraisF5 = new LigneFraisForfait("KM", 701, fiche, f1);
		fraisF6 = new LigneFraisForfait("ETP", 5, fiche, f2);
		fraisF7 = new LigneFraisForfait("NUI", 10, fiche, f3);
		fraisF8 = new LigneFraisForfait("REP", 15, fiche, f4);
		
		Date date = new Date();
		
		fraisHF1 = new LigneFraisHorsForfait(1, "Restaurant avec practicien", date, 50.0, fiche);
		fraisHF2 = new LigneFraisHorsForfait(1, "parking", date, 2.50, fiche);
		fraisHF3 = new LigneFraisHorsForfait(1, "Voyage SNCF", date, 31, fiche);
		fraisHF4 = new LigneFraisHorsForfait(1, "Locationn salle conférence", date, 50.0, fiche);
		fraisHF5 = new LigneFraisHorsForfait(1, "Dinner avec médecin", date, 50.0, fiche);
		
		lesFraisForfait1 = new ArrayList<LigneFraisForfait>();
		lesFraisForfait2 = new ArrayList<LigneFraisForfait>();
		
		lesFraisHorsForfait1 = new ArrayList<LigneFraisHorsForfait>();
		lesFraisHorsForfait2 = new ArrayList<LigneFraisHorsForfait>();
		
		lesFraisForfait1.add(fraisF1);
		lesFraisForfait1.add(fraisF2);
		lesFraisForfait2.add(fraisF3);
		lesFraisForfait2.add(fraisF4);
		
		lesFraisHorsForfait1.add(fraisHF1);
		lesFraisHorsForfait1.add(fraisHF2);
		lesFraisHorsForfait2.add(fraisHF3);
		lesFraisHorsForfait2.add(fraisHF4);
		lesFraisHorsForfait2.add(fraisHF5);
		
		fiche.setListeFraisForfait(lesFraisForfait1);
		fiche.setListeFraisHorsForfait(lesFraisHorsForfait1);
		
	}

	@After
	public void tearDown() throws Exception {
		region = null;
		utilisateur = null;
		utilisateur2 = null;
		
		fiche = null;
		f1 = null;
		f2 = null;

		lesFraisForfait1 = null;
		lesFraisForfait2 = null;
		lesFraisHorsForfait1 = null;
		lesFraisHorsForfait2 = null;
		
		fraisF1 = null;
		fraisF2 = null;
		fraisF3 = null;
		fraisF4 = null;
		
		fraisHF1 = null;
		fraisHF2 = null;
		fraisHF3 = null;
		fraisHF4 = null;
		fraisHF5 = null;
	}

	//test de l'instanciation
	@Test
	public void testFicheFrais() {
		assertNotNull("L'instance est créée ", fiche);
	}
	
	//test accesseur mois
	@Test
	public void testGetMois() {
		assertEquals("Test accesseur mois", fiche.getMois(), "201503");
	}
	
	//test mutateur mois (pour hibernate)
	@Test
	public void testSetMois() {
		fiche.setMois("201504");
		assertEquals("Test accesseur mois", fiche.getMois(), "201504");
	}
	
	//test accesseur idVisiteur
	@Test
	public void testGetUtilisateur() {
		assertEquals("Test accesseur idVisiteur", fiche.getUtilisateur(), utilisateur);
	}
	
	//test mutateur idVisiteur (pour hibernate)
	@Test
	public void testSetUtilisateur() {
		fiche.setUtilisateur(utilisateur2);
		assertEquals("Test accesseur idVisiteur", fiche.getUtilisateur(), utilisateur2);
	}
	
	//test accesseur nbJustificatifs
	@Test
	public void testGetNbJustificatifs() {
		assertEquals("Test accesseur nbJustificatifs", fiche.getNbJustificatifs(), 0);
	}
	
	//test mutateur nbJustificatifs
	@Test
	public void testSetNbJustificatifs() {
		fiche.setNbJustificatifs(2);
		assertEquals("Test accesseur nbJustificatifs", fiche.getNbJustificatifs(), 2);
	}
	
	//test accesseur montantValide
	@Test
	public void testGetMontantValide() {
		assertEquals("Test accesseur montantValide", fiche.getMontantValide(), 0, 1000000);
	}
	
	//test mutateur montantValide
	@Test
	public void testSetMontantValide() {
		fiche.setMontantValide(1000);
		assertEquals("Test accesseur montantValide", fiche.getMontantValide(), 1000, 0);
	}
	
	//test accesseur dateModif
	@Test
	public void testGetDateModif() {
		assertEquals("Test accesseur montantValide", fiche.getDateModif(), null);
	}
	
	//test mutateur montantValide
	@Test
	public void testSetDateModif() {
		Date date2 = new Date();
		fiche.setDateModif(date2);
		assertEquals("Test accesseur montantValide", fiche.getDateModif(), "30/03/2015");
	}
	
	//test accesseur etat
	@Test
	public void testGetEtat() {
		assertEquals("Test accesseur montantValide", fiche.getEtat(), "CR");
	}
	
	//test mutateur etat
	@Test
	public void testSetEtat() {
		fiche.setEtat("CL");
		assertEquals("Test accesseur montantValide", fiche.getEtat(), "CL");
	}
	
	// test accesseur liste LigneFraisForfait
	@Test
	public void testGetListeFraisForfait() {
		assertEquals("Test accesseur ListeFraisForfait", fiche.getListeFraisForfait() , lesFraisForfait1);
	}
	
	// test mutateur liste LigneFraisForfait
	@Test
	public void testSetListeFraisForfait() {
		fiche.setListeFraisForfait(lesFraisForfait2);
		assertEquals("Test mutateur ListeFraisForfait", fiche.getListeFraisForfait() , lesFraisForfait2);
	}
	
	// test accesseur liste LigneFraisHorsForfait
	@Test
	public void testGetListeFraisHorsForfait() {
		assertEquals("Test accesseur ListeFraisHorsForfait", fiche.getListeFraisHorsForfait() , lesFraisHorsForfait1);
	}
	
	// test mutateur liste LigneFraisHorsForfait
	@Test
	public void testSetListeFraisHorsForfait() {
		fiche.setListeFraisHorsForfait(lesFraisHorsForfait2);
		assertEquals("Test mutateur ListeFraisHorsForfait", fiche.getListeFraisHorsForfait() , lesFraisHorsForfait2);
	}
}