public class Dodekaeder extends RegelmaessigeGeometrischeKoerper {   
// Konstruktordefinition 
   public Dodekaeder(double a) {
      super(a);
   }
   public double volumen() {
      return Math.round(Math.pow(a,3)/4*(15+7*Math.sqrt(5.0)));
   }
   public double oberflaeche() {
      return Math.round(3*Math.pow(a,2)*Math.sqrt(
        (5*(5+2*Math.sqrt(5.0)))));
   }
   public double umkugel() {
      return Math.round(a/4*Math.sqrt(3.0)*(1+Math.sqrt(5.0)));
   }
   public double inkugel() {
      return Math.round(a/4*Math.sqrt(10+22/5.0*Math.sqrt(5.0)));
   }
}
