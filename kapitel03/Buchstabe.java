public class Buchstabe implements Cloneable  {   
   private char buchstabe;
// Konstruktordefinition 
   public Buchstabe(char c) {
      buchstabe = c;
   }
// �berschreiben der Methode der Klasse Object 
   protected Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}
