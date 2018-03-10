package fr.esiea.glpoo.ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

import org.apache.log4j.Logger;


public class Tree extends JFrame {
	private final static Logger log = Logger.getLogger(Launcher.class);
	private final TreeModele modele = new TreeModele();
	
	
    public Tree() {
        super("Fractal Tree");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	
	private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }
	
	@Override
    public void paint(Graphics g) {
		//TODO 
		// selectionner le tirage avec une liste
		// selectionner la couleur en fonction d'une boule random
		// selectionner l'angle avec l'addition de deux boule random
		// selectionner la x1 = addition de toute les boules
		// selectionner y1 = addition des etoiles * 10
		// selectionner la profondeur en fonction d'une etoile 1 ou 2 random
		Random rand = new Random();
		int red = 12;//boule 1
		int green = 11;//boule 2
		int blue = 13;//boule 3
		
		g.setColor(new Color(red,green,blue));
        drawTree(g, 400, 500, -90, 9);
    }
}
