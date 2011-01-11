import java.awt.*;
import javax.swing.*;
public class Framemitpaint extends Frame {
// Konstruktordefinition
   public Framemitpaint() {
// Eine Überschrift für das Fenster definieren
      super("Oval zeichnen und füllen");
// Größe und Position des Fensters bestimmen
      setBounds(0,0,100,100);
// Die Hintergrundfarbe für das Fenster setzen
      setBackground(Color.cyan); 
   }
// Die paint()-Methode überschreiben 
   public void paint(Graphics g) {
// Die Farbe für das Zeichnen setzen
      g.setColor(Color.red); 
      g.fillOval(30,50,60,40);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      Framemitpaint frame = new Framemitpaint();
      frame.setVisible(true);
   }
}
