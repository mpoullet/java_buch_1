import java.util.Arrays;
import java.util.logging.*; 
public class SprachundAusnahmeErweiterungen {
// Ein unbenanntes Logger-Objekt w�re in diesem Fall ausreichend,
// private static Logger logger = Logger.getAnonymousLogger();
// dieses kann aber auch �ber einen Namen verf�gen
   private static Logger logger = Logger.getLogger(
     Logger.GLOBAL_LOGGER_NAME); 
   private static String[] erweiterungen = {"ThrowinCatch", 
     "ArrayCopy", "EmptyString", "GLOBAL_LOGGER_NAME"};
   private static String[] s = {"","JAVA 6.0",null};
   private static Integer[] array1 = {1, 2, 3, 4};
   private static Number[] array2 = {1.0,2.0,3.0,4.0};
// Eine Warnung am Bildschirm ausgeben, und nachdem der 
// StackTrace gef�llt wurde, wird die im Methodenaufruf 
// �ber eine RuntimeException-Referenz �bergebene Exception-
// Instanz mit der Anweisung throw weitergeleitet
   static void catchThrow(RuntimeException e) { 
// Die nachfolgenden Aufrufe f�hren zu gleicher Ausgabe
    //  logger.warning("Laufzeitfehler!"); 
        logger.log(Level.WARNING, "LaufzeitFehler");
        e.fillInStackTrace(); 
        throw e; 
    } 
    public static void main(String args[]) {
// Die Methoden copyOfRange() und copyOf()
      System.out.println("1. Array vor dem Kopieren: "
        + Arrays.toString(erweiterungen));
      System.out.println("2. Array vor dem Kopieren: "
        + Arrays.toString(s));
// Den angegebenen Bereich des spezifizierten Arrays in ein neues
// Array kopieren
      String copy[] = Arrays.copyOfRange(erweiterungen,1,3);
      System.out.println("Neues Array nach dem Kopieren: "
        + Arrays.toString(copy));
// Das spezifizierte Array kopieren, k�rzen oder erg�nzen und mit 
// null-Werten auff�llen, damit das erzeugte Array die angegebene
// L�nge hat 
      erweiterungen = Arrays.copyOf(s, 4);
      System.out.println("1. Array nach dem Kopieren: "
        + Arrays.toString(erweiterungen));
      System.out.println("2. Array nach dem Kopieren: "
        + Arrays.toString(s));
// Die Methode isEmpty()
      for(int i=0; i<s.length; i++) {
         try {
            if(s[i].isEmpty())
               System.out.println("Leerer String: "+s[i]);
            else
               System.out.println("Nicht leerer String: "+s[i]);
         } 
         catch(NullPointerException e) {
            System.out.println("null-String: "+s[i]);
// Die abgefangene Exception wird aus diesem catch-Block 
// �ber den Aufruf der Methode catchThrow() der Klasse 
// weitergegeben
            catchThrow(e); 
         }
      }
   }
}
