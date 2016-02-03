/** Author: Harrison Lingren
 ** Bar Chart Project | CS447 Graphics **/

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class BarChart extends JFrame {
	private static final String title="Bar Chart Generator";
	private static final int width=800;
	private static final int height=600;
	
	public BarChart() {
		//init
		setTitle(title); setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setContentPane(new Chart());
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new BarChart();
	}
}

class Chart extends JPanel {
	
	int numBars, maxVal, barWidth, pos;
	int values[];
	String labels[];
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Dimension size = getSize();
		double w = size.getWidth() - 50;
		double h = size.getHeight() + 20;
		
		try {readFile();}
		catch(IOException e) {System.err.println("IO issue");}
		
		barWidth = ((int)(w/numBars)) - 20;
		pos = 5;
		
		int xPos[] = {pos,pos,pos,pos};
		int yPos[] = {pos,pos,pos,pos};
		
		maxVal = maxValue(values);
		double barH, ratio;
		
		for (int i=0; i<numBars-1; i++) {
			new Color((int)(Math.random() * 0x1000000));
			ratio = (double)values[i] / (double)maxVal;
			barH = ( (h) * ratio ) - 10;
			
			xPos[0] = pos; xPos[2] = pos+barWidth;
			xPos[1] = xPos[0]; xPos[3] = xPos[2];
			yPos[0] = (int)h; yPos[1] = (int)barH;
			yPos[2] = yPos[1]; yPos[3] = yPos[0];
			
			System.out.println("xPos:"+xPos[1]+" yPos:"+yPos[0]+" h:"+barH+" ratio:"+ratio+" pos:"+pos);

			g.fillPolygon(xPos, yPos, xPos.length);
			g.drawString(labels[i],xPos[0],yPos[0]);
			pos = pos + barWidth + 10;
		}
		
	}
	
	public void readFile() 
		throws IOException, FileNotFoundException {
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter the name of the file to process:  ");
		String file; file = inp.nextLine();
		System.out.println(file);
		Scanner fileScan = new Scanner( new FileReader( file ) );
		fileScan.useDelimiter(",");
		
		numBars = fileScan.nextInt();
		values = new int[numBars]; labels = new String[numBars];
		for (int i=0; i<numBars-1; i++) {
			values[i] = fileScan.nextInt();
			labels[i] = fileScan.next(); 
			System.out.println(values[i] + " " + labels[i]);
		}
		inp.close();
		fileScan.close();
	}
	
	private static int maxValue(int[] arr) {
	int max = arr[0];
	for (int i = 0; i<arr.length; i++) {
		if (arr[i] > max) {
			max = arr[i];
		}
	}
	return max;
}
	
}
 