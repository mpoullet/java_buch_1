class PunktTest {
   public static void main(String args[]) {
// Erzeugen einer Punkt-Instanz 
      Punkt p = new Punkt(1.5, -4.5);
// Anzeige der Punkt-Instanz
      p.anzeige();
// Setzen und Lesen von Punktkoordinaten   
      p.setX(-4.0);
      p.setY(4.0);
      System.out.println("x = "+p.getX());
      System.out.println("y = "+p.getY());
   }
}
