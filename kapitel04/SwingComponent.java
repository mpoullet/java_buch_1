import java.awt.*;
import javax.swing.*;
public class SwingComponent extends JLabel { // JComponent { 
   private final static Color farbe[] = {Color.black, 
     Color.white, Color.gray};
// Konstruktordefinition
   public SwingComponent() {
      setOpaque(true);
      setBackground(Color.green);
   }
// Die gewünschte Größe der Komponente definieren
   public Dimension getPreferredSize() {
       return new Dimension(150,150);
   }
// Die Methode paintComponent() wird aufgerufen, wenn eine 
// Komponente zum erstemmal gemalt wird oder wenn sich
// ihre Sichtbarkeit oder Größe ändert
   protected void paintComponent(Graphics g) {
// Den Hintergrund von Komponenten setzen
      super.paintComponent(g); 
      Dimension size = getSize();
      int d = Math.min(size.width, size.height); 
      int breite = 10;
      int y = 40;
      for(int x=40; x+breite<=size.width-40; x+=breite) {
         g.setColor(farbe[x % farbe.length]);
         g.fillRect(x, y, breite, size.height-8*breite );
      }
// Hiermit werden die gemalten Inhalte vom Hintergrund 
// der Komponente überschrieben
   //   super.paintComponent(g); 
   } 
}
