import java.awt.*;
import java.awt.event.*;
public class FramemitUpdate extends Frame 
                                     implements WindowListener {
// Konstruktordefinition
   public FramemitUpdate() {
      super("Incremental painting");
      setLayout(new FlowLayout());
      setPreferredSize(new Dimension(200,125));
// Den WindowListener für das aktuelle Objekt registrieren
      this.addWindowListener(this);
   }
// Die Methoden von WindowListener implementieren
   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }
   public void windowClosed(WindowEvent e) {} 
   public void windowIconified(WindowEvent e) {}
   public void windowDeiconified(WindowEvent e) {}
   public void windowActivated(WindowEvent e) {}
   public void windowDeactivated(WindowEvent e) {}
   public void windowOpened(WindowEvent e) {}
// Objekt der Klasse erzeugen 
   public static void main( String args[] ) {
      Point []point1 = new Point[100];
      Point []point2 = new Point[100];
      for(int i=0; i<99; i++) {
         point1[i] = new Point();
         point2[i] = new Point();
      }
      FramemitUpdate frame = new FramemitUpdate();
// Zum Fenster zwei Komponenten, die verschiedene 
// Zeichentechniken nutzen, hinzufügen
      frame.add(new ComponentmitPaint(point1));
      frame.add(new ComponentmitUpdate(point2));
      frame.pack();
      frame.setVisible(true);
   }
}
