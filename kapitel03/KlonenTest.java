public class KlonenTest {
   public static void main(String args[]) 
                           throws CloneNotSupportedException {
// Erzeugen und Klonen von Objekten der Klasse Buchstabe
      Buchstabe b1 = new Buchstabe('A');
      Buchstabe b2 = (Buchstabe)b1.clone();
// Vergleich der Referenzen auf geklonte Objekte
      System.out.println("Vergleich der Referenzen auf geklonte "
        + "Objekte : "+ (b1 == b2));
   }
}
