public class Objekt1 implements Cloneable {
   private int zahl;       
// Konstruktordefinition 
   public Objekt1(int n) {
      zahl = n;
   }
   public static void main(String args[]) 
                           throws CloneNotSupportedException {
// Erzeugen und Klonen eines Objektes der eigenen Klasse 
      Objekt1 kopie1 = new Objekt1(4);
      Objekt1 kopie2 = (Objekt1)kopie1.clone();
// Vergleich der Referenzen von geklonten Objekten      
      System.out.println("Vergleich der Referenzen auf geklonte "
        + "Objekte : " + (kopie1 == kopie2));
// Durch das Klonen wird das Feld des Objektes kopiert 
      System.out.println(kopie1.zahl);
      System.out.println(kopie2.zahl);
   }
}