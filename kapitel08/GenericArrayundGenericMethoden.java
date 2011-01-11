public class GenericArrayundGenericMethoden { 
// Gehört das angegebene Element zur Menge?
   static <T, V extends T> int sucheElement(T elem, V[] array) { 
      for(int i=0; i<array.length; i++) 
         if(elem.equals(array[i]))
             return i; 
         return -1; 
   } 
// Ist die erste Menge in der zweiten enthalten?
   static <T, V> boolean sucheMenge(T[] array1, V[] array2) { 
      for(int i=0; i<array1.length; i++) { 
         for(int j=0; j<array2.length; j++) { 
            if(array1[i] != (array2[j])) {
                return false; 
            }
         }
      }
      return true;
   }
// Bei ungleichen Mengenelementen diese gleich setzen
   static <T> T[] tauscheMenge(T[] array1, T[] array2) {
      for(int i=0; i<array1.length; i++) {
         if(array1[i] != (array2[i])) {
            array1[i] = array2[i];
         }
      }
      return array1;
   } 
// Mengen als Array-Objekte darstellen und die Methoden der 
// Klasse aufrufen
   public static void main(String args[]) { 
      Integer []zahlen = {1, 20, 3, 14, 5, 10, 34, 4, 8};
      String []buchstaben1 = {"A", "B", "C", "D"};
      String []buchstaben2 = {"F", "B", "C", "E"};  
      String []buchstaben; 
// Ein Element in einer Menge suchen
      for(int i=0; i<11; i++) { 
         int index = sucheElement(i, zahlen); 
         if(index != -1)
            System.out.println(i + " ist ein Element der Menge"); 
         else
            System.out.println(i + " ist kein Element der Menge"); 
      }
// Teilmenge ermitteln
      if(sucheMenge(buchstaben2, buchstaben1))
         System.out.println("Menge ist Teilmenge"); 
      else
         System.out.println("Menge ist keine Teilmenge"); 
// Ungleiche Elemente austauschen
      buchstaben = tauscheMenge(buchstaben1,buchstaben2);
      System.out.print("Elemente einer Menge: ");
      for(int i=0; i<buchstaben.length; i++) {
         System.out.print(buchstaben[i]+" ");
      }
   } 
} 
