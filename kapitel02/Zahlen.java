public class Zahlen extends Objekte {
// Konstruktordefinition
   Zahlen(Integer o) {
      super(o);
   }
// Zugriffsmethode mit ge�ndertem R�ckgabewert
   public Integer getObject() {
      System.out.print(
        "Die Methode Integer getObject() wurde aufgerufen: ");
      return (Integer)object;
   } 
}
