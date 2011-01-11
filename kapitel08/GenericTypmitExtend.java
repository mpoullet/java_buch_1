import java.awt.*;
import javax.swing.*;
public class GenericTypmitExtend <T extends Number> { 
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
// Methodendefinitionen mit Wildcardtypen
   public static GenericTypmitExtend <? extends Number>  
    anzeige(GenericTypmitExtend <? extends Number> tObjekt) {
      System.out.println("Objektwert = "+ tObjekt.getObjekt()
         + " * Objekttyp = "+ tObjekt.getObjektTyp());
      return tObjekt;
   }
   public static int add(GenericTypmitExtend <? extends Number> 
    iObjekt, GenericTypmitExtend <? extends Number> sObjekt) {
      Number zahl1 = iObjekt.getObjekt();
      Number zahl2 = sObjekt.getObjekt();
      return zahl1.intValue()+zahl2.intValue();
   }
// Objekte der Klasse erzeugen
   public static void main(String[] args) {
// Die Variable, welche den Rückgabewert der Methode empfängt,
// muss den gleichen Typ wie der Rückgabenwert aufweisen
      GenericTypmitExtend <? extends Number> obj; 
      GenericTypmitExtend <Integer> iObjekt = 
        new GenericTypmitExtend<Integer>();
      iObjekt.setObjekt(new Integer(10));
   // iObjekt = anzeige(iObjekt); // Fehler
      obj = anzeige(iObjekt);
      System.out.println("Typ des Rueckgabewertes: " 
        + obj.getObjektTyp());
      GenericTypmitExtend<Float> sObjekt = 
        new GenericTypmitExtend<Float>();
      sObjekt.setObjekt(new Float(10.10));
      obj = anzeige(sObjekt);
      System.out.println("Typ des Rueckgabewertes: " 
        + obj.getObjektTyp());
      GenericTypmitExtend<Double> dObjekt = 
        new GenericTypmitExtend<Double>();
      dObjekt.setObjekt(new Double(10E+3));
      obj = anzeige(dObjekt);
      System.out.println("Typ des Rueckgabewertes: " 
        + obj.getObjektTyp());
// Die numerischen Werte, welche von den Wrapper-Klassen 
// eingehüllt wurden, addieren und das Ergebnis anzeigen
      int i1 = add(iObjekt,sObjekt); 
      int i2 = add(sObjekt,dObjekt);
      System.out.println("Ergebnisse der Addition: "
        + i1 + " und "+i2);
   }
}
