import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Framemitrepaint extends Frame 
                                       implements MouseListener {
   private Font f = new Font("TimesRoman", Font.BOLD, 16);
// Die Koordinaten (x,y) für den Programmaufruf initialisieren
   private int x = 100 ;
   private int y = 50; 
// Konstruktordefinition
   public Framemitrepaint() {
      super("Fenster anklicken");
      setBounds(10,10,200,100);
      setVisible(true);
// Den MouseListener für das Fenster registrieren
      addMouseListener(this);
   }
   public void paint(Graphics g) {
      g.setFont(f); 
      g.setColor(Color.red);
// Der Text wird auf dem Bildschirm an den Pixelkoordinaten 
// (x,y) ausgegeben
      g.drawString("Java 6.0", x, y);
   }
// Die Methoden des Interface implementieren
   public void mousePressed(MouseEvent e) {
// Die Koordinaten des Mausklicks lesen;
      x = e.getX();
      y = e.getY();
// ein neuer Text wird ausgehend von dem Punkt mit diesen 
// Koordinaten geschrieben 
      repaint();
   }
   public void mouseClicked(MouseEvent e){};
   public void mouseReleased(MouseEvent e){};
   public void mouseEntered(MouseEvent e){};
   public void mouseExited(MouseEvent e){};
// die update()-Methode überschreiben
   public void update(Graphics g) {
// nur Aufruf von paint(), ohne den Hintergrund zu löschen
        paint(g);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      Framemitrepaint frame = new Framemitrepaint();
   }
}   
