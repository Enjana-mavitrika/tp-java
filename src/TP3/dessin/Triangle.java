package dessin;

public class Triangle extends Polygone
{
  /*------------------------------------------------
   *                data                           *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrTri = 0;
  
  
  /*------------------------------------------------
   *                                               *
   *                Constructors                   *
   *                                               *
   *-----------------------------------------------*/
  
    public Triangle(Point p1, Point p2, Point p3)
    {
	super(3);
	changePoint(1, p1);
	changePoint(2, p2);
	changePoint(3, p3);
	nbrTri++;
	NUM_TYPE_FORME = nbrTri;
	nbrPoly--;
    }

  /*------------------------------------------------
   *                                               *
   *                setters                        *
   *                                               *
   *-----------------------------------------------*/
  
    /**
     * Change le coordonne de son n-ieme sommet par (x, y)
     *
     * @param int,int  coordonnee x et y  
     */
    public void changeSommet(int n, double x, double y)
    {
	changePoint(n, x, y);
    }

  /*------------------------------------------------
   *                                               *
   *                Methods                        *
   *                                               *
   *-----------------------------------------------*/

  /* === Redefinition de la méthode surface de Polygone === */
  public double surface ()
  {
    System.out.println("Calcul de la surface d'un triangle");
    return super.surface();
  }

    
    
}
