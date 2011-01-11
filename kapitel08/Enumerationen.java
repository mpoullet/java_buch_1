import java.util.*;
public class Enumerationen {
// Konstruktordefinition
   public Enumerationen() {
// Die Anzeige der Aufzählungskonstanten aus beiden Enumerationen 
      System.out.print("Enumeration WTag: ");
      for(WTag tag: WTag.values())
         System.out.print(tag+" ");
      System.out.println();
      System.out.print("Enumeration Tag: ");
      for(Tage.Tag tag: Tage.Tag.values())
         System.out.print(tag+" ");
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      Enumerationen wochentage = new Enumerationen();
   }
}
// Die Enumeration WTag
enum WTag {
   Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, 
     Sonntag
}
// Die Klasse Tage und die Enumeration Tag
class Tage {
// Definition der Enumeration Tag
   enum Tag {
      tag1, tag2, tag3, tag4, tag5, tag6, tag7
   }
}
