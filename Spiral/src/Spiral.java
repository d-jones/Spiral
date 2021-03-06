
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

import javax.swing.*;
public class Spiral extends JPanel{
	
	private int radius;
	private String radiusTemp;
	public static void main(String[] args){
		Spiral spiral = new Spiral();
		
		
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(spiral);
		application.setSize(500,500);
		application.setVisible(true);
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint (Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Arc2D arc;
		

		double x = 250.0;
		double y = 250.0;
		double width = radius/10.0;
		double height = radius/10.0;
		double depth = radius/10.0;
		int startAngle = -90;
		int arcAngle = 180;
		int numArcs = 10;
		
		//create x/y axis
		g.drawLine(250,0, 250, 500);
		g.drawLine(0, 250, 500, 250);
		//create "x" and "y"
		Font f = new Font("Times New Roman", Font.BOLD, 16);
		g.setFont(f);
		g.drawString("X", 470, 240);
		g.drawString("Y", 260, 15);
		
		//draw the spiral
		for(int i = 0; i < numArcs; i++){
			if(i % 2 == 0){
				x -= depth;
				width += 2*depth;
				height += 2*depth;
				arc = new Arc2D.Double(x, y, width, height, startAngle, arcAngle, Arc2D.OPEN);
				g2d.draw(arc);
			}
			else{
				y -= 2*depth;
				x -= depth;
				width += 2*depth;
				height += 2*depth;
				arc = new Arc2D.Double(x, y, width, height, startAngle, -arcAngle, Arc2D.OPEN);
				g2d.draw(arc);
			}
		}
		
		//Draw the radius to verify the size of the spiral
		g2d.setStroke(new BasicStroke(3));
		g2d.draw(new Line2D.Float(250, 250, 250, 250-radius));
	}
	
	
	//constructor
	Spiral(){
		//initialize "radius" and validate input
		while(true){
			try{
				if(radiusTemp != null){
					radius = Integer.parseInt(radiusTemp);
					if(radius < 251 && radius > 0) break;
				}
				radiusTemp = JOptionPane.showInputDialog(null, "Please enter a radius between 1-120:");
				radius = Integer.parseInt(radiusTemp);
				if(radius < 251 && radius > 0) break;
			}
			catch(NumberFormatException nfe){
				radiusTemp = JOptionPane.showInputDialog(null, "Please enter a radius between 1-120:");
				if(radius < 251 && radius > 0) break;
			}
		}
	}
}
