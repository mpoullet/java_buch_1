import java.util.*;
public class EnumerationIteratorIterable {
// Parametrisierte Instanzen vom Typ der Klassen EnumMap und 
// Hashtable erzeugen
   private EnumMap<Tage.Tag,WTag> map = 
     new EnumMap<Tage.Tag,WTag>(Tage.Tag.class);
   private Hashtable<Tage.Tag,WTag> hashTable = 
     new Hashtable<Tage.Tag,WTag>();
// Konstruktordefinition
   public EnumerationIteratorIterable() {
// Zum angelegten Container vom Typ der parametrisierten Klassen 
// EnumMap<Tage.Tag,WTag> und Hashtable<Tage.Tag,WTag> werden 
// Objekte vom Typ der Parameterklassen, mit der Methode put() 
// der Schnittstelle Map<K,V>, hinzugefügt
      map.put(Tage.Tag.tag1, WTag.Montag);
      map.put(Tage.Tag.tag2, WTag.Dienstag);
      map.put(Tage.Tag.tag3, WTag.Mittwoch);
      hashTable.put(Tage.Tag.tag1, WTag.Montag);
      hashTable.put(Tage.Tag.tag2, WTag.Dienstag);
      hashTable.put(Tage.Tag.tag3, WTag.Mittwoch);
// Die Methode values() der Klasse Enum liefert ein Array der 
// Aufzählungskonstanten in der Reihenfolge ihrer Deklaration
      for(WTag tag: WTag.values()) {
         System.out.println(tag);
// Die switch-Anweisung wurde mit Java 5.0 erweitert, so dass 
// diese auch enum-Konstanten akzeptiert
         switch(tag) {
            case Montag:
               System.out.println((tag.ordinal() + 1)
                 + ". Wochentag: " + tag);
               break;
            case Dienstag:
               System.out.println((tag.ordinal() + 1)
                 + ". Wochentag: " + tag);
               break;
         }
      }
// Die Methode ordinal() der Klasse Enum gibt die Zahl, welche 
// einer Aufzählungskonstanten zugeordnet wurde, zurück und die 
// Methode get() der Schnittstelle Map liefert die Werte, 
// die in einer Abbildung den Schlüsseln zugeordnet wurden
      for(Tage.Tag tag: Tage.Tag.values()) {
         System.out.println(tag + ": " + map.get(tag));
         switch(tag.ordinal()) {
            case 0:
         System.out.println((tag.ordinal() + 1) 
           + ". Wochentag: " + map.get(tag));
               break;
            case 1:
         System.out.println((tag.ordinal() + 1)
           + ". Wochentag: " + map.get(tag));
               break;
         }
      }
// Mit der Methode keySet() der Schnittstelle Map wird die Menge
// der Schlüssel einer Abbildung ermittelt und in einem Objekt 
// vom Typ der parametrisierten Schnittstelle Set<E>, 
// einem Unterinterface von Collection<E>, abgelegt
      Set<Tage.Tag> key = map.keySet();
      Object[] object = key.toArray();
// Die verschiedenen Formen der for-Schleife für die Ausgabe der 
// Schlüssel einer Abbildung nutzen
      for(int i=0; i<object.length; i++)
         System.out.print(object[i].toString() + " ");
      System.out.println();
      for(Iterator iterator=key.iterator(); iterator.hasNext();) 
         System.out.print(iterator.next() + " ");
      System.out.println();
      for(Object objekt: key)
         System.out.print(objekt + " ");
      System.out.println();
// Die Schlüssel und Werte der Hashtable anzeigen 
      for(Enumeration<WTag> enumeration = hashTable.elements();
        enumeration.hasMoreElements();) 
      System.out.print(enumeration.nextElement() + " ");
      System.out.println();
      for(Enumeration<WTag> enumeration = hashTable.elements();
        enumeration.hasMoreElements();) 
      System.out.print(enumeration.nextElement() + " ");
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      EnumerationIteratorIterable instanz = 
        new EnumerationIteratorIterable();
   }
}
// Die Enumerationen WTag
enum WTag {
   Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, 
     Sonntag
}
// Die Klasse Tage und die Enumeration Tag
class Tage {
// Die Enumeration Tag
   enum Tag {
      tag1, tag2, tag3, tag4, tag5, tag6, tag7
   }
}
