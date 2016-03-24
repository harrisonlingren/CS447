import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class house extends Frame {
	
	public static void main(String[] args) { new house(); }
	
	house() {
		
		super("Harrison Lingren -- House");
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {System.exit(0);}
			}
		);
		setSize(936,860); show();
		add("Center", new BuildHouse());
	}
}

class BuildHouse extends Canvas {
	
	public void paint(Graphics g) {	
		//ground rect
		int xGround[] = {0,0,936,936};
		int yGround[] = {860,740,740,860};
		g.setColor(Color.green.darker());
		g.fillPolygon(xGround, yGround, xGround.length);
		g.setColor(Color.black);
		g.drawLine(0,740,936,740);
		
		//sky rect
		int xSky[] = {0,0,936,936};
		int ySky[] = {0,740,740,0};
		g.setColor(Color.cyan.brighter());
		g.fillPolygon(xSky, ySky, xSky.length);
		
		//base rect
		int xBase[] = {100,100,820,820};
        int yBase[] = {260,760,760,260};
		g.setColor(Color.yellow.darker());
		g.fillPolygon(xBase, yBase, xBase.length);
		g.setColor(Color.black);
		g.drawPolygon(xBase, yBase, xBase.length);
		
		//roof tri
		int xRoof[] = {64,856,(720/2)+100};
		int yRoof[] = {260,260,80};
		g.setColor(Color.red.darker().darker());
		g.fillPolygon(xRoof, yRoof, xRoof.length);
		g.setColor(Color.black);
		g.drawPolygon(xRoof, yRoof, xRoof.length);
		
		//garage rect
		int xGara[] = {460,460,790,790};
        int yGara[] = {760,530,530,760};
		g.setColor(Color.red.darker().darker());
		g.fillPolygon(xGara, yGara, xGara.length);
		g.setColor(Color.black);
		g.drawPolygon(xGara, yGara, xGara.length);
		
			//Gara sec1 rect
			int xGaraSec1[] = {480,480,605,605};
			int yGaraSec1[] = {550,610,610,550};
			g.setColor(Color.black);
			g.drawPolygon(xGaraSec1, yGaraSec1, xGaraSec1.length);
			
			//Gara Sec2 rect
			int xGaraSec2[] = {625,625,770,770};
			int yGaraSec2[] = {550,610,610,550};
			g.setColor(Color.black);
			g.drawPolygon(xGaraSec2, yGaraSec2, xGaraSec2.length);
			
			//Gara Sec3 rect
			int xGaraSec3[] = {480,480,605,605};
			int yGaraSec3[] = {740,630,630,740};
			g.setColor(Color.black);
			g.drawPolygon(xGaraSec3, yGaraSec3, xGaraSec3.length);
			
			//Gara Sec4 rect
			int xGaraSec4[] = {625,625,770,770};
			int yGaraSec4[] = {740,630,630,740};
			g.setColor(Color.black);
			g.drawPolygon(xGaraSec4, yGaraSec4, xGaraSec4.length);
		
		//driveway polygon
		int xDrive[] = {435,460,790,825};
        int yDrive[] = {840,760,760,840};
		g.setColor(Color.gray.brighter());
		g.fillPolygon(xDrive, yDrive, xDrive.length);
		g.setColor(Color.black);
		g.drawPolygon(xDrive, yDrive, xDrive.length);
		
		//Door rect
		int xDoor[] = {330,330,430,430};
        int yDoor[] = {730,530,530,730};
		g.setColor(Color.red.darker().darker());
		g.fillPolygon(xDoor, yDoor, xDoor.length);
		g.setColor(Color.black);
		g.drawPolygon(xDoor, yDoor, xDoor.length);
		
			//Door sec1 rect
			int xDoorSec1[] = {340,340,375,375};
			int yDoorSec1[] = {625,540,540,625};
			g.setColor(Color.black);
			g.drawPolygon(xDoorSec1, yDoorSec1, xDoorSec1.length);
			
			//Door Sec2 rect
			int xDoorSec2[] = {385,385,420,420};
			int yDoorSec2[] = {625,540,540,625};
			g.setColor(Color.black);
			g.drawPolygon(xDoorSec2, yDoorSec2, xDoorSec2.length);
			
			//Door Sec3 rect
			int xDoorSec3[] = {340,340,375,375};
			int yDoorSec3[] = {720,635,635,720};
			g.setColor(Color.black);
			g.drawPolygon(xDoorSec3, yDoorSec3, xDoorSec3.length);
			
			//Door Sec4 rect
			int xDoorSec4[] = {385,385,420,420};
			int yDoorSec4[] = {720,635,635,720};
			g.setColor(Color.black);
			g.drawPolygon(xDoorSec4, yDoorSec4, xDoorSec4.length);
		
		//Door handle circle
		g.setColor(Color.yellow);
		g.fillOval(416,626,8,8);
		
		//Doorstep rect
		int xDoorstep[] = {320,320,440,440};
        int yDoorstep[] = {760,730,730,760};
		g.setColor(Color.gray.brighter());
		g.fillPolygon(xDoorstep, yDoorstep, xDoorstep.length);
		g.setColor(Color.black);
		g.drawPolygon(xDoorstep, yDoorstep, xDoorstep.length);
		
		//window1 rect
		int xWind1[] = {130,130,300,300};
		int yWind1[] = {540,710,710,540};
		g.setColor(Color.white);
		g.fillPolygon(xWind1, yWind1, xWind1.length);
		g.setColor(Color.black);
		g.drawPolygon(xWind1, yWind1, xWind1.length);
		g.drawLine((300-130)/2+130,540,(300-130)/2+130,710);
		g.drawLine(130,(710-540)/2+540,300,(710-540)/2+540);
		
		//window2 rect
		int xWind2[] = {130,130,260,260};
		int yWind2[] = {310,470,470,310};
		g.setColor(Color.white);
		g.fillPolygon(xWind2, yWind2, xWind2.length);
		g.setColor(Color.black);
		g.drawPolygon(xWind2, yWind2, xWind2.length);
		g.drawLine((260-130)/2+130,310,(260-130)/2+130,470);
		g.drawLine(130,(470-310)/2+310,260,(470-310)/2+310);
		
		//window3 rect
		int xWind3[] = {300,300,430,430};
		int yWind3[] = {310,470,470,310};
		g.setColor(Color.white);
		g.fillPolygon(xWind3, yWind3, xWind3.length);
		g.setColor(Color.black);
		g.drawPolygon(xWind3, yWind3, xWind3.length);
		g.drawLine((430-300)/2+300,310,(430-300)/2+300,470);
		g.drawLine(300,(470-310)/2+310,430,(470-310)/2+310);
		
		//window4 rect
		int xWind4[] = {490,490,790,790};
		int yWind4[] = {310,470,470,310};
		g.setColor(Color.white);
		g.fillPolygon(xWind4, yWind4, xWind4.length);
		g.setColor(Color.black);
		g.drawPolygon(xWind4, yWind4, xWind4.length);
		g.drawLine((790-490)/3+490,310,(790-490)/3+490,470);
		g.drawLine(((790-490)/3)*2+490,310,((790-490)/3)*2+490,470);
		g.drawLine(490,(470-310)/2+310,790,(470-310)/2+310);
		
		//bush ovals
		g.setColor(Color.green.darker());
		g.fillOval(125,720,100,50);
		g.fillOval(175,720,100,50);
		g.setColor(Color.black);
		g.drawOval(125,720,100,50);
		g.drawOval(175,720,100,50);
		g.setColor(Color.green.darker());
		g.fillOval(126,721,99,48);
		g.fillOval(174,721,99,48);
	}
}