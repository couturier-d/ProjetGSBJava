package com.test;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.LigneFraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.persistance.AccesData;
import com.util.ConvertDate;

public class AccesDataTest {
	
	FicheFrais laFiche;
	FraisForfait fraisForfait;
	LigneFraisForfait ligneFraisForfait;
	LigneFraisHorsForfait ligneFraisHorsForfait;
	Region laRegion;
	Utilisateur utilisateur;
	
	private List<Utilisateur> listeUtilisateur;
	private List<Region> listeRegion;
	
	private static List<FicheFrais> listeFichesFrais;
	private static List<FraisForfait> listeFraisForfait;
	
	private static List<LigneFraisForfait> listeLigneFraisForfait;
	private static List<LigneFraisHorsForfait> listeLigneFraisHorsForfait;
	
	@Test
	public void getListeRegionTest() {
		listeRegion = AccesData.getListeRegion();
		assertNotNull("test chargement liste regions", listeRegion);
		assertEquals("test nb region", listeRegion.size(), 27);
		
		assertEquals(listeRegion.get(0).getIdRegion(), "1");
		assertEquals(listeRegion.get(0).getNomRegion(), "Alsace");
		assertEquals(listeRegion.get(1).getIdRegion(), "10");
		assertEquals(listeRegion.get(1).getNomRegion(), "Franche Comte");
		assertEquals(listeRegion.get(2).getIdRegion(), "11");
		assertEquals(listeRegion.get(2).getNomRegion(), "Haute Normandie");
	}
	
	@Test
	public void getListeUtilisateurTest() {
		listeUtilisateur = AccesData.getListeUtilisateur();
		//Date dateembauche = ConvertDate.toDate("21/12/2005");
		assertNotNull("test chargement liste utilisateurs", listeUtilisateur);
		assertEquals("test nb utilisateurs", listeUtilisateur.size(), 27);
		
		
		assertEquals(listeUtilisateur.get(0).getIdUtilisateur(), "a131");
		assertEquals(listeUtilisateur.get(0).getIdTypeUtilisateur().toString(), "V");
		assertEquals(listeUtilisateur.get(0).getNom(), "Villechalane");
		assertEquals(listeUtilisateur.get(0).getPrenom(), "Louis");
		assertEquals(listeUtilisateur.get(0).getLogin(), "lvillachane");
		//assertEquals(listeUtilisateur.get(0).getDateEmbauche(), dateembauche);
		assertEquals(listeUtilisateur.get(0).getRegion().getIdRegion(), "16");
		assertEquals(listeUtilisateur.get(0).getRegion().getNomRegion(), "Midi-Pyrénées");
		assertEquals(listeUtilisateur.get(1).getIdUtilisateur(), "a17");
		assertEquals(listeUtilisateur.get(1).getIdTypeUtilisateur().toString(), "V");
		assertEquals(listeUtilisateur.get(1).getNom(), "Andre");
		assertEquals(listeUtilisateur.get(1).getPrenom(), "David");
		assertEquals(listeUtilisateur.get(1).getLogin(), "dandre");
		//assertEquals(listeUtilisateur.get(1).getDateEmbauche(), ConvertDate.toDate("1998/11/23"));
		assertEquals(listeUtilisateur.get(1).getRegion().getIdRegion(), "16");
		assertEquals(listeUtilisateur.get(1).getRegion().getNomRegion(), "Midi-Pyrénées");
	}
	
	
	@Test
	public void getListeFicheFraisTest() {
		listeFichesFrais = AccesData.getListeFicheFrais();
		assertNotNull("test chargement liste fiches frais", listeFichesFrais);
		assertEquals("test nb fiches frais", listeFichesFrais.size(), 570);
	
		assertEquals(listeFichesFrais.get(0).getIdVisiteur(), "a131");
		assertEquals(listeFichesFrais.get(0).getMois(), "201301");
		assertEquals(listeFichesFrais.get(0).getNbJustificatifs(), 0);
		assertEquals(listeFichesFrais.get(0).getMontantValide(), 2037.76, 0);
		assertEquals(listeFichesFrais.get(0).getEtat(), "RB");
		assertEquals(listeFichesFrais.get(19).getIdVisiteur(), "a131");
		assertEquals(listeFichesFrais.get(19).getMois(), "201408");
		assertEquals(listeFichesFrais.get(19).getNbJustificatifs(), 10);
		assertEquals(listeFichesFrais.get(19).getMontantValide(), 4471.32, 0);
		assertEquals(listeFichesFrais.get(19).getEtat(), "VA");
	}
	
