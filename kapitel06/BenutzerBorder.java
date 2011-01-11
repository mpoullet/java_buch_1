import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class BenutzerBorder extends AbstractBorder {
   private Insets in;
// Konstruktordefinition  
   public BenutzerBorder(int oben, int unten, int rechts, 
                         int links) {
      in = new Insets(oben, unten, rechts, links); 
   }
// Die Methode der Klasse AbstarctBorder wird überschrieben
   public void paintBorder(Component comp, Graphics g, int x,
                           int y, int width, int height) {
      g.setColor(Color.red);
      g.fillRect(x+in.top, y+in.bottom, width-in.right, in.right);
      g.fillRect(x+in.top, y+in.bottom, in.left, height-in.left);
      g.translate(x-in.top, y-in.bottom);
      g.fillRect(width-in.right, in.left, in.right, 
        height-in.left);
      g.fillRect(in.right, height-in.left, width-in.right, 
        in.left);
      g.translate(-x-in.top, -y-in.bottom);
   }
}
