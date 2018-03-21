package fr.esiea.glpoo.ihm;

import java.io.File;
import java.util.List;

import javax.swing.table.AbstractTableModel;

//import org.apache.log4j.Logger;

//import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.Tirage;

@SuppressWarnings("serial")
public class TreeModele extends AbstractTableModel {
	private final String[] headers;
	private List<Tirage> tirages;
	// private final static Logger log = Logger.getLogger(Launcher.class);

	public TreeModele() throws Exception {
		headers = new String[] { "Annee", "Jour", "Date", "Numero", "Date Fermeture", "Boule 1", "Boule 2", "Boule 3",
				"Boule 4", "Boule 5", "Etoile 1", "Etoile 2" };
		final String fileName = "src/main/resources/my_euromillions.csv";
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);

		tirages = dao.findAllTirage();
	}

	@Override
	public int getRowCount() {
		return tirages.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final Tirage tirage = tirages.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tirage.getAnnee();
		case 1:
			return tirage.getJour();
		case 2:
			return tirage.getDate();
		case 3:
			return tirage.getNumeroTirage();
		case 4:
			return tirage.getDateFermeture();
		case 5:
			return tirage.getBoule1();
		case 6:
			return tirage.getBoule2();
		case 7:
			return tirage.getBoule3();
		case 8:
			return tirage.getBoule4();
		case 9:
			return tirage.getBoule5();
		case 10:
			return tirage.getEtoile1();
		case 11:
			return tirage.getEtoile2();
		default:
			throw new IllegalArgumentException("la colonne choisie n'est pas la bonne");
		}
	}

	@Override
	public String getColumnName(int column) {
		return headers[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String[].class;
		case 3:
			return Integer.class;
		case 4:
			return String[].class;
		case 5:
			return Integer.class;
		case 6:
			return Integer.class;
		case 7:
			return Integer.class;
		case 8:
			return Integer.class;
		case 9:
			return Integer.class;
		case 10:
			return Integer.class;
		case 11:
			return Integer.class;
		default:
			return Object.class;

		}
	}

	public Tirage randomTree(int value) {
		return tirages.get(value);
	}

}
