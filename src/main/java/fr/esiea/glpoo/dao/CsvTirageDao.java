package fr.esiea.glpoo.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import fr.esiea.glpoo.tirage.SimpleTirage;
import fr.esiea.glpoo.tirage.Tirage;

public class CsvTirageDao implements TirageDao {

	private File file;

	@Override
	public void init(File file) {
		this.file = file;
	}

	@Override
	public List<Tirage> findAllTirage() throws Exception {
		final List<Tirage> tirages = new ArrayList<>();

		// fichier > lignes
		final List<String> lignes = lecture();

		// ligne > oiseau
		boolean first = true;
		for (final String ligne : lignes) {

			if (ligne.trim().isEmpty() || ligne.startsWith("#")) {
				continue;
			}

			if (first) {
				first = false;
				continue;
			}

			final Tirage tirage = transform(ligne);

			tirages.add(tirage);
		}

		return tirages;
	}

	private Tirage transform(String ligne) {
		final SimpleTirage tirage = new SimpleTirage();

		final String separator = ";";
		final String[] values = ligne.split(separator);

		// Recuperation Annee et numero du tirage
		final String tempAnnee = values[0];
		final int annee = Integer.parseInt(tempAnnee);
		tirage.setAnnee(annee);
		// Recuperation Jour
		tirage.setJour(values[1]);
		// Recuperation Date
		final String dateSeprator = "/";
		final String[] tempDate = values[2].split(dateSeprator);
		final String[] date = tempDate;
		tirage.setDate(date);
		// Recuperation Numero de tirage dans le cycle
		final String tempNumero = values[3];
		final int numero = Integer.parseInt(tempNumero);
		tirage.setNumeroTirage(numero);
		// Recuperation date de fin
		final String[] tempEndDate = values[4].split(dateSeprator);
		final String[] endDate = tempEndDate;
		tirage.setDateFermeture(endDate);
		// Recuperation boule_1
		final String tempBoule1 = values[5];
		final int boule1 = Integer.parseInt(tempBoule1);
		tirage.setBoule1(boule1);
		// Recuperation boule_2
		final String tempBoule2 = values[6];
		final int boule2 = Integer.parseInt(tempBoule2);
		tirage.setBoule2(boule2);
		// Recuperation boule_3
		final String tempBoule3 = values[7];
		final int boule3 = Integer.parseInt(tempBoule3);
		tirage.setBoule3(boule3);
		// Recuperation boule_4
		final String tempBoule4 = values[8];
		final int boule4 = Integer.parseInt(tempBoule4);
		tirage.setBoule4(boule4);
		// Recuperation boule_5
		final String tempBoule5 = values[9];
		final int boule5 = Integer.parseInt(tempBoule5);
		tirage.setBoule5(boule5);
		// Recuperation etoile_1
		final String tempEtoile1 = values[10];
		final int etoile1 = Integer.parseInt(tempEtoile1);
		tirage.setEtoile1(etoile1);
		// Recuperation etoile_2
		final String tempEtoile2 = values[11];
		final int etoile2 = Integer.parseInt(tempEtoile2);
		tirage.setEtoile2(etoile2);
		// Recuperation du tableau des boules gagnantes
		final String tableSeprator = "-";
		final String[] tempTableBoule = values[12].split(tableSeprator);
		final String[] boules = tempTableBoule;
		tirage.setBoules(boules);
		// Recuperation du tableu des etoiles gagnantes
		final String[] tempTableEtoile = values[13].split(tableSeprator);
		final String[] etoiles = tempTableEtoile;
		tirage.setBoules(etoiles);
		
		return tirage;
	}

	private List<String> lecture() throws Exception {
		final List<String> lignes = new ArrayList<>();
		final FileReader fr = new FileReader(file);
		final BufferedReader br = new BufferedReader(fr);
		for (String ligne = br.readLine(); ligne != null; ligne = br.readLine()) {
			ligne = ligne.trim();
			if (ligne.isEmpty()) {
				continue;
			}
			if (ligne.startsWith("#")) {
				continue;
			}
			lignes.add(ligne);
		}

		br.close();
		fr.close();

		return lignes;
	}
}
