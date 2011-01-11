public class ExceptionsundFinally {
// Ausnahmen generieren
   public static void ausfuehrenFinally(int i) {
      char[] buchstaben = {'J','A','V','A'};
      int[] codePoint1 = {-1,2,3,4};
      String s1 = new String(buchstaben); 
      try {
         switch(i) {
            case 0:
               String s2 = s1.substring(2,8);
               break;
            case 1:
               int zahl1 = Integer.parseInt("a234");
               break;
            case 2:
               String s3 = new String(codePoint1,0,3);
               System.out.println(s3);
               break;
            case 3:
               int zahl2 =Integer.valueOf(s1); 
               break;
            case 4:
               System.out.println("Rueckkehr aus dem try-Block");
               return;
            default:
               System.out.println("Keine Exception ausgeloest");
         }
      }
      catch(IndexOutOfBoundsException e) {
         System.out.println("Teilstringbildung nicht moeglich,"
           + " Rueckkehr aus dem catch-Block");
         return;
      }
      catch(NumberFormatException e) {
         System.out.println("Konvertierung nicht moeglich");
      }
      catch(IllegalArgumentException e) {
         System.out.println("Stringbildung nicht moeglich");
      }
      finally {
         System.out.println("finally wird immer ausgefuehrt");
      }
   }
   public static void main(String args[]) {
      for(int i=0; i<=5; i++)
         ausfuehrenFinally(i);
   }   
} 
