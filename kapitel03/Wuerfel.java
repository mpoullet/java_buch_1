public class Wuerfel extends RegelmaessigeGeometrischeKoerper {          
// Konstruktordefinition 
   public Wuerfel(double a) {
      super(a);
   }
   public double volumen() {
      return Math.round(Math.pow(a,3));
   }
   public double oberflaeche() {
      return Math.round(6*Math.pow(a,2));
   }
   public double umkugel() {
      return Math.round(a/2*Math.sqrt(3.0));
   }
   public double inkugel() {
      return Math.round(a/2);
   }
}
