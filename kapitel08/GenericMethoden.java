import java.util.*;
import java.awt.Point;
import java.lang.reflect.Array;
public class GenericMethoden { 
// Generische Methodendefinitionen 
   public static <T> T[] erzeugeArray(T[] ein) { 
      T[] aus = (T[])Array.newInstance(
        ein.getClass().getComponentType(), ein.length); 
      for(int i=0; i<ein.length; i++) {
         aus[i] = ein[i];
      }
      return aus;
   }
   public static <T> void anzeigeArray(T[] ein) { 
// Die Elemente eines Arrays werden über eine for-each-Schleife 
// ausgegeben
      for(T eingabeArray: ein) { 
         System.out.print(eingabeArray.toString());
      }
   }
   public static void main(String args[]) {
// Nicht generische Arrays deklarieren und initialisieren
      Integer []intArray1 = new Integer[5];
      String []stringArray1 = new String[5];
      Point []pointArray1 = new Point[5];
      for(int i=0; i<5; i++) {
         intArray1[i] = new Integer(i);
         stringArray1[i] = new String("Array"+i);
         pointArray1[i] = new Point(i, i+1);
      }
// Generische Arrays erzeugen und anzeigen
      Integer []intArray2 = erzeugeArray(intArray1);
      String []stringArray2 = erzeugeArray(stringArray1);
      Point []pointArray2 = erzeugeArray(pointArray1);
      System.out.println("Eingaben:");
      anzeigeArray(intArray1);
      System.out.println();
      anzeigeArray(stringArray1);
      System.out.println();
      anzeigeArray(pointArray1);
      System.out.println();
      System.out.println("Ausgaben:");
      anzeigeArray(intArray2);
      System.out.println();
      anzeigeArray(stringArray2);
      System.out.println();
      anzeigeArray(pointArray2);
   }
}   
