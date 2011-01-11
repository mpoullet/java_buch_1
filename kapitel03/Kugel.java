public class Kugel extends GeometrischeKoerper {
// Konstruktordefinition
   public Kugel(double r) {
// Weil die Kugel keine Höhe besitzt, ruft ihr Konstruktor
// den Konstruktor der Oberklasse mit h = r auf
      super(r,r);
   }
// Implementierung der abstrakten Methoden
   public double volumen() {
       return Math.round(4*Math.PI*r*r*r); 
   }
   public double oberflaeche() {
       return Math.round(4*Math.PI*r*r);
   }
}
