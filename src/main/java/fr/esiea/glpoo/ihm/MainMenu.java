package fr.esiea.glpoo.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.Launcher;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Launcher.class);

	JFrame frame;
	JPanel panel;
	JButton btn_tree, btn_triangle, btn_exit;

	public MainMenu() {
		ImageIcon img = new ImageIcon("src/main/resources/bingo.png");

		frame = new JFrame("GLPOO 3A PROJET ESIEA");
		frame.setIconImage(img.getImage());
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		btn_tree = new JButton(new GoToTree());
		btn_triangle = new JButton(new GoToTriangle());
		btn_exit = new JButton(new ExitProg());

		final JPanel colonneButton = new JPanel();
		colonneButton.setLayout(null);
		colonneButton.setBackground(new Color(50, 58, 79));

		btn_tree.setBounds((frame.getSize().height / 2), 30, 200, 100);
		btn_triangle.setBounds((frame.getSize().height / 2), 130, 200, 100);
		btn_exit.setBounds((frame.getSize().height / 2), 230, 200, 100);

		colonneButton.add(btn_tree);
		colonneButton.add(btn_triangle);
		colonneButton.add(btn_exit);

		frame.getContentPane().add(colonneButton);
		frame.setVisible(true);

	}
	
	private class GoToTree extends AbstractAction {
		
		private static final long serialVersionUID = 1L;
		
		public GoToTree() {
			super("Arbre Fractal");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			log.debug("Ici on lance la fenetre pour les arbres fractal");
		}
		
	}
	
	private class GoToTriangle extends AbstractAction {

		private static final long serialVersionUID = 1L;
		
		public GoToTriangle() {
			super("Triangle de Sierpiński");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			log.debug("Ici on lance la fenetre pour les triangles fractal");
			
		}
		
	}
	
	private class ExitProg extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public ExitProg() {
			super("Quitter le programme");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			log.debug("Ici on quitte le programme");
			frame.dispose();
		}
		
	}
	
	

}
