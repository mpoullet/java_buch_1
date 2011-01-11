public class Objekt2 implements Cloneable {
   private int zahl;       
// Konstruktordefinition 
   public Objekt2(int n) {
      zahl = n;
   }
// Überschreiben der Methode der Klasse Object 
// mit Rückgabewert Objekt2 (ab Java 5.0)
   public Objekt2 clone() throws CloneNotSupportedException {
              return (Objekt2)super.clone();
   }
   public static void main(String args[]) 
                           throws CloneNotSupportedException {
// Erzeugen eines Objektes vom Typ einer anderen Klasse 
      Objekt1 zahl1 = new Objekt1(2);
// und aufrufen der clone() Methode der Klasse Object an dieser 
// Instanz
   // Objekt1 kopie1 = (Objekt1)zahl1.clone(); // Fehler
// Erzeugen eines Objektes der eigenen Klasse und Aufruf der 
// clone()-Methode
      Objekt2 zahl2 = new Objekt2(4);
// Ein Casting ist nicht mehr erforderlich
      Objekt2 kopie2 = zahl2.clone();
// Vergleich der Referenzen auf geklonte Objekte      
      System.out.println("Vergleich der Referenzen auf geklonte "
        + "Objekte : " + zahl2.equals(kopie2));
   }
} 
