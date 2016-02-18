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
	int xP[] = {50,50,350,350,250};
	int yP[] = {50,250,250,50,100};
	
	int botX[] = {185,185,215,215}; //width: 30 height: 30
	int botY[] = {135,165,165,135}; 
	
	double xCent = 0;
	double yCent = 0;
	
	int botTriX[] = {190,210,200};
	int botTriY[] = {135,135,125};
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Dimension size = getSize();
		double w = size.getWidth() - 50;
		double h = size.getHeight() + 20;
		
		double n = 64;
		
		/* try {readFile();}
		catch(IOException e) {System.err.println("IO issue");} */
		
		double xP_dbl[] = new double[xP.length];
		for (int i=0; i<xP.length; i++)
			xP_dbl[i] = (double) xP[i];
		
		double yP_dbl[] = new double[yP.length];
		for (int i=0; i<yP.length; i++)
			yP_dbl[i] = (double) yP[i];		
		
		// room
		g.setColor(Color.white);
		g.fillPolygon(xP,yP,xP.length);
		g.setColor(Color.black);
		g.drawPolygon(xP,yP,xP.length);
		
		Polygon p = new Polygon(xP,yP,xP.length);
		
		// find center point for robot
		xCent = calcCenter(xP_dbl.length,xP_dbl,yP_dbl,xCent);
		yCent = calcCenter(xP_dbl.length,xP_dbl,yP_dbl,yCent);
		
		print("");
		print("xCent:"+xCent);
		print("yCent:"+yCent);
		
		int botX[] = {(int)xCent-15,(int)xCent-15,(int)xCent+15,(int)xCent+15}; //width: 30 height: 30
		int botY[] = {(int)yCent-15,(int)yCent+15,(int)yCent+15,(int)yCent-15};
		System.out.print(Arrays.toString(botX));
		System.out.print(Arrays.toString(botY));
		
		//sensor lines
		double angle, cosAngle, sinAngle, radius, lineX, lineY;		
		for (double i=0; i<n; i++) {
			// get angles for 'n' lines
			angle = Math.PI * (i/n) * 2;
			// System.out.println(angle);
			cosAngle = Math.cos(angle);
			sinAngle = Math.sin(angle);
			
			// find radius length to border
			radius = 0;
			do {
				lineX = xCent + (cosAngle * radius);
				lineY = yCent + (sinAngle * radius);
				radius++;
			}
			// draw line
			while (p.contains(lineX, lineY));
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
	
	public void print(Object i) {System.out.println(i);}
	
	public double calcCenter(int nP, double[] x, double[] y, double xCent) {
		// calculate area
		double pA = 0;
		print("Finding polygon area...");
		for (int j=1; j<nP; j++) {
			pA = pA + ( (x[j-1] * y[j]) - (x[j] * y[j-1]) );
			print("  "+j+":"+pA);
		}
		pA = pA / 2;
		print("  pA:"+pA);

		// x center point
		xCent = 0;
		print("Finding xCent...");
		for (int j=1; j<nP; j++) {
			xCent = xCent + ( (x[j-1] + x[j]) * ( (x[j-1] * y[j]) - (x[j] * y[j-1]) ) );
			print("    "+x[j-1]); print("    "+y[j-1]); print("  "+j+":"+xCent);
		}
		xCent = xCent * (1 / (6 * pA));
		print("  xCent:"+xCent);
		
		return xCent;
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
 