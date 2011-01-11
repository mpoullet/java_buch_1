public class Quadrat  {
   protected double a;
// Konstruktordefinition 
   public Quadrat(double x) {
      a = x;
   }
// Zugriffsmethoden 
   public double getSeite1() {
      return a; 
   }
   public void setSeite1(double x) { 
      a = x;
   }
// Instanzmethoden zum Berechnen von Diagonalen, Flächeninhalt 
// und Umfang  
   public double[] diagonale() {
      double[] d = new double [2];
      d[0] = Math.sqrt(2*a*a);
      d[1] = Math.sqrt(2*a*a);
      return d;
   }
   public double flaeche() {
      double f = a*a;
      return f;
   }
   public double umfang() {
      double u = 4*a;
      return u;
   }
// Instanzmethode zur Anzeige der Diagonalen
   public void toString(double[] d) {
      System.out.println("1. Diagonale= "+d[0]+
        " * 2. Diagonale= "+d[1]);
   }
}
