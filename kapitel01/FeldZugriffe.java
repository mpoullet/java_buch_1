class FeldZugriffe {
// Instanzfeld
   int zaehlerAlsInstanzfeld; 
// Klassenfeld 
   static int zaehlerAlsKlassenfeld; 
// Konstruktordefinition
      FeldZugriffe() {
         zaehlerAlsKlassenfeld++;
         zaehlerAlsInstanzfeld++;
   }
// Instanzmethoden, haben direkten Zugriff auf Instanz- und 
// Klassenfelder 
   public void anzeigeInstMeth() {
      System.out.print("Zaehler als Instanzfeld: " 
        + zaehlerAlsInstanzfeld);
// Zeilenumbruch ausgeben
      System.out.println();
      System.out.print("Zaehler als Klassenfeld: " 
        + FeldZugriffe.zaehlerAlsKlassenfeld);
// Innerhalb der Klasse kann auf den Klassennamen verzichtet 
// werden    
      System.out.print("*"+zaehlerAlsKlassenfeld);
      System.out.println();
   }
// Klassemethoden haben direkten Zugriff auf Klassenfelder, 
// darin können nur die Instanzfelder eines erzeugten Objektes 
// der Klasse angesprochen werden 
   public static void anzeigeKlsMeth() {
      System.out.print("Zaehler als Klassenfeld: " 
       + zaehlerAlsKlassenfeld); 
      System.out.print("*"+FeldZugriffe.zaehlerAlsKlassenfeld);
// Zeilenumbruch 
      System.out.println();
   // System.out.println(zaehlerAlsInstanzfeld); // Fehler
// Instanz vom Typ der Klasse erzeugen
      FeldZugriffe t = new FeldZugriffe(); 
      System.out.print("Zaehler als Instanzfeld: " 
        + t.zaehlerAlsInstanzfeld); 
      System.out.print("*"+t.zaehlerAlsKlassenfeld);
   }
}
