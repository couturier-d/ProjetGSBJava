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
	public static FicheFrais getFicheFrais(int idFicheFrais) 	{
		return (FicheFrais) session.get(FicheFrais.class, idFicheFrais);
	}
	public static FraisForfait getFraisForfait(int idFraisForfait) 	{
		return (FraisForfait) session.get(FraisForfait.class, idFraisForfait);
	}
	public static LigneFraisForfait getLigneFraisForfait(int idLigneFraisForfait) 	{
		return (LigneFraisForfait) session.get(LigneFraisForfait.class, idLigneFraisForfait);
	}
	public static LigneFraisHorsForfait getLigneFraisHorsForfait(int idLigneFraisHorsForfait) 	{
		return (LigneFraisHorsForfait) session.get(LigneFraisHorsForfait.class, idLigneFraisHorsForfait);
	}
	public static Region getRegion(int idRegion) 	{
		return (Region) session.get(Region.class, idRegion);
	}
	public static Utilisateur getUtilisateur(int idUtilisateur) 	{
		return (Utilisateur) session.get(Utilisateur.class, idUtilisateur);
	}
	public static void addFicheFrais(FicheFrais f) 	{
		session.saveOrUpdate(f);
		trans.commit();
	}
	public static void deleteFicheFrais(FicheFrais f) 	{
		session.delete(f);
		trans.commit();
	}
	public static void updateFicheFrais(FicheFrais f) 	{
		session.saveOrUpdate(f);
		trans.commit();
	}
	public static void addFraisForfait(FraisForfait f) 	{
		session.saveOrUpdate(f);
		trans.commit();
	}
	public static void deleteFraisForfait(FraisForfait f) 	{
		session.delete(f);
		trans.commit();
	}
	public static void updateFraisForfait(FraisForfait f) 	{
		session.saveOrUpdate(f);
		trans.commit();
	}
	public static void updateLigneFraisForfait(LigneFraisForfait l)
	{
		session.saveOrUpdate(l);
		trans.commit();
	}
	public static void deleteLigneFraisForfait(LigneFraisForfait l) 	{
		session.delete(l);
		trans.commit();
	}
	public static void addLigneFraisForfait(LigneFraisForfait l) 	{
		session.saveOrUpdate(l);
		trans.commit();
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
