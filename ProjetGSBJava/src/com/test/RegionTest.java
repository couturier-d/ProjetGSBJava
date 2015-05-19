package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metier.*;
import com.util.ConvertDate;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegionTest {
	
	Region r, r2;
	Date date, date2;
	List<Utilisateur> ensUtil = new ArrayList<Utilisateur>();
	List<Utilisateur> ensUtil2 = new ArrayList<Utilisateur>();
	Utilisateur u1, u2;

	@Before
	public void setUp() throws Exception {
		r = new Region("10", "Bretagne");
		r2 = new Region("1", "Pays de la Loire");
		date = ConvertDate.toDate("27/03/2015");
		date2 = ConvertDate.toDate("28/03/2015");
		u1 = new Utilisateur("g01", 'C', "Couturier", "David", date, r2);
		u2 = new Utilisateur("g02", 'S', "Truillet", "Adrien", date2, r2);
		ensUtil2.add(u1);
		ensUtil2.add(u2);
	}

	@After
	public void tearDown() throws Exception {
		ensUtil = null;
		ensUtil2 = null;
		u2 = null;
		u1 = null;
		r = null;
		r2 = null;
		date = date2 = null;
	}

	@Test
	public void testRegion() {
		assertNotNull("L'instance est créée", r);
	}
	
	@Test
	public void testGetIdRegion() {
		assertEquals("L'accesseur sur l'id fonctionne", r.getIdRegion(), "10");
	}
	
	@Test
	public void testSetIdRegion() {
		r.setIdRegion("11");
		assertEquals("Le modificateur sur l'id fonctionne", r.getIdRegion(), "11");
	}
	
	@Test
	public void testGetNomRegion() {
		assertEquals("L'accesseur sur le nom fonctionne", r.getNomRegion(), "Bretagne");
	}
	
	@Test
	public void testSetNomRegion() {
		r.setNomRegion("Pleyben");
		assertEquals("Le modificateur sur le nom fonctionne", r.getNomRegion(), "Pleyben");
	}
	
	@Test
	public void testAddUtilisateur() {
		r.addUtilisateur(u1);
		assertEquals("Le test sur la région de l'utilisateur fonctionne", r.getLesUtilisateurs().size(), 0);
		r2.addUtilisateur(u1);
		assertEquals("La méthode d'ajout d'un utilisateur fonctionne", r2.getLesUtilisateurs().size(), 1);
	}
	
	@Test
	public void testGetLesUtilisateurs() {
		assertEquals("L'accesseur sur la liste d'utilisateurs fonctionne", r.getLesUtilisateurs().size(), 0);
	}
	
	@Test
	public void testSetLesUtilisateurs() {
		ensUtil.add(u2);
		r2.setLesUtilisateurs(ensUtil);
		assertEquals("Le nombre d'utilisateurs dans la nouvelle liste est correct", r2.getLesUtilisateurs().size(), 1);
		assertEquals("L'accesseur sur la liste d'utilisateurs fonctionne", r2.getLesUtilisateurs().get(0), u2);	
	}
	
	@Test
	public void testGetUnUtilisateurId() {
		r.setLesUtilisateurs(ensUtil2);
		assertEquals("Le 1er utilisateur est correct", r.getUnUtilisateur(0), u1);
		assertEquals("L'accesseur sur un utilisateur en fonction de l'id fonctionne", r.getUnUtilisateur(1), u2);
	}

	@Test
	public void testGetUnUtilisateurIndex() {
		r.setLesUtilisateurs(ensUtil2);
		assertEquals("Le test sur un utilisateur inexistant fonctionne", r.getUnUtilisateur("g1"), null);
		assertEquals("Le 1er utilisateur est correct", r.getUnUtilisateur("g01"), u1);
		assertEquals("L'accesseur sur un utilisateur en fonction de l'index fonctionne", r.getUnUtilisateur("g02"), u2);
	}
	
	@Test
	public void testGetNbUtilisateurs() {
		r.setLesUtilisateurs(ensUtil2);
		assertEquals("Le cas où aucun utilisateur n'existe est traité", r2.getNbUtilisateurs(), 0);
		assertEquals("L'accesseur sur le nombre d'utilisateurs fonctionne", r.getNbUtilisateurs(), 2);
	}
}
