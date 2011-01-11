public class KreishatPunktTest {
   public static void main(String args[]) {
      Punkt P = new Punkt(-1.0, -1.0);
      P.anzeige();
      KreishatPunkt K =new KreishatPunkt(new Punkt(1.0,1.0),3.0);
      System.out.println(K.toString());
      System.out.println("Die Koordinaten des Mittelpunktes: "+
         K.getP().getX()+ " * "+K.getP().getY()+ 
           " Der Radius: "+K.getR());
   }
}
