class MethodenAufrufe1 {    
// Instanzmethoden 
   public void instMethode1() {
      System.out.println("1. Instanzmethode der Klasse "
        + "MethodenAufrufe1");
// Aufruf einer Instanzmethode aus einer Instanzmethode der 
// gleichen Klasse
      instMethode2();
// Aufruf einer Klassenmethode aus einer Instanzmethode der 
// gleichen Klasse
      MethodenAufrufe1.klsMethode1();
   }
   public void instMethode2() {
      System.out.println("2. Instanzmethode der Klasse "
       + "MethodenAufrufe1");    
   }
// Klassenmethoden 
   public static void klsMethode1() {
      System.out.println("1. Klassenmethode der Klasse "
        + "MethodenAufrufe1");
   }
   public static void klsMethode2() {
      System.out.println("2. Klassenmethode der Klasse "
        + "MethodenAufrufe1");
// Aufruf einer Instanzmethode aus einer Klassenmethode der 
// gleichen Klasse
      MethodenAufrufe1 instanz = new MethodenAufrufe1(); 
      instanz.instMethode2();
// Aufruf einer Klassenmethode aus einer Klassenmethode der 
// gleichen Klasse
      MethodenAufrufe1.klsMethode1();
   }
}
