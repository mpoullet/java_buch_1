public class KlasseA {
   protected static int zaehlerSupkls;
// Konstruktordefinition
   KlasseA() {
      zaehlerSupkls++;
   }
// Klassenmethode, welche die Anzahl von erzeugten Instanzen der 
// Klasse berechnet
   protected static int anzeigeZaehler() {
      System.out.println(
        "Die Methode der Oberklasse wurde aufgerufen");
      return zaehlerSupkls;
   }
}
