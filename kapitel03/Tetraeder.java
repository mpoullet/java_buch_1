public class Tetraeder extends RegelmaessigeGeometrischeKoerper {
// Konstruktordefinition
   public Tetraeder(double a) {
      super(a);
   }
   public double volumen() {
      return Math.round(Math.pow(a,3)/12*Math.sqrt(2.0));
   }
   public double oberflaeche() {
      return Math.round(Math.pow(a,2)*Math.sqrt(3.0));
   }
   public double umkugel() {
      return Math.round(a/4*Math.sqrt(6.0));
   }
   public double inkugel() {
      return Math.round(a/12*Math.sqrt(6.0));
   }
}
