import java.lang.reflect.Array;
import java.util.Arrays;
public class ArrayTest1 {
// Ein Array-Objekt muss mit dem new-Operator über die Angabe 
// einer festen Grösse erzeugt werden 
   private static int[]a = new int[3];
   private static int[][] x = new int [2][3]; 
// Alternative Deklarationen   
   // private int a[] = new int[3];
   // private static [][] int x = new int [2][3]; 
   // private static int [] x [] = new int [2][3]; 
// Klassenmethode für die Anzeige eines zweidimensionalen Arrays
   public static void anzeige(int[][] x) {
      for(int i=0; i<2; i++) {
         for(int j=0; j<3; j++)
            System.out.print(x[i][j]+" ");
// Zeilenumbruch ausgeben
         System.out.println();
      }
      System.out.println();
}
   public static void main(String args[]) {
// Eindimensionale Arrays initialisieren
// Arrayelemente können auch einzeln initialisiert werden
      int []y = new int[3];
      for(int i=0; i<3; i++)
         y[i]= 1;
// Eine kompakte Initialisierung für Arrayelemente wird vom 
// Compiler in eine Initialisierung von einzelnen Elementen 
// umgeformt und erst zur Laufzeit durchgeführt
      int[] z = {2,2,2};
// Initialisierungen mit einem konstanten Wert über die Methode 
// fill() der Klasse Arrays 
      Arrays.fill(a,7);
      System.out.println(
        "Eindimensionales Array von primitiven Datentypen");
// Mit der Methode toString() der Klasse Arrays das Array 
// anzeigen
      System.out.println(Arrays.toString(a));
// Methoden der Klasse Array aufrufen
      Array.setInt(a, 0, 6); 
      Array.setInt(a, 1, 6); 
      Array.setInt(a, 2, 6);
      Integer integer = (Integer)Array.get(a, 0);
// Den Wert des Wrapper-Objektes ermitteln 
      int n = integer.intValue();
      System.out.println(a[0] + " " + a[1] +" " +a[2]+"**"+n);
// Zweidimensionale Arrays über eindimensionale Arrays erzeugen
      System.out.println("Zweidimensionale Arrays sind Arrays"
        +" von eindimensionalen Arrays");
      for(int i=0; i<2; i++) {
         x[i] = new int [] {9, 9, 9};
// Mit der Methode toString() der Klasse Arrays die 
// eindimsionalen Arrays anzeigen
         System.out.print(Arrays.toString(x[i]));
         System.out.println(); 
      }
      System.out.println("Zweidimensionale Arrays von primitiven"
        + " Datentypen");
// Das so erzeugte zweidimensionale Array ausgeben
      anzeige(x);
// Inititialisierungen von zweidimensionalen Arrays
      x = new int[][]{{1, 1, 1},{2,2,2}};
      anzeige(x);
      x = new int[][]{y, z};
      anzeige(x);
// Dynamisches Erzeugen eines Array mit der Methode 
// newInstance() der Klasse Array 
      int c[] = {2}; 
      Object array = Array.newInstance(int.class,c);
      Array.setInt(array, 0, 4); 
      Array.setInt(array, 1, 4);
      System.out.println("Eindimensionales Array von primitiven"
        + " Datentypen"); 
      System.out.println(Array.getInt(array,0) + " "+ 
        Array.getInt(array,1));
// Elemente von Referenzarrays müssen immer einzeln instanziert 
// werden
      Vektor [] v = new Vektor[2];
      Vektor [][] w = new Vektor[2][2];
      System.out.println("Eindimensionales Array vom Typ der "
        + "Klasse Vektor");
      for(int i=0; i<2; i++) {
         v[i] = new Vektor(1,2,3);  
      }
// An den Vektor-Objekten wird die Methode anzeige() der Vektor-
// Klasse aufgerufen
      v[0].anzeige(); 
      v[1].anzeige();
// Zeilenumbruch definieren
      System.out.println();
      System.out.println("Zweidimensionales Array vom Typ der "
        + "Klasse Vektor");
      for(int i=0; i<2; i++) {
         w[i][0] = new Vektor(1,2,3);
         w[i][1] = new Vektor(4,5,6);
      }
      for(int i=0; i<2; i++) {
         w[i][0].anzeige(); 
         w[i][1].anzeige();
      }
   }
}
