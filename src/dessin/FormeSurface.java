package dessin;

import java.awt.Color;

public abstract class FormeSurface implements Forme, Comparable, Dessinable
{

  /*------------------------------------------------
   *                   data                        *
   *                                               *
   *-----------------------------------------------*/
  public static int nbrForme = 0; 
  private final int NUM_FORME;
  protected int NUM_TYPE_FORME;
  protected Color couleur = COULEUR;


  public FormeSurface()
  {
    nbrForme++;
    NUM_FORME = nbrForme;
  }
  

   /*------------------------------------------------
   *                   methods                     *
   *                                               *
   *-----------------------------------------------*/
  
  public void setCouleur(Color c) {couleur = c;}

  
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
  
  public int compareTo(Object o)
  {
	  FormeSurface f = (FormeSurface)o;
	  return (int)(surface() - f.surface());
  }


  /*------------------------------------------------
   *            abstract methods                   *
   *                                               *
   *-----------------------------------------------*/
}
