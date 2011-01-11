public class KreisistPunktTest {
   public static void main(String args[]){
      PunktNeu P = new PunktNeu(-1.0, -1.0);
      System.out.println(P.toString());
      KreisistPunkt K = new KreisistPunkt(1.0, 1.0, 3.0);
      System.out.println(K.toString());
      System.out.println("Die Koordinaten des Mittelpunktes: "+
        K.getX()+ " * "+K.getY()+ " Der Radius: "+K.getR());
      PunktNeu Q = new KreisistPunkt(2.0, 1.0, 3.0);
      System.out.println(Q.toString());
   }
}
