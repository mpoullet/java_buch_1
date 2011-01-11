import java.util.*;
public class AbstractMapObjekteundExceptions {
   private final static String []tage = {"Montag","Sonntag",
     "Mittwoch","Donnerstag","Dienstag","Freitag","Samstag"};
   private static Collection<String> collection, coll;
   private static Collection<WTag> collection1;  
public static void main(String args[]) {
      try {
         AbstractMap<Integer,String> map1 = 
           new HashMap<Integer,String>();
         AbstractMap<Integer,String> map5 = 
           new HashMap<Integer,String>();
         TreeMap<Integer,String> map3 = 
           new TreeMap<Integer,String>();
// Im Konstruktor der Klasse EnumMap kann ein .class Objekt 
// übergeben werden, welches vom gleichem Typ wie der
// Schlüssel ist
         AbstractMap<Tage.Tag,WTag> map2 = 
           new EnumMap<Tage.Tag,WTag>(Tage.Tag.class);
         try {   
// Den Schlüsseln der Abbildungen map1 und map5 Werte zuordnen 
// und diese anzeigen
            System.out.print("Map1: "); 
            for(int i=0; i<7; i++) {
               map1.put(i,tage[i]);
               System.out.print(map1.get(i)+" ");
            }
            System.out.println();
            System.out.print("Map5: "); 
            for(int i=3; i<7; i++) {
               map5.put(i,tage[i]);
               System.out.print(map5.get(i)+" ");
            }
            System.out.println();
// Die Einträge für map2 als Zuordnungen zwischen Schlüsseln 
// vom Typ der Enumeration Tage.Tag und Werten vom Typ der 
// Enumeration Wtag definieren 
            Tage.Tag wtg;
            wtg = Tage.Tag.tag3;
            map2.put(Tage.Tag.tag1, WTag.Montag);
            map2.put(Tage.Tag.tag2, WTag.Dienstag);
            map2.put(wtg, WTag.Mittwoch);
// Mit der Methode keySet() der Schnittstelle Map die Menge aller
// Schlüssel von map2 ermitteln und anzeigen
            Set<Tage.Tag> key = map2.keySet();
            Object[] object = key.toArray();
            System.out.print("Map2Keys: "); 
            for(int i=0; i<object.length; i++)
               System.out.print(object[i].toString()+" ");
            System.out.println();
// Einen Iterator vom Typ der Schlüssel für map2 über deren Menge
// legen und damit die Werte der Abbildung ausgeben 
            Iterator<Tage.Tag> iterator = key.iterator();
            System.out.print("Map2Values: ");
            while(iterator.hasNext()) {
               System.out.print(map2.get(iterator.next())+" ");
            }
            System.out.println();
// Im Konstruktor der Klasse EnumMap eine Referenz vom Typ der 
// gleichen Klasse übergeben und so ein zweites 
// EnumMap<Tage.Tag,WTag>-Objekt erzeugen
            EnumMap<Tage.Tag,WTag> map4 = 
              new EnumMap<Tage.Tag,WTag>(map2);
            System.out.print("Map4: ");
// Mit der Methode get() des Interface Map einzelne Werte von 
// map4 über ihren Schlüssel lesen und anzeigen
            System.out.print(map4.get(Tage.Tag.tag1)+" ");
            System.out.print(map4.get(Tage.Tag.tag2)+" ");
            System.out.print(map4.get(wtg)+" ");
            System.out.println();
// Mit der Methode putAll() des Interface Map alle Map-Einträge 
//(als Paare betrachtet) von map1 nach map3 kopieren
            map3.putAll(map1);
// Die Methode subMap() gibt eine Sicht auf alle Map-Einträge 
// zurück, deren Schlüssel sich zwischen den angegebenen 
// Werten befinden, inklusiv des ersten und exklusiv des zweiten
            SortedMap<Integer,String> submap = map3.subMap(2,5);
// Die Methode tailMap() gibt eine Sicht auf alle Map-Einträge 
// zurück,deren Schlüssel kleiner (oder gleich) als der 
// angegebene Schlüssel sind
            SortedMap<Integer,String> tailmap = map3.tailMap(3);
// Die Methode headMap() gibt eine Sicht auf alle Map-Einträge 
// zurück, deren Schlüssel kleiner als der angegebene Wert sind
            SortedMap<Integer,String> headmap = map3.headMap(4);
// Die Einträge von map3 und den so erzeugten Submaps anzeigen
            System.out.print("Map3: ");
            System.out.println(map3);
            System.out.print("Das SubMap: ");
            System.out.println(submap);
            System.out.print("Das HeadMap: ");
            System.out.println(headmap);
            System.out.print("Das TailMap: ");
            System.out.println(tailmap);
// Eine Collecction-Sicht auf die Werte der Abbildung map1 
// definieren; die Abbildungswerte sind nicht in aufsteigender 
// Reihenfolge der Schlüsselwerte sortiert
            collection = map1.values();
// Die Einträge der so erzeugten Collection mit einer for-each-
// Schleife anzeigen
            System.out.print("1. Collection: ");
            for(String mapCollection : collection) { 
               System.out.print(mapCollection+" ");
            }
            System.out.println();
// Beinhaltet die so erzeugte Collection alle Werte der 
// Abbildung map4?
   System.out.println(collection.containsAll(map4.values()));
// Alle Werte der Abbildung map4, die auch in map5 enthalten 
// sind, in der Collection löschen und die gebliebenen Werte 
// anzeigen
            collection.removeAll(map5.values());
            System.out.print("2. Collection: ");
            for(String mapCollection: collection) { 
               System.out.print(mapCollection+" ");
            }
            System.out.println();
// Nur die Abbildungswerte aus dem Submap weiter in der 
// Collection beibehalten und im finally-Block anzeigen
            collection.retainAll(submap.values());
// Der Compiler gibt bei der nachfolgenden Anweisung eine Warnung
// aus; wird diese ignoriert, wird zur Laufzeit eine 
// IllegalArgumentException: "Der Schlüssel = 0 liegt ausserhalb 
// des zugelassenen Bereiches" ausgelöst 
            submap.put(0, "Montag");
         }
         catch(IllegalArgumentException e) {
            e.printStackTrace();
         }
         catch(UnsupportedOperationException e) {
            e.printStackTrace();
         }
         catch(ClassCastException e) {
            e.printStackTrace();
         }
// Können in der Collection collection1 die Werte der Abbildung 
// map2 gespeichert werden?
         collection1.addAll(map2.values());
// Kann die Collection collection eine null-Collection 
// beinhalten?
         System.out.println(collection.containsAll(coll));
      }
      catch(NullPointerException e) {
         System.out.println(
           "addAll() auf collection1 nicht moeglich!");
         e.printStackTrace();
      }
// Der finally-Block wir immer ausgeführt
      finally {
         System.out.print("3. Collection: ");
         for(String mapCollection: collection) { 
            System.out.print(mapCollection+" ");
         }
      }
   } 
}
// Die Enumerationen WTag
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
