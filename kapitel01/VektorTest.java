class VektorTest {
   public static void main(String args[]) {
// Erzeugen von Vektor-Objekten mit den unterschiedlichen 
// Konstruktoren
      Vektor v1 = new Vektor();
      v1.anzeige();
      Vektor v2 = new Vektor(1,1,1);
      v2.anzeige();
      Vektor v3 = new Vektor(v2);
      v3.anzeige(); 
// Erzeugen eines neuen Vektor-Objektes durch Veränderung des 
// aufrufenden Objektes
      Vektor vneu = v1.neu(3,3,3);
      v1.anzeige();
      vneu.anzeige();
// oder
      v1 = new Vektor();
      Vektor vcopy = v1.neu(new Vektor(3,3,3));
      v1.anzeige();
      vcopy.anzeige();
// Erzeugen eines neuen Vektor-Objektes durch Beibehalten des 
// aufrufenden Objektes
      v1 = new Vektor();
      Vektor vneu1 = v1.neu1(3,3,3);
      v1.anzeige();
      vneu1.anzeige();
   }
}
