package dessin;

public class Quadrilatere extends Polygone
{

  /*------------------------------------------------
   *                data                           *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrQuad = 0;
  
  /*------------------------------------------------
   *                constructors                   *
   *                                               *
   *-----------------------------------------------*/
  
  public Quadrilatere ()
  {
    super(4);
    nbrQuad++;
    NUM_TYPE_FORME = nbrQuad;
    nbrPoly--;
  }
  public Quadrilatere (Point p1, Point p2, Point p3, Point p4)
  {
    this();
    this.changePoint(1, p1);
    this.changePoint(2, p2);
    this.changePoint(3, p3);
    this.changePoint(4, p4);
  }

  /*------------------------------------------------
   *                   Methods                     *
   *                                               *
   *-----------------------------------------------*/
  
  /* === redefinition de la méthode surface de polygone === */
  public double surface ()
  {
    System.out.println("Calcul de la surface d'un quadrilatere");
    return super.surface();
  }
    
}
