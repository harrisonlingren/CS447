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
import java.text.DecimalFormat;

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
	
	// Parts of the robot
	Polygon finger1, finger2, body, hand, arm;
	Point[] finger1P, finger2P, bodyP, handP, armP;
	
	// Rotation states - 0: arm, 1: hand, 2: fingers
	int rotState;
	
	// angle of rotation
	double angle;	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		/* g.drawLine(10,200,50,400);
		g.drawLine(600,10,200,100); */
		
		getInfo();
		rotLimb(rotState);
		
		bodyP = getOriginalPoints(4);
		
		finger1 = polygonize(finger1P);
		finger2 = polygonize(finger2P);
		arm = polygonize(armP);
		body = polygonize(bodyP);
		hand = polygonize(handP);
		
		g.setColor(Color.GRAY.darker());
		g.fillPolygon(arm);
		g.fillPolygon(body);
		
		g.setColor(Color.red);
		g.fillPolygon(hand);

		g.setColor(Color.blue);
		g.fillPolygon(finger1);
		g.fillPolygon(finger2);
	}
	
	// Returns original Point dimensions for each element
	private Point[] getOriginalPoints(int num) {
		Point[] originalPoints = new Point[4];

		switch (num) {
			// arm points
			case 0: {
				originalPoints[0]= new Point(180,345);
				originalPoints[1]= new Point(180,355);
				originalPoints[2]= new Point(360,355);
				originalPoints[3]= new Point(360,345);
				break;
			}
			// hand points
			case 1: {
				originalPoints[0]= new Point(360,340);
				originalPoints[1]= new Point(360,360);
				originalPoints[2]= new Point(390,360);
				originalPoints[3]= new Point(390,340);
				break;
			}
			// finger1 points
			case 2: {
				originalPoints[0]= new Point(390,355);
				originalPoints[1]= new Point(390,360);
				originalPoints[2]= new Point(420,360);
				originalPoints[3]= new Point(420,355);
				break;
			}
			// finger2 points
			case 3: {
				originalPoints[0]= new Point(390,340);
				originalPoints[1]= new Point(390,345);
				originalPoints[2]= new Point(420,345);
				originalPoints[3]= new Point(420,340);
				break;
			}
			// body points
			case 4: {
				originalPoints[0]= new Point(70,350);
				originalPoints[1]= new Point(70,560);
				originalPoints[2]= new Point(180,560);
				originalPoints[3]= new Point(180,350);
				break;
			}
			default: println("Error: getOriginalPoints() - polygon not found for "+num);
		}
        return originalPoints;
	}
	
	// Returns center point for each element
	private Point getCenterPoint(int rs) {
		switch (rs) {
			// center point for arm
			case 0: return new Point(180,350);
			// center point for hand
			case 1: return new Point(360,350);
			// center point for fingers
			case 2: return new Point(390,350);
			default: return null;
		}
	}
	
	// Initiates rotation based on user input
	private void rotLimb(int rs) {
		switch (rs) {
			
			// rotate all in relation to arm pivot
			case 0: {				
				// multiply point matrices by transformation matrices and convert to points
				println(""); println("Rotating arm...");
				armP = doubleArrayToPoint( multMatrix( pointArrayToMatrix( getOriginalPoints(0)), transMatrix( getCenterPoint(0), angle)));
				println(""); println("Rotating hand...");
				handP = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(1)), transMatrix(getCenterPoint(0), angle)));
				println(""); println("Rotating finger1...");
				finger1P = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(2)), transMatrix(getCenterPoint(0), angle)));
				println(""); println("Rotating finger2...");
				finger2P = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(3)), transMatrix(getCenterPoint(0), angle)));
				
				
				break;
			}
			
			// rotate all in relation to hand pivot
			case 1: {
				println(""); println("Rotating arm...");
				armP = getOriginalPoints(0);
				println(""); println("Rotating hand...");
				handP = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(1)), transMatrix(getCenterPoint(1), angle)));
				println(""); println("Rotating finger1...");
				finger1P = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(2)), transMatrix(getCenterPoint(1), angle)));
				println(""); println("Rotating finger2...");
				finger2P = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(3)), transMatrix(getCenterPoint(1), angle)));
				break;
			}
			
			// rotate all in relation to finger pivot
			case 2: {
				armP = getOriginalPoints(0);
				handP = getOriginalPoints(1);
				finger1P = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(2)), transMatrix(getCenterPoint(2), angle)));
				finger2P = doubleArrayToPoint(multMatrix(pointArrayToMatrix(getOriginalPoints(3)), transMatrix(getCenterPoint(2), angle)));
				break; 
			}
			default: {
				println("Error: rotLimb() - no case found for "+rs);
				armP = getOriginalPoints(0);
				handP = getOriginalPoints(1);
				finger1P = getOriginalPoints(2);
				finger2P = getOriginalPoints(3);
				break;
			}
		}
	}
	
	// Builds transformation matrix for centerpoint of element and inputted angle
	public double[][] transMatrix(Point center, double angl) {
		double ang = Math.toRadians(angl);
		double first, second;
		
		first = center.x - (center.x * Math.cos(ang)) - (center.y * -Math.sin(ang));
		second = center.y - (center.x * Math.sin(ang)) - (center.y * Math.cos(ang));

		double[][] A = { {Math.cos(ang),-Math.sin(ang), first}, {Math.sin(ang), Math.cos(ang), second}, {0,0,1} };
		
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		println("TRANSFORM:  matrix used: "); print("{");
		for (int i=0; i<A.length;i++) {
			print("{ ");
			for (int j=0; j<A[0].length;j++)
				print(df.format(A[i][j])+", ");
			print("},");
		}
		print("}"); println("");
		
		return A;
    }
	
	// Gets initial info from user
	private void getInfo() {
		Scanner sysin = new Scanner(System.in);
		print("Please enter the limb you wish to rotate (0: arm, 1: hand, 2: fingers):  ");
		rotState = (int)(sysin.nextInt());
		println("Mode:  "+rotState);
		print("Please enter the angle of rotation:  ");
		angle =  Double.parseDouble(sysin.next());
		println("Angle:  "+angle+" degrees");
	}
	
	// Converts from an array of Points to a Polygon object
	public Polygon polygonize(Point[] polyPoints) {

        //a simple method that makes a new polygon out of the rotated points
		Polygon tempPoly = new Polygon();

		/* for(int i=0; i < polyPoints.length; i++) {
			println(polyPoints[i].x + "  --> to polygon");
			tempPoly.addPoint(polyPoints[i].x, polyPoints[i].y);
        } */
		return tempPoly;
    }
	
	// Multiplies two Matrices
    public static double[][] multMatrix(double[][] A, double[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++)
            for (int j = 0; j < nB; j++)
                for (int k = 0; k < nA; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }
	
	// Converts from an array of Points to a Matrix of doubles
	private static Point[] doubleArrayToPoint(double[][] Arr) {
		int len = Arr.length;
		Point[] tempPt = new Point[len];
		
		for (int i = 0; i<len; i++) {
			//println(Arr[i][0]+" --> to point "+i);
			tempPt[i] = new Point((int)Arr[i][0], (int)Arr[i][1]);
		}
		
		println("POINT: new calculated points: "); //print("{");
		for (int i=0; i<tempPt.length;i++) {
			print("{ "+tempPt[i].x+","+tempPt[i].y+" },");
		}
		println("");
		
		return tempPt;		
	}
	
	// Converts from a Matrix of doubles to an array of Points
	private static double[][] pointArrayToMatrix(Point[] Arr) {
		int len = Arr.length;
		double[][] tempDbl = new double[len][3];
		
		for (int i = 0; i<len; i++) {
			tempDbl[i][0] = Arr[i].x;
			tempDbl[i][1] = Arr[i].y;
			tempDbl[i][2] = 1;
		}
		println("DOUBLE: matrix used: "); print("{");
		for (int i=0; i<tempDbl.length;i++) {
			print("{ ");
			for (int j=0; j<tempDbl[0].length;j++)
				print(tempDbl[i][j]+", ");
			print("},");
		}
		print("}"); println("");
		return tempDbl;		
	}

	private static void print(Object a) {System.out.print(a);}
	private static void println(Object a) {System.out.println(a);}
}