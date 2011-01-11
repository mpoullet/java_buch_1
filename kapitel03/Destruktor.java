public class Destruktor {
   private int zaehler;
// Konstruktordefinition
   Destruktor(int i) {
      zaehler = i;
      System.out.println("Der "+zaehler+"-te Konstruktoraufruf");
   }
// Die Methode der Klasse Object wird überschrieben
   public void finalize() {
      System.out.println("Der "+zaehler+"-te Destruktoraufruf");
   }
}
