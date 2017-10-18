package dessin;
import dessin.Triangle;
import dessin.Rectangle;

public class EnsemblePolygoneAlea extends EnsemblePolygone {

	public EnsemblePolygoneAlea(int tailleMax) {
		super(tailleMax);
		
		
		
		EnsemblePolygone Ens=new EnsemblePolygone(tailleMax);
		
		for (int i=1;i<=tailleMax;i++)
		{
			Point p1 = new Point();
			Point p2 = new Point();
			Point p3 = new Point();
			
			
			Triangle Tri1=new Triangle(p1,p2,p3);
			Rectangle Rect1=new Rectangle(p1,p2);
			
			
			
		int rd=(int)(Math.random()*(4-1))+1;
		//System.out.println("rd:"+rd);	
		switch(rd)
			{
			case 1: Ens.ajouterPolygone(Tri1);
				break;
			case 2: Ens.ajouterPolygone(Rect1);
				break;
			case 3:
				int rd2=(int)(Math.random()*(21-5))+5;
				//System.out.println("rd2:"+rd2);
				Polygone Poli1=new Polygone(rd2);
				Ens.ajouterPolygone(Poli1);
				break;
				
			default:System.out.println("erreur");
			}
		
		
		}
		
		}
		
		
	
	}


	

