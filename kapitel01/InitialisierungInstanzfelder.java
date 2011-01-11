// import java.util.Arrays;
public class InitialisierungInstanzfelder {
// Instanzfeld Initialisierer  
   private byte einbyte;
   private char einchar = 'A';
   private int einint ;
   private short einshort;
   private long einlong = 1;
   private float einfloat;
   private double eindouble = 0.1;
   private boolean einboolean;
   private String einString ="Java 6.0";
   private Punkt einPunkt;
   private char [] einArray = new char[26];
// Instanzblock Initialisierer
   {
      for(int i = 0; i<26; i++) {
// buchstabe ist eine lokale Variable und kein Feld der Klasse
         char buchstabe = (char)('A'+ i);
         einArray[i] = buchstabe;
      }
   }
// Selbstreferenzierendes Instanzfeld
   InitialisierungInstanzfelder selfReferentialFeld; 
// Konstruktordefinition
   InitialisierungInstanzfelder(String s) {
      einPunkt = new Punkt(1,1);
      einint = 50;
      System.out.println(s);
   }
// Methode zur InitIialisierung des selbstreferenzierenden 
// Instanzfeldes
   public InitialisierungInstanzfelder setselfReferentialFeld() {
      return selfReferentialFeld = 
        new InitialisierungInstanzfelder(
          "Initialisierung von Instanzfelder");
   }
   public static void main(String args[]) {
// Objekt der Klasse erzeugen
      InitialisierungInstanzfelder instanz = 
        new InitialisierungInstanzfelder(
          "Initialisierung von Instanzfelder");
// Initialisierung des selbstreferenzierenden Feldes 
      System.out.println(instanz.setselfReferentialFeld());
// Anzeige der Werte  von primitiven Typen
      System.out.println("einbyte: "+instanz.einbyte);
      System.out.println("einint: "+instanz.einint);
      System.out.println("einshort: "+instanz.einshort);
      System.out.println("einfloat: "+instanz.einfloat);
      System.out.println("einboolean: "+instanz.einboolean);
      System.out.println("einchar: "+instanz.einchar);
      System.out.println("einlong: "+instanz.einlong);
      System.out.println("eindouble: "+instanz.eindouble);
// Anzeige der Werte von Referenztypen 
      System.out.println("einString: "+instanz.einString);
      System.out.print("einPunkt: ");
// Die Methode der Klasse Punkt, an einer Instanz der Klasse 
// aufrufen
      instanz.einPunkt.anzeige();          
// Die Anzeige der Elemente von einArray kann nicht über den 
// Methodenaufruf Arrays.toString(einArray) erfolgen, weil auf 
// ein Instanzfeld, nicht aus einem statischen Kontext, direkt 
// zugegriffen werden kann
// System.out.println(Arrays.toString(einArray)); // Fehler
      System.out.print("[ ");
      for(int i = 0; i<26; i++) {
         System.out.print(instanz.einArray[i]+" ");
      }
      System.out.println("]");
   }
}  
