public class UngepruefteExceptionsohneBehandlung  {
   public static void main(String args[]) {
// Über verschiedene Konstruktoren der String-Klasse Objekte 
// erzeugen
      char[] buchstaben = {'J','A','V','A'};
      int[] codePoint1 = {1,2,3};
      int[] codePoint2 = {100,101,102};
      String s1 = new String(buchstaben); 
      String s2 = new String("Java");
      String s5 = new String(codePoint1,0,3);
      String s6 = new String(codePoint2,0,3);
// String anfügen
      s1 = s2.concat(" lernen");
// Teilstring kann gebildet werden 
      String s3 = s1.substring(2,8);
// Teilstring kann nicht gebildet werden und führt zu einem
// Laufzeit-Fehler; das Programm wird hier abgebrochen, 
// weil keine Ausnahmebehandlung vorgesehen ist.
// Die ArrayIndexOutOfBoundsException wird geworfen.
      String s4 = s2.substring(2,8);
// Die Zahl kann nicht gebildet werden, führt ebenfalls zu 
// einem Laufzeit-Fehler: NumberFormatException  
   // int zahl = Integer.parseInt(s6);
   }
}  
