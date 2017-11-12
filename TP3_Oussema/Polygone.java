package dessin;
import java.awt.*;
import java.lang.Math;

public class Polygone extends Forme {
    
    // data
    public static final int PERIMETRE_MIN = 600;
    protected Point[]sommets;
	
    
    // constructors
    public Polygone(int nbrCote)
    {
	int i;
	this.sommets = new Point[nbrCote];
	do{
	    for (i = 0; i < nbrCote; i++)
		{
		    this.sommets[i] = new Point();
		}
	}
	while(this.perimetre() < PERIMETRE_MIN);
    }
	
    // methods
    /**
     * Retourne le nombre de son cote
     * 
     * @return int le nombre de son cote
     */
    public int nbrCotes()
    {
	return this.sommets.length;
    }
    /**
     * Retourne l'objet Point numero n
     * 
     * @param n numero du point à recuperer
     * @return Point l'objet Point numero n
     */
    public Point getPoint(int n)
    {
	if (n >= 1 && n <= nbrCotes())
	    return this.sommets[n-1];
	else
	    {
		System.out.println("Attention parametre non valide donc retourne getPoint(1) !!!! " + this);
		return this.sommets[0];
	    }
    }
    /**
     * Change le point numero n par Point(x, y) 
     * 
     * @param int n numero de point
     * @param double x abcisse du point
     * @param double y ordonne du point
     */
    public void changePoint(int n, double x, double y)
    {
	if (n >= 1 && n <= nbrCotes())
	    {
		getPoint(n).setX(x);
		getPoint(n).setY(y);
	    }
	else 
	    {
		System.out.println("Attention parametre non valide donc aucun point n'a été changé !!! " );
	    }
    }
    public void changePoint(int n, Point p)
    {
	this.changePoint(n, p.getX(), p.getY());
    }
	
    /**
     * Retourne son perimetre
     * 
     * @return double son perimetre
     */
    public double perimetre()
    {
	int j;
	double perimetre = 0.0d;
	for (j = 1; j < this.nbrCotes(); j++)
	    {
		perimetre += getPoint(j).distance(getPoint(j+1));
	    }
	perimetre += getPoint(j).distance(getPoint(1));
		
	return perimetre;
    }
    /**
     * Retourne sa surface si connus
     * 
     * @return double > 0 si connus | -1 si inconnus
     */
    public double surface ()
    {
	double a, b, c, p, surface;
	int i,j,k;
	
	if(this.estConvexe()==false)
	{
		return -1;
	}
	
	switch(this.nbrCotes())
	    {
		// cas triangle : Formule de Héron
	   /* case 3:
		p = perimetre()/2.0d;
		a = getPoint(1).distance(getPoint(2));
		b = getPoint(2).distance(getPoint(3));
		c = getPoint(3).distance(getPoint(1));
		surface = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return surface;
	   */ default:
		i=1;
		j=2;
		k=3;
		surface=0;
	    while (k<=this.nbrCotes())
	    {
	    	p = perimetre()/2.0d;
			a = getPoint(i).distance(getPoint(j));
			b = getPoint(j).distance(getPoint(k));
			c = getPoint(k).distance(getPoint(i));
			surface =surface+( Math.sqrt(p * (p - a) * (p - b) * (p - c)) );
	   j++;
	   k++;
	    }
				
		return surface;
	    }

	
    }
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
  
    
    
    
    public boolean estConvexe ()
    {
      int suivant;
      int precedant;
      boolean convexe = true;
      int signe = getPoint(1).singeAngle(getPoint(2), getPoint(nbrCotes()));
      int i;
      for (i = 2; i <= nbrCotes(); i++)
      {
        suivant = (i == nbrCotes()) ? 1 : (i+1);
        precedant = (i-1);
        convexe &= (signe == getPoint(i).singeAngle(getPoint(suivant), getPoint(precedant)) && signe != Point.ALIGNES);
      }
      
      return convexe;
  }
	
  
	

	public boolean plusGrand (Polygone Poly)
    {
   if (this.surface()>Poly.surface()) 	
   {
	   return true;
   }
   return false;
    }
	

    public String toString()
    {
	int i;
	String str = new String();
	str += this.getClass().getName() + " a� " + this.nbrCotes() + " cotes :\n";
	for (i = 1; i <= this.nbrCotes(); i++)
	    {
		str += this.getPoint(i) + ", ";
	    }
		
	str +="\n Surface de "+getClass().getName()+"  =" +this.surface()+"\n";
	return str;
    }

    public boolean dedans (Point p)
    {
      int suivant;
      int signe = p.singeAngle(getPoint(1), getPoint(2));
      int i;
      boolean dedans = true;
      for (i = 2; i <= nbrCotes(); i++)
      {
        suivant = (i == nbrCotes()) ? 1 : i+1;
        dedans &= (signe == p.singeAngle(getPoint(i),getPoint(suivant))) && (signe != Point.ALIGNES);
      }

      return dedans;
    }

    public void seDessiner(Graphics g)
	{	
    	
		
    	Point origin = new Point(WIDTH_MAX/2,HEIGHT_MAX/2);
		int i=0;
    	int xx=(int)origin.getX();
    	int yy=(int)origin.getX();
    	
    	
    	while (i<nbrCotes()-1) {
    		 System.out.print("----" +i+"\n");
   
    		 int X=(int)(sommets[i].getX());
 	    	int Y=(int)(sommets[i].getY());
 	    	
 	    	//System.out.print("icixx:"+xx);
    		//System.out.print(" iciyy:"+yy+"\n");
 	    	
 	    	X=X+xx;
	    	Y=Y+yy;
	    	//System.out.print("iciX:"+X);
    		//System.out.print(" iciY:"+Y+"\n");
    		
    	
    		g.drawLine(xx, yy, X, Y);
    		
    			 
    		 xx=X;
     		yy=Y;
     		 i++;
    	}
    	int xx2=(int)origin.getX();
    	int yy2=(int)origin.getX();
    	g.drawLine(xx2, yy2, xx, yy);
 
		
    	

	
	}    
    

    public void translater(double dx, double dy)
    {
      for (int i = 1; i <= nbrCotes(); i++)
        changePoint(i, dx + getPoint(i).getX(), dy + getPoint(i).getY());
  }
    

}
