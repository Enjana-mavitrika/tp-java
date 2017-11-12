package dessin;
import java.awt.*; 
import javax.swing.*; 


public class DessinFormes  {

	public static void main(String[] args) {
		
		//Créer la JPanel
		
				Panneau panel = new Panneau(); 
				panel.setBackground(Color.GRAY);
				panel.setPreferredSize(new Dimension(1000,500));
				panel.setLocation(100, 100);
				
				
			    
				
		 //Créer la JFrame
		
		JFrame frame = new JFrame("Dessin de formes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		frame.setLocation(400, 300);
		
		
		//fullscreen
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		frame.setVisible(true);
		frame.pack();
		
	}
	


}
