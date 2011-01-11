import java.awt.*;
import javax.swing.*;
public class CustomField extends JTextField {
// Konstruktordefinition
   public CustomField(int n) {
// Ein Textfeld mit n Spalten erzeugen
      super(n);
// Das UI-Delegationsobjekt daran hindern, den Hintergrund des 
// Texfeldes zu malen
      setOpaque(false);
   }
// Eine abgerundete viereckige Fläche für das Textfeld zeichnen
   protected void paintComponent(Graphics g) {
      int width = getWidth();
      int height = getHeight();
      g.setColor(Color.gray);
      g.fillRoundRect(0, 0, width, height, height, height);
      super.paintComponent(g); 
   }
// Einen abgerundeten viereckigen Rand um das Textfeld zeichnen
   protected void paintBorder(Graphics g) {
      g.setColor(getForeground());
      g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 
        getHeight()-1, getHeight()-1);
   }
}
