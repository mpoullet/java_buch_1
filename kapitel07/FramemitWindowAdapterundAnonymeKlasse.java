import java.awt.*;
import java.awt.event.*;
public class FramemitWindowAdapterundAnonymeKlasse extends Frame{
// Konstruktor der umgebenden Klasse
   public FramemitWindowAdapterundAnonymeKlasse() {
      super("Anonyme Klasse für WindowAdapter");
      setBounds(10,10,100,100);
      setBackground(Color.cyan);
      setVisible(true);
// Den WindowListener als Instanz vom Typ WindowAdapter mittels 
// einer anonymen Klasse für Objekte der umgebenden Klasse 
// registrieren und implementieren
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      }); 
   }
// Objekt der umgebenden Klasse erzeugen
   public static void main(String[] args) {
      FramemitWindowAdapterundAnonymeKlasse frame = new 
        FramemitWindowAdapterundAnonymeKlasse();
   }
}
