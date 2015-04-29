package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.persistance.AccesData;

public class AccesDataTest {
	
	private List<Utilisateur> listeUtilisateur;
	private List<Region> listeRegion;
	
	private static List<FicheFrais> listeFichesFrais;
	private static List<FraisForfait> listeFraisForfait;
	
//	private static ArrayList<LigneFraisForfait> listeLignesFraisForfait;
//	private static ArrayList<LigneFraisHorsForfait> listeLignesFraisHorsForfait;
	
	/*@Test
	public void testGetListeFicheFrais() {
		listeFichesFrais = AccesData.getListeFicheFrais();
		
		assertNotNull( "Est ce que l'instanciation fonctionne ?", listeFichesFrais);
		assertEquals("", listeFichesFrais.size(), 569);
		
		assertEquals("Est ce que l'id visiteur est bon ?",listeFichesFrais.get(0).getUtilisateur().getIdUtilisateur() , "a132");
		assertEquals("Est ce que le mois est bon ?",listeFichesFrais.get(0).getMois(), "");
		assertEquals("Est ce que l'état est bon ?", listeFichesFrais.get(0).getEtat(), "");
		
	}*/
	
	@Test
	/*public void getListeFraisForfait() {
		listeFraisForfait = AccesData.getListeFraisForfait();
//		
		assertEquals(10+1, 11);
		
//		assertNotNull( "Est ce que l'instanciation fonctionne ?", listeFraisForfait);
//		assertEquals("test nombre FraisForfait", listeFraisForfait.size(), 4);
		
//		assertEquals("test type d'objet", listeFraisForfait.get(0).getClass().getSimpleName(), "FraisForfait");
//		assertEquals("test id FraisForfait",listeFraisForfait.get(0).getIdFraisForfait() , "ETP");
//		assertEquals("test libelle FraisForfait",listeFraisForfait.get(0).getLibelleFraisForfait(), "Forfait Etape");
//		assertEquals("test montant FraisForfait", listeFraisForfait.get(0).getMontant(), 110, 0);
//		
//		assertEquals("test type d'objet", listeFraisForfait.get(0).getClass().getSimpleName(), "FraisForfait");
//		assertEquals("test id FraisForfait",listeFraisForfait.get(2).getIdFraisForfait() , "NUI");
//		assertEquals("test libelle FraisForfait",listeFraisForfait.get(2).getLibelleFraisForfait(), "Nuitée Hôtel");
//		assertEquals("test montant FraisForfait", listeFraisForfait.get(2).getMontant(), 80, 0);
	}*/
//	public void getListeLigneFraisForfait() {
//	}
//	public void getListeLigneFraisHorsForfait() {
//	}
	public void getListRegion() {
		listeRegion = AccesData.getListeRegion();
		assertNotNull("test chargement liste regions", listeRegion);
	}
	
	public void getListeUtilisateur() {
		listeUtilisateur = AccesData.getListeUtilisateur();
		assertNotNull("test chargement liste utilisateurs", listeUtilisateur);
	}
	
	public void getFicheFrais(int idFicheFrais) {
		listeFichesFrais = AccesData.getListeFicheFrais();
		assertNotNull("test chargement liste fiches frais", listeFichesFrais);
	}
	
	public void getFraisForfait(int idFraisForfait) {
		listeFraisForfait = AccesData.getListeFraisForfait();
		assertNotNull("test chargement liste frais forfait", listeFraisForfait);
	}
	
//	public void getLigneFraisForfait(int idLigneFraisForfait) {
//		
//	}
//	
//	
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
//	public void updateUtilisateur(Utilisateur u) {
//	}
//	public void deleteUtilisateur(Utilisateur u) {	
//	}
//	public void addUtilisateur(Utilisateur u) {
//	}


}
