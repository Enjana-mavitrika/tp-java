/*---------------------------------------------------------
 !                                                        !
 ! ** historique **                                       !
 !     ok                           !
 !                                                        !
 ---------------------------------------------------------*/
package dessin;
import java.lang.Math;

public class EnsemblePolygoneAlea extends EnsemblePolygone
{

  /*------------------------------------------------
   *               constructors                    *
   *                                               *
   *-----------------------------------------------*/

  public EnsemblePolygoneAlea ()
  {
    super ((int)((Math.random() * 100) % 100)+1); // nbPoly aléatoires entre 1 et 100
    char typesTab[] = {'P', 'R', 'Q', 'T'};
    for (int i = 0; i < TAILLE_MAX; i++)
    {
      switch(typesTab[(int)((Math.random() * 10) % 4)]) // choix alea type
      {
      case 'P':
	ajouterPolygone (new Polygone ((int)((Math.random() * 100) % 15 + 5))); // creer polygone avec nbr cotes entre 5 et 20
	break;
      case 'R':
	Point p1 = new Point ();
	Point p2 = new Point ();
	while (p1.getX() == p2.getX() && p1.getY() == p2.getY())
	  p2 = new Point ();
	ajouterPolygone (new Rectangle (p1, p2));
	break;
      case 'Q':
	ajouterPolygone (new Quadrilatere());
	break;
      case 'T':
	ajouterPolygone (new Triangle (new Point(), new Point(), new Point()));
	break;
      }
    }
  }
}
