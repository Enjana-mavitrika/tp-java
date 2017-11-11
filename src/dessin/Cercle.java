package dessin;

import java.awt.Graphics;
import java.awt.Color;

public class Cercle extends FormeSurface implements Zoomable
{
  
  /*------------------------------------------------
   *                   data                        *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrCer = 0;
  public static final double PI = 3.14;
  private Point centre;
  private double rayon;

  
  /*------------------------------------------------
   *                   constructors                *
   *                                               *
   *-----------------------------------------------*/
  public Cercle(Point p, double rayon)
  {
    this.rayon = rayon;
    centre = new Point();
    centre.copie(p);
    nbrCer++;
    NUM_TYPE_FORME = nbrCer;
  }

  /*------------------------------------------------
   *                   getters                     *
   *                                               *
   *-----------------------------------------------*/
  public Point getCentre()
  {
    return this.centre;
  }
  public double getRayon()
  {
    return this.rayon;
  }

  /*------------------------------------------------
   *                   methods                     *
   *                                               *
   *-----------------------------------------------*/
  
  public double perimetre()
  {
    return 2 * PI * rayon;
  }
  public double surface()
  {
    return PI * rayon * rayon;
  }
  public boolean dedans(Point p)
  {
    return rayon >= p.distance(centre);
  }
  public void translater(double dx, double dy)
  {
    centre.setX(centre.getX() + dx);
    centre.setY(centre.getY() + dy);
  }
  public String toString()
  {
    return (super.afficher() + " " + centre + ", R = " + rayon + ", Surface = " + surface());
  }
  
  public void seDessiner(Graphics g)
  {
	  //g.drawString(toString(),(int)(centre.getX() + rayon + 5), (int)centre.getY());
	  g.setColor(couleur);
	  g.drawOval((int)(centre.getX() - rayon), (int)(centre.getY() - rayon), (int)rayon * 2, (int)rayon * 2);
	  g.setColor(Color.BLACK);
  }
  public void zoom(int zoomX) {rayon *= zoomX;}
}
