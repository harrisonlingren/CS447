// DefPoly.java: Drawing a polygon.
// Uses: CvDefPoly (discussed below).

// Copied from Section 1.5 of
//    Ammeraal, L. (1998) Computer Graphics for Java Programmers,
//       Chichester: John Wiley.

import java.awt.*;
import java.awt.event.*;

public class DefPoly extends Frame
{  public static void main(String[] args){new DefPoly();}
 
   DefPoly()
   {  super("Define polygon vertices by clicking");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize(500, 300);
      add("Center", new CvDefPoly());
      setCursor(Cursor.getPredefinedCursor(CROSSHAIR_CURSOR));
      show();
   }
}
