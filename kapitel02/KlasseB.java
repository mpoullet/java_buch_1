public class KlasseB extends KlasseA {
   protected static int zaehlerSubkls;
// Konstruktordefinition
   KlasseB() {
      zaehlerSubkls++;
   }
// Klassenmethode, welche die Anzahl von erzeugten Instanzen 
// der Klasse berechnet
   protected static int anzeigeZaehler() {
      System.out.println(
        "Die Methode der Unterklasse wurde aufgerufen");
      return zaehlerSubkls;
// Ein Auruf mit super. ist in Klassenmethoden nicht erlaubt
   // super.anzeigeZaehler();  // Fehler  
   }
// Instanzmethode, zur Demonstration der Aufrufsyntax für 
// verdeckte Klassenmethoden
   protected void aufrufMethoden() {
// Aufruf der Klassenmethode am aktuellen Objekt
      System.out.println("Es wurde die "+anzeigeZaehler()+
        ". Instanz der Unterklasse erzeugt");
// Aufruf der Klassenmethode der Oberklasse am aktuellen Objekt
      System.out.println("Es wurde die "+super.anzeigeZaehler()+
        ". Instanz der Oberklasse erzeugt");
   }
}
