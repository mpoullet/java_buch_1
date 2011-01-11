public class Kreis {
   private static final double PI = Math.PI; 
   private Strecke PQ;
// Konstruktordefinition
   public Kreis(Strecke PQ) {
      this.PQ = PQ;
   }
   public double flaeche() {
      return Math.round (PI*PQ.distanz()*PQ.distanz());
   }
   public double umfang() {
      return Math.round(2*PI*PQ.distanz());
   }
   public void kreisGleichung() {
      Punkt P = PQ.getP();
      double xP = P.getX(); 
      double yP = P.getY(); 
      System.out.println("(x - " +xP+")**2 + "+ "(y - " +yP+
        ")**2 "+"- "+PQ.distanz()*PQ.distanz()+" = 0");
   }
}
