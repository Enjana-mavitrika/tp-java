package dessin;

public class Point {
  
  /*------------------------------------------------
   *                   data                        *
   *                                               *
   *-----------------------------------------------*/
  
  public static final double ORIGINEX = 0.0d;
  public static final double ORIGINEY = 0.0d;
  public static final int SAM = -1;
  public static final int ALIGNES = 0;
  public static final int SIAM = 1;
  
  private double x;
  private double y;
	
  /*------------------------------------------------
   *                   constructors                *
   *                                               *
   *-----------------------------------------------*/
  
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
	
  /*------------------------------------------------
   *                   getters                     *
   *                                               *
   *-----------------------------------------------*/
  
  public double getX()
  {
    return this.x;
  }
  public double getY()
  {
    return this.y;
  }
	
  /*------------------------------------------------
   *                   setters                     *
   *                                               *
   *-----------------------------------------------*/
  
  public void setX(double x)
  {
    this.x = x;
  }
  public void setY(double y)
  {
    this.y = y;
  }
  
  /*------------------------------------------------
   *                   methods                     *
   *                                               *
   *-----------------------------------------------*/
  
  public double distance(final Point p)
  {
    return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
  }
  public double distance()
  {
    Point origine = new Point(ORIGINEX, ORIGINEY);
    return this.distance(origine);
  }
  public String toString()
  {
    return " x = " + this.x + " y = " +this.y;
  }
  
  /**
   * Methode qui retourne le signe de l'angle formé par les 3 points
   * 
   * @param Point : 1er point qui forme l'angle
   * @param Point : 2nd point qui forme l'angle
   * @return SAM = -1|ALIGNE = 0|SIAM = 1 : le signe de l'angle
   */
  public final int signeAngle (Point b, Point c)
  {
    double signe;
    signe = (b.getX() - this.x) * (c.getY() - this.y) - (c.getX() - this.x) * (b.getY() - this.y);
    if (signe == 0)
    {
      return ALIGNES;
    }
    else if (signe > 0)
    {
      return SIAM;
    }
    else
    {
      return SAM;
    }
  }
  
}