	@Test
	public void getListeFraisForfaitTest() {
		listeFraisForfait = AccesData.getListeFraisForfait();
		assertNotNull("test chargement liste frais forfait", listeFraisForfait);
		
		assertEquals("nb frais forfait", listeFraisForfait.size(), 4);
		assertEquals(listeFraisForfait.get(0).getIdFraisForfait(), "ETP");
		assertEquals(listeFraisForfait.get(0).getLibelleFraisForfait(), "Forfait Etape");
		assertEquals(listeFraisForfait.get(0).getMontant(), 110.00, 0);
		assertEquals(listeFraisForfait.get(1).getIdFraisForfait(), "KM");
		assertEquals(listeFraisForfait.get(1).getLibelleFraisForfait(), "Frais Kilométrique");
		assertEquals(listeFraisForfait.get(1).getMontant(), 0.62, 0);
	}
	
	@Test
	public void getListeLigneFraisForfaitTest() {
	listeLigneFraisForfait = AccesData.getListeLigneFraisForfait();
	assertNotNull("test chargement liste ligne frais forfait", listeLigneFraisForfait);
	
	assertEquals("nb ligne frais forfait", listeLigneFraisForfait.size(), 2276);
	assertEquals(listeLigneFraisForfait.get(0).getIdFraisForfait(), "ETP");
	assertEquals(listeLigneFraisForfait.get(0).getQuantite(), 6);
	assertEquals(listeLigneFraisForfait.get(0).getFicheFrais().getIdVisiteur(), "a131");
	assertEquals(listeLigneFraisForfait.get(0).getFicheFrais().getMois(), "201301");
	assertEquals(listeLigneFraisForfait.get(750).getIdFraisForfait(), "NUI");
	assertEquals(listeLigneFraisForfait.get(750).getQuantite(), 3);
	assertEquals(listeLigneFraisForfait.get(750).getFicheFrais().getIdVisiteur(), "b28");
	assertEquals(listeLigneFraisForfait.get(750).getFicheFrais().getMois(), "201407");
	}
	
	@Test
	public void getListeLigneFraisHorsForfaitTest() {
		listeLigneFraisHorsForfait = AccesData.getListeLigneFraisHorsForfait();
		assertNotNull("test chargement liste ligne frais hors forfait", listeLigneFraisHorsForfait);
		
		assertEquals("nb ligne frais hors forfait", listeLigneFraisHorsForfait.size(), 79260);
		assertEquals(listeLigneFraisHorsForfait.get(0).getIdLigneFraisHorsForfait(), 3885);
		assertEquals(listeLigneFraisHorsForfait.get(0).getLibelleFraisHorsForfait(), "traiteur, alimentation, boisson");
		assertEquals(listeLigneFraisHorsForfait.get(0).getMontant(), 133.00, 0);
		assertEquals(listeLigneFraisHorsForfait.get(0).getFicheFrais().getIdVisiteur(), "a131");
		assertEquals(listeLigneFraisHorsForfait.get(0).getFicheFrais().getMois(), "201301");
		assertEquals(listeLigneFraisHorsForfait.get(14).getIdLigneFraisHorsForfait(), 3899);
		assertEquals(listeLigneFraisHorsForfait.get(14).getLibelleFraisHorsForfait(), "location salle conférence");
		assertEquals(listeLigneFraisHorsForfait.get(14).getMontant(), 184.00, 0);
		assertEquals(listeLigneFraisHorsForfait.get(14).getFicheFrais().getIdVisiteur(), "a131");
		assertEquals(listeLigneFraisHorsForfait.get(14).getFicheFrais().getMois(), "201302");
	}

	@Test
	public void getFicheFraisTest() {
		laFiche = AccesData.getFicheFrais("a55", "201307");
		assertNotNull("test chargement fiche frais", laFiche);

		assertEquals(laFiche.getIdVisiteur(), "a55");
		assertEquals(laFiche.getMois(), "201307");
		assertEquals(laFiche.getNbJustificatifs(), 12);
		assertEquals(laFiche.getMontantValide(), 7023.48, 0);
		assertEquals(laFiche.getEtat(), "RB");
	}
	
	@Test
	public void getFraisForfaitTest() {
		fraisForfait = AccesData.getFraisForfait("ETP");
		assertNotNull("test chargement frais forfait", fraisForfait);

		assertEquals(fraisForfait.getIdFraisForfait(), "ETP");
		assertEquals(fraisForfait.getLibelleFraisForfait(), "Forfait Etape");
		assertEquals(fraisForfait.getMontant(), 110.00, 0);
	}
	
	@Test
	public void getLigneFraisForfaitTest() {
		ligneFraisForfait = AccesData.getLigneFraisForfait("a93", "201310", "NUI");
		assertNotNull("test chargement ligne frais forfait", ligneFraisForfait);

		assertEquals(ligneFraisForfait.getIdFraisForfait(), "NUI");
		assertEquals(ligneFraisForfait.getQuantite(), 10);
		assertEquals(ligneFraisForfait.getFicheFrais().getIdVisiteur(), "a93");
		assertEquals(ligneFraisForfait.getFicheFrais().getMois(), "201310");
	}
	
