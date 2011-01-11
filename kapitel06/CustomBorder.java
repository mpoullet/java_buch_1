import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class CustomBorder extends AbstractBorder { 
// Selbstreferenzierendes Klassenfeld
   private static Border buttonBorder = new CustomBorder();
// Zugriffsmethode
   public static Border getButtonBorder() {
      return buttonBorder;
   }
// Einen neuen Rand in einer vom Button-Status abhängigen Farbe 
// und der von der Methode getInsets() vorgegebenen Breite malen
   public void paintBorder(Component c, Graphics g, int x, int y,
                           int width, int height) {
      AbstractButton b = (AbstractButton)c;
      ButtonModel bm = b.getModel();
      Insets in = getBorderInsets(c);
      if(bm.isPressed()) {
         g.setColor(c.getForeground());
      }
      else if (b.hasFocus()) {
         g.setColor(SystemColor.green);
      } 
      else {
         g.setColor(SystemColor.red);
      }
      g.fillRect(x, y, width, in.left);
      g.fillRect(x, y+height-in.right, width, in.left);
      g.fillRect(x+width-in.right, y, in.left, height);
      g.fillRect(x, y, in.left, height);
   }
// Definition der Breite des oberen, linken, rechten und 
// unteren Randes der Kompponente
   public Insets getBorderInsets (Component c) {
      return new Insets(3, 3, 3, 3);
   }
}
