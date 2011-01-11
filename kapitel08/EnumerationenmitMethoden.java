import java.util.*;
public class EnumerationenmitMethoden {
// Konstruktordefinition
   public EnumerationenmitMethoden() {
// An den Aufzählungskonstanten der Enumerationen werden deren 
// Methoden getTag() und ansage() aufgerufen 
      for(WTag tag: WTag.values())
         System.out.print(tag.getTag()+" ");
      System.out.println();
      for(Tage.Tag tag: Tage.Tag.values())
         System.out.println(tag.ansage());
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      EnumerationenmitMethoden wochentage = 
        new EnumerationenmitMethoden();
   }
}
// Die Enumeration WTag 
enum WTag {
   Montag(Tage.Tag.tag1), Dienstag(Tage.Tag.tag2), Mittwoch(
     Tage.Tag.tag3), Donnerstag(Tage.Tag.tag4),  Freitag(
       Tage.Tag.tag5), Samstag(Tage.Tag.tag6), Sonntag(
         Tage.Tag.tag7);
   private Tage.Tag tag;
// Konstruktordefinition
   WTag(Tage.Tag tag) {
      this.tag = tag;
   }
// Zugriffsmethoden
   public Tage.Tag getTag() {
      return tag;
   }
   public void setTag(Tage.Tag tag) {
      this.tag = tag;
   }
}
// Die Klasse Tage und die Enumeration Tag
class Tage {
// Die abstrakte Methode ansage() der Enumeration Tag wird 
// konstantenabhängig implementiert
   enum Tag {
      tag1 { 
         String ansage() {
            return "Heute ist Montag";
         }
      },
      tag2 {
         String ansage() {
            return "Heute ist Dienstag";
         }
      },
      tag3 { 
         String ansage() {
            return "Heute ist Mittwoch";
         }
      },
      tag4 { 
         String ansage() {
            return "Heute ist Donnerstag";
         }
      },
      tag5 { 
         String ansage() {
            return "Heute ist Freitag";
         }
      },
      tag6 {
         String ansage() {
            return "Heute ist Samstag";
         }
      },
      tag7 { 
         String ansage() {
            return "Heute ist Sonntag";
         }
      };
// Deklaration der abstrakten Methode 
      abstract String ansage();
   }
}
