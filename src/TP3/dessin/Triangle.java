package dessin;

public class Triangle extends Polygone
{
  
  /*------------------------------------------------
   *                                               *
   *                Constructors                   *
   *                                               *
   *-----------------------------------------------*/
  
    public Triangle(Point p1, Point p2, Point p3)
    {
	super(3);
	super.changePoint(1, p1);
	super.changePoint(2, p2);
	super.changePoint(3, p3);
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
	super.changePoint(n, x, y);
    }

  /*------------------------------------------------
   *                                               *
   *                Methods                        *
   *                                               *
   *-----------------------------------------------*/

  /* === Redefinition de la méthode surface de Polygone === */
  public double surface ()
  {
    System.out.println("Calcule de la surface d'un triangle");
    return super.surface();
  }

    
    
}
