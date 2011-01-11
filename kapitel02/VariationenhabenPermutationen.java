public class VariationenhabenPermutationen {    
   Permutationen p1,p2;
// Konstruktordefinition
   public VariationenhabenPermutationen(Permutationen p1, 
                                        Permutationen p2) {
      this.p1 = p1;
      this.p2 = p2;
   }
// Zugriffsmethoden 
   public Permutationen getP1() {
      return this.p1; 
   }
   public void setP1(Permutationen p1) { 
      this.p1 = p1;
   }
   public Permutationen getP2() {
       return this.p2; 
   }
   public void setP2(Permutationen p2) { 
       this.p2 = p2;
   }
//Instanzmethode zum Berechnen von Variationen 
   public int anordnen() {
      return  p1.anordnen()/p2.anordnen();
   }  
}
