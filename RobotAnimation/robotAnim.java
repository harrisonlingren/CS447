/*
	Program: 	Robot Animation
	Author:		Harrison Lingren
	Class: 		CS 447
 */

import java.io.*;
import java.util.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class robotAnim extends JFrame {
	public static final int width=800;
	public static final int height=600;
	public static final String title="Robot Animation";
	
	public robotAnim() {
		//init
		setTitle(title); setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setContentPane(new anim());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new robotAnim();
	}
}

class anim extends JPanel {
	
	Dimension size = getSize();
	double w = size.getWidth();
	double h = size.getHeight();
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawLine(10,200,50,400);
		g.drawLine(600,10,200,100);
	}
}