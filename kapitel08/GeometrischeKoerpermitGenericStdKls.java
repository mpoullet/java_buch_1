import java.util.*;
public class GeometrischeKoerpermitGenericStdKls {
// Konstruktordefinition
   public GeometrischeKoerpermitGenericStdKls() {
// ArrayList-Instanzen vom Typ Kugel und Kegel erzeugen
      ArrayList<Kugel> aList1 = new ArrayList<Kugel>();
      ArrayList<Kegel> aList2 = new ArrayList<Kegel>();
// und diesen Instanzen der spezifizierten Klassen hinzufügen
      aList1.add(new Kugel(3)); 
      aList2.add(new Kegel(3,4)); 
      aList1.add(new Kugel(2)); 
      aList2.add(new Kegel(2,2)); 
      ausgabe(aList1);
      ausgabe(aList2);
   }
// Reguläre Methodendefinition mit generischen Wildcardtypen; 
// dies ist keine generische Methode
   public static void ausgabe(
                        List <? extends GeometrischeKoerper> l) {
      for(GeometrischeKoerper geomKorp: l) 
         System.out.println(geomKorp.oberflaeche()
           + "*" + geomKorp.volumen());
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      GeometrischeKoerpermitGenericStdKls geomKorpList = 
         new GeometrischeKoerpermitGenericStdKls();
   }
}   
