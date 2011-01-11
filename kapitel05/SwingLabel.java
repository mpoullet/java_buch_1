import javax.swing.*;
import java.awt.*;
class SwingLabel extends JLabel {
// Konstruktordefinition
   public SwingLabel(String text, Color farbe) {
      super(text);
// Den Text in der Mitte des Labels positionieren
      setHorizontalAlignment(JLabel.CENTER);
//  Die Hintergrundfarbe der Komponente festlegen
      setOpaque(true);
      setBackground(farbe);
// Die Schriftfarbe festlegen
      setForeground(Color.black);
// Einen Rand festlegen
      setBorder(BorderFactory.createLineBorder(Color.black));
   }
}
