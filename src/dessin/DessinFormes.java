package dessin;

import javax.swing.JFrame;
import java.awt.Color;

public class DessinFormes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fenetre = new JFrame("Dessin de formes géométriques");
		Panneau panneau = new Panneau(7);
		fenetre.setSize(1000, 800);
		fenetre.setLocation(100, 100);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panneau.setBackground(Color.GRAY);
		fenetre.setContentPane(panneau);
		
		fenetre.setVisible(true);
		
	}

}
