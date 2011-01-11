import java.awt.*;
import javax.swing.*;
public class JFramemitpaint extends JFrame {
   private int x = 35;
   private int y = 35;
// Konstruktordefinition
   public JFramemitpaint() {
      super("Kreis zeichnen und f�llen");
      setPreferredSize(new Dimension(100,100)); 
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((d.width -getSize().width)/2,
        (d.height-getSize().height)/2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      pack();
   }
// Die paint()-Methode �berschreiben 
   public void paint(Graphics g) {
// Einen Hintergrund f�r des Fenster setzen
      super.paint(g);
// Die Farbe f�r das Zeichnen setzen
      g.setColor(Color.red); 
      g.fillOval(x,y,50,50);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitpaint frame = new JFramemitpaint();
   }
}
