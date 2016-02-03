/** Author: Harrison Lingren
 ** Bar Chart Project | CS447 Graphics **/

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

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
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		g.drawLine(100,200,100,400);
		
	}
}
 