package fr.esiea.glpoo;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.Tirage;

public class Launcher {
	private final static Logger logger =  Logger.getLogger(Launcher.class);
	public static void main(String[] args) throws Exception {
		logger.info("Hello");
		
		final String fileName = "src/main/resources/my_euromillions.csv";
		
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);
		
		final List<Tirage> tirages = dao.findAllTirage();
		
		for(final Tirage tirage : tirages) {
			logger.debug("* " + tirage.getAnnee() + tirage.getBoules()[0] + " END");
		}
		
	}
}