	@Test
	public void getLigneFraisHorsForfaitTest() {
		ligneFraisHorsForfait = AccesData.getLigneFraisHorsForfait(3892);
		assertNotNull("test chargement ligne frais hors forfait", ligneFraisHorsForfait);

		assertEquals(ligneFraisHorsForfait.getIdLigneFraisHorsForfait(), 3892);
		assertEquals(ligneFraisHorsForfait.getLibelleFraisHorsForfait(), "location équipement vidéo/sonore");
		assertEquals(ligneFraisHorsForfait.getMontant(), 813.00, 0);
		assertEquals(ligneFraisHorsForfait.getFicheFrais().getIdVisiteur(), "a131");
		assertEquals(ligneFraisHorsForfait.getFicheFrais().getMois(), "201301");
	}
	
	@Test
	public void getRegionTest() {
		laRegion = AccesData.getRegion("6");
		assertNotNull("test chargement region", laRegion);

		assertEquals(laRegion.getIdRegion(), "6");
		assertEquals(laRegion.getNomRegion(), "Bretagne");
	}
	
	@Test
	public void getUtilisateurTest() {
		utilisateur = AccesData.getUtilisateur("b13");
		assertNotNull("test chargement utilisateur", utilisateur);

		assertEquals(utilisateur.getIdUtilisateur(), "b13");
		assertEquals(utilisateur.getIdTypeUtilisateur().toString(), "V");
		assertEquals(utilisateur.getNom(), "Bentot");
		assertEquals(utilisateur.getPrenom(), "Pascal");
		assertEquals(utilisateur.getLogin(), "pbentot");
		assertEquals(utilisateur.getRegion().getIdRegion(), "16");
		assertEquals(utilisateur.getRegion().getNomRegion(), "Midi-Pyrénées");
		
	}
	
	@Test
	public void addDeleteFicheFraisTest() {
		Utilisateur u = AccesData.getUtilisateur("a131");
		FicheFrais f = new FicheFrais("202401", u);
		f.setIdVisiteur(u.getIdUtilisateur());
		assertTrue(AccesData.addFicheFrais(f));
		//Cas de suppression non fonctionnel, car problème de clé étrangère dans la bdd (problème repéré chez plusieurs binômes)
	}
	
	@Test
	public void updateFicheFraisTest() {
		FicheFrais f = AccesData.getFicheFrais("a131", "202401");
		f.setEtat("CR");
		assertTrue(AccesData.updateFicheFrais(f));
	}
	
	@Test
	public void addDeleteFraisForfaitTest() {
		FraisForfait f = new FraisForfait("COV", "Covoiturage", 10.00);
		assertTrue(AccesData.addFraisForfait(f));
		assertTrue(AccesData.deleteFraisForfait(f));
	}
	
	@Test
	public void updateFraisForfaitTest() {
		FraisForfait f = AccesData.getFraisForfait("ETP");
		f.setLibelleFraisForfait("Forfait Etape");
		assertTrue(AccesData.updateFraisForfait(f));
	}
//	public void updateLigneFraisForfaitTest(LigneFraisForfait l){
//	}
	
	@Test
	public void addDeleteLigneFraisForfaitTest() {
		FicheFrais f = AccesData.getFicheFrais("a131", "202401");
		FraisForfait f2 = AccesData.getFraisForfait("ETP");
		LigneFraisForfait l = new LigneFraisForfait("ETP", 100, f, f2);
		assertTrue(AccesData.addLigneFraisForfait(l));
		assertTrue(AccesData.deleteLigneFraisForfait(l));
	}
//	public void addLigneFraisHorsForfaitTest(LigneFraisHorsForfait l) {
//	}
//	public void deleteLigneFraisHorsForfaitTest(LigneFraisHorsForfait l) {
//	}
//	public void updateLigneFraisHorsForfaitTest(LigneFraisHorsForfait l) {
//	}
//	public void addRegionTest(Region r) {
//	}
//	public void deleteRegionTest(Region r) {
//	}
//	public void updateRegionTest(Region r) {
//	}
//	public void updateUtilisateur() {
//		Utilisateur u = AccesData.getStation(1);
//		String ancValeur = s.getLibelleEmplacement();
//		String nouvelleValeur = "gare test";
//		s.setLibelleEmplacement(nouvelleValeur);
//		assertTrue(AccesData.updateStation(s));
//		// remise à l'état initial
//		s.setLibelleEmplacement(ancValeur);
//		assertTrue(AccesData.updateStation(s));
//		s = AccesData.getStation(1);
//	}
//	public void deleteUtilisateur(Utilisateur u) {	
//	}
//	public void addUtilisateur(Utilisateur u) {
//	}


}
