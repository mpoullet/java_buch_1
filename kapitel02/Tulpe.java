public class Tulpe extends Blumen {
// Konstruktordefinition 
   Tulpe() {
      super(1, GELB);
   }
// Die Methode der Oberklasse wird überschrieben und aufgerufen 
   public void identifizieren() {
      super.identifizieren();
      System.out.print("Tulpe");
   }
   public void zwiebeln() {
      System.out.println(" und hat Zwiebeln");
   }
}
