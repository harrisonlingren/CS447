// CvDefPoly.java: To be used in other program files.
//   A class that enables the user to define
//   a polygon by clicking the mouse.
// Uses: Point2D (discussed below).

// Copied from Section 1.5 of
//    Ammeraal, L. (1998) Computer Graphics for Java Programmers,
//       Chichester: John Wiley.

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class CvDefPoly extends Canvas
{  Vector v = new Vector();
   float x0, y0, rWidth = 10.0F, rHeight = 7.5F, pixelSize;
   boolean ready = true;
   int centerX, centerY;

   CvDefPoly()
   {  addMouseListener(new MouseAdapter()
      {  public void mousePressed(MouseEvent evt)
         {  float xA = fx(evt.getX()), yA = fy(evt.getY());
            if (ready) 
            {  v.removeAllElements();
               x0 = xA; y0 = yA;
               ready = false;
            }
            float dx = xA - x0, dy = yA - y0;
            if (v.size() > 0 && 
               dx * dx + dy * dy < 4 * pixelSize * pixelSize)
               ready = true;
            else
               v.addElement(new Point2D(xA, yA));
            repaint();
         }
      });
   }

   void initgr()  
   {  Dimension d = getSize();
      int maxX = d.width - 1, maxY = d.height - 1;
      pixelSize = Math.max(rWidth/maxX, rHeight/maxY);
      centerX = maxX/2; centerY = maxY/2;
   }
   
   int iX(float x){return Math.round(centerX + x/pixelSize);}
   int iY(float y){return Math.round(centerY - y/pixelSize);}
   float fx(int X){return (X - centerX) * pixelSize;}
   float fy(int Y){return (centerY - Y) * pixelSize;}   

   public void paint(Graphics g)
   {  initgr();
      int left = iX(-rWidth/2), right = iX(rWidth/2),
          bottom = iY(-rHeight/2), top = iY(rHeight/2);
      g.drawRect(left, top, right - left, bottom - top);

      int n = v.size();
      if (n == 0) return;
      Point2D A = (Point2D)(v.elementAt(0)); 
      // Show tiny rectangle around first vertex:
      g.drawRect(iX(A.x)-2, iY(A.y)-2, 4, 4);
      for (int i=1; i<=n; i++)
      {  if (i == n && !ready) break;
         Point2D B = (Point2D)(v.elementAt(i % n));
         g.drawLine(iX(A.x), iY(A.y), iX(B.x), iY(B.y));
         A = B;
      }
   }
}
