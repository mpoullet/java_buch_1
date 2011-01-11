public abstract class DreieckArten implements FlaechenInhalt {
   protected double a;
   protected double b;
   protected double c;
// Konstruktordefinition
   public DreieckArten(double x, double y, double z) {
      a = x;
      b = y;
      c = z;
   }
   public static double winkel(double x, double y, double z) {
      return (Math.acos((x*x-y*y-z*z)/(-2*y*z)))*180/Math.PI;
   }
   public abstract double[] berechneWinkel();
   public double umfang() {
      return a+b+c;
   }
   public double flaeche(double h) {
      return Math.round((1/2.0)*c*h);
   }
}
