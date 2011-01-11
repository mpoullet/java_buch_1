public class Parallelogramm extends Rechteck {    
   protected double alpha;
// Konstruktordefinition
   public Parallelogramm(double x, double y, double z) {
      super(x,y);
      alpha = z;
   }
// Zugriffsmethoden
   public double getWinkel1() {
      return alpha;
   }
   public void setWinkel1(double z ) {
      alpha = z;
   } 
// Instanzmethoden zum Berechnen von Diagonalen, Flächeninhalt
// und Umfang
   public double[] diagonale() {
      double[] d = new double[2];
      double beta = 180-alpha;
      d[0] = Math.sqrt(((Quadrat)this).a*((Quadrat)this).a+
        ((Rechteck)this).a*((Rechteck)this).a-2*((Quadrat)this).
          a*((Rechteck)this).a*Math.cos(Math.toRadians(alpha)));
      d[1] = Math.sqrt(((Quadrat)this).a*((Quadrat)this).a+
        ((Rechteck)this).a*((Rechteck)this).a-2*((Quadrat)this).
          a*((Rechteck)this).a*Math.cos(Math.toRadians(beta)));
      return d;
   }
   public double flaeche() { 
      double[] d = new double[2];
      d = this.diagonale();
      double p = 0.5*(((Quadrat)this).a+((Rechteck)this).a+d[0]);
      double f = 2*Math.sqrt(p*(p-((Quadrat)this).a)*
        (p-((Rechteck)this).a)*(p-d[0]));
      return f;
   } 
   public double umfang() {
      double u = super.umfang();
   // double u = ((Rechteck)this).(super.umfang()); // Fehler
      return u;
   }
}
