import java.awt.*;
import javax.swing.*;
public class GenericTyp2 <T> {
   private T objekt;
// Konstruktordefinition
   public GenericTyp2(T objekt) {
      this.objekt = objekt;
   }
// Zugriffsmethode auf das Objekt
   public T getObjekt() {
      return objekt;
   }
// Typ des Objekts
   public String getObjektTyp() {
      return objekt.getClass().getName();
   }
// Objekte der Klasse erzeugen
   public static void main(String[] args) {
// Es wird ein GenericTyp2<Integer>-Objekt der Klasse erzeugt 
// und seine Referenz einer Variablen vom gleichen Typ zugewiesen
// Durch Autoboxing wird der int-Wert 10 in ein Integer-Objekt 
// umgesetzt 
      GenericTyp2<Integer> iObjekt =
        new GenericTyp2<Integer>(10);
// Es wird ein GenericTyp2<String>-Objekt der Klasse erzeugt und 
// seine Referenz einer Variablen vom gleichen Typ zugewiesen
      GenericTyp2<String> sObjekt = 
        new GenericTyp2<String>("Java");
// Die Werte (Objekte) der erzeugten Instanzen der Klasse 
// ermitteln und anzeigen
      System.out.println("iObjektWert = "+ iObjekt.getObjekt()
        + " * sObjektWert = "+ sObjekt.getObjekt());
// Den Datentyp dieser Objekte anzeigen
      System.out.println("iObjektTyp = "+ iObjekt.getObjektTyp()
        + " * sObjektTyp = "+ sObjekt.getObjektTyp());
   }
}
