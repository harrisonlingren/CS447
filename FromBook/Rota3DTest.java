// Rota3DTest.java: Rotating a cube about an axis 
//    parallel to a diagonal of its top plane.
//    Uses: Point3D, Rota3D (discussed above).

// Copied from Section 3.9 of
//    Ammeraal, L. (1998) Computer Graphics for Java Programmers,
//       Chichester: John Wiley.

public class Rota3DTest
{  public static void main(String[] args)
   {  Point3D A = new Point3D(0, 0, 1), B = new Point3D(1, 1, 1);
      double alpha = Math.PI;
      // Specify AB as directed axis of rotation
      // and alpha as the rotation angle:
      Rota3D.initRotate(A, B, alpha);
      // Vertices of a cube; 0, 1, 2, 3 at the bottom,
      // 4, 5, 6, 7 at the top. Vertex 0 at the origin O:
      Point3D[] V = {
         new Point3D(0, 0, 0), new Point3D(1, 0, 0),
         new Point3D(1, 1, 0), new Point3D(0, 1, 0),
         new Point3D(0, 0, 1), new Point3D(1, 0, 1),
         new Point3D(1, 1, 1), new Point3D(0, 1, 1)};
      System.out.println(
         "Cube rotated through 180 degrees about line AB,");
      System.out.println(
         "where A = (0, 0, 1) and B = (1, 1, 1)");
      System.out.println("Vertices of cube:");
      System.out.println(
         "    Before rotation    After rotation");
      for (int i=0; i<8; i++)
      {  Point3D P = V[i];
         // Compute P1, the result of rotating P:
         Point3D P1 = Rota3D.rotate(P);
         System.out.println(i + ":  " + 
            P.x + " " + P.y + " " + P.z + "        " +
            f(P1.x) + " " + f(P1.y) + " " + f(P1.z));
      }
   }

   static double f(double x){return Math.abs(x) < 1e-10 ? 0.0 : x;} 
}
