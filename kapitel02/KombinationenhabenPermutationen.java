public class KombinationenhabenPermutationen {    
   Permutationen p1,p2,p3;
// Konstruktordefinition
   public KombinationenhabenPermutationen(Permutationen p1, 
                             Permutationen p2,Permutationen p3) {
      this.p1 = p1;
      this.p2 = p2;
      this.p3 = p3;
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
   public Permutationen getP3() {
      return this.p3; 
   }
   public void setP3(Permutationen p3) { 
      this.p3 = p3;
   }
//Instanzmethode zum Berechnen der Anzahl von Kombinationen 
   public int anordnen() {
      return  p1.anordnen()/(p2.anordnen()*p3.anordnen());
   }  
}
