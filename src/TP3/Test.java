import dessin.Point;
import dessin.Polygone;
import dessin.Triangle;
import dessin.Quadrilatere;
import dessin.Rectangle;
import dessin.EnsemblePolygone;

public class Test
{

    public static void main(String[] args)
    {
	// les variables
	Point p = new Point();
	Point p1 = new Point(0.0d, 1.0d);
	Point p2 = new Point();
	Point p3 = new Point();
	Polygone pol = new Polygone(4);
	Polygone pol1 = new Polygone(3);
	Triangle tri = new Triangle(new Point(0.0d, 0.0d), p1, new Point(3.0d, 0.0d));
	Quadrilatere quad = new Quadrilatere(p, p1, p2, p3);
	Rectangle rec = new Rectangle(p1, new Point(3.0d, 0.0d));
	EnsemblePolygone ensPol = new EnsemblePolygone(3);
	
		
	/* test de la classe Point */
	afficherTest("CLASSE POINT");
	System.out.println(p);
	afficherTest("méthode distance()");
	System.out.println("distance entre p : " + p + " et l'origine = " + p.distance());
	afficherTest("méthode distance(Point p)");
	System.out.println("distance entre p : " + p + " et p1 : " + p1 + " = " + p.distance(p1));
		
	/* test de la classe Polygone */
	afficherTest("CLASSE POLYGONE");
	System.out.println("Creation polygone :\n" + pol);
	System.out.println("Son perimetre = " + pol.perimetre());
	afficherTest("méthode changePoint(int n, double x, double y)");
	pol.changePoint(1, 1.0d, 2.0d);
	System.out.println("changer point 1");
	System.out.println(pol);
	afficherTest("méthode changePoint(int n, Point p)");
	System.out.println("changer point 2");
	pol.changePoint(2, p1);
	pol.changePoint(1, p1);
	pol.changePoint(3, p1);
	pol.changePoint(4, p1);
	System.out.println(pol);
	afficherTest("méthode perimetre()");
	System.out.println(pol + "\nSon perimetre =  " + pol.perimetre());

	// Test de la classe Triangle
	afficherTest("CLASSE TRIANGLE");
	System.out.println("Creation d'un triangle à partir de 3 points");
	System.out.println(tri);
	afficherTest("methode changeSommet(int n, double x, double y)");
	tri.changeSommet(3, 23.0d, 12.0d);
	System.out.println(tri);

	// Test de la classe Quadrilatere
	afficherTest("CLASSE QUADRILATERE");
	System.out.println("Creation d'un quadrilatere à partir de 4 points");
	System.out.println(quad);

	// Test de la classe Rectangle
	afficherTest("CLASSE RECTANGLE");
	System.out.println("Creation d'un rectangle à partir des 2 points en haut à gauche et en bas à doite");
	System.out.println(rec);
	afficherTest("methode hauteur() et largeur() et surface()");
	System.out.println("Hauteur du rectangle = " + rec.hauteur() + "; Largeur du rectangle = " + rec.largeur() + " Surface = " + rec.surface());

	// Test de la méthode surface() de Polygone
	afficherTest("méthode surface() de Polygone");
	System.out.println(pol);
	System.out.println("Sa surface = " + pol.surface());
	System.out.println(pol1);
	System.out.println("Sa surface = " + pol1.surface());
	tri.changeSommet(3, 3.0d, 0.0d);
	System.out.println(tri);
	System.out.println("Sa surface = " + tri.surface());

	// Test de la classe EnsemblePolygone
	afficherTest("CLASSE ENSEMBLE POLYGONE");
	System.out.println(ensPol);
	afficherTest("methode ajouterPolygone(Polygone pol)");
	ensPol.ajouterPolygone(tri);
	ensPol.ajouterPolygone(rec);
	ensPol.ajouterPolygone(quad);
	ensPol.ajouterPolygone(pol1);
	System.out.println(ensPol);
	afficherTest("methode sommePerimetres()");
	System.out.println("Somme des perimetres de ses polygones = " + ensPol.sommePerimetres());
	afficherTest("methode affiche()");
	ensPol.affiche();
	
	
    }


    
    private static void afficherTest(String nomTest)
    {
	System.out.println("\n\n*** Test de " + nomTest + "***");
	System.out.println("====================================");
    }
}
