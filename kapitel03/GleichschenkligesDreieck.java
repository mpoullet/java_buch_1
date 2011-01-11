public class GleichschenkligesDreieck extends DreieckArten {    
// Konstruktordefinition
   public GleichschenkligesDreieck(double x, double y) {
// Der Konstruktor der Klasse ruft den Konstruktor der 
// abstrakten Oberklasse auf
      super(x, y, x);
   }
// Die Instanzmethoden zum Berechnen von Winkeln und Höhe werden 
// implementiert  
   public double[] berechneWinkel() {
      double w[] = new double[3];
      w[0] = Math.round(winkel(a,b,b));
      w[1] = Math.round(winkel(b,a,b));
      w[2] = w[1];
      return w;
   }
   public double hoehe() {
      return Math.round(Math.sqrt(a*a-(c/2)*2));
   }
}
