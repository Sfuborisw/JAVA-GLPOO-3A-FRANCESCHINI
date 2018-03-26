package fr.esiea.glpoo.ihm;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.File;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.SimpleTirage;
import fr.esiea.glpoo.tirage.Tirage;

public class Triangle extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Launcher.class);

	JFrame frame;
	JButton btn_random, btn_save;
	
	MyTrianglePanel DrawPanel;

	private List<Tirage> tirages;
	private Tirage tirageEnCours = new SimpleTirage();
	private Random rand = new Random();
	private boolean first = true;
	
	public Triangle() throws Exception {
		final String fileName = "src/main/resources/my_euromillions.csv";
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);
		tirages = dao.findAllTirage();

		if (first == true) {
			tirageEnCours = tirages.get(0);
		}
		
		frame = new JFrame("Sierpinski Triangle");
		
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_random = new JButton("RANDOM");
		btn_save = new JButton("SAVE");
		
		final JPanel barreButton = new JPanel();
		barreButton.add(btn_random);
		barreButton.add(btn_save);
		
		DrawPanel = new MyTrianglePanel();
		
		frame.getContentPane().add(barreButton, BorderLayout.SOUTH);
		frame.getContentPane().add(DrawPanel,BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

}
