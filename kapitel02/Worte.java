public class Worte extends Objekte {
// Konstruktordefinition
   Worte(String o) {
      super(o);
   }
// Zugriffsmethode mit geändertem Rückgabewert
   public String getObject() {
      System.out.print(
        "Die Methode String getObject() wurde aufgerufen: ");
      return (String)object;
   } 
}
