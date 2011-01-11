public class Permutationen {    
   protected int n;
// Konstruktordefinition 
   public Permutationen(int n) {
      this.n = n;
   }
// Zugriffsmethoden  
   public int getN() {
       return n; 
   }
   public void setN(int n) { 
      this.n = n;
   }
// Instanzmethode zum Berechnen der Anzahl von Permutationen  
   protected int anordnen() {
      int nFakultaet = 1;
      if(n != 0) {
         for(int i=1;i<=n; i++) {
            nFakultaet = nFakultaet*i;
         }
      }
      return nFakultaet;
   }  
}
