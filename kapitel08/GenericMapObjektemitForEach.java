import java.util.*;
public class GenericMapObjektemitForEach {
   public static void main(String args[]) { 
String[] a = {"Schule1","Schule2"};
      String[][] b = new String [2][2]; 
      String[] c = {"Klasse11","Klasse12"};
      String[] d = {"Klasse21","Klasse22"};
      String[][][] l = new String[2][2][2]; 
      String[][] m = {{"Schueler111","Schueler112"},
        {"Schueler121","Schueler122"}};
      String[][] n = {{"Schueler211","Schueler212"},
        {"Schueler221","Schueler222"}};
      b = new String[][]{c, d};
      l = new String[][][]{m, n};
// Eine parametrisierte Instanz der Klasse TreeMap vom Typ 
// <String,String[]> erzeugen
      TreeMap<String,String[][]> map1 = 
        new TreeMap<String,String[][]>();
      TreeMap<String,String[][][]> map2 = 
        new TreeMap<String,String[][][]>();
      System.out.println("Anzeige der Strings als "
        + "Arrayelemente");
// Ausgabe von einzelnen Arrayelementen mit Hilfe von for-each-
// Schleifen
      for(String str1: a)
         System.out.print(" "+str1);
// Die Varariable x wird als Referenz von einem eindimensionalen
// String-Array definiert; jede Iteration von dieser for-
// Schleife vereinbart das nächste Array aus b und beginnt mit 
// b[0], wobei b[0] = new String [] {"Klasse11","Klasse12"};
      for(String x[] : b) {
         System.out.println();
// Die innere Schleife gibt alle Elemente dieser Arrays aus
         for(String str2: x)
            System.out.print(" "+str2);
      }
      System.out.println();
      for(String y[][] : l) {
         for(String z[] : y) {
            for(String str3: z) {
               System.out.print(" "+str3);
            }
         }
         System.out.println();
      }
// Zuordnungen zwischen Schlüsseln und Werten für die Abbildung 
// map1 definieren
      for(String x : a) {
         map1.put(x,b);
      }
// Die Menge aller Schlüssel und Werte für die Abbildung map1 
// anzeigen
      System.out.println(map1.keySet());
      for(String[][] s: map1.values()) {
         for(String u[] : s) {
           System.out.println(Arrays.asList(Arrays.asList(u)));
         }
      }
// Zuordnungen zwischen Schlüsseln und Werten für die Abbildung 
// map2 definieren
      for(String []x : b) {
         for(String y : x) {
            map2.put(y,l);

         }
      }
// Die Menge aller Schlüssel und Werte für die Abbildung map2 
// anzeigen
      System.out.println(map2.keySet());
         for(String[][][] s: map2.values()) {
            for(String t[][] : s){
               for(String r[] : t){
               System.out.println(Arrays.asList(r));
            }
         }
      }
      System.out.println("Anzeige der Strings als Werte von "
        +"Abbildungen");
      for(String x : a) {
         System.out.print("Die "+x+" hat ");
         for(String[] s: map1.get(x)) {
            for(String u: s) {
               System.out.println("die "+ u + 
                 " mit den Schuelern: "); 
               for(String[][] t: map2.get(u)) {
                  for(String r[] : t) {
                     System.out.println(Arrays.asList(r));
                  }   
               }
            }
         }
      }   
   }
} 
