package dessin;

import java.awt.Color;
import java.awt.Graphics;

public interface Dessinable {
	public int WIDTH_MAX = 1500;
	public int HEIGHT_MAX = 1000;
	public Color COULEUR = Color.BLUE;
	public void seDessiner(Graphics g);
}
