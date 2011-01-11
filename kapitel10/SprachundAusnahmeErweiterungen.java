import java.util.Arrays;
import java.util.logging.*; 
public class SprachundAusnahmeErweiterungen {
// Ein unbenanntes Logger-Objekt wäre in diesem Fall ausreichend,
// private static Logger logger = Logger.getAnonymousLogger();
// dieses kann aber auch über einen Namen verfügen
   private static Logger logger = Logger.getLogger(
     Logger.GLOBAL_LOGGER_NAME); 
   private static String[] erweiterungen = {"ThrowinCatch", 
     "ArrayCopy", "EmptyString", "GLOBAL_LOGGER_NAME"};
   private static String[] s = {"","JAVA 6.0",null};
   private static Integer[] array1 = {1, 2, 3, 4};
   private static Number[] array2 = {1.0,2.0,3.0,4.0};
// Eine Warnung am Bildschirm ausgeben, und nachdem der 
// StackTrace gefüllt wurde, wird die im Methodenaufruf 
// über eine RuntimeException-Referenz übergebene Exception-
// Instanz mit der Anweisung throw weitergeleitet
   static void catchThrow(RuntimeException e) { 
// Die nachfolgenden Aufrufe führen zu gleicher Ausgabe
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
// Das spezifizierte Array kopieren, kürzen oder ergänzen und mit 
// null-Werten auffüllen, damit das erzeugte Array die angegebene
// Länge hat 
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
// über den Aufruf der Methode catchThrow() der Klasse 
// weitergegeben
            catchThrow(e); 
         }
      }
   }
}
