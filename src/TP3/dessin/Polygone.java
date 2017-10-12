package dessin;
import java.lang.Math;

public class Polygone {
    
  /*------------------------------------------------
   *                                               *
   *               data                            *
   *                                               *
   *-----------------------------------------------*/
  
  public static final int PERIMETRE_MIN = 600;
  protected Point[]sommets;
	
    
  /*------------------------------------------------
   *                                               *
   *                constructor                    *
   *                                               *
   *-----------------------------------------------*/
  
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
	

  /*------------------------------------------------
   *                                               *
   *                  getters                      *
   *                                               *
   *-----------------------------------------------*/
  
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

  /*------------------------------------------------
   *                                               *
   *                  setters                      *
   *                                               *
   *-----------------------------------------------*/
  
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

  /*------------------------------------------------
   *                                               *
   *                Methods                        *
   *                                               *
   *-----------------------------------------------*/
	
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
    if (estConvexe()){
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
    }
    else
    {
      surface = -1;
    }

    return surface;
  }
  
  /*----------------------------------------------------------------------------
   * Méthode pour calculer la surface d'un triangle avec la formule d'héron
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

  /**
   * Methode pour verifier s'il est strictement convexe
   *
   * @return bool : true si oui, sinon false
   */
  public boolean estConvexe ()
  {
    int suivant;
    int precedant;
    boolean convexe = true;
    int signe = getPoint(1).signeAngle(getPoint(2), getPoint(nbrCotes()));
    int i;
    for (i = 2; i <= nbrCotes(); i++)
    {
      suivant = (i == nbrCotes()) ? 1 : (i+1);
      precedant = (i-1);
      convexe &= (signe == getPoint(i).signeAngle(getPoint(suivant), getPoint(precedant)) && signe != Point.ALIGNES);
    }
    
    return convexe;
  }

  /**
   * Methode pour verifier si un Point est strictement inclus dans le polygone
   *
   * @param Point : le point à verifier
   * @return boolean : true si inclus sinon false
   */
  public boolean dedans (Point p)
  {
    int suivant;
    int signe = p.signeAngle(getPoint(1), getPoint(2));
    int i;
    boolean dedans = true;
    for (i = 2; i <= nbrCotes(); i++)
    {
      suivant = (i == nbrCotes()) ? 1 : i+1;
      dedans &= (signe == p.signeAngle(getPoint(i),getPoint(suivant))) && (signe != Point.ALIGNES);
    }

    return dedans;
  }

  /**
   * Methode pour verifier si le polygone courant a une surface plus grande que le polygone en parametre
   *
   * @param Polygone 
   * @return boolean : true si le polygone courant a une surface plus grande sinon false
   */
  public boolean plusGrand (Polygone p)
  {
    return this.surface() > p.surface();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    int i;
    String str = new String();
    str += "\n" + this.getClass().getName() + " à " + this.nbrCotes() + " cotés :\n";
    for (i = 1; i <= this.nbrCotes(); i++)
    {
      str += this.getPoint(i) + ", ";
    }
    str += "Surface = " + this.surface();
		
    return str;
  }
	
}
