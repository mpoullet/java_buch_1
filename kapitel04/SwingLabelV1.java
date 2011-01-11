import javax.swing.*;
import java.awt.*;
public class SwingLabel extends JLabel {
   private String text;
   private Color farbe;
// Konstruktordefinition
   public SwingLabel(String text, Color farbe) {
      this.farbe = farbe;
      this.text = text;
// Werden die auskommentierten Anweisungen ausgeführt, 
// wird der Hintergrund auf rosa gesetzt.
// Ohne diese Anweisungen ist der Label transparent,
// d.h. es erscheint der Hintergrund des Containers.
   // setOpaque(true);
   // setBackground(Color.pink);
      setForeground(Color.black);
      setBorder(BorderFactory.createLineBorder(Color.black));
   }
// Graphische Definition der Komponente
   public void paintComponent(Graphics g) {
   //super.paintComponent(g);
      g.setColor(farbe);
      g.fillRect(5,5,30,30);
      g.setColor(getForeground()); 
      g.drawString(text,7,25);
   }
// Bevorzugte Größe der Komponente
   public Dimension getPreferredSize() {
      return new Dimension(40,40);
   }
}
