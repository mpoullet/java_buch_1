import java.awt.*;
import javax.swing.*;
public class Framemitpaint extends Frame {
// Konstruktordefinition
   public Framemitpaint() {
// Eine �berschrift f�r das Fenster definieren
      super("Oval zeichnen und f�llen");
// Gr��e und Position des Fensters bestimmen
      setBounds(0,0,100,100);
// Die Hintergrundfarbe f�r das Fenster setzen
      setBackground(Color.cyan); 
   }
// Die paint()-Methode �berschreiben 
   public void paint(Graphics g) {
// Die Farbe f�r das Zeichnen setzen
      g.setColor(Color.red); 
      g.fillOval(30,50,60,40);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      Framemitpaint frame = new Framemitpaint();
      frame.setVisible(true);
   }
}
