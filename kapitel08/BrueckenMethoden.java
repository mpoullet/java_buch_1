import java.awt.*;
public class BrueckenMethoden {
   public static void main(String[] args) {
// GenericTyp<Point>- und GenericSubTyp-Objekte erzeugen 
      GenericTyp<Point> pObjekt = new GenericTyp<Point>();
      GenericSubTyp subpObjekt = new GenericSubTyp();
// und deren Instanzfeldern Werte zuweisen
      pObjekt.setObjekt(new Point(1,1));
      subpObjekt.setObjekt(new Point(2,2));
// Die Werte der erzeugten Objekte lesen
      System.out.println("Das Objekt der Oberklasse hat den Wert"
        + " = "+ pObjekt.getObjekt());
      System.out.println("Das Objekt der Unterklasse hat den "
        + " Wert = "+ subpObjekt.getObjekt());
   }
}
// Externe Klasse (generische Oberklasse)
class GenericTyp <T> {
   T objekt;
// Zugriffsmethoden auf das Objekt
   public void setObjekt(T obj) {
      objekt = obj;
   }
   public T getObjekt() {
      return objekt;
   }
}
// Externe Klasse (Unterklasse)
class GenericSubTyp extends GenericTyp<Point> {
// Die Methode der Unterklasse definiert einen kovarianten 
// Rückgabetyp, der Typ Point ist von Object abgeleitet
   public Point getObjekt() {
      return objekt;
   }
}
