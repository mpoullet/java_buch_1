public class GleichseitigesDreieck extends DreieckArten {
// Konstruktordefinition
   public GleichseitigesDreieck(double x) {
// Der Konstruktor der Klasse ruft den Konstruktor der 
// abstrakten Oberklasse auf
      super(x, x, x);
   }
// Die Instanzmethoden zum Berechnen von Winkeln und Höhe werden 
// implementiert  
   public double[] berechneWinkel() {
      double w[] = new double[3];
      w[0] = Math.round(winkel(a,a,a));
      w[1] = w[0];
      w[2] = w[0];
      return w;
   }
   public double hoehe() {
      return Math.round((a/2)*Math.sqrt(3.0));
   }
}
