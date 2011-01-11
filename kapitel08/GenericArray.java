public class GenericArray<T> { 
   T [] array;
// Konstruktordefinition
   GenericArray(T[] zahlen) { 
// Compiler Fehler: "Generic array creation"
   // array = new T[10]; 
// Korrekt ist eine Zuweisung von Referenzen 
      array = zahlen; 
   } 
   public static void main(String args[]) { 
      Integer []iNummer = {1, 2}; 
      Double [] dNummer = {1.0, 2.0}; 
// Objekte der GenericArray-Klasse von unterschiedlichen Typen 
// erzeugen und die Elemente der Instanzfelder der Klasse
// (vom Typ Array) anzeigen
      GenericArray<Integer> iObjekt = 
        new GenericArray<Integer>(iNummer);
      GenericArray<Double> dObjekt = 
        new GenericArray<Double>(dNummer); 
      for(int i=0; i<2; i++) {
         System.out.print(" I["+i+"] = "+iObjekt.array[i]);
         System.out.print(" D["+i+"] = "+dObjekt.array[i]);
      }
      System.out.println();
// Array-Objekte von unterschiedlichen parametrisierten Typen der
// GenericArray-Klasse erzeugen (zweidimensionale Arrays)
// Fehlerhafte Zuweisung: "Generic array creation"
   // GenericArray<Integer> []genArray = 
   //   new GenericArray<Integer>[2]; 
// Korrekt ist: 
      GenericArray <?>[] genArray = new GenericArray<?>[2]; 
      for(int i=0; i<2; i++) {
         genArray[i] = new GenericArray<Integer>(iNummer); 
         for(int j=0; j<2; j++) {
            System.out.print(" I["+i+","+j+"] = " 
              + genArray[i].array[j]);
         }
         System.out.println();
      }
      for(int i=0; i<2; i++) {
         genArray[i] = new GenericArray<Double>(dNummer); 
         for(int j=0; j<2; j++) {
            System.out.print(" D["+i+","+j+"] = " 
              + genArray[i].array[j]);
         }
         System.out.println();
      }  
   } 
}
