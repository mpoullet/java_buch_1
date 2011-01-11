import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitgetGraphics extends JFrame 
                                       implements MouseListener {
   private Font f = new Font("TimesRoman", Font.BOLD, 16);
   Graphics g;
// Konstruktordefinition
   public JFramemitgetGraphics() {
      super("Fenster anklicken");
      setBounds(10,50,200,100);
      setVisible(true);
      addMouseListener(this);
// Den Graphikkontext für das Fenster ermitteln
      g = this.getGraphics();
      g.setFont(f); 
      g.setColor(Color.red);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
// Die Methoden des MouseListener implementieren
   public void mousePressed(MouseEvent e) {
// Die Koordinaten des Mausklicks lesen
      int x = e.getX();
      int y = e.getY();
// Der Text wird auf dem Bildschirm an den Pixelkoordinaten 
// (x,y) ausgegeben 
      g.drawString("Java6.0", x, y);
   }
   public void mouseClicked(MouseEvent e) {};
   public void mouseReleased(MouseEvent e) {};
   public void mouseEntered(MouseEvent e) {};
   public void mouseExited(MouseEvent e) {};
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitgetGraphics frame = 
        new JFramemitgetGraphics();
   }
}   
