package com.test;

import java.util.ArrayList;
import java.util.List;

import com.metier.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegionTest {
	
	Region r, r2;
	List<Utilisateur> ensUtil = new ArrayList<Utilisateur>();
	Utilisateur u1, u2;

	@Before
	public void setUp() throws Exception {
		r = new Region("10", "Bretagne");
		r2 = new Region("1", "Pays de la Loire");
		u1 = new Utilisateur("Secrétaire", "Couturier", "David", "27/03/2015", r2);
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		r = null;
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
	
	/*@Test
	public void testGetAddUtilisateur() {
		
		assertEquals("L'accesseur sur la liste d'utilisateurs fonctionne", r.getLesUtilisateurs().size(), 0);
	}
	
	@Test
	public void testGetLesUtilisateurs() {
		assertEquals("L'accesseur sur la liste d'utilisateurs fonctionne", r.getLesUtilisateurs().size(), 0);
	}
	
	@Test
	public void testSetLesUtilisateurs() {
		assertEquals("L'accesseur sur la liste d'utilisateurs fonctionne", r.getLesUtilisateurs().size(), 1);	
	}*/

}
