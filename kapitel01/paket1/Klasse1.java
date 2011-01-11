package paket1;
// Die Klasse muss als public definiert werden, weil sie aus 
// einem externen Paket angesprochen wird
public class Klasse1 {
   private static int privatesFeld = 1;
   protected static int geschuetztesFeld = 2;
   public static int oeffentlichesFeld = 3;
   static int feld = 4;
// Konstruktordefinition
   public Klasse1() {
      System.out.println("Instanz der Klasse1");
   }
}
