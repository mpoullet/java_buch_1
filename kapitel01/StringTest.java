import java.util.Arrays;
public class StringTest {
   public static void main(String args[]) {
      String s1, s2, s3; 
// Zuweisung eines Literals
      s1 = "Java"; 
// Den Defaultwert für eine Referenzvariable zuweisen
      s2 = null; 
// String Objekt erzeugen  
      s3 = new String("Java"); 
// String anfügen 
      s1 = s1.concat(" lernen");
// String Objekt erzeugen  
      s2 = new String(s1);
// Teilstring bilden  
      s3 = s2.substring(2,8);
// Die Methode valueOf()der Klasse String aufrufen 
      String s4 = String.valueOf(s1); 
      String s5 = String.valueOf(s2);
// Addieren von String Objekten
      String s6 = s4 + s5;
      System.out.println(s1+" * "+s2+" * "+s3+" * "+s4+" * "+s5+
        " * "+s6);
// Vergleichen von String-Objekten
      System.out.println(vergleichen(s4,s5)); 
// Konvertieren von Strings in numerische Werte
      System.out.print(Integer.parseInt("123"));
      System.out.print(" "+Double.parseDouble("12.3"));
      System.out.print(" "+Short.parseShort("123"));
      System.out.println();
// Konvertieren von numerischen Werten in Strings
      System.out.print(String.valueOf(123+1));
      System.out.print(" "+ String.valueOf(12.3+0.1));
      System.out.print(" "+ String.valueOf(123>0));
      System.out.println();
// Umwandlungen von char-Arrays in String-Objekte
      char[] buchstaben = {'J','A','V','A'};
// Den Konstruktor der Klasse String aufrufen
      String s = new String(buchstaben); 
      char []zahlen = {'0','1','2','3','4','5','6','7','8','9'};
// Mit dem zweiten und dritten Element des char-Arrays einen 
// String erzeugen
      String zwoelf = String.copyValueOf(zahlen,1,2);
// und diesen in ein neues char-Array umsetzen
      char[] zahl1 = zwoelf.toCharArray();
      System.out.println(zwoelf);
      System.out.println(Arrays.toString(zahl1));
      String tausendzweihundertvierunddreisig = String.
        copyValueOf(zahlen,1,4);
      char[] zahl2 = tausendzweihundertvierunddreisig.
        toCharArray();
      System.out.println(tausendzweihundertvierunddreisig); 
      System.out.println(Arrays.toString(zahl2));
// Definition eines String-Array 
      String[] sArray = new String[3];
// Initialisieren der Arrayelemente 
      sArray[0] = StringTest.vergleichen("Java", "JAVA");
      sArray[1] = StringTest.vergleichen("JAVA", "JAVA");
      sArray[2] = StringTest.vergleichen("JAVA", "Java");
      System.out.println(sArray[0]+" und "+sArray[1]+" und "
        +sArray[2]);
// String-Array am Beispiel der Kommandozeilenparameter
      for(int i=0; i<args.length; i++) {
         System.out.println("Parameter "+(i+1)+": " +args[i]);  
      }
   }
// Klassenmethode zum Vergleichen von String Objekten
   public static String vergleichen(String s1, String s2) {
      if(s1.compareTo(s2) > 0)
         return s1+" > "+s2;
      else if(s1.compareTo(s2) < 0)
         return s1+" < "+s2;
      else
         return s1+" = "+s2;
   }
}

