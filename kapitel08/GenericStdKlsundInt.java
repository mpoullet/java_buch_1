import java.util.*;
import java.awt.geom.*;
import java.awt.Point;
public class GenericStdKlsundInt {
// Generische Methode mit generischen Wildcardtypen
   public static <T> T addListe(Collection <T> collection, 
                                List<? super T > liste ) {
      T lastElem = null;
      for(T t: collection) {
         lastElem = t;
         liste.add(lastElem); 
      }
      return lastElem;
   }
   public static void main(String args[]) {
// Vector-Objekte von einem parametrisierten Typ bilden
      Vector<Point> vector1 = new Vector<Point>();
      Vector<Point2D.Float> vector2 = 
        new Vector<Point2D.Float>();
      Vector<Point2D.Double> vector3 = 
        new Vector<Point2D.Double>();
// und Elemente vom spezifizierten Typ hinzufügen
      vector1.add(new Point(3,3)); 
      vector2.add(new Point2D.Float(3,3)); 
      vector3.add(new Point2D.Double(3E+0,3E+0));
// Eine Liste als Objekt vom parametrisierten Typ List<Point2D> 
// erzeugen     
      List<Point2D> liste = new Vector<Point2D>();
      Point punkt = addListe(vector1, liste);
      Point2D.Float punktFloat = addListe(vector2, liste);
      Point2D.Double punktDouble = addListe(vector3, liste);
      System.out.println("Anzeige von einzelnen Instanzen: ");
      System.out.println(punkt + " " + punktFloat + " " + 
        punktDouble);
      System.out.println("Ausgabe aus der Liste: ");
      for(Point2D punktListe: liste) { 
         System.out.print(punktListe.toString() + " ");
      }
      System.out.println();
// Die Liste in ein Point2D-Array umwandeln
      Point2D[]  array = new Point2D[3];
      array = liste.toArray(new Point2D[0]);
      System.out.println("Ausgabe aus dem Point2D-Array: ");
      for(Point2D punktArray: array) { 
         System.out.print(punktArray.toString()+ " ");
      }
      System.out.println();
// Die Liste in ein Object-Array umwandeln
      Object[] object = new Object[3];
      object = liste.toArray(object);
   // object = liste.toArray();// ist hier auch korrekt
   // object = liste.toArray(new Object[0]); // ist auch korrekt
      System.out.println("Ausgabe aus dem Object-Array: ");
      for(Object objectArray: object) { 
         System.out.print(objectArray.toString()+ " ");
      }
   }
}
