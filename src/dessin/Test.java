package dessin;
import dessin.Polygone;
import dessin.Triangle;
import dessin.Quadrilatere;
import dessin.Rectangle;
import dessin.EnsemblePolygone;
import dessin.EnsemblePolygoneAlea;
import dessin.Cercle;
import dessin.EnsembleForme;
import dessin.EnsembleFormeAlea;

public class Test
{

  public static void main(String[] args)
  {
    
   /*------------------------------------------------
    *                                               *
    *          declaration variables                *
    *                                               *
    *-----------------------------------------------*/
	  
    Point p = new Point(0.5d, 1.5d);
    Point pt = new Point(1.0d, 0.5d);
    Point p1 = new Point(0.0d, 1.0d);
    Point p2 = new Point(3.0d, 4.0d);
    Point p3 = new Point(2.0d, 1.0d);
    Polygone pol = new Polygone(4);
    Polygone pol1 = new Polygone(3);
    Triangle tri = new Triangle(new Point(0.0d, 0.0d), p1, new Point(3.0d, 0.0d));
    Triangle tri2 = new Triangle (new Point(3.0d, 0.0d), new Point(0.0d, 0.0d), p1);
    Polygone tri_po = new Triangle(new Point (0.0d, 0.0d), new Point (0.0d, 1.0d), new Point (1.0d, 0.0d));
    Quadrilatere quad = new Quadrilatere(p, p1, p2, p3);
    Quadrilatere quad2 = new Quadrilatere(p3, p, p1, p2);
    Rectangle rec = new Rectangle(p1, new Point(3.0d, 0.0d));
    Cercle c = new Cercle(new Point(1.0d, 1.0d), 2.0d);
    Cercle c2 = new Cercle (new Point(1.0d, 1.0d), 1.5d);
    Polygone pol3 = new Polygone(4);
    Quadrilatere quad3 = new Quadrilatere(pt, p3, p2, p1);
    EnsemblePolygone ensPol = new EnsemblePolygone(3);
    EnsemblePolygoneAlea ensPolAlea = new EnsemblePolygoneAlea();
    EnsembleForme ensFor = new EnsembleForme(5);
    EnsembleFormeAlea ensForAlea = new EnsembleFormeAlea();



    /*-----------------------------------------------
    *                                               *
    *       test de la methode toString() TP        *
    *                                               *
    *-----------------------------------------------*/
    afficherTest("METHODE TOSTRING() TP5");
    System.out.println(p + "\n" + pt + "\n" + p1 + "\n" + p2 + "\n" + p3 + "\n" + pol + "\n" + pol1 + "\n" + tri + "\n" + tri2 + "\n" + tri_po + "\n" + quad + "\n" + quad2 + "\n" + rec + "\n" + c + "\n" + c2 + "\n" + pol3 + "\n" + quad3);
	
		
    
    /*------------------------------------------------
    *                                               *
    *          test de la classe Point              *
    *                                               *
    *-----------------------------------------------*/
    
    afficherTest("CLASSE POINT");
    System.out.println(p);
    afficherSousTest("méthode distance()");
    System.out.println("distance entre p : " + p + " et l'origine = " + p.distance());
    afficherSousTest("méthode distance(Point p)");
    System.out.println("distance entre p : " + p + " et p1 : " + p1 + " = " + p.distance(p1));
    
    /* ==== test de la méthode signeAngle  ===== */
    afficherSousTest("méthode signeAngle(Point, Point)");
    System.out.println("p1.signeAngle(p2, p3) = " + p1.signeAngle(p2, p3));
    System.out.println("p2.signeAngle(p3, p1) = " + p2.signeAngle(p3, p1));
    System.out.println("p1.signeAngle(p1, p2) = " + p3.signeAngle(p1, p2));
		
    
    /*------------------------------------------------
    *                                               *
    *        test de la classe Polygone             *
    *                                               *
    *-----------------------------------------------*/
    
    afficherTest("CLASSE POLYGONE");
    System.out.println("Creation polygone :\n" + pol);
    System.out.println("Son perimetre = " + pol.perimetre());
    afficherSousTest("méthode changePoint(int n, double x, double y)");
    pol.changePoint(1, 1.0d, 2.0d);
    System.out.println("changer point 1");
    System.out.println(pol);
    afficherSousTest("méthode changePoint(int n, Point p)");
    System.out.println("changer point 2");
    pol.changePoint(2, p1);
    pol.changePoint(1, p1);
    pol.changePoint(3, p1);
    pol.changePoint(4, p1);
    System.out.println(pol);
    afficherSousTest("méthode perimetre()");
    System.out.println(pol + "\nSon perimetre =  " + pol.perimetre());
    
    /* ==== Test de la méthode surface() de Polygone ==== */
    afficherSousTest("méthode surface() de Polygone");
    System.out.println(pol);
    System.out.println("Sa surface = " + pol.surface());
    System.out.println(pol1);
    System.out.println("Sa surface = " + pol1.surface());
    tri.changeSommet(3, 3.0d, 0.0d);
    System.out.println(tri);
    System.out.println("Sa surface = " + tri.surface());

    /* ==== Test de la méthode estConvexe()  ==== */
    afficherSousTest("méthode estConvexe()");
    System.out.println("tri : " + tri);
    System.out.println("tri.estConvexe = " + tri.estConvexe());
    System.out.println("rec : " + rec);
    System.out.println("rec.estConvexe = " + rec.estConvexe());
    System.out.println("pol : " + pol);
    System.out.println("pol.estConvexe = " + pol.estConvexe());

    /* ==== Test de la méthode dedans() ==== */
    afficherSousTest("méthode dedans()");
    System.out.println("tri : " + tri);
    System.out.println("p : " + p);
    System.out.println("tri.dedans(p) = " + tri.dedans(p));
    System.out.println("tri : " + tri);
    System.out.println("pt : " + pt);
    System.out.println("tri.dedans(pt) = " + tri.dedans(pt));

    /* ==== Test de la méthode plusGrand(Polygone) ==== */
    afficherSousTest("méthode plusGrand(Polygone)");
    System.out.println("tri = " + tri);
    System.out.println("rec = " + rec);
    System.out.println("tri.plusGrand(rec) = " + tri.plusGrand(rec));
    System.out.println("rec.plusGrand(tri) = " + rec.plusGrand(tri));

    /* ==== Test de la méthode equals ==== */
    afficherSousTest("méthode equals(Polygone)");
    System.out.println("rec.equals(rec) = " + rec.equals(rec));
    System.out.println("rec : " + rec + "\nrec.equals(tri) = " + rec.equals(tri));
    System.out.println("tri : " + tri + "\n tri2 : " + tri2 + "\ntri.equals(tri2) = " + tri.equals(tri2));
    System.out.println("quad : " + quad + "\n quad2 : " + quad2 + "\nquad.equals(quad2) = " + quad.equals(quad2));

    afficherSousTest("methode translater(double, double)");
    System.out.println("rec = " + rec + "\n rec.translater(2.0d, 2.0d)");
    rec.translater(2.0d, 2.0d);
    System.out.println("rec = " + rec);
    
    


    /*------------------------------------------------
    *                                               *
    *          test de la classe triangle           *
    *                                               *
    *-----------------------------------------------*/
    
    afficherTest("CLASSE TRIANGLE");
    System.out.println("Creation d'un triangle à partir de 3 points");
    System.out.println(tri);
    afficherSousTest("methode changeSommet(int n, double x, double y)");
    tri.changeSommet(3, 23.0d, 12.0d);
    System.out.println(tri);

    
    /*------------------------------------------------
    *                                               *
    *      test de la classe Quadrilatere           *
    *                                               *
    *-----------------------------------------------*/
    
    afficherTest("CLASSE QUADRILATERE");
    System.out.println("Creation d'un quadrilatere à partir de 4 points");
    System.out.println(quad);

    
    /*------------------------------------------------
    *                                               *
    *       test de la classe Rectancle             *
    *                                               *
    *-----------------------------------------------*/
    
    afficherTest("CLASSE RECTANGLE");
    System.out.println("Creation d'un rectangle à partir des 2 points en haut à gauche et en bas à doite");
    System.out.println(rec);
    afficherSousTest("methode hauteur() et largeur() et surface()");
    System.out.println("Hauteur du rectangle = " + rec.hauteur() + "; Largeur du rectangle = " + rec.largeur() + " Surface = " + rec.surface());


    
    /*-----------------------------------------------
    *                                               *
    *    test de ma classe EnsemblePolygone         *
    *                                               *
    *-----------------------------------------------*/
    
    afficherTest("CLASSE ENSEMBLE POLYGONE");
    System.out.println(ensPol);
    afficherSousTest("methode ajouterPolygone(Polygone pol)");
    ensPol.ajouterPolygone(tri);
    ensPol.ajouterPolygone(rec);
    ensPol.ajouterPolygone(quad);
    ensPol.ajouterPolygone(pol1);
    System.out.println(ensPol);
    afficherSousTest("methode sommePerimetres()");
    System.out.println("Somme des perimetres de ses polygones = " + ensPol.sommePerimetres());
    afficherSousTest("methode affiche()");
    ensPol.affiche();


    /*-----------------------------------------------
    *                                               *
    * test du comportement polymorphe de surface()  *
    *                                               *
    *-----------------------------------------------*/
    afficherSousTest("comportement polymorphe de surface()");
    System.out.println("Triangle surclassé en Polygone tri_po = " + tri_po);

    
    /*-----------------------------------------------
    *                                               *
    *     TEST DE LA CLASSE ENSEMBLEPOLYGONEALEA    *
    *                                               *
    *-----------------------------------------------*/
    afficherTest("ENSEMBLEPOLYGONEALEA");
    afficherSousTest("méthode affiche() ");
    ensPolAlea.affiche();

    /*---------------------------------------------------
    *                                                   *
    * test du comportement polymorphe de sommeSurface() *
    *                                                   *
    *---------------------------------------------------*/
    afficherSousTest("méthode sommeSurface()");
    System.out.println("Somme surface ensPolAlea (Objet EnsemblePolygoneAlea) = " + ensPolAlea.sommeSurface());


    /*-----------------------------------------------
    *                                               *
    *     TEST DE LA CLASSE CERCLE                  *
    *                                               *
    *-----------------------------------------------*/
    afficherTest("CLASSE CERCLE");
    System.out.println("c = " + c);
    afficherSousTest("methode perimetre()");
    System.out.println("c.perimetre() = " + c.perimetre());
    afficherSousTest("methode surface()");
    System.out.println("c.surface() = " + c.surface());
    afficherSousTest("methode dedans(Point)");
    System.out.println("Point p : " + p + "\n c.dedans(p) = " + c.dedans(p));
    System.out.println("Point p2 : " + p2 + "\n c.dedans(p) = " + c.dedans(p2));
    afficherSousTest("methode plusGrand(Cercle)");
    System.out.println("c = " + c + " ; c2 = " + c2 + "\n c.plusGrand(c2) = " + c.plusGrand(c2));
    System.out.println("c = " + c + " ; c2 = " + c2 + "\n c2.plusGrand(c) = " + c2.plusGrand(c));
    afficherSousTest("methode translater(double, double)");
    System.out.println("c = " + c + "\n c.translater(2.0d, 2.0d)");
    c.translater(2.0d, 2.0d);
    System.out.println("c = " + c);
    System.out.println("c = " + c + "\n c.translater(-3.0d, -1.0d)");
    c.translater(-3.0d, -1.0d);
    System.out.println("c = " + c);


    /*-----------------------------------------------
    *                                               *
    *     TEST DE LA CLASSE ABSTRAITE FORME         *
    *                                               *
    *-----------------------------------------------*/
    afficherTest("CLASSE ABSTRAITE FORME");
    afficherSousTest("methode plusGrand(Forme)");
    System.out.println(" c = " + c + "\nrec = " + rec + "\nrec.plusGrand(c) = " + rec.plusGrand(c));

    
    /*-----------------------------------------------
    *                                               *
    *     TEST DE LA CLASSE ENSEMBLEFORME           *
    *                                               *
    *-----------------------------------------------*/
    afficherTest("CLASSE ENSEMBLEFORME");
    System.out.println(ensFor);
    afficherSousTest("methode ajouterForme(Forme)");
    ensFor.ajouterForme(tri);
    ensFor.ajouterForme(rec);
    ensFor.ajouterForme(quad);
    ensFor.ajouterForme(pol1);
    ensFor.ajouterForme(c);
    
    System.out.println(ensFor);
    afficherSousTest("methode sommePerimetres()");
    System.out.println("Somme des perimetres de ses formes = " + ensFor.sommePerimetres());
    afficherSousTest("methode affiche()");
    ensFor.affiche();


     /*-----------------------------------------------
    *                                               *
    *     TEST DE LA CLASSE ENSEMBLEFORMEALEA    *
    *                                               *
    *-----------------------------------------------*/
    afficherTest("ENSEMBLEFORMEALEA");
    afficherSousTest("méthode affiche() ");
    ensForAlea.affiche();

    /*---------------------------------------------------
    *                                                   *
    * test du comportement polymorphe de sommeSurface() *
    *                                                   *
    *---------------------------------------------------*/
    afficherSousTest("méthode sommeSurface()");
    System.out.println("Somme surface ensForAlea (Objet EnsembleFormeAlea) = " + ensForAlea.sommeSurface());

    
    
  }


    
  private static void afficherTest(String nomTest)
  {
    System.out.println();
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("*                                                                     *");
    System.out.println("*       Test de         " + nomTest + "                               ");
    System.out.println("*                                                                     *");
    System.out.println("-----------------------------------------------------------------------");
    System.out.println();
  }

  public static void afficherSousTest(String nomTest)
  {
    System.out.println();
    System.out.println("=================================  TEST DE " + nomTest.toUpperCase()  + "  ===========================");
    System.out.println();
  }
}
