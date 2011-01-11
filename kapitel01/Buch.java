class Buch {
   private int seite;
// Eine globale Referenz vom Typ der eigenen Klasse definiert
// ein selbstreferenzierendes Feld
   private Buch naechsteSeite; 
// Konstruktordefinition
   Buch(int seite) {
      setSeite(seite);
      setNaechsteSeite(null);
   }
// Zugriffsmethoden
   public void setSeite(int seite) {
      this.seite = seite;
   }
   public int getSeite() {
      return seite;
   }
   public void setNaechsteSeite(Buch naechsteSeite) {
      this.naechsteSeite = naechsteSeite;
   }
   public Buch getNaechsteSeite() {
      return naechsteSeite;
   }
// Links über selbreferenzierende Felder erzeugen
   public static void rueckwaertsBlaettern(int von, int bis) {
// Lokale Referenz vom Typ der eigenen Klasse
      Buch vorigeSeite = null; 
      for(int i=von; i<=bis; i++) {
// Eine neue Instanz der Klasse, mit einem Verweis auf die vorher
// konstruierte, wird erzeugt  
         Buch aktuelleSeite = new Buch(i); 
         aktuelleSeite.setNaechsteSeite(vorigeSeite);
// Bei einer Zuweisung von Referenzvariablen, wird kein neues 
// Objekt erzeugt, die Referenzvariable vorigeSeite zeigt auf das
// gleiche Objekt wie die Referenzvariable aktuelleSeite
         vorigeSeite = aktuelleSeite;
      }
      Buch aktuelleSeite = vorigeSeite;
      while(aktuelleSeite != null) {
      System.out.print("Seite "+ aktuelleSeite.getSeite() + " ");
         aktuelleSeite = aktuelleSeite.getNaechsteSeite();
      }
      System.out.println();
   }
   public static void vorwaertsBlaettern(int von, int bis) {
// Lokale Referenz vom Typ der eigenen Klasse
      Buch vorigeSeite = new Buch(bis); 
      for(int i=bis-1; i>=von; i--) {
// Eine neue Instanz der Klasse, mit einem Verweis auf die vorher
// konstruierte, wird erzeugt  
         Buch aktuelleSeite = new Buch(i); 
         aktuelleSeite.setNaechsteSeite(vorigeSeite);
// Zuweisung von Referenzvariablen
         vorigeSeite = aktuelleSeite;
      }
      Buch aktuelleSeite = vorigeSeite;
      while(aktuelleSeite != null) {
      System.out.print("Seite "+ aktuelleSeite.getSeite() + " ");
         aktuelleSeite = aktuelleSeite.getNaechsteSeite();
      }
      System.out.println();
   }
}
