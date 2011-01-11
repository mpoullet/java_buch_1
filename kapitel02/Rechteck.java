public class Rechteck extends Quadrat {
   protected double a;
// Konstruktordefinition
   public Rechteck(double x, double y) {
// Der Konstruktor initialisiert die Variable a und nützt
// für das Initialisieren des geerbten Feldes den 
// Konstruktor der Oberklasse
      super(x);
      a = y;
   }
// Zugriffsmethoden zum Setzen und Lesen der zweiten Seite eines
// Rechtecks, für die erste Seite können die Methoden der Klasse
// Quadrat genutzt werden, da diese geerbt werden  
   public double getSeite2() {
      return a; 
   }
   public void setSeite2(double y) { 
      a = y;
   }
// Instanzmethoden zum Berechnen von Diagonalen, Flächeninhalt 
// und Umfang 
   public double[] diagonale() {
      double[] d = new double [2];
      d[0] = Math.sqrt(super.a*super.a+a*a);
      d[1] = Math.sqrt(super.a*super.a+a*a);
      return d;
   }
   public double flaeche() {
      double f = super.a*a;
      return f;
   }
   public double umfang() {
      double u = 2*(a+super.a);
      return u;
   }
}
