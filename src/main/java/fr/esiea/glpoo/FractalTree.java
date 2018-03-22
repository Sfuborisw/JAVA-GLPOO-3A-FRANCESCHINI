package fr.esiea.glpoo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FractalTree extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	//JPanel DrawPanel;
	JButton btn_ramdom, btn_save;

	
	public FractalTree() {
		
		btn_ramdom = new JButton("RANDOM");
		btn_save = new JButton("SAVE");
		final JPanel barreButton = new JPanel();
		barreButton.add(btn_ramdom);
		barreButton.add(btn_save);

		//MyDrawPanel DrawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, barreButton);
		//frame.getContentPane().add(BorderLayout.CENTER, DrawPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(700, 700));
		frame.setVisible(true);
		frame.setTitle("Fractal Tree");
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


	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		drawTree(g, 400, 500, -90, 9);
	}

	public static void main(String[] args) {
		new FractalTree().setVisible(true);
	}
}
