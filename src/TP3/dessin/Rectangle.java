package dessin;

public class Rectangle extends Quadrilatere
{
  /*------------------------------------------------
   *                data                           *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrRect = 0;
  
  
  /*------------------------------------------------
   *                                               *
   *             Constructors                      *
   *                                               *
   *-----------------------------------------------*/
  
  public Rectangle (Point p1, Point p2)
  {
    super();
    construire (p1, p2);	  // mettre à jour les 2 autres sommets pour former un rectangle avec les 2 sommets en param
    nbrRect++;
    NUM_TYPE_FORME = nbrRect;
    nbrQuad--;
  }

  /*------------------------------------------------
   *                                               *
   *                Methods                        *
   *                                               *
   *-----------------------------------------------*/
  
  private void construire (Point p1, Point p2)
  {
    this.changePoint(1, p1);
    this.changePoint(3, p2);	  
    this.changePoint(2, new Point(p2.getX(), p1.getY()));
    this.changePoint(4, new Point((p1.getX() + p2.getX() - p2.getX()), (p1.getY() + p2.getY() - p1.getY())));
  }
  public double hauteur ()
  {
    return this.getPoint(1).distance(getPoint(4));
  }
  public double largeur ()
  {
    return this.getPoint(1).distance(getPoint(2));
  }
  /* === redefinition de la méthode surface de polygone === */
  public double surface ()
  {
    System.out.println("Calcul de la surface d'un rectangle");
    return this.hauteur() * this.largeur();
  }

}
