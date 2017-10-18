package dessin;

public class Point {
    /**
     * datas
     */
	public static final int SAM=-1;
	public static final int ALIGNES=0;
	public static final int SIAM=1;
	
    public static final double ORIGINEX = 0.0d;
    public static final double ORIGINEY = 0.0d;
    private double x;
    private double y;
	
    /**
     * constructors
     */
    public Point ()
    {
	this.x = (Math.random()*300)%300;
	this.y = (Math.random()*300)%300;
    }
    public Point(double x, double y)
    {
	this.x = x;
	this.y = y;
    }
	
    /**
     * getters
     */
    public double getX()
    {
	return this.x;
    }
    public double getY()
    {
	return this.y;
    }
	
    /**
     * setters
     */
    public void setX(double x)
    {
	this.x = x;
    }
    public void setY(double y)
    {
	this.y = y;
    }
    /**
     * methods
     */
    public double distance(final Point p)
    {
	return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }
    public double distance()
    {
	Point origine = new Point(ORIGINEX, ORIGINEY);
	return this.distance(origine);
    }
    
    public int singeAngle(Point b,Point c)
    { 
    	double a=(b.x-this.x)*(c.y-this.y)-(c.x-this.x)*(b.y-this.y) ;
   if (a>0)  
   {
   return SAM;
   }
   else if (a<0)
   {
	   return ALIGNES;
   }
   else
   {
	   return SIAM;
   }
   
    }
    
    public String toString()
    {
	return " x = " + this.x + " y = " +this.y  ;
    }
}
