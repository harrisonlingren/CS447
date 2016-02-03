/** Author: Harrison Lingren
 ** Bar Chart Project | CS447 Graphics **/

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BarChart extends JFrame {
	private static final String title="Bar Chart Generator";
	private static final int width=1280;
	private static final int height=720;
	
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
	
	int numBars, maxVal
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		readFile(file);
		
		
		
	}
	
	private void readFile() 
		throws IOException, FileNotFoundException {
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter the name of the file to process:  ");
		String file;
		file = inp.next();
		Scanner fileScan = new Scanner( new FileReader(file));
		
		numBars = fileScan.nextInt();
		for (int i=0; i<numBars-1; i++) {
			values[i] = fileScan.nextInt();
			labels[i] = fileScan.next();
		}
	}
	
}
 