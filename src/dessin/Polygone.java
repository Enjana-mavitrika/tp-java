package dessin;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
public class Polygone extends FormeSurface
{
    
  /*------------------------------------------------
   *                                               *
   *               data                            *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrPoly = 0;
  public static final int PERIMETRE_MIN = 300;
  protected Point[]sommets;
	
    
  /*------------------------------------------------
   *                                               *
   *                constructor                    *
   *                                               *
   *-----------------------------------------------*/
  
  public Polygone(int nbrCote)
  {
	  double x, y;
	  this.sommets = new Point[nbrCote];
	  do{
		  // construire un polygone convexe		  
		  sommets[0] = new Point();
		  y = Math.random() * 1000 + getPoint(1).getY();
		  sommets[2] = new Point(Math.random() * 1000, y);
		  x = (getPoint(1).getX() < getPoint(3).getX()) ? Math.random() * getPoint(1).getX() : Math.random() * getPoint(3).getX();
		  y = Math.random() * getPoint(3).getY() + getPoint(1).getY();
		  sommets[1] = new Point(x, y);
		  for (int i = 3; i < nbrCote; i++)
		  {
			  x = (getPoint(i).getX() > getPoint(1).getX()) ? Math.random() * 1000 + getPoint(i).getX() : Math.random() * 1000 + getPoint(1).getX();
			  y = Math.random() * getPoint(i).getY() + getPoint(1).getY();
			  sommets[i] = new Point(x, y);
		  }
	  }
    while(this.perimetre() < PERIMETRE_MIN && !estConvexe());
    nbrPoly++;
    NUM_TYPE_FORME = nbrPoly;
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
   * Méthode pour verifier si le polygone en parametre est eguale au polygone courant
   *
   * @param Polygone 
   * @return boolean
   */
  public boolean equals (Polygone pol)
  {
    Point pointTmp = new Point();
    Point pointTmp2 = new Point();
    boolean equals = false;
    System.out.println(this + " surface - pol.surface = " + Math.abs(Math.round(surface()) - Math.round(pol.surface())));
    if (nbrCotes() != pol.nbrCotes() || Math.abs(Math.round(surface()) - Math.round(pol.surface())) > 0.01 )
      return equals;
    for (int i = 0; i < nbrCotes(); i++)
    {
      pointTmp2.copie(pol.getPoint(nbrCotes()));
      for (int j = 1; j <= nbrCotes(); j += 2)
      {	       
	pointTmp.copie(pol.getPoint(j));
	pol.changePoint(j, pointTmp2);
	if (j + 1 <= nbrCotes())
	{ // eviter erreur cas nbrCotes impair
	  pointTmp2.copie(pol.getPoint(j + 1));
	  pol.changePoint(j + 1, pointTmp);
	}
      }
      System.out.println("[debug equals] : " + pol + " equals_aux(pol) = " + equals_aux(pol));
      // verifier si pol décaler d'une position est egal au polygone courant
      if (equals_aux(pol))
	equals = true;
    }
    return equals;
  }
  // methode auxiliaire de la méthode equals
  private boolean equals_aux (Polygone pol)
  {
    double dy, dx;
    boolean equals = true;
    // verifier translation
    dx = getPoint(1).getX() - pol.getPoint(1).getX();
    dy = getPoint(1).getY() - pol.getPoint(1).getY();
    for (int i = 2; i <= nbrCotes(); i++)
    {
      equals &= (dx == getPoint(i).getX() - pol.getPoint(i).getX()) && (dy == getPoint(i).getY() - pol.getPoint(i).getY());
    }
    return equals;
  }

  public void translater(double dx, double dy)
  {
    for (int i = 1; i <= nbrCotes(); i++)
      changePoint(i, dx + getPoint(i).getX(), dy + getPoint(i).getY());
  }
  
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    int i;
    String str = new String();
    str += super.afficher();
    for (i = 1; i <= this.nbrCotes(); i++)
    {
      str += this.getPoint(i) + ", ";
    }
    str += "Surface = " + this.surface();
		
    return str;
  }
  
  public void seDessiner(Graphics g)
  {
	  int endLoop = sommets.length - 1;
	  //g.drawString(toString(), (int)getPoint(1).getX(), (int)getPoint(1).getY());
	  g.setColor(couleur);
	  g.drawLine((int)getPoint(sommets.length).getX(), (int)getPoint(sommets.length).getY(), (int)getPoint(1).getX(), (int)getPoint(1).getY());
	  for (int i = 1; i <= endLoop; i++) 
	  {
		  g.drawLine((int)getPoint(i).getX(), (int)getPoint(i).getY(), (int)getPoint(i + 1).getX(), (int)getPoint(i + 1).getY());
	  }
	  g.setColor(Color.BLACK);
  }
	
}
