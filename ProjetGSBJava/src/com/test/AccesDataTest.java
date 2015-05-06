package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.LigneFraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.persistance.AccesData;

public class AccesDataTest {
	
	FicheFrais laFiche;
	FraisForfait fraisForfait;
	LigneFraisForfait ligneFraisForfait;
	LigneFraisHorsForfait ligneFraisHorsForfait;
	
	private List<Utilisateur> listeUtilisateur;
	private List<Region> listeRegion;
	
	private static List<FicheFrais> listeFichesFrais;
	private static List<FraisForfait> listeFraisForfait;
	
	private static List<LigneFraisForfait> listeLigneFraisForfait;
	private static List<LigneFraisHorsForfait> listeLigneFraisHorsForfait;
	
	@Test
	public void getListRegion() {
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
	public void getListeUtilisateur() {
		listeUtilisateur = AccesData.getListeUtilisateur();
		assertNotNull("test chargement liste utilisateurs", listeUtilisateur);
		assertEquals("test nb utilisateurs", listeUtilisateur.size(), 27);
		
		
		assertEquals(listeUtilisateur.get(0).getIdUtilisateur(), "a131");
		assertEquals(listeUtilisateur.get(0).getIdTypeUtilisateur().toString(), "V");
		assertEquals(listeUtilisateur.get(0).getNom(), "Villechalane");
		assertEquals(listeUtilisateur.get(0).getPrenom(), "Louis");
		assertEquals(listeUtilisateur.get(0).getLogin(), "lvillachane");
		assertEquals(listeUtilisateur.get(0).getRegion().getIdRegion(), "16");
		assertEquals(listeUtilisateur.get(1).getIdUtilisateur(), "a17");
		assertEquals(listeUtilisateur.get(1).getIdTypeUtilisateur().toString(), "V");
		assertEquals(listeUtilisateur.get(1).getNom(), "Andre");
		assertEquals(listeUtilisateur.get(1).getPrenom(), "David");
		assertEquals(listeUtilisateur.get(1).getLogin(), "dandre");
		assertEquals(listeUtilisateur.get(1).getRegion().getIdRegion(), "16");
	}
	
	
	@Test
	public void getListeFicheFrais() {
		listeFichesFrais = AccesData.getListeFicheFrais();
		assertNotNull("test chargement liste fiches frais", listeFichesFrais);
		assertEquals("test nb fiches frais", listeFichesFrais.size(), 569);
	
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
	public void getListeFraisForfait() {
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
	
//	public void getListeLigneFraisForfait() {
//	}
//	public void getListeLigneFraisHorsForfait() {
//	}

//	public void getFicheFrais(int idFicheFrais) {
//	}
//	public void getFraisForfait(int idFraisForfait) {
//	}
//	public void getLigneFraisForfait(int idLigneFraisForfait) {
//	}
//	public void getLigneFraisHorsForfait(int idLigneFraisHorsForfait) {
//	}
//	public void getRegion(int idRegion) {
//	}
//	public void getUtilisateur(int idUtilisateur) {
//	}
//	public void addFicheFrais(FicheFrais f) {
//	}
//	public void deleteFicheFrais(FicheFrais f) {
//	}
//	public void updateFicheFrais(FicheFrais f) {
//	}
//	public void addFraisForfait(FraisForfait f) {
//	}
//	public void deleteFraisForfait(FraisForfait f) {
//	}
//	public void updateFraisForfait(FraisForfait f) {
//	}
//	public void updateLigneFraisForfait(LigneFraisForfait l){
//	}
//	public void deleteLigneFraisForfait(LigneFraisForfait l) {
//	}
//	public void addLigneFraisForfait(LigneFraisForfait l) {
//	}
//	public void addLigneFraisHorsForfait(LigneFraisHorsForfait l) {
//	}
//	public void deleteLigneFraisHorsForfait(LigneFraisHorsForfait l) {
//	}
//	public void updateLigneFraisHorsForfait(LigneFraisHorsForfait l) {
//	}
//	public void addRegion(Region r) {
//	}
//	public void deleteRegion(Region r) {
//	}
//	public void updateRegion(Region r) {
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
