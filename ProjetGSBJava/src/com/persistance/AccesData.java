package com.persistance;
import com.metier.*;
import com.util.HibernateSession;

import java.util.*;

import org.hibernate.*;

public class AccesData {
	
	private static Session session = HibernateSession.getSession();
	private static Transaction trans = session.beginTransaction();
	// accesseurs sur listes d'objets
	public static List<FicheFrais> getListeFicheFrais() 	{
		return session.createQuery("from FicheFrais").list();
					}
	public static List<FraisForfait> getListeFraisForfait() 	{
		return session.createQuery("from FraisForfait").list();
	}
	public static List<LigneFraisForfait> getListeLigneFraisForfait() 	{
		return session.createQuery("from LigneFraisForfait").list();
	}
	public static List<LigneFraisHorsForfait> getListeLigneFraisHorsForfait() 	{
		return session.createQuery("from LigneFraisHorsForfait").list();
					}
	public static List<Region> getListeRegion() 	{
		return session.createQuery("from Region").list();
	}
	public static List<Utilisateur> getListeUtilisateur() 	{
		return session.createQuery("from Utilisateur").list();
	}
	public static FicheFrais getFicheFrais(String idVisiteur, String mois) 	{
		FicheFraisPK ficheFraisPK = new FicheFraisPK();
		ficheFraisPK.setIdVisiteur(idVisiteur);
		ficheFraisPK.setMois(mois);
		return (FicheFrais) session.get(FicheFrais.class, ficheFraisPK);
	}
	public static FraisForfait getFraisForfait(String idFraisForfait) 	{
		return (FraisForfait) session.get(FraisForfait.class, idFraisForfait);
	}
	public static LigneFraisForfait getLigneFraisForfait(String idVisiteur, String mois, String idFraisForfait) 	{
		LigneFraisForfaitPK ligneFraisForfaitPK = new LigneFraisForfaitPK();
		ligneFraisForfaitPK.setIdVisiteur(idVisiteur);
		ligneFraisForfaitPK.setMois(mois);
		ligneFraisForfaitPK.setIdFraisForfait(idFraisForfait);
		return (LigneFraisForfait) session.get(LigneFraisForfait.class, ligneFraisForfaitPK);
	}
	public static LigneFraisHorsForfait getLigneFraisHorsForfait(int idLigneFraisHorsForfait) 	{
		return (LigneFraisHorsForfait) session.get(LigneFraisHorsForfait.class, idLigneFraisHorsForfait);
	}
	public static Region getRegion(String idRegion) 	{
		return (Region) session.get(Region.class, idRegion);
	}
	public static Utilisateur getUtilisateur(String idUtilisateur) 	{
		return (Utilisateur) session.get(Utilisateur.class, idUtilisateur);
	}
	public static Boolean addFicheFrais(FicheFrais f) 	{
		Boolean succes = false;
		try {
			session.saveOrUpdate(f);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean deleteFicheFrais(FicheFrais f) 	{
		Boolean succes = false;
		try {
			session.delete(f);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean updateFicheFrais(FicheFrais f) 	{
		Boolean succes = false;
		try {
			session.saveOrUpdate(f);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean addFraisForfait(FraisForfait f) 	{
		Boolean succes = false;
		try {
			session.saveOrUpdate(f);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean deleteFraisForfait(FraisForfait f) 	{
		Boolean succes = false;
		try {
			session.delete(f);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean updateFraisForfait(FraisForfait f) 	{
		Boolean succes = false;
		try {
			session.saveOrUpdate(f);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean updateLigneFraisForfait(LigneFraisForfait l)
	{
		Boolean succes = false;
		try {
			session.saveOrUpdate(l);
			trans.commit();
			succes = true;
		}
		finally {
		}
		return succes;
	}
	public static Boolean deleteLigneFraisForfait(LigneFraisForfait l) 	{
		Boolean succes;
		try {
			session.delete(l);
			trans.commit();
			succes = true;
		}
		catch(Exception exp) {
			succes = false;
		}
		return succes;
	}
	public static Boolean addLigneFraisForfait(LigneFraisForfait l) 	{
		Boolean succes;
		try {
			session.saveOrUpdate(l);
			trans.commit();
			succes = true;
		}
		catch(Exception exp) {
			succes = false;
		}
		return succes;
	}
	public static void addLigneFraisHorsForfait(LigneFraisHorsForfait l) 	{
		session.saveOrUpdate(l);
		trans.commit();
	}
	public static void deleteLigneFraisHorsForfait(LigneFraisHorsForfait l) 	{
		session.delete(l);
		trans.commit();
	}
	public static void updateLigneFraisHorsForfait(LigneFraisHorsForfait l) 	{
		session.saveOrUpdate(l);
		trans.commit();
	}
	public static void addRegion(Region r) 	{
		session.saveOrUpdate(r);
		trans.commit();
	}
	public static void deleteRegion(Region r) 	{
		session.delete(r);
		trans.commit();
	}
	public static void updateRegion(Region r) 	{
		session.saveOrUpdate(r);
		trans.commit();
	}
	public static void updateUtilisateur(Utilisateur u)
	{
		session.saveOrUpdate(u);
		trans.commit();
	}
	public static void deleteUtilisateur(Utilisateur u) 	{
		session.delete(u);
		trans.commit();
	}
	public static void addUtilisateur(Utilisateur u) 	{
		session.saveOrUpdate(u);
		trans.commit();
	}
	public static void closeBd() 	{
		session.close();
	}

}
