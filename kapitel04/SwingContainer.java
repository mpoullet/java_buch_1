import javax.swing.*;
import java.awt.*;
public class SwingContainer extends JPanel {
   private final static Color colors[] = {Color.black, 
     Color.white, Color.gray};
// Konstruktordefinition
   public SwingContainer() {
      setLayout(new BorderLayout());
   // setLayout(new FlowLayout());
   }
   protected void paintChildren(Graphics g) {
      Dimension size = getSize();
      int d = Math.min(size.width, size.height);
      int laenge = 10;
      int x = 0;
      for(int y=0; y+laenge<=size.height; y+=laenge) {
         g.setColor(colors[y % colors.length]);
         g.fillRect(0, y, size.width, laenge);
      }
      super.paintChildren(g); 
   }
}
