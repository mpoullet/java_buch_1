public abstract class GeometrischeKoerper { 
   protected double r;
   protected double h;
// Konstruktordefinition
   public GeometrischeKoerper(double r, double h) {
      this.r = r;
      this.h = h;
   }
// Abstrakte Methoden zum Berechnen von Volumen und Oberfläche
   public abstract double volumen();
   public abstract double oberflaeche();
}
