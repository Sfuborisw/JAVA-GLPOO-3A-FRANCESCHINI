package fr.esiea.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.SimpleTirage;
import fr.esiea.glpoo.tirage.Tirage;

public class Tree extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JButton btn_ramdom, btn_save;
	JTextArea textArea;
	private final static Logger log = Logger.getLogger(Launcher.class);

	MyDrawPanel DrawPanel;

	private List<Tirage> tirages;
	private Tirage tirageEnCours = new SimpleTirage();
	private Random rand = new Random();
	private boolean first = true;

	public Tree() throws Exception {
		final String fileName = "src/main/resources/my_euromillions.csv";
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);
		tirages = dao.findAllTirage();

		if (first == true) {
			tirageEnCours = tirages.get(0);
		}

		frame = new JFrame("Fractal Tree");
		textArea = new JTextArea(24, 80);

		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn_ramdom = new JButton(new RandomTree());
		btn_save = new JButton(new SaveAsPng());

		final JPanel barreButton = new JPanel();
		barreButton.add(btn_ramdom);
		barreButton.add(btn_save);

		DrawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, barreButton);
		frame.getContentPane().add(BorderLayout.CENTER, DrawPanel);
		DrawPanel.setBackground(Color.WHITE);
		DrawPanel.setColor(tirageEnCours);
		DrawPanel.setAngle(tirageEnCours);
		DrawPanel.setDepth(tirageEnCours);

		frame.setVisible(true);

	}

	private class RandomTree extends AbstractAction {

		private static final long serialVersionUID = 1L;

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
			first = false;
			DrawPanel.removeAll();
			DrawPanel.validate();
			DrawPanel.setColor(tirageEnCours);
			DrawPanel.setAngle(tirageEnCours);
			DrawPanel.setDepth(tirageEnCours);
			DrawPanel.revalidate();
			DrawPanel.repaint();
		}

	}

	private class SaveAsPng extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SaveAsPng() {
			super("Save as PNG");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO save as a png our fractal tree
			log.info("soon....");
			/*
			 * JFileChooser chooser = new JFileChooser(); int retval =
			 * chooser.showSaveDialog(btn_save); if(retval == JFileChooser.APPROVE_OPTION) {
			 * File file = chooser.getSelectedFile(); if (file == null) { return; }
			 * if(!file.getName().toLowerCase().endsWith(".png")) { file = new
			 * File(file.getParentFile(),file.getName() + ".png"); } try {
			 * textArea.write(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
			 * Desktop.getDesktop().open(file); } catch (Exception except) {
			 * except.printStackTrace(); } }
			 */
		}

	}
}
