public class Blumen {
   protected final static int ROSE = 0;
   protected final static int TULPE = 1;
   protected final static int NELKE = 2;
   protected final static String ROT = "rot";
   protected final static String GELB = "gelb";
   protected final static String BLAU = "blau";
   protected String farbe;
   protected int blume;
// Konstruktordefinition
   Blumen(int blume, String farbe) {
      this.blume = blume;
      this.farbe = farbe;
   }
// Methodendefinitionen
   public void identifizieren() {
      System.out.print("Diese Blume ist eine "); 
   } 
   public void farbe() {
      System.out.print(", von der Farbe " + farbe);
   }
}
