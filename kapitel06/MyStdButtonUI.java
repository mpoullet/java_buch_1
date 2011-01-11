import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.*;
public class MyStdButtonUI extends MetalButtonUI {
// Eine unveränderbare Instanz der Klasse erzeugen
   private final static MyStdButtonUI myButtonUI = 
      new MyStdButtonUI();
// Die Methoden der Klasse MetalButtonUI überschreiben
   public static ComponentUI createUI(JComponent c) {
      return myButtonUI;
   }
   public void installUI(JComponent c) {
      super.installUI(c);
   }
   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
   }
   protected void paintButtonPressed(Graphics g, 
                                     AbstractButton b) {
      Dimension size = b.getSize();
      Insets insets = b.getBorder().getBorderInsets(b);
      g.setColor(UIManager.getColor("Button.shadow"));
      g.drawOval(insets.left, insets.top, size.width-insets.left-
        insets.right, size.height-insets.top-insets.bottom);
   }
}
