public class Drachen extends Parallelogramm {
   private double alpha;
// Konstruktordefinition
   public Drachen(double x, double y, double z, double v) {
      super(x,y,z);
      alpha = v;
   }
// Zugriffsmethoden zum Setzen und Lesen des Instanzfeldes 
   public double getWinkel2() {
      return alpha;
   }
   public void setWinkel2(double z ) {
      alpha = z;
   } 
// Instanzmethoden zum Berechnen von Diagonalen und Flächeninhalt
   public double[] diagonale() {
      double[] d = new double[2];
// Die lokale Variable mit dem Namen alpha wird mit Werten der 
// verdeckten Feldvariablen alpha initialisiert
      double alpha = (0.5)*(360-(this.alpha+
        ((Parallelogramm)this).alpha));
      d[0] = Math.sqrt(((Quadrat)this).a*((Quadrat)this).a+
        ((Quadrat)this).a*((Quadrat)this).a-2*((Quadrat)this).
           a*((Quadrat)this).a*Math.cos(Math.toRadians(alpha)));
      d[1] = Math.sqrt(((Quadrat)this).a*((Quadrat)this).a+
        ((Rechteck)this).a*((Rechteck)this).a-2*((Quadrat)this).
           a*((Rechteck)this).a*Math.cos(Math.toRadians(alpha)));
      return d;
   }
   public double flaeche() {
      double[] d = new double[2];
      d = diagonale();
      double f = (0.5)*d[0]*d[1];
      return f;
   } 
// Die Methode umfang() wird hier nicht überschrieben
}
