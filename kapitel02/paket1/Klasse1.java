package paket1;
public class Klasse1 {
   private static int privatesFeld = 1;
   protected static int geschuetztesFeld = 2;
   public static int oeffentlichesFeld = 3;
   static int standardFeld = 4;
// Konstruktordefinition
public Klasse1() {
       System.out.println("Instanz der Klasse1");
   }
   protected void anzeige() {
      System.out.print(privatesFeld+" ");
      System.out.print(geschuetztesFeld+" ");
      System.out.print(standardFeld+" ");
      System.out.println(oeffentlichesFeld);
   }
}
