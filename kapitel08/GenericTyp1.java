import java.awt.*;
import javax.swing.*;
public class GenericTyp1 <T> {
   private T objekt;
// Zugriffsmethoden auf das Objekt
   public void setObjekt(T objekt) {
      this.objekt = objekt;
   }
   public T getObjekt() {
      return objekt;
   }
// Typ des Objekts
   public String getObjektTyp() {
      return objekt.getClass().getName();
   }
// Objekte der Klasse erzeugen
   public static void main(String[] args) {
// Es werden GenericTyp1<Integer>- und GenericTyp1<String>-
// Objekte erzeugt und ihre Referenzen Variablen vom gleichen Typ 
// zugewiesen
      GenericTyp1<Integer> iObjekt = new GenericTyp1<Integer>();
      GenericTyp1<String> sObjekt = new GenericTyp1<String>();
// Korrekte Zuweisungen von Werten
      iObjekt.setObjekt(new Integer(10));
      sObjekt.setObjekt(new String("Java"));
// Fehlerhafte Zuweisungen, erzeugen Compiler-Fehler
   // sObjekt.setObjekt(new Integer(10));
   // iObjekt.setObjekt(new String("Java"));
// Die Werte (auch Objekte) der erzeugten Instanzen der Klasse 
// ermitteln und anzeigen
      System.out.println("iObjektWert = "+ iObjekt.getObjekt()
        + " * sObjektWert = "+ sObjekt.getObjekt());
// Den Datentyp dieser Objekte anzeigen
      System.out.println("iObjektTyp = "+ iObjekt.getObjektTyp()
        + " * sObjektTyp = "+ sObjekt.getObjektTyp());
   }
}
