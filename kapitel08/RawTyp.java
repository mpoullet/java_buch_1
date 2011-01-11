public class RawTyp { 
   public static void main(String args[]) { 
// Objekte von parametrisierten Typen erzeugen und anzeigen
      GenericPunkt<Integer,Integer> intPunkt = 
        new GenericPunkt<Integer,Integer>(-1,1); 
      GenericPunkt.ausgabe(intPunkt); 
      GenericPunkt<Double,Double> doublePunkt = 
        new GenericPunkt<Double,Double>(1.0,-1.0); 
      GenericPunkt.ausgabe(doublePunkt);
      GenericPunkt<Integer,Double> mischPunkt = 
        new GenericPunkt<Integer,Double>(1,1.0); 
      GenericPunkt.ausgabe(mischPunkt);
// Raw-Typ-Objekte erzeugen 
      GenericPunkt punkt1 = new GenericPunkt(1.0,1.0); 
      GenericPunkt punkt2 = new GenericPunkt(1,-1); 
      GenericPunkt punkt3 = new GenericPunkt(-1.0F,1); 
// und ausgeben
      GenericPunkt.ausgabe(punkt1); 
      GenericPunkt.ausgabe(punkt2); 
      GenericPunkt.ausgabe(punkt3); 
// Der Runtime-Fehler: "ClassCastException: java.lang.Double"
// wird ausgegeben
   // Integer i1 = (Integer)punkt1.getKoordinate1();
   // Integer i2 = (Integer)punkt1.getKoordinate2();
// Der Compiler-Fehler: "incompatible Typs" zeigt an, dass ein 
// Casting erforderlich ist, weil der Typ unbekannt ist
   // Double d1 = punkt1.getKoordinate1();
   // Double d2 = punkt1.getKoordinate2();
// Korrektes Casting
      Double d1 = (Double)punkt1.getKoordinate1();
      Double d2 = (Double)punkt1.getKoordinate2();
      GenericPunkt.ausgabe(punkt1); 
// Initialisieren der Feldwerte über Zugriffsmethoden 
      punkt2.setKoordinate1(2.0);
      punkt3.setKoordinate2(2.0);
      GenericPunkt.ausgabe(punkt2); 
      GenericPunkt.ausgabe(punkt3); 
// Raw-Typen gewährleisten keine Typsicherheit
// Eine Referenz vom Typ GenericPunkt<Double> kann ein Objekt 
// von einem Raw-Typ referenzieren,
      doublePunkt = punkt2;
// doch führen die nachfolgenden Aufrufe zu dem Laufzeitfehler:
// "ClassCastException: java.lang.Integer"
   // d1 = doublePunkt.getKoordinate1();
   // d2 = doublePunkt.getKoordinate2();
// Einer Referenz von einem Raw-Typ kann eine Referenz vom Typ 
// GenericPunkt<Integer> zugeweisen werden,
      punkt1 = intPunkt;
// doch führen die nachfolgenden Aufrufe zu dem Laufzeitfehler:
// "ClassCastException: java.lang.Integer"
      d1 = (Double)punkt1.getKoordinate1();
      d2 = (Double)punkt1.getKoordinate2();
   } 
}     
class GenericPunkt<T, V> { 
   T koordinate1; 
   V koordinate2; 
// Konstruktordefinition
   GenericPunkt(T k1, V k2) { 
      koordinate1 = k1; 
      koordinate2 = k2; 
   }
// Zugriffsmethoden auf die Koordinaten
   public void setKoordinate1(T k1) { 
      koordinate1 = k1; 
   } 
   public void setKoordinate2(V k2) { 
      koordinate2 = k2; 
   } 
   public T getKoordinate1() { 
      return koordinate1; 
   } 
   public V getKoordinate2() { 
      return koordinate2; 
   } 
// Anzeige von Punkten 
   public static void ausgabe(GenericPunkt<?,?> punkt) {
      System.out.println("1. Koordinate vom Typ: " 
        + punkt.koordinate1.getClass().getName()+" = "
          + punkt.getKoordinate1());
      System.out.println("2. Koordinate vom Typ: " 
        + punkt.koordinate2.getClass().getName()
          + " = "+punkt.getKoordinate2());  
   } 
}
