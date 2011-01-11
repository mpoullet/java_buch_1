import java.awt.*;
import javax.swing.*;
public class SwingPaintComponent {
// Ein Objekt der Klasse SwingContainer
// in einem Fenster sichtbar machen
   public static void main(String[] args) {
      JFrame f = new JFrame("Swing-Komponenten");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = new SwingContainer();
      c.add(new SwingComponent());
      f.add(c, BorderLayout.CENTER);
      f.pack();
      f.setVisible(true);
   }
}
