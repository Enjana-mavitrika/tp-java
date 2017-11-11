package dessin;
import java.lang.Math;

public class EnsembleFormeAlea extends EnsembleForme
{

	/*------------------------------------------------
	 *               constructors                    *
	 *                                               *
	 *-----------------------------------------------*/

	public EnsembleFormeAlea ()
	{
		super ((int)((Math.random() * 100) % 100)+1); // nbPoly aléatoires entre 1 et 100
		for (int i = 0; i < TAILLE_MAX; i++)
		{
			switch((int)((Math.random() * 10) % 5)) // choix alea type
			{
			case 0 :
				ajouterForme (new Polygone ((int)((Math.random() * 100) % 15 + 5))); // creer polygone avec nbr cotes entre 5 et 20
				break;
			case 1 :
				Point p1 = new Point ();
				Point p2 = new Point ();
				while (p1.getX() == p2.getX() && p1.getY() == p2.getY())
					p2 = new Point ();
				ajouterForme (new Rectangle (p1, p2));
				break;
			case 2 : ajouterForme (new Quadrilatere());
			break;
			case 3 : ajouterForme (new Triangle (new Point(), new Point(), new Point()));
			break;
			case 4 : ajouterForme (new Cercle(new Point(), Math.random()*100));
			break;
			}
		}
	}
	
	public EnsembleFormeAlea(int nbrForme) 
	{
		super(nbrForme);
		for (int i = 0; i < nbrForme; i++)
		{
			switch((int)((Math.random() * 10) % 5)) // choix alea type
			{
			case 0 :
				ajouterForme (new Polygone ((int)((Math.random() * 100) % 15 + 5))); // creer polygone avec nbr cotes entre 5 et 20
				break;
			case 1 :
				Point p1 = new Point ();
				Point p2 = new Point ();
				while (p1.getX() == p2.getX() && p1.getY() == p2.getY())
					p2 = new Point ();
				ajouterForme (new Rectangle (p1, p2));
				break;
			case 2 : ajouterForme (new Quadrilatere());
			break;
			case 3 : ajouterForme (new Triangle (new Point(), new Point(), new Point()));
			break;
			case 4 : ajouterForme (new Cercle(new Point(), Math.random()*100));
			break;
			}
		}
	}
}
