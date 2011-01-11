import java.util.*;
public class PrivaterKonstruktor {
// Selbstreferenzierendes Klassenfeld
   private static PrivaterKonstruktor datumunduhrzeit;
// Privater Konstruktor der Klasse
   private PrivaterKonstruktor() {
// Instanz der Klasse GregorianCalendar erzeugen und deren 
// Methoden aufrufen
      GregorianCalendar calendar = new GregorianCalendar(); 
      System.out.println("Datum: "+calendar.get(Calendar.DATE)+
        "."+(calendar.get(Calendar.MONTH)+1)+"."+
          calendar.get(Calendar.YEAR)); 
      System.out.println("Uhrzeit: "+calendar.get(
        Calendar.HOUR_OF_DAY)+"."+calendar.get(Calendar.MINUTE)+
          "."+calendar.get(Calendar.SECOND)); 
   }
// Klassenmethode, welche ein Objekt der Klasse erzeugt 
   public static PrivaterKonstruktor getInstanz() {
      if(datumunduhrzeit == null)
         datumunduhrzeit = new PrivaterKonstruktor();
      return datumunduhrzeit;
   }
} 

