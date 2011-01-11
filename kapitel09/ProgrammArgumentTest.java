import java.io.*;
public class ProgrammArgumentTest {
   public static void main(String argFile[]) {
      try {
         if(argFile.length != 1)
// Ein IllegalArgumentException-Objek, über den Konstruktor der 
// Klasse, welcher einen Meldungstext entgegennimmt, erzeugen
            throw new IllegalArgumentException(
              "Falsche Anzahl Argumente");
// File-Objekt erzeugen; im Konstruktor der Klasse File kann ein
// Datei- oder Verzeichnis-Name übergeben werden 
         File f = new File(argFile[0]);
// Die Klasse File stellt Methoden zur Verfügung mit denen 
// Informationen über eine Datei oder ein Dateiverzeichnis geholt
// werden können       
         if(f.exists() && f.isFile()) {   
            throw new IllegalArgumentException(argFile[0]
              + " ist eine Datei");   
         }
         else {
         if(f.exists() && f.isDirectory()) {
            throw new IllegalArgumentException(argFile[0]
              + " ist ein Dateiverzeichnis");
            }
            else {
// Ist der im Programmaufruf angegebene String weder eine Datei
// noch ein Dateiverzeichnis, soll dieser in ein int-Zahl 
// konvertiert werden 
               int zahl = Integer.parseInt(argFile[0]);
               System.out.println(zahl);
            }   
         }
      }
      catch (NumberFormatException e) {
         System.out.println("Konvertierung nicht moeglich: "
           + e.getMessage());
      }
      catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
      }
      System.out.println("Es erfolgt kein Programmabbruch: "
        + "Hier kann es weiter gehen");
   }
}
