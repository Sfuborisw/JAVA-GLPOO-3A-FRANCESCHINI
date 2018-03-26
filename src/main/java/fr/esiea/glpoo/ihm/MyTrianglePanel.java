package fr.esiea.glpoo.ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyTrianglePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	final int level = 10;

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		drawTriangle(level, getWidth() / 2, getHeight() / 2, 360, (Graphics2D) g);
	}

	public void drawTriangle(int level, int x, int y, int size, Graphics2D g) {
		if (level <= 0) {
			return;
		}
		g.drawLine(x, y, x + size, y);
		g.drawLine(x, y, x, y + size);
		g.drawLine(x + size, y, x, y + size);

		drawTriangle(level - 1, x, y, size / 2, g);
		drawTriangle(level - 1, x + size / 2, y, size / 2, g);
		drawTriangle(level - 1, x, y + size / 2, size / 2, g);
	}
}
