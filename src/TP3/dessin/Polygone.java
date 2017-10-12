package dessin;
import java.lang.Math;

public class Polygone {
    
  // data
  public static final int PERIMETRE_MIN = 600;
  protected Point[]sommets;
	
    
  // constructors
  public Polygone(int nbrCote)
  {
    int i;
    this.sommets = new Point[nbrCote];
    do{
      for (i = 0; i < nbrCote; i++)
      {
	this.sommets[i] = new Point();
      }
    }
    while(this.perimetre() < PERIMETRE_MIN);
  }
	
  // methods
  /**
   * Retourne le nombre de son cote
   * 
   * @return int le nombre de son cote
   */
  public int nbrCotes()
  {
    return this.sommets.length;
  }
  /**
   * Retourne l'objet Point numero n
   * 
   * @param n numero du point à recuperer
   * @return Point l'objet Point numero n
   */
  public Point getPoint(int n)
  {
    if (n >= 1 && n <= nbrCotes())
      return this.sommets[n-1];
    else
    {
      System.out.println("Attention parametre non valide donc retourne getPoint(1) !!!! " + this);
      return this.sommets[0];
    }
  }
  /**
   * Change le point numero n par Point(x, y) 
   * 
   * @param int n numero de point
   * @param double x abcisse du point
   * @param double y ordonne du point
   */
  public void changePoint(int n, double x, double y)
  {
    if (n >= 1 && n <= nbrCotes())
    {
      getPoint(n).setX(x);
      getPoint(n).setY(y);
    }
    else 
    {
      System.out.println("Attention parametre non valide donc aucun point n'a été changé !!! " );
    }
  }
  public void changePoint(int n, Point p)
  {
    this.changePoint(n, p.getX(), p.getY());
  }
	
  /**
   * Retourne son perimetre
   * 
   * @return double son perimetre
   */
  public double perimetre()
  {
    int j;
    double perimetre = 0.0d;
    for (j = 1; j < this.nbrCotes(); j++)
    {
      perimetre += getPoint(j).distance(getPoint(j+1));
    }
    perimetre += getPoint(j).distance(getPoint(1));
		
    return perimetre;
  }
  /**
   * Méthode qui retourne sa surface 
   * 
   * @return double sa surface
   */
  public double surface ()
  {
    double surface = 0;
    int i;
    if (nbrCotes() >= 4)
    {
      for (i = 1; i < nbrCotes(); i++)
      {
	switch (i)
	{
	case 1:
	  surface += heron(getPoint(i), getPoint(2), getPoint(nbrCotes()));
	  break;
	case 2:
	  surface += heron(getPoint(i), getPoint(3), getPoint(4));
	  i++;
	  break;
	default:
	  surface += heron(getPoint(i), getPoint(i+1), getPoint(2));
	  break;
	}
      }
    }
    else
    {
      surface = heron(getPoint(1), getPoint(2), getPoint(3));
    }

    return surface;
  }
  
  /*----------------------------------------------------------------------------
   * 
   * Méthode pour calculer la surface d'un triangle avec la formule d'héron
   *
   -----------------------------------------------------------------------------*/
  private double heron(Point p1, Point p2, Point p3)
  {
    double a, b, c, p;
    a = p1.distance(p2);
    b = p2.distance(p3);
    c = p3.distance(p1);
    p = (a + b + c) / 2.0d;
    
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    int i;
    String str = new String();
    str += this.getClass().getName() + " à " + this.nbrCotes() + " cotés :\n";
    for (i = 1; i <= this.nbrCotes(); i++)
    {
      str += this.getPoint(i) + ", ";
    }
		
    return str;
  }
	
}
