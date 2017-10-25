package dessin;

public abstract class Forme
{

  /*------------------------------------------------
   *                   data                        *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrForme = 0; 
  private final int NUM_FORME;
  protected int NUM_TYPE_FORME;

  public Forme()
  {
    nbrForme++;
    NUM_FORME = nbrForme;
  }
  

   /*------------------------------------------------
   *                   methods                     *
   *                                               *
   *-----------------------------------------------*/
  /**
   * Methode pour verifier si le forme courant a une surface plus grande que le forme en parametre
   *
   * @param Forme 
   * @return boolean : true si la forme courant a une surface plus grande sinon false
   */
  public boolean plusGrand (Forme f)
  {
    return this.surface() > f.surface();
  }

  public String afficher()
  {
    return "Forme (n° " + NUM_FORME + "), " + this.getClass().getName() + "(n° " + NUM_TYPE_FORME + ") : ";
  }


  /*------------------------------------------------
   *            abstract methods                   *
   *                                               *
   *-----------------------------------------------*/
  public abstract double perimetre();
  public abstract double surface();
  public abstract boolean dedans(Point p);
  public abstract void translater(double dx, double dy);
}
