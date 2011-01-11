import java.awt.*;
import javax.swing.*;
public class PaintKreis extends JComponent { // JLabel { 
// Konstruktordefinition
   public PaintKreis(int x, int y, int d1, int d2, Color c) {
      setBounds(x,y,d1,d2);
      setForeground(c);
      setBackground(Color.lightGray);
      setOpaque(true);
   }
// Die Komponente in der über die forground-Eigenschaft 
// gesetzten Farbe malen
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
   }
}
