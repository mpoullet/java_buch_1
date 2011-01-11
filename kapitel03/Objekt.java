public class Objekt implements Cloneable, Comparable {
   private int zahl;       
// Konstruktordefinition
   public Objekt(int n) {
      zahl = n;
   }
// Überschreiben der Methode equals() der Klasse Object
   public boolean equals(Object object) {
      if(!(object instanceof Objekt))
         return false;
// Aufruf der Methode der Oberklasse
      System.out.println("Vergleich der Referenzen auf geklonte "
        + "Objekte : " + super.equals(object));
      Objekt kopie = (Objekt)object;
      return (zahl == kopie.zahl);
   }
// Implementieren der Methode des Interface Comparable 
   public int compareTo(Object object) {
      Objekt kopie = (Objekt)object;
      return kopie.zahl - this.zahl;
   }   
   public static void main(String args[]) 
                           throws CloneNotSupportedException {
// Objekt der Klasse erzeugen
      Objekt kopie1 = new Objekt(1234);
// Aufruf der Methode clone() der Klasse Object; die Referenz vom
// Typ Object wird in eine Referenz vom Typ des kopierten 
// Objektes konvertiert
      Objekt kopie2 = (Objekt)kopie1.clone();
// Vergleich der Referenzen auf geklonte Objekte 
      System.out.println("Vergleich der Referenzen auf geklonte "
        + "Objekte : " + (kopie1 == kopie2));
// Vergleich von geklonten Objekten
      System.out.println("Vergleich von geklonten Objekten : "
            + kopie1.equals(kopie2));
      System.out.println("Vergleich von geklonten Objekten : "
            + (kopie1.compareTo(kopie2) == 0));
   }
} 
