import java.io.*;
public class ProgrammArgumentTestmitMyException {
   public static void main(String argFile[]) {
// File-Objekt erzeugen; im Konstruktor der Klasse File kann 
// ein Datei- oder Verzeichnis-Name übergeben werden 
      try {
         if(argFile.length != 1)
// MyException-Objekt über den Konstruktor der Klasse, welcher 
// einen Meldungstext entgegennimmt, erzeugen 
            throw new MyException("Falsche Anzahl Argumente", 
              "1. ");
         File f = new File (argFile[0]);
         if(f.exists() && f.isFile()) {   
            throw new MyException(argFile[0]
              + " ist eine Datei", "2. ");   
         }
         else {
            if(f.exists() && f.isDirectory()) {
               throw new MyException(argFile[0]
                 + " ist ein Dateiverzeichnis", "3. ");
            }
            else{
               int zahl = Integer.parseInt(argFile[0]);
               System.out.println(zahl);
            }   
         }
      }
      catch (NumberFormatException e) {
         System.out.println("Konvertierung nicht moeglich: " 
           + e.getMessage());
      }
      catch (MyException e) {
         System.out.println(e.getMeldungsNr()
           + e.getMessage());
      }
      System.out.println("Es erfolgt kein Programmabbruch: "
        + "Hier kann es weitergehen");
   }
}
