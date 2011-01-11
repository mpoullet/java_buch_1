import java.awt.*;
public class PointEqual implements Equality<Point> {
// Die Methode mit dem generischen Typ implementieren
   public boolean equal(Point punkt1, Point punkt2) {
      if((punkt1.x == punkt2.x) && (punkt1.y == punkt2.y))
         return true;
      else
         return false;
   }   
// Ein Array von Point-Objekten erstellen und ein Objekt der 
// Klasse erzeugen, an welchem die Methode equal() aufgerufen 
// werden kann 
   public static void main(String args[]) {
      Point[] punkt = {new Point(1,1), new Point(1,1), 
        new Point(2,2)};
      PointEqual punktE = new PointEqual(); 
// Je zwei der Punkte vergleichen
      for(int i=0; i<2; i++) {
         if(punktE.equal(punkt[i], punkt[i+1]))
            System.out.println("Gleicher Punkt"); 
         else
            System.out.println("Verschiedene Punkte");
      } 
   }     
}
interface Equality<T> { 
   public boolean equal(T obj1, T obj2); 
}
