public class Variationen extends Permutationen {
   protected int k;
// Konstruktordefinition
   public Variationen(int n, int k) {
// Der Konstruktor der abgeleiteten Klasse ruft den Konstruktor 
// der Oberklasse auf
      super(n);
      this.k = k;
   }
// Zugriffsmethoden 
   public int getK() {
      return k; 
   }
   public void setK(int k) { 
      this.k = k;
   }
// Instanzmethode zum Berechnen der Anzhal von Variationen
   public int anordnen() {
// Eine lokale Referenz vom Typ der Klasse Permutationen 
// definieren
      Permutationen p1 = new Permutationen(n-k);
// Die Methode der Oberklasse wird an einem Variationen-Objekt, 
// dem aktuellen Objekt mit dem Präfix super. aufgerufen
      int a1 = super.anordnen(); 
// und hier direkt über den Methodennamen an einem 
// Permutationen-Objekt 
      int a2 = p1.anordnen();
      return a1/a2;
   }  
}
