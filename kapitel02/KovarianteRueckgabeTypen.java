public class KovarianteRueckgabeTypen {
   public static void main(String args[]) {
// Objekte der Klassen erzeugen
      PunktNeu punkt = new PunktNeu(1,1);
   // Punkt punkt = new Punkt(1,1);
      Objekte objekt = new Objekte(punkt);
      Worte wort = new Worte("ZAHL");
      Zahlen zahl = new Zahlen(2222);
// und die Methode getObject() an diesen aufrufen
   // System.out.println(objekt.getObject().anzeige()); // Fehler
      System.out.println(objekt.getObject().toString());
      System.out.println(wort.getObject());
      System.out.println(zahl.getObject());
   }
}
