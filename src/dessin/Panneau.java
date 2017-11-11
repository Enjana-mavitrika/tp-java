package dessin;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Panneau extends JPanel{
	
	/*------------------------------------------------
	 *                   data                        *
	 *                                               *
	 *-----------------------------------------------*/

	private static final long serialVersionUID = 1L;
//	Cercle c1 = new Cercle(new Point(Dessinable.WIDTH_MAX / 2, Dessinable.HEIGHT_MAX / 2), 200), c2 = new Cercle(new Point(400.0d, 300.0d), 100);
//	Rectangle r1 = new Rectangle(new Point(10.0d, 10.0d), new Point(50.0d, 50.0d));
//	Polygone p1 = new Polygone(10), p2 = new Polygone(15);
	
	EnsembleFormeAlea ensembleF;
	
	public Panneau(int nbrForme) {ensembleF = new EnsembleFormeAlea(nbrForme); ensembleF.changeCouleurs();}
	
	/*------------------------------------------------
	 *   redefinition paintComponent(Graphics)       *
	 *                                               *
	 *-----------------------------------------------*/

	public void paintComponent(Graphics g) 
	{
		ensembleF.toutDessiner(g);
		System.out.println(ensembleF.getTaille());
	}
}
