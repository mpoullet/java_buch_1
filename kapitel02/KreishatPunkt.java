public class KreishatPunkt {
   private double r;
   private Punkt p;
// Konstruktordefinition
   public KreishatPunkt(Punkt P, double R) {
      p = P;
      r = R;
   }
// Zugriffsmethoden
   public void setR(double R) {
      r = R;
      System.out.println("Wert fuer Radius gesetzt.");
   }
   public double getR() {
      return r;
   } 
   public void setP(Punkt P) {
      p = P;
      System.out.println("Wert fuer Mittelpunkt gesetzt.");
   }
   public Punkt getP() {
      return p;
   } 
// Überschreiben der toString()-Methode der Klasse Object
   public String toString() {
// Aufruf der Methode anzeige() der Klasse Punkt
      p.anzeige();
         return "Kreisgleichung: (x - " +p.getX()+")**2 + "+
           "(y - " +p.getY()+")**2 "+" - "+r*r+" = 0";
   }
}
