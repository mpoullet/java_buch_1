import java.util.*;
import java.lang.reflect.*;
public class GenericClassmitGenericConstructor { 
// Generische Methode für das Erzeugen einer Collection
// von ausgewählten Objekten
   public static <T> Collection<T> selectObjects(
                                Class<T> tClass, String string) { 
      Collection<T> collection = new ArrayList<T>();
      try {   
// Den Konstruktor der übergebenen Klasse, welcher als Parameter 
// eine Referenz vom Typ String definiert, bestimmen
         Constructor<T> tConstructor = 
           tClass.getConstructor(String.class);
// und damit dynamisch eine Instanz der Klasse erzeugen
         T instanz = tConstructor.newInstance(string);
// Auf Felder des Class-Objektes zugreifen
         Field f = tClass.getDeclaredField("s");
         Field feld = tClass.getDeclaredField("name");
// und deren Feldwerte anzeigen
         System.out.println(f.get(instanz));
// Für Felder vom Typ Array wird für die Anzeige ein Array-
// Objekt definiert
         Object[] array = (Object[])feld.get(instanz);
         for(int i =0; i<array.length; i++) {
            System.out.print(" "+array[i]);
// Ist der im Methodenaufruf angegebene String-Wert gleich mit 
// einem der Arrayelemente, wird die vorher erzeugte Instanz 
// zu einer Collection hinzugefügt
            if(array[i].equals(string)) {
               collection.add(instanz);
            }
         }
         System.out.println();
      }   
      catch(Exception ex) { 
         System.out.println(ex); 
      }
      return collection;
   }
// Generische Methode für die Anzeige der Objekte 
// in der Collection
   public static <T> void ausgabeObjects(Collection <T>
                                         collection) {
      try {   
         for(T t : collection) {
            Field f = t.getClass().getDeclaredField("s");
            System.out.println(t.getClass().getName()
              + ":" + f.get(t));
         }
      }   
      catch(Exception ex) {
         System.out.println(ex);
      }
   }
// Instanzen der Klassen Name, Strasse und Wohnort dynamisch 
// erzeugen und diese zu Collectionen vom Typ der Klassen 
// hinzufügen
   public static void main(String args[]) {
      Collection<Name> c1 = selectObjects(Name.class, "Jung");
      c1.addAll(selectObjects(Name.class, "Mueller"));
      c1.addAll(selectObjects(Name.class, "Hahn"));
      Collection<Strasse> c2 = selectObjects(Strasse.class, 
        "Am Weissen Stein");
      c2.addAll(selectObjects(Strasse.class, "Goethestrasse"));
      Collection<Wohnort> c3 = selectObjects(Wohnort.class, 
        "Frankfurt");
      c3.addAll(selectObjects(Wohnort.class, "Bonn"));
      c3.addAll(selectObjects(Wohnort.class, "Mainz"));
// Die Elemente der Collectionen anzeigen
      System.out.println("Die selektierten Namen sind:");
      ausgabeObjects(c1);
      System.out.println("Die selektierten Strassen sind:");
      ausgabeObjects(c2);
      System.out.println("Die selektierten Wohnorte sind:");
      ausgabeObjects(c3);
   }
}
// Die Klasse Name
class Name { 
   final String []name = {"Jung", "Mueller", "Mayer", "Schmidt",
     "Hahn"};
   String s;
// Konstruktordefinitionen
   public Name() {}
   public Name(String s) {
      this.s = s;
   }
}
// Die Klasse Strasse 
class Strasse {
   final String [] name = {"Goethestrasse", "Sandweg", 
     "Am Weissen Stein", "Karl-Katsky-Weg"};
   String s;
// Konstruktordefinitionen
   public Strasse() {}
   public Strasse(String s) {
      this.s = s;
   }
}
// Die Klasse Wohnort 
class Wohnort {
   final String []name = {"Frankfurt", "Berlin", "Bonn",
     "Hamburg", "Koeln"};
   String s; 
// Konstruktordefinitionen
   public Wohnort() {}
   public Wohnort(String s) {
      this.s = s;
   }
}
