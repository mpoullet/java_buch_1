import java.util.*;
public class GenericMapObjekte {
   private static String [] schule = new String[3]; 
   private static String [][] klasse = new String[3][3]; 
   private static String [][][] schueler = new String[3][3][3]; 
// Instanzen der generischen Klasse TreeMap<K,V> erzeugen
   public static void main(String args[]) { 
      TreeMap<String,String> map1 = new TreeMap<String,String>();
      TreeMap<String,Map<String,String>> map2 =
         new TreeMap<String, Map<String,String>>();
      for(int i=1; i<3; i++) {
         schule[i] = new String("Schule"+i);
         for(int j=1; j<3; j++) {
            klasse[i][j] = new String("Klasse"+i+j);
            for(int k=1; k<3; k++) {
               schueler[i][j][k] = new String("Schueler"+i+j+k);
            }
         }
      }
      for(int i=1; i<3; i++) {
         for(int j=1; j<3; j++) {
// Den Schlüsseln der Abbildung map1 Werte zuordnen
            map1.put(klasse[i][j], schule[i]);
         }
      }
      for(int i=1; i<3; i++) {
         for(int j=1; j<3; j++) {
            for(int k=1; k<3; k++) {
// Den Schlüsseln der Abbildung map2 Werte zuordnen
               map2.put(schueler[i][j][k], map1);
            }
         }
      }
      for(int i=1; i<3; i++) {
         for(int j=1; j<3; j++) {
            for(int k=1; k<3; k++) {
// Die Werte, in welche diese Maps ihre Schlüssel abgebildet 
// haben, ermitteln
               System.out.println("Der " + schueler[i][j][k]
                 + " ist in der " + klasse[i][j]+ " der " + 
                (map2.get(schueler[i][j][k])).get(klasse[i][j]));
            }
         }
      }
   } 
}     
