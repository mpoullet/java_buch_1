public class Objekte {
   protected Object object;
// Konstruktordefinition
   Objekte(Object o) {
      object = o;
   }
// Zugriffsmethoden
   public void setObject(Object o) {
      object = o;
   }
   public Object getObject() {
      System.out.print(
        "Die Methode Object getObject() wurde aufgerufen: ");
      return object;
   } 
}
