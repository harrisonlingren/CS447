/** Author: Harrison Lingren
 ** Bar Chart Project | CS447 Graphics **/

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class robot extends JFrame {
	private static final String title="Sensor Array";
	private static final int width=800;
	private static final int height=600;
	
	public robot() {
		//init
		setTitle(title); setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setContentPane(new Bot());
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new robot();
	}
}

class Bot extends JPanel {
	
	/* int numBars, maxVal, barWidth, pos;
	int values[];
	String labels[]; */
	int xP[] = {50,50,350,350};
	int yP[] = {50,250,250,50};
	
	int botX[] = {185,185,215,215};
	int botY[] = {135,165,165,135};
	
	int xCent = (botX[0] + botX[2]) / 2;
	int yCent = (botY[0] + botY[2]) / 2;
	
	int botTriX[] = {190,210,200};
	int botTriY[] = {135,135,125};
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Dimension size = getSize();
		double w = size.getWidth() - 50;
		double h = size.getHeight() + 20;
		
		double n = 23;
		
		/* try {readFile();}
		catch(IOException e) {System.err.println("IO issue");}
		 */
		
		// room
		g.setColor(Color.white);
		g.fillPolygon(xP,yP,xP.length);
		g.setColor(Color.black);
		g.drawPolygon(xP,yP,xP.length);
		
		//sensor lines
		double angle, cosAngle, sinAngle, xRadius, yRadius, lineX, lineY;
		
		for (double i=0; i<n; i++) {
			// get angles for 'n' lines
			angle = Math.PI * (i/n) * 2;
			System.out.println(angle);
			cosAngle = Math.cos(angle);
			sinAngle = Math.sin(angle);
			
			// find radius length to border
			xRadius = 200;
			yRadius = 200;
			
			
			// find outer coordinate
			lineX = xCent + (cosAngle * xRadius);
			lineY = yCent + (sinAngle * yRadius);
			
			// draw line
			g.drawLine((int)xCent,(int)yCent,(int)lineX,(int)lineY);
		}
		
		//bot square and triangle
		g.setColor(Color.white);
		g.fillPolygon(botX,botY,botX.length);
		g.fillPolygon(botTriX,botTriY,botTriX.length);
		g.setColor(Color.black);
		g.drawPolygon(botX,botY,botX.length);
		g.drawPolygon(botTriX,botTriY,botTriX.length);
		
	}
	
	public void readFile() 
		throws IOException, FileNotFoundException {
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter the name of the file to process:  ");
		String file; file = inp.nextLine();
		System.out.println(file);
		Scanner fileScan = new Scanner( new FileReader( file ) );
		fileScan.useDelimiter(",");
		
				
		
		/* numBars = fileScan.nextInt();
		values = new int[numBars]; labels = new String[numBars];
		for (int i=0; i<numBars-1; i++) {
			values[i] = fileScan.nextInt();
			labels[i] = fileScan.next(); 
			System.out.println(values[i] + " " + labels[i]);
		}
		inp.close();
		fileScan.close(); */
	}	
}
 