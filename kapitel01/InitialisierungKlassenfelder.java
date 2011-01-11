import java.util.Arrays;
public class InitialisierungKlassenfelder {
// Klassenfeld Initialisierer  
   private static byte einbyte;
   private static char einchar = 'A';
   private static int einint ;
   private static short einshort;
   private static long einlong = 1;
   private static float einfloat;
   private static double eindouble = 0.1;
   private static boolean einboolean;
   private static String einString = "Java 6.0"; 
   private static Punkt einPunkt;
   private static char [] einArray = new char[26];
// Klassenblock Initialisierer
   static{
      for(int i = 0; i<26; i++) {
// buchstabe ist eine lokale Variable und kein Feld der Klasse
         char buchstabe = (char)('A'+ i);
         einArray[i] = buchstabe;
      }
   }
// Selbstreferenzierendes Klassenfeld
   static InitialisierungKlassenfelder selfReferentialFeld = 
     new InitialisierungKlassenfelder(
       "Initialisierung von Klassenfelder");
// Konstruktordefinition
   InitialisierungKlassenfelder(String s) {
      einPunkt = new Punkt(1,1);
      einint = 1;
      System.out.println(s);
   } 
   public static void main(String args[]) {
// Anzeige der Werte von primitiven Typen
      System.out.println(selfReferentialFeld);
      System.out.println("einbyte: "+einbyte);
      System.out.println("einint: "+einint);
      System.out.println("einshort: "+einshort);
      System.out.println("einfloat: "+einfloat);
      System.out.println("einboolean: "+einboolean);
      System.out.println("einchar: "+einchar);
      System.out.println("einlong: "+einlong);
      System.out.println("eindouble: "+eindouble);      
// Anzeige der Werte von Referenztypen
      System.out.println("einString: "+einString);
      System.out.print("einPunkt: ");
// Methode der Klasse Punkt an einer Instanz der Klasse aufrufen
      einPunkt.anzeige(); 
// Anzeige der Werte von Arraytypen mit der Methode der Klasse 
// Arrays
      System.out.println(Arrays.toString(einArray));
   }
}
