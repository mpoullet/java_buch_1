public class Oktaeder extends RegelmaessigeGeometrischeKoerper {
// Konstruktordefinition 
   public Oktaeder(double a) {
      super(a);
   }
   public double volumen() {
      return Math.round(Math.pow(a,3)/3*Math.sqrt(2.0));
   }
   public double oberflaeche() {
      return Math.round(2*Math.pow(a,2)*Math.sqrt(3.0));
   }
   public double umkugel() {
      return Math.round(a/2*Math.sqrt(2.0));
   }
   public double inkugel() {
      return Math.round(a/6*Math.sqrt(6.0));
   }
}
