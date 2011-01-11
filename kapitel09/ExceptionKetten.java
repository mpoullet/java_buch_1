import java.io.*;
public class ExceptionKetten {
// Globale Referenzen
   private String [] argFile;
   private File f;
   private MyException nofileEx, fileEx, directoryEx;
   private MyException1 myEx; 
// Konstruktordefinition
public ExceptionKetten(String [] argFile) throws MyException1, 
                       MyException {
      try {
         this.argFile = argFile;
// Ein MyException-Objekt über den Konstruktor der Klasse, 
// welcher einen Meldungstext entgegennimmt, erzeugen 
         if(argFile.length == 1) {
            throw new MyException("Korekte Anzahl Argumente");
         }
         else {
            throw new MyException("Falsche Anzahl Argumente");
         }
      }
      catch (MyException e) {
         try {
// Ein File-Objekt erzeugen und mit den Methoden der Klasse 
// Informationen über die Datei oder das Verzeichnis holen 
            f = new File(argFile[0]);
// Eine mit der Exception e gekettete Ausnahme erzeugen und 
// werfen      
            if(f.exists())
               myEx =  new MyException1(argFile[0]
                + " ist eine Datei oder ein Dateiverzeichnis",e);   
            else
               myEx =  new MyException1(argFile[0]
                +" ist keine Datei und kein Dateiverzeichnis",e);   
            throw myEx;
         }
// Wurde kein Argument im Programmaufruf angegeben,
// wird eine IndexOutOfBoundsException erzeugt, 
// weil argFile[0] nicht vorhanden ist
         catch (IndexOutOfBoundsException npe) {
            System.out.println(e.getMessage());
            npe.printStackTrace();
         }
// Weitere Ausnahmen vom Typ MyException erzeugen und diesen, 
// da sie nicht über einen entsprechenden Konstruktor verfügen, 
// über die Methode initCause() die zu verkettende Ausnahme mye 
// zuweisen
         catch (MyException1 mye) {
            if(f.isFile()) {
               fileEx = new MyException(argFile[0]
                 + " ist eine Datei");
               fileEx.initCause(mye);
               throw fileEx;
            }
            else if(f.isDirectory()) {
               directoryEx = new MyException(argFile[0] 
                 + " ist ein Dateiverzeichnis");
               directoryEx.initCause(mye);
               throw directoryEx;
            }
            else {
               nofileEx = new MyException(argFile[0]
                 + " wurde im Programmaufruf angegeben");
               nofileEx.initCause(mye);
               throw nofileEx;
            }
         }
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String argFile[]) {
      try {
         ExceptionKetten exKette = new ExceptionKetten(argFile);
      }
// Alle Exceptions, die vom Konstruktor der Klasse ausgelöst und 
// nicht abgefangen wurden, hier abarbeiten 
      catch(Exception e) {
         while(e != null) {
// Die Meldungstexte der Ausnahmen in der Reihenfolge ihrer 
// Kettung ausgeben
            System.out.println(e.getMessage());
            e =(Exception)e.getCause();
         }
      }
      System.out.println("Die gesamte Kette wurde abgearbeitet");
   }
} 
