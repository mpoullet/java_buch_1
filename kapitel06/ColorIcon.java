import java.awt.*;
import javax.swing.*;
public class ColorIcon implements Icon {
   private Color color;
// Konstruktor der Klasse
   public ColorIcon(Color color) { 
      this.color = color;
   }
// Die Methoden der Icon-Schnittstelle implementieren
// Die Größe des Icon definieren
   public int getIconHeight() {
      return 16;
   }
   public int getIconWidth() {
      return 56;
   }
// Das Icon zeichnen
   public void paintIcon(Component c, Graphics g, int x, int y) {
// Die Referenz vom Typ Component zeigt auf die Komponente,
// auf welche das Icon gemalt werden soll
      g.setColor(color);
      g.fillRect(x, y, 56, 16);
   }
}
