public class ArrayTest2 {
// Methodendefinitionen
   public static void anzeige() {
      int[] array1 = new int[2]; 
      int[][] array2 = new int[2][2]; 
      int[][][] array3 = new int[2][2][2];
// Initialisieren der Arrayelemente 
      for(int i=0;i<2; i++) {
         array1[i] = i;
         for(int j=0; j<2; j++) {
            array2[i][j] = i+j;
            for(int k=0; k<2; k++) {
               array3[i][j][k] = i+j+k;
            }
         }
      }
// Anzeige der Arrayelemente 
      for(int x : array1) {
         System.out.print(x+" ");
      }
      System.out.println();
      System.out.println();
      for(int x[] : array2) {
         for(int y : x) {
            System.out.print(y+" ");
         }
         System.out.println();
      }
      System.out.println();
      for(int x[][] : array3) {
         for(int y[] : x) {
            for(int z : y) {
               System.out.print(z+" ");
            }
         System.out.println();
         }
      }
   }
// Array als Rückgabewert in Mehtoden
   public static char[] rueckgabe(char a0, char a1, char a2) {
      char[] a = {a0, a1,a2};
      return a;
   }
   public static void main(String args[]) {
      System.out.println("char-Array");
// Die Methode rueckgabe() liefert ein char-Array zurück, und 
// dessen Elemente werden in einer for-each-Schleife ausgegeben
      for(char x : rueckgabe('a','b','c'))
         System.out.print(x+" ");
      System.out.println();
      System.out.println("int-Arrays"); 
      anzeige();
   } 
}

