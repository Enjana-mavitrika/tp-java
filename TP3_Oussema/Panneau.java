package dessin;

import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Panneau extends JPanel {

	//ens alea
	EnsembleFormeAlea ensembleF = new EnsembleFormeAlea(20);
	
	Point p1=new Point(0,0);
	Cercle c1=new Cercle(p1,200);
	Point p2=new Point(400,300);
	Cercle c2=new Cercle(p2,100);
	
	Polygone pg=new Polygone(3);
	
	//button
JButton Arcenciel = new JButton ("Arc-en-ciel");
//Couleur
Color randomColor=Color.RED;
   


	public void paintComponent(Graphics g) {
		
	g.setColor(randomColor);
	c1.seDessiner(g);
	c2.seDessiner(g);
	
	
	pg.changePoint(0,0,0);
	pg.changePoint(1,300,0);
	pg.changePoint(2,0,30);
	
	pg.seDessiner(g);


	//ensembleF.affiche();
	//ensembleF.toutDessiner(g);
	}
	
	public void changeCouleurs(){
		
		Random rand = new Random();
		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = rand.nextFloat();
		float gg = rand.nextFloat();
		float b = rand.nextFloat();
		randomColor = new Color(r, gg, b);
		
		
		 repaint();
	}
	
	
	public Panneau(){
		Arcenciel.setPreferredSize(new Dimension(180, 60));
		add(Arcenciel);
		Arcenciel.addActionListener( new ActionListener()
		{
		    
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK!!!!!");
				changeCouleurs();
		
				
			}
		});
	
	}

	
	

}

