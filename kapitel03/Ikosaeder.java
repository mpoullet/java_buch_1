public class Ikosaeder extends RegelmaessigeGeometrischeKoerper {   
// Konstruktordefinition 
   public Ikosaeder(double a) {
      super(a);
   }
   public double volumen() {
      return Math.round(5*Math.pow(a,3)/12*(3+Math.sqrt(5.0)));
   }
   public double oberflaeche() {
      return Math.round(5*Math.pow(a,2)*Math.sqrt(3.0));
   }
   public double umkugel() {
      return Math.round(a/4*Math.sqrt(2*(5+Math.sqrt(5.0))));
   }
   public double inkugel() {
      return Math.round(a/12*Math.sqrt(3.0)*(3+Math.sqrt(5.0)));
   }
}
