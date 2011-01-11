public class Strecke {
   private Punkt P;
   private Punkt Q;
// Konstruktordefinition
   public Strecke(Punkt P, Punkt Q) {
      this.P = P;
      this.Q = Q;
   }
// Zugriffsmethoden
   public void setzeP(Punkt A) {
      P = A;
   }
   public void setzeQ(Punkt B) {
      Q = B;
   }
   public Punkt getP() {
      return P;
   }
   public Punkt getQ() {
      return Q;
   }
   public double distanz() {
      double xP = P.getX(); 
      double yP = P.getY(); 
      double xQ = Q.getX(); 
      double yQ = Q.getY(); 
      return Math.round(Math.sqrt(Math.pow(xQ-xP,2)+
        Math.pow(yQ-yP,2)));
   }
   public void geradenGleichung() {
      double xP = P.getX(); 
      double yP = P.getY(); 
      double xQ = Q.getX(); 
      double yQ = Q.getY(); 
      System.out.println("(y - "+yP+") = (("+yQ+" - "+yP+
        ")/("+xQ+" - "+xP+"))*(x - "+xP+")");
   }
}
