package dessin;

public class Triangle extends Polygone
{
    // constructors
    /**
     * Creer un triangle a partir de 3 Points
     *
     */
    public Triangle(Point p1, Point p2, Point p3)
    {
	super(3);
	super.changePoint(1, p1);
	super.changePoint(2, p2);
	super.changePoint(3, p3);
    }

    // methods
    /**
     * Change le coordonne de son n-ieme sommet par (x, y)
     *
     * @param int,int  coordonnee x et y  
     */
    public void changeSommet(int n, double x, double y)
    {
	super.changePoint(n, x, y);
    }

    
    
}
