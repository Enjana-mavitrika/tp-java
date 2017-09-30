package dessin;

public class Quadrilatere extends Polygone
{
    // constructors
    public Quadrilatere ()
    {
	super(4);
    }
    public Quadrilatere (Point p1, Point p2, Point p3, Point p4)
    {
	super(4);
	super.changePoint(1, p1);
	super.changePoint(2, p2);
	super.changePoint(3, p3);
	super.changePoint(4, p4);
    }

    
}
