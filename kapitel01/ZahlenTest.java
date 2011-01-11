class ZahlenTest {
// Konstantendefinitionen zur Beschreibung von Objektzuständen
   static final int GANZEZAHLEN = 1; 
   static final int RATIONALEZAHLEN = 2; 
// Der Typ der Zahlen wird zur Vereinfachung von deren Auswahl
// als int-Wert definiert         
   int zahlenTyp;
// Globale Referenzen vom Typ der Klasse GanzeZahlen                  
   GanzeZahlen z1; 
   GanzeZahlen z2; 
// Konstruktordefinition
   ZahlenTest(int zahlenTyp,int z1, int z2) {
      this.z1 = new GanzeZahlen(z1);
      this.z2 = new GanzeZahlen(z2);
      this.zahlenTyp = zahlenTyp;
      switch(zahlenTyp) {
         case GANZEZAHLEN: 
            defGanzeZahlen(); 
            break;
         case RATIONALEZAHLEN:
            defRationaleZahlen();
             break;
      }
   }
   public void defGanzeZahlen() {
      z1.anzeige();
      z2.anzeige();
      GanzeZahlen t = GanzeZahlen.ggTeiler(z1, z2);
      System.out.print("Groesste gemeinsame Teiler: ");
      t.anzeige();
GanzeZahlen v = GanzeZahlen.kgVielfaches(z1, z2);
      System.out.print("Kleinste gemeinsame Vielfache: ");
      v.anzeige();
      System.out.print("Ergebnis der Addition: ");
      GanzeZahlen.add(z1, z2).anzeige();
      System.out.print("Ergebnis der Subtraktion: ");
// Ketten von Methoden
      z1.subtr(z2).anzeige();
      System.out.print("Ergebnis der Division: ");
      GanzeZahlen.divid(z1, z2).anzeige();
      System.out.print("Ergebnis der Multiplikation: ");
      z1.multipl(z2).anzeige();
   }
   public void defRationaleZahlen() {
      RationaleZahlen r1 = new RationaleZahlen(
        new GanzeZahlen(-1), new GanzeZahlen(-5));
      r1.anzeige();
      RationaleZahlen r2 = new RationaleZahlen(z1,z2);
      r2.anzeige();
      System.out.print("Kuerzung von rationalen Zahlen: ");
      r1.kuerzen().anzeige();
      r2.kuerzen().anzeige();
      System.out.print("Ergebnis der Addition: ");
      RationaleZahlen.add(r1, r2).anzeige();
      System.out.print("Ergebnis der Subtraktion: ");
// Ketten von Methoden
      r1.subtr(r2).anzeige();
      System.out.print("Ergebnis der Division: ");
      RationaleZahlen.divid(r1, r2).anzeige();
      System.out.print("Ergebnis der Multiplikation: ");
      r1.multipl(r2).anzeige();
   }
// Objekte der Klasse erzeugen
   public static void main(String args[]) {
      ZahlenTest test1 = new ZahlenTest(1, 6, -9);
      ZahlenTest test2 = new ZahlenTest(2, 6, -9);
   }
} 
