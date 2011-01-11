public class Zahl implements Cloneable {
   public String zahl = "1234";
// Überschreiben von Methoden der Klasse Object 
   public String toString() {
      return "Zahl: " + zahl;
   }
// Beim Überschreiben von Methoden ist ein kovarianter 
// Rückgabetyp zugelassen
   public Zahl clone() throws CloneNotSupportedException {
      Zahl kopie = (Zahl)super.clone(); 
      return kopie;
   } 
}
