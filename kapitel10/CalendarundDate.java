import java.util.*;
public class CalendarundDate {
   public static void main(String args[]) {
// Eine Instanz der Klasse Calendar anlegen
      Calendar calendar = Calendar.getInstance();
// Die einzelnen Werte anzeigen
      System.out.print("Heute ist der: " + calendar.get(
        Calendar.DAY_OF_MONTH) + " ");      
      System.out.print((calendar.get(Calendar.MONTH)+1) + " ");
      System.out.print(calendar.get(Calendar.YEAR) + " ");
      System.out.print(" und es ist: " + calendar.get(
        + Calendar.HOUR_OF_DAY) + " ");
      System.out.print(calendar.get(Calendar.MINUTE) + " ");
      System.out.print(calendar.get(Calendar.SECOND) + " Uhr");
      System.out.println();
// Eine Instanz der Klase Locale anlegen
      Locale locale = Locale.getDefault();
// Den Namen des aktuellen Monats anzeigen
      String monat = calendar.getDisplayName(Calendar.MONTH, 
        Calendar.LONG, locale);
      System.out.println("Der aktuelle Monat ist: "+ monat);
// und die gekürtzten Namen der Monate in einer Abbildung vom 
// Typ Map<String,Integer> den konstanten Werten von 0 bis 11 
// zuordnen
      Map<String,Integer> map = calendar.getDisplayNames(
        Calendar.MONTH, Calendar.SHORT, locale);
// Die Map-Einträge anzeigen
      System.out.println(map);
// Die Instanzen der Klassen Date und GregorianCalendar
// Der Konstruktor Date(year+1900, month, date) ist "deprecated"
      Date datum1 = new Date(107,04,22);
      System.out.println(datum1);
// und wurde durch GregorianCalendar(year+1900, month, date) 
// ersetzt
      GregorianCalendar datum2 = 
        new GregorianCalendar(2007,04,22);
// Damit wird jedoch eine andere String-Representation für ein 
// Datum geliefert
   // System.out.println(datum2);
// Darum für die Datumsanzeige die get-Methoden der Klasse 
// aufrufen 
      System.out.println(datum2.get(Calendar.DAY_OF_MONTH) + 
        " " + datum2.get(Calendar.MONTH) + " "
          + datum2.get(Calendar.YEAR));
// Wenn der Monat nicht von 0 bis 11, sondern von 1 bis 12
// angezeigt werden soll, muss +1 addiert werden:
      System.out.println(datum2.get(Calendar.DAY_OF_MONTH) + 
        " " + ( datum2.get(Calendar.MONTH)+1 ) + " "
          + datum2.get(Calendar.YEAR));
// Die Methode getTime() der Klasse Calendar liefert ein
// Date-Objekt zurück
      System.out.println(calendar.getTime());
// Der parameterlose Konstruktor ist nicht "deprecated"; 
// ebenfalls die Methode getTime() der Klasse Date
      Date datum3 = new Date();
      System.out.println(datum3.getTime());
   }
}
