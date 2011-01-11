public class Kegel extends GeometrischeKoerper {
// Konstruktordefinition
   public Kegel(double r, double h) {
// Der Konstruktor der Klasse ruft den Konstruktor der 
// abstrakten Oberklasse auf
      super(r,h);
   }
// Implementierung der abstrakten Methoden
   public double volumen() {
       return Math.round(Math.PI*r*r*h/3.);
   }
   public double oberflaeche() {
       return Math.round(Math.PI*r*(r+h));
   }
}
