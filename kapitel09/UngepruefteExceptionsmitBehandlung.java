public class UngepruefteExceptionsmitBehandlung {
   public static void main(String args[]) {   
      char[] buchstaben = {'J','A','V','A'};
      int[] codePoint1 = {1,2,3};
      int[] codePoint2 = {100,101,102};
      try {
         String s1 = new String(buchstaben); 
         String s2 = new String("Java");  
         try {
// Strings anfügen
            s1 = s2.concat(" lernen");
// Teilstrings bilden 
            String s3 = s2.substring(2,8); 
            String s4 = s1.substring(2,8); 
         }
         catch(IndexOutOfBoundsException e) {
            System.out.println(
              "Teilstringbildung nicht moeglich");
            e.printStackTrace();
         }
// Nach Ausgabe der Fehlermeldung wird das Programm an dieser  
// Stelle weitergeführt   
         String s5 = new String(codePoint1,0,3);
         String s6 = new String(codePoint2,0,3);
         int zahl = Integer.parseInt(s6);
// Zu dieser Anweisung kehrt das Programm nicht mehr zurück, 
// ein weiterer try/catch-Block wäre erforderlich
         int zahl2 = Integer.valueOf(s1); 
      }
      catch(NumberFormatException e) {
         System.out.println("Konvertierung nicht moeglich");
         e.printStackTrace();
      }
   }
}
