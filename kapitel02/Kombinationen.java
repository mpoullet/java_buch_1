public class Kombinationen extends Permutationen {   
   protected int k;
// Konstruktordefinition
   public Kombinationen(int n, int k) {
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
// Instanzmethode zum Berechnen der Anzahl von Kombinationen 
   public int anordnen() {
// Lokale Referenzen vom Typ der Klasse Permutationen definieren
      Permutationen p1 = new Permutationen(n-k );
      Permutationen p2 = new Permutationen(k);
// Die Methode der Oberklasse wird an einem Kombinationen-Objekt,
// dem aktuellen Objekt, mit dem Präfix super. aufgerufen
      int a1 = super.anordnen();
// und hier direkt über den Methodennamen an 
// einem Permutationen-Objekt
      int a2 = p1.anordnen()*p2.anordnen();
      return a1/a2;
   }  
}
