import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LabelmitMouseEvent extends JLabel implements 
                                                 MouseListener {
   private Color c;
   private Font f;
// Koordinatenwerte für den Aufruf von paintComponent() 
// beim Programmstart setzen
   private int x = 100;
   private int y = 100;
// Konstruktordefinition
public LabelmitMouseEvent() {
      c = Color.red;
      f = new Font("Arial", Font.BOLD, 16);
// Den MouseListener registrieren
      addMouseListener(this);
   }
// Zugriffsmethoden
   public void defFarbe(Color c) {
      this.c = c;
   }
   public void defSchrift(Font f) {
      this.f = f;
   }
// Den Text schreiben
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setFont(f); 
      g.setColor(c);
      g.drawString("Java 6.0",x,y);
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
   public void mouseClicked(MouseEvent e) {};
   public void mouseReleased(MouseEvent e) {};
   public void mouseEntered(MouseEvent e) {};
   public void mouseExited(MouseEvent e) {};
}
