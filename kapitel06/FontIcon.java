import java.awt.*;
import javax.swing.*;
public class FontIcon implements Icon {
   private Font font;
   private String string;
// Konstruktor der Klasse
   public FontIcon(Font font, String string) {
      this.font = font;
      this.string = string;
   }
// Die Größe des Icon definieren
   public int getIconHeight() {
      return 16;
   }
   public int getIconWidth() {
      return 96;
   }
// Das Icon zeichnen; die paintIcon()-Methode wird nicht nur am 
// Anfang beim Erzeugen der Komponente aufgerufen, sondern bei 
// jeder Mausbewegung entlang der Komponente
   public void paintIcon(Component c, Graphics g, int x, int y) {
      g.setFont(font);
      g.setColor(Color.red);
// (x,y) ist der Eckpunkt der Komponente, auf welche das Icon 
// gemalt werden soll
      g.drawString(string, x, y+10);
   }
}
