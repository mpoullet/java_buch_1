package paket1.paket2;
import paket1.Klasse1;
public class Klasse2 extends Klasse1 {
// Konstruktordefinition
   public Klasse2() {
      System.out.println("Instanz der Klasse2");
// Das Feld aus Klasse1 verfügt über privaten Zugriff 
   // System.out.println(Klasse1.privatesFeld); // Fehler
// Auf ein Standard-Feld kann nicht von außerhalb des Paketes 
// zugegriffen werden 
   // System.out.println(Klasse1.standardFeld); // Fehler
// Zugriff erlaubt, weil uneingeschränkt öffentlich durch die 
// Definition mit public
      System.out.println("Zugriff aus Klasse2 auf ein "
        + "oeffentliches Feld der Klasse1: "
          + Klasse1.oeffentlichesFeld);
// Das Feld aus Klasse1 verfügt über geschützten Zugriff, kann 
// aber aus einer Unterklasse, die in einem anderen Paket liegt,
// angesprochen werden 
      System.out.println("Zugriff aus Klasse2 auf ein "
        + "geschuetztes Feld der Klasse1: "
          + Klasse1.geschuetztesFeld);
   }
}
