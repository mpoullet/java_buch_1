public class KlasseD extends KlasseC {
// Konstruktordefinition
   KlasseD() {
   }
// Klassenmethode, die einen Text ausgibt 
   protected static void k() {
      System.out.println(
        "Die Klassenmethode der Unterklasse wurde aufgerufen");
   }
// Instanzmethode, die die Methode der Oberklasse aufruft und 
// einen Text ausgibt 
   protected void m() {
      super.m();
      System.out.println(
        "Die Instanzmethode der Unterklasse wurde aufgerufen");
   }
   public static void main(String args[]) {
// Instanzen der Klassen erzeugen
      KlasseC c1 = new KlasseC();
      KlasseC c2 = new KlasseD();
      KlasseD d1 = new KlasseD();
// Die Klassenmethoden über den Klassennamen aufrufen
      KlasseC.k();
      KlasseD.k();
// Die von den jeweiligen Klassen definierten Methoden an 
// Instanzen der Klassen aufrufen
      c1.k();
      d1.k();
      c1.m();
      d1.m();
      System.out.println("Statisches Binden von "
        + "Klassenmethoden:"); 
      c2.k(); 
      System.out.println("Dynamisches Binden von "
        + "Instanzmethoden:");
      c2.m();
   }
}
