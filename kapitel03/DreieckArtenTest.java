public class DreieckArtenTest {
   public static void main(String args[]) {
      String[] name = {"Gleichseitiges Dreieck: ", 
        "Gleichschenkliges Dreieck: "};   
// Zuweisen von Objektreferenzen der konkreten Klassen an eine 
// Referenzvariable vom Typ der abstrakten Klasse 
      DreieckArten[] dr = new DreieckArten[] {
        new GleichseitigesDreieck(4),
          new GleichschenkligesDreieck(5,3)};
      for(int i=0; i<2; i++) {
         System.out.println(name[i]+ "Hoehe = "+dr[i].hoehe()+
          " * Flaecheninhalt = "+dr[i].flaeche(dr[i].hoehe())+
            " * Umfang = "+dr[i].umfang());
         double[] winkel = dr[i].berechneWinkel();
         System.out.println("1. Winkel = "+winkel[0]+" * 2. "+
           "Winkel = "+ winkel[1]+" * 3. Winkel = "+winkel[2]);
      }
// Zuweisen von Objektreferenzen der konkreten Klassen an eine 
// Variable vom Typ des Interfaces 
      FlaechenInhalt[] f = new FlaechenInhalt[] {
        new GleichseitigesDreieck(4),
          new GleichschenkligesDreieck(5,3)};
      for(int i=0; i<2; i++) {
         System.out.println( name[i]+ "Hoehe = "+f[i].hoehe()+
            " * Flaecheninhalt = "+f[i].flaeche(f[i].hoehe()));
      }
// Aufruf der Methoden der Schnittstelle und der abstrakten 
// Klasse an Instanzen einer Unterklasse
      GleichseitigesDreieck gsd = new GleichseitigesDreieck(4);
      System.out.println( name[0]+ "Hoehe = "+gsd.hoehe()+ 
        " * Flaecheninhalt = "+gsd.flaeche(gsd.hoehe())+
          " * Umfang = "+gsd.umfang());
      double[] wgsd = gsd.berechneWinkel();
      System.out.println("1. Winkel = "+wgsd[0]+
        " * 2. Winkel = "+wgsd[1]+" * 3. Winkel = "+wgsd[2]);
   }
}   
