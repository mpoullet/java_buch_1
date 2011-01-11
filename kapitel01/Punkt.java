class Punkt {
   private double x;
   private double y;
// Konstruktordefinition
   Punkt(double a, double b) {
      x = a;
      y = b;
   }
// Zugriffsmethoden 
   public void setX(double X) {
      x = X;
      System.out.println("x-Wert gesetzt");
   }
   public void setY(double Y) {
      y = Y;
      System.out.println("y-Wert gesetzt");
   }
   public double getX() {
      return x;
   } 
   public double getY() {
      return y;
   }
// Instanzmethode für eine Punktanzeige
   public void anzeige() {
      System.out.println("("+ x +","+ y +")");
   }
}