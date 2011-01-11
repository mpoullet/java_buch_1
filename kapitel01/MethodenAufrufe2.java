class MethodenAufrufe2 {    
 // Instanzmethode 
   public void instMethode() {
      System.out.println("Instanzmethode der Klasse "
        + "MethodenAufrufe2");
// Aufruf einer Instanzmethode aus einer Instanzmethode einer 
// anderen Klasse
      MethodenAufrufe1 instanz1 = new MethodenAufrufe1();
      instanz1.instMethode1();
// Aufruf einer Klassenmethode aus einer Instanzmethode einer 
// anderen Klasse
      MethodenAufrufe1.klsMethode2();
   }
// Klassenmethode 
   public static void klsMethode() {
      System.out.println("Klassenmethode der Klasse "
        + "MethodenAufrufe2");
// Aufruf einer Instanzmethode aus einer Klassenmethode einer 
// anderen Klasse
      MethodenAufrufe1 instanz2 = new MethodenAufrufe1();
      instanz2.instMethode1();
// Aufruf einer Klassenmethode aus einer Klassenmethode einer 
// anderen Klasse
      MethodenAufrufe1.klsMethode2();
   }
}
