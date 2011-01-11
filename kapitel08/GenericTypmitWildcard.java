import java.awt.*;
import javax.swing.*;
public class GenericTypmitWildcard <T> { 
   T objekt;
// Zugriffsmethoden auf das Objekt
   public void setObjekt(T objekt) {
      this.objekt = objekt;
   }
   public  T getObjekt() {
      return this.objekt;
   }
// Typ des Objekts
   public String getObjektTyp() {
      return objekt.getClass().getName();
   }
// Methodendefinition mit Wildcardtypen
   public static void anzeige(GenericTypmitWildcard <?> tObjekt){
      System.out.println("ObjektWert = "+ tObjekt.getObjekt()
        + " * ObjektTyp = "+ tObjekt.getObjektTyp());
   }
// Objekte der Klasse von unterschiedlichen Typen erzeugen 
// und deren Werte und Typen anzeigen
   public static void main(String[] args) {
      GenericTypmitWildcard <Integer> iObjekt = 
        new GenericTypmitWildcard<Integer>();
      iObjekt.setObjekt(new Integer(10));
      anzeige(iObjekt);
      GenericTypmitWildcard<Float> sObjekt = 
        new GenericTypmitWildcard<Float>();
      sObjekt.setObjekt(new Float(10.10));
      anzeige(sObjekt);
      GenericTypmitWildcard<Double> dObjekt = 
        new GenericTypmitWildcard<Double>();
      dObjekt.setObjekt(new Double(10E+3));
      anzeige(dObjekt);
// Eine Referenz vom Typ <?> kann auf ein beliebiges Objekt der
// Klasse zeigen
      GenericTypmitWildcard <?> obj1 = 
        new GenericTypmitWildcard<Integer>();
      GenericTypmitWildcard<?> obj2 = 
        new GenericTypmitWildcard<Float>();
// Darauf kann nicht schreibend zugegriffen werden,
   // obj1.setObjekt(new Integer(10)); // Fehler 
// ein lesender Zugriff ist erlaubt
      GenericTypmitWildcard <?> obj3 = sObjekt;
      anzeige(obj3);
   }
}
