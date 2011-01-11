package paket1.paket2;
import paket1.Klasse1;
public class Klasse4 {
// Konstruktordefinition
   public Klasse4() {
      System.out.println("Instanz der Klasse4");
// Das Feld aus Klasse1 verfügt über privaten Zugriff 
   // System.out.println(Klasse1.privatesFeld);
// Auf ein Standard-Feld kann nicht von außerhalb des Paketes 
// zugegriffen werden 
   // System.out.println(Klasse1.standardFeld); // Fehler
// Zugriff erlaubt, weil uneingeschränkt öffentlich durch die 
// Definition mit public
      System.out.println("Zugriff aus Klasse4 auf ein "
        + "oeffentliches Feld der Klasse1: "
          + Klasse1.oeffentlichesFeld);
// Zugriff auf das geschützte Feld
   // System.out.println("Zugriff aus Klasse4 auf ein "
   //   + "geschuetztes Feld der Klasse1: "
   //     + Klasse1.geschuetztesFeld); // Fehler
   }
}
