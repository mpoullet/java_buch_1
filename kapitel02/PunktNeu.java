public class PunktNeu {
   protected double x;
   protected double y;
// Konstruktordefinition
   PunktNeu(double a, double b) {
      x = a;
      y = b;
   }
// Zugriffsmethoden 
   public void setX(double X) {
      x = X;
   }
   public void setY(double Y) {
      y = Y;
   }
   public double getX() {
      return x;
   } 
   public double getY() {
      return y;
   }
// Instanzmethode für eine Punktanzeige
   public String toString() {
      return "("+ x +","+ y +")";
   }
}
