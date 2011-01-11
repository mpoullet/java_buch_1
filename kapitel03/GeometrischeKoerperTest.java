public class GeometrischeKoerperTest {
   public static void main(String args[]) {
// Es können keine Objekte von abstrakten Klassen erzeugt werden;
// der Aufruf von Methoden erfolgt an Objekten der Unterklassen
      Kugel kugel = new Kugel(3);
      System.out.println("Kugel: Volumen = "+kugel.volumen()+
        " Oberflaeche = "+kugel.oberflaeche());
      Kegel kegel = new Kegel(3,4);
      System.out.println("Kegel: Volumen = "+kegel.volumen()+
        " Oberflaeche = "+kegel.oberflaeche());
   }
}
