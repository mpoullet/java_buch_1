public class KreisistPunkt extends PunktNeu {
   private double r;
// Konstruktordefinition
   public KreisistPunkt(double X, double Y, double R) {
// Der Konstruktor der Oberklasse wird aufgerufen
      super(X,Y);
      r = R;
   }
// Zugriffsmethoden
   public void setR(double R) {
      r = R;
   }
   public double getR() {
      return r;
   } 
// Überschreiben der toString()-Methode der Klasse PunktNeu
   public String toString() {
      System.out.println(super.toString());
      return "Kreisgleichung: (x - " +x+")**2 + "+"(y - " +y+
        ")**2 "+" - "+r*r+" = 0";
   }
}
