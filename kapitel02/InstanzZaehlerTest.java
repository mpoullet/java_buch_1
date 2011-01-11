public class InstanzZaehlerTest {
   public static void main(String args[]) {
// Array mit Objekten von KlasseA und KlasseB erzeugen
      KlasseA[] klsA = new KlasseA[2];
      KlasseB[] klsB = new KlasseB[2];
// Erzeugen von Objekten der Oberklasse KlasseA 
      for(int i = 0;i<2; i++) {
         klsA[i] = new KlasseA();
      } 
// Aufruf der Klassenmethode der Oberklasse,über den Klassennamen
   System.out.println("Es wurden "+ KlasseA.anzeigeZaehler()+
     " Instanzen der Oberklasse erzeugt");
// Erzeugen von Objekten der Unterklasse KlasseB 
      for(int i = 0; i<2; i++) {
         klsB[i] = new KlasseB();
// die Instanzmethode der KlasseB an diesen aufrufen
         klsB[i].aufrufMethoden(); 
      }
// Ausgabe der Anzahl von vorher erzeugten Instanzen über den 
// Aufruf der Klassenmethoden aus Ober- und Unterklasse
      System.out.println("Es wurden "+ KlasseA.anzeigeZaehler()+
        " Instanzen der Oberklasse " +    "und "+ KlasseB.
         anzeigeZaehler()+" Instanzen der Unterklasse erzeugt");
// Aufruf der Klassenmethoden an Objekten der beiden Klassen 
      for(int i = 0; i<2; i++) {
         System.out.println("Aktuelle Anzahl von Instanzen der "
           +"Oberklasse: "+klsA[i].anzeigeZaehler()+
            " * und der Unterklasse: "+klsB[i].anzeigeZaehler());
      } 
// Statisches Binden von Klassenmethoden 
      KlasseA a = new KlasseB();
         System.out.println("Neue Anzahl von Instanzen der "
           +"Oberklasse: "+a.anzeigeZaehler()); 
   }
} 
