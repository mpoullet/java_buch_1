public class Zahl implements Cloneable {
   public String zahl = "1234";
// �berschreiben von Methoden der Klasse Object 
   public String toString() {
      return "Zahl: " + zahl;
   }
// Beim �berschreiben von Methoden ist ein kovarianter 
// R�ckgabetyp zugelassen
   public Zahl clone() throws CloneNotSupportedException {
      Zahl kopie = (Zahl)super.clone(); 
      return kopie;
   } 
}
