public class Worte extends Objekte {
// Konstruktordefinition
   Worte(String o) {
      super(o);
   }
// Zugriffsmethode mit ge�ndertem R�ckgabewert
   public String getObject() {
      System.out.print(
        "Die Methode String getObject() wurde aufgerufen: ");
      return (String)object;
   } 
}
