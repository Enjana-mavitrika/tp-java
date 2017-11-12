package dessin;

import java.awt.Graphics;

public class Cercle extends Forme {
	private Point centre;
	private double rayon;
	
	public Cercle(Point pCentre, double rayon) {
		centre=pCentre;
		this.rayon=rayon;
	}
	
	public double perimetre() {
		return 2*Math.PI*rayon;
	}
	
	public double surface() {
		return Math.PI*Math.pow(rayon, 2);
	}
	
	public boolean dedans(Point p) {
		if(this.centre.distance(p)>rayon)
			return false;
		else
			return true;
	}
	

	
	public void translater(double dx, double dy)
	  {
	    centre.setX(centre.getX() + dx);
	    centre.setY(centre.getY() + dy);
	}
	
	public void seDessiner(Graphics g)
	{	
		
		Point origin = new Point(WIDTH_MAX / 2,HEIGHT_MAX / 2);
		
		int X=(int)(centre.getX()+origin.getX());
		int Y=(int)(centre.getY()+origin.getY());
		
		g.fillOval(X,Y,(int)rayon,(int)rayon);	
	
	}
	
	 public String toString()
	  {
	    return (super.afficher() + " " + centre + ", R = " + rayon + ", Surface = " + surface());
	}
	
}
