package fr.esiea.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.SimpleTirage;
import fr.esiea.glpoo.tirage.Tirage;

public class Tree extends JFrame {
	private final static Logger log = Logger.getLogger(Launcher.class);
	// private final TreeModele modele = new TreeModele();
	// private final JTable tableau = new JTable(modele);

	private final String[] headers;
	private List<Tirage> tirages;

	private Tirage tirageEnCours = new SimpleTirage();
	private Random rand = new Random();

	Graphics g;

	public Tree() throws Exception {
		headers = new String[] { "Annee", "Jour", "Date", "Numero", "Date Fermeture", "Boule 1", "Boule 2", "Boule 3",
				"Boule 4", "Boule 5", "Etoile 1", "Etoile 2" };
		final String fileName = "src/main/resources/my_euromillions.csv";
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);

		tirages = dao.findAllTirage();

		setTitle("FractalTree");
		setPreferredSize(new Dimension(700, 700));

		// setBounds(100, 100, 800, 600);

		final JPanel barreButton = new JPanel();
		barreButton.setBackground(Color.GRAY);
		final JButton buttonRandom = new JButton(new RandomTree());
		final JButton buttonSave = new JButton(new SaveAsPng());
		barreButton.add(buttonRandom);
		barreButton.add(buttonSave);
		getContentPane().add(barreButton, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class RandomTree extends AbstractAction {

		public RandomTree() {
			super("New Random Tree");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			log.debug("ici actionPerformed");
			int value = rand.nextInt(70);
			log.debug("random effctuer " + value);
			tirageEnCours = tirages.get(value);
			log.debug("test some value " + tirageEnCours.getBoule1());
		}

	}

	private class SaveAsPng extends AbstractAction {
		public SaveAsPng() {
			super("Save as PNG");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO save as a png our fractal tree
			log.info("soon....");
		}

	}

	private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
		if (depth == 0)
			return;
		int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
		int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
		g.drawLine(x1, y1, x2, y2);
		drawTree(g, x2, y2, angle - 20, depth - 1);
		drawTree(g, x2, y2, angle + 20, depth - 1);
	}

	@Override
	public void paint(Graphics g) {
		int red = tirageEnCours.getBoule1();
		int green = tirageEnCours.getBoule2();
		int blue = tirageEnCours.getBoule3();

		double angle = (double) tirageEnCours.getBoule4() + tirageEnCours.getBoule5();
		int x1 = tirageEnCours.getBoule1() + tirageEnCours.getBoule2() + tirageEnCours.getBoule3()
				+ tirageEnCours.getBoule4() + tirageEnCours.getBoule5();
		int y1 = tirageEnCours.getEtoile1() + tirageEnCours.getEtoile2() * 10;
		int depth;
		if (tirageEnCours.getEtoile1() > tirageEnCours.getEtoile2()) {
			depth = tirageEnCours.getEtoile1();
		} else {
			depth = tirageEnCours.getEtoile2();
		}
		g.setColor(new Color(red, green, blue));
		drawTree(g, 400, 500, -90, 9);
		// drawTree(g, 400, 500, -90, 9);
	}
}
