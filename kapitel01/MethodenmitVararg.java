public class MethodenmitVararg {
// Methode mit einer variablen Anzahl von Argumenten
   public static void varArg(char ... c) {
      System.out.println("Anzahl der variablen Argumente: "
        + c.length);
      System.out.print("Werte der variablen Argumente: ");
      for(char x : c)
         System.out.print(x+" ");
      System.out.println();
   }
// Überladen der Methode, indem der Typ der Parameter
// abgeändert wird
   public static void varArg(boolean ... c) {
      System.out.println("Anzahl der variablen Argumente: "
        + c.length);
      System.out.print("Werte der variablen Argumente: ");
      for(boolean x : c)
         System.out.print(x+" ");
      System.out.println();
   }
// Überladen der Methode, indem die Parameterliste erweitert wird
   public static void varArg(int i1, int i2, boolean ... c) {
      System.out.println("Anzahl der variablen Argumente: "
        + c.length);
      System.out.print("Werte der variablen Argumente: ");
      for(boolean x : c)
         System.out.print(x+" ");
      System.out.println();
      System.out.println("Werte der klassischen Argumente: " 
        + i1 + " " + i2);
   }
   public static void main(String args[]) {
// Methodenaufrufe mit unterschiedlicher Anzahl von Argumenten
      varArg('a');
      varArg('a','b','c');
      varArg(false);
      varArg(true, true);
      varArg(1,2,false,true);
      varArg(1,2,true);
   }
} 
