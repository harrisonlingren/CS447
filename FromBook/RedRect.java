// RedRect.java: The largest possible rectangle in red.

// Copied from Section 1.1 of
//    Ammeraal, L. (1998) Computer Graphics for Java Programmers,
//       Chichester: John Wiley.
// Run under Windows 95

import java.awt.*;
import java.awt.event.*;

public class RedRect extends Frame
{  public static void main(String[] args){new RedRect();}
   
   RedRect()
   {  super("RedRect");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(200, 100);
      add("Center", new CvRedRect());
      show();
   }
}

class CvRedRect extends Canvas
{  public void paint(Graphics g)
   {  Dimension d = getSize();
      int maxX = d.width - 1, maxY = d.height - 1;
      g.drawString("d.width  = " + d.width,  10, 30);
      g.drawString("d.height = " + d.height, 10, 60);
      g.setColor(Color.green);
      g.drawRect(10, 10, maxX-20, maxY-20);
      
     //  g.fillOval(50,50, 90,120);
   }
}