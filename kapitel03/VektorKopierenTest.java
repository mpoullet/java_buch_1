public class VektorKopierenTest {
   public static void main(String args[]) 
                           throws CloneNotSupportedException {
// Erzeugen eines neuen VektorKopieren-Objektes mit den 
// Konstruktoren der Klasse
      VektorKopieren v1 = new VektorKopieren(1,1,1);
      v1.anzeige();
      VektorKopieren v2 = new VektorKopieren(v1);
      v2.anzeige(); 
// Erzeugen eines neuen VektorKopieren-Objektes durch Veränderung
// des aufrufenden Objektes
      VektorKopieren vneu = v1.neu(3,3,3);
      v1.anzeige();
      vneu.anzeige();
// Erzeugen eines neuen VektorKopieren-Objektes durch Beibehalten
// des aufrufenden Objektes
      v1 = new VektorKopieren(1,1,1);
      VektorKopieren vneu1 = v1.neu1(3,3,3);
      v1.anzeige();
      vneu1.anzeige();
// Für das Klonen von Instanzen der Klasse VektorKopieren 
// ist das Überschreiben der clone()-Methode erforderlich
      VektorKopieren v3 = (VektorKopieren)v1.clone();
      v1.anzeige();
      v3.anzeige();
   }
}
