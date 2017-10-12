package dessin;

public class Rectangle extends Quadrilatere
{
  
  /*------------------------------------------------
   *                                               *
   *             Constructors                      *
   *                                               *
   *-----------------------------------------------*/
  
  public Rectangle (Point p1, Point p2)
  {
    super();
    Point tabPoint[] = new Point[2];
    tabPoint = this.construire(p1, p2);
    this.changePoint(1, p1); // mettre à jour coordonne sommet haut gauche
    this.changePoint(2, tabPoint[0]); // mettre à jour coordone sommet haut droite
    this.changePoint(3, p2);	  // mettre à jour coordone sommet bas droite
    this.changePoint(4, tabPoint[1]); // mettre à jour coordone sommet bas gauche
  }

  /*------------------------------------------------
   *                                               *
   *                Methods                        *
   *                                               *
   *-----------------------------------------------*/
  
  private Point[] construire (Point p1, Point p2)
  {
    Point tabPoint[] = new Point[2];
    tabPoint[0] = new Point(p2.getX(), p1.getY());
    tabPoint[1] = new Point((p1.getX() + p2.getX() - tabPoint[0].getX()), (p1.getY() + p2.getY() - tabPoint[0].getY()));

    return tabPoint;
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
