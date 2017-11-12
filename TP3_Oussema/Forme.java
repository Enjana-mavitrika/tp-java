package dessin;

import java.awt.Graphics;

public abstract class Forme implements Dessinable {
	
	  public static int nbrForme = 0; 
	  private final int NUM_FORME;
	  protected int NUM_TYPE_FORME;

	  public Forme()
	  {
	    nbrForme++;
	    NUM_FORME = nbrForme;
	}
	
	
	public boolean plusGrand (Forme form)
	  {
	    return this.surface() > form.surface();
	  }
	
	abstract double perimetre();
	abstract double surface();
	abstract boolean dedans(Point p);
	abstract void translater(double dx, double dy);
	abstract void seDessiner(Graphics g);
	
	
	public String afficher()
	  {
	    return "Forme (n° " + NUM_FORME + "), " + this.getClass().getName() + "(n° " + NUM_TYPE_FORME + ") : ";
	}
	

	
}
