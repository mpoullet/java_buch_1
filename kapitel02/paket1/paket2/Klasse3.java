package paket1.paket2;
import paket1.Klasse1;
public class Klasse3 extends Klasse2 {
// Konstruktordefinition
   public Klasse3() {
      System.out.println("Instanz der Klasse3");
// Das Feld aus Klasse1 verfügt über privaten Zugriff 
   // System.out.println(Klasse1.privatesFeld); // Fehler
// Auf ein Standard-Feld, kann nicht von außerhalb des Paketes 
// zugegriffen werden 
   // System.out.println(Klasse1.standardFeld); // Fehler
// Zugriff erlaubt, weil uneingeschränkt öffentlich durch die 
// Definition mit public
      System.out.println("Zugriff aus Klasse3 auf ein "
        + "oeffentliches Feld der Klasse1: "
          + Klasse1.oeffentlichesFeld);
// Das Feld aus Klasse1 verfügt über geschützten Zugriff, kann
// aber aus einer Unterklasse, die in einem anderen Paket liegt,
// angesprochen werden 
      System.out.println("Zugriff aus Klasse3 auf ein "
        + "geschuetztes Feld der Klasse1: "
          + Klasse1.geschuetztesFeld);
   }
   public static void main(String args[]) {
      Klasse1 kls1 = new Klasse1();
// Für Unterklassen wird auch der Konstruktor der Oberklasse
// aufgerufen 
      Klasse2 kls2 = new Klasse2();
      Klasse3 kls3 = new Klasse3();
      Klasse4 kls4 = new Klasse4();
// Die Methode anzeige() aus paket1.Klasse1 ist geschützt 
   // kls1.anzeige(); // Fehler
   // kls2.anzeige(); // Fehler
      kls3.anzeige();
   // kls4.anzeige(); // Fehler
// Zugriff auf das geschützte Feld
      System.out.println(kls1.geschuetztesFeld +" "+ 
        kls2.geschuetztesFeld+" "+kls3.geschuetztesFeld);
   // System.out.println(kls4.geschuetztesFeld); // Fehler 
   }
}
