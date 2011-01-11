import java.util.*;
public class NavigableMapsundSets {
   private static AbstractMap<Tage.Tag,WTag> map = 
      new EnumMap<Tage.Tag,WTag>(Tage.Tag.class);
   public static void main(String args[]) {
// Die EnumMap mit Daten füllen
      map.put(Tage.Tag.tag1, WTag.Montag);
      map.put(Tage.Tag.tag2, WTag.Dienstag);
      map.put(Tage.Tag.tag3, WTag.Mittwoch);
      map.put(Tage.Tag.tag4, WTag.Donnerstag);
      map.put(Tage.Tag.tag5, WTag.Freitag);
      map.put(Tage.Tag.tag6, WTag.Samstag);
      map.put(Tage.Tag.tag7, WTag.Sonntag);
// Die EnumMap als TreeMap ansprechen und an dieser Instanz
// die Methoden des Interface NavigableMap aufrufen
      NavigableMap<Tage.Tag,WTag> navigableMap = 
        new TreeMap<Tage.Tag,WTag>(map);
      System.out.println(map);
      System.out.println(navigableMap);
      System.out.println("Erster Schluessel: "
        + navigableMap.firstKey());
      System.out.println("Letzter Schluessel: "
        + navigableMap.lastKey());
      System.out.println("Erster Schluessel, der kleiner oder "
        + "gleich dem angegebenen Wert ist: " 
          + navigableMap.floorKey(Tage.Tag.tag4));
      System.out.println("Erster Schluessel, der kleiner als "
        + "der angegebene Wert: "
          + navigableMap.lowerKey(Tage.Tag.tag4));
      System.out.println("Erster Schluessel, der groesser oder "
        + "gleich dem angegebenen Wert ist: " 
          + navigableMap.ceilingKey(Tage.Tag.tag4));
      System.out.println("Erster Schluessel, der groesser als "
        + "der angegebene Wert ist: "  
          + navigableMap.higherKey(Tage.Tag.tag4));
// Map-Einträge, d.h. Instanzen vom Typ Map.Entry in Form von 
// Schlüssel-Werte Paaren anzeigen
      System.out.println("Erster Eintrag: "
        + navigableMap.firstEntry());
      System.out.println("Letzter Eintrag: "
        + navigableMap.lastEntry());
// Eine dritte Art von Methoden liefert die Menge aller Schlüssel
// und Map-Einträge in absteigender Reihenfolge
      System.out.println("MapKeys: "
        + navigableMap.descendingKeySet());
      System.out.println("MapEntrys: "
        + navigableMap.descendingMap());
// Eine Instanz vom Typ NavigableSet<String> mit Hilfe der 
// Methode descendingKeySet() des Interface NavigableMap liefern 
// und ihre Referenz einer Variablen vom gleichen Typ zuweisen 
      NavigableSet<Tage.Tag> navigableKey = 
        navigableMap.descendingKeySet();
// Die Methoden des Interface NavigableSet
// Eine Sicht auf Untermengen einer NavigableSet-Instanz 
// definieren; die Argumente vom Typ boolean ermöglichen, die 
// angegebenen Elementwerte ein- bzw. auszuschliessen 
      System.out.println("Die Untermenge der Mengenelemente, "
        + "welche kleiner als der angegebene Wert sind: " 
          + navigableKey.headSet(Tage.Tag.tag6,true)); 
      System.out.println("Die Untermenge der Mengenelemente "
        + "welche groesser oder gleich dem angegebenen Wert "
          + "sind: "+ navigableKey.tailSet(Tage.Tag.tag4,false)); 
      System.out.println("Die Untermenge der Mengenelemente, "
        + "welche zwischen den angegebenen Werten liegen: "
          + navigableKey.subSet(Tage.Tag.tag6,true,
            Tage.Tag.tag4,true));
// Die Methoden zum Ermitteln von spezifizierten Elementen einer 
// Menge vom Typ NavigableSet aufrufen
      System.out.print("Einzelne Elemente der Menge: "); 
      System.out.println(navigableKey.ceiling(Tage.Tag.tag4)
        + " " + navigableKey.floor(Tage.Tag.tag4) + " " 
          + navigableKey.higher(Tage.Tag.tag4) + " "
            + navigableKey.lower(Tage.Tag.tag4));
   } 
}
// Die Enumeration WTag
enum WTag {
   Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, 
     Sonntag
}
// Die Klasse Tage und die Enumeration Tag
class Tage {
   enum Tag {
      tag1, tag2, tag3, tag4, tag5, tag6, tag7
   }
}
