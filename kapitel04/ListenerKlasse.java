import java.awt.*;
import java.awt.event.*;
public class ListenerKlasse extends WindowAdapter 
                            implements ActionListener {
// Methode der Klasse WindowAdapter überschreiben
   public void windowClosing(WindowEvent e) {
         System.exit(0);
   }
// Methode des Interfaces ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
      System.exit(0);
   }
}
