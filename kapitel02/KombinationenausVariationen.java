public class KombinationenausVariationen extends Variationen {
// Konstruktordefinition
   public KombinationenausVariationen(int n,int k) {
// Der Konstruktor der abgeleiteten Klasse ruft den Konstruktor 
// der Oberklasse auf
      super(n,k);
   }
// Instanzmethode zum Berechnen von Kombinationen
   public int anordnen() {
// Lokale Referenzen vom Typ der Klassen Variationen und 
// Permutationen definieren
      Variationen v = new Variationen(n,k );
      Permutationen p = new Permutationen(k);
// Die Methode der Klasse Permutationen kann weder am aktuellen 
// Objekt noch an einer Instanz der Klasse Variationen 
// aufgerufen werden 
   // int a1 = super.super.anordnen(); // Fehler
   // int a1 = v.(super.anordnen());   // Fehler 
// Die Methode der Oberklasse Variationen wird an einem 
// KombinationenausVariationen-Objekt, dem aktuellen Objekt,
// mit dem Präfix super. aufgerufen 
      int a2 = super.anordnen(); 
// und hier direkt über den Methodennamen an Permutationen-
// oder Variationen-Objekten 
      int a1 = p.anordnen();           // korrekt
   // int a2 = v.anordnen();           // korrekt
      return a2/a1;
   }  
}
