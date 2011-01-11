public class ViereckeTest {
   public static void main(String args[]) { 
// Erzeugen von Objekten der Klasse Quadrat und ihrer 
// Unterklassen, Aufruf von überschriebenen Methoden 
      Quadrat q = new Quadrat(4);
      System.out.println("Quadrat: Flaeche = "+q.flaeche()
        +" * Umfang = "+q.umfang());
      q.toString(q.diagonale());
      Rechteck r = new Rechteck(4,3);
      System.out.println("Rechteck: Flaeche = "+r.flaeche()
        +" * Umfang = "+r.umfang());
      r.toString(r.diagonale());
      Parallelogramm p = new Parallelogramm(4,4,60);
      System.out.println("Parallelogramm: Flaeche = "+p.flaeche()
        +" * Umfang = "+p.umfang());
      p.toString(p.diagonale());
      Drachen d = new Drachen(4,3,60,40);
      System.out.println("Drachen: Flaeche = "+d.flaeche()
        +" * Umfang = "+d.umfang());
      d.toString(d.diagonale());
// Aufruf der Zugriffsmethoden, am Beispiel der Klasse Drachen
      System.out.println("1. Seite = "+d.getSeite1()
        +" * 2. Seite = "+d.getSeite2()+" * 1. Winkel = "
          +d.getWinkel1()+" * 2. Winkel = "+d.getWinkel2());
   }
}   
