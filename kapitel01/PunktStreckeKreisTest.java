public class PunktStreckeKreisTest {
   public static void main(String args[]) {
// Erzeugen und Anzeigen von zwei Punkt-Objekten 
      Punkt P = new Punkt(4.0, 3.0);
      Punkt Q = new Punkt(1.0, 2.0);
      System.out.print("Punkt P: ");
      P.anzeige();
      System.out.print("PunktQ : ");
      Q.anzeige();
// Berechnung der Länge der Strecke PQ und Anzeige der 
// Geradengleichung durch diese Punkte
      Strecke PQ = new Strecke(P,Q);
      System.out.println("Laenge der Strecke PQ = " + 
        PQ.distanz());
      System.out.print("Geradengleichung: ");
      PQ.geradenGleichung();
// Berechnung von Flaeche und Umfang des Kreises und Anzeige der
// Kreisgleichung 
      Kreis k = new Kreis(PQ);
      System.out.println("Flaeche des Kreises mit dem " +
        "Mittelpunkt P" + " und PQ als Radius = " + k.flaeche());
      System.out.println("Umfang des Kreises mit dem " +
        "Mittelpunkt P" + " und PQ als Radius = " + k.umfang());
      System.out.print("Kreisgleichung: ");
      k.kreisGleichung();
   }
}
