public abstract class RegelmaessigeGeometrischeKoerper 
                      implements UmKugelRadius, InKugelRadius {    
   protected double a;
// Konstruktordefinition
   public RegelmaessigeGeometrischeKoerper(double x) {
      a = x;
   }
// Abstrakte Methoden zum Berechnen von Volumen und Oberfl�che   
   public abstract double volumen();
   public abstract double oberflaeche();
}
