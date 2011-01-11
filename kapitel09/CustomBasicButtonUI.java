import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.*;
public class CustomBasicButtonUI extends BasicButtonUI {
// Ein selbstreferenzierendes Klassenfeld kann in seiner 
// Deklaration initialisiert werden
   private final static CustomBasicButtonUI buttonUI = 
     new CustomBasicButtonUI();
   private static Color defaultLowColor = UIManager.getColor(
     "Button.LowBackground");
   private static Color defaultHighColor = UIManager.getColor(
     "Button.HighBackground");
// Die Methoden der Klasse BasicButtonUI überschreiben
   public static ComponentUI createUI(JComponent c) {
      return buttonUI;
   }
   public void installUI(JComponent c) {
      super.installUI(c);
// Für die Standard-Buttons ist die opaque-Eigenschaft auf 
// true gesetzt und für den CustomButton wird sie über 
// setContentAreaFilled(false) gesetzt; damit dies nicht dazu 
// führt, dass für das CustomLookAndFeel Bildschirmmmüll im 
// Standard-Buttons angezeigt wird, werden auch diese 
// durchsichtig gemacht
      c.setOpaque(false);
   }
   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
   }
   public void paint(Graphics g, JComponent c) {
// Die Schrift auf den Buttons soll ihre Farbe nach dem Status 
// der Komponente ändern
      AbstractButton b =(AbstractButton)c;
      ButtonModel bm = b.getModel();
      Dimension d = b.getSize();
      FontMetrics fm = g.getFontMetrics();
      String label = b.getText();
      int x = (d.width-fm.stringWidth(label))/2;
      int y = (d.height+fm.getAscent())/2;
      if(bm.isPressed()) {
         g.setColor(defaultLowColor); 
      } 
      else if(b.hasFocus()) {
         g.setColor(defaultHighColor); 
      } 
      else {
         g.setColor(Color.blue);
      }
      g.drawString(label,x,y);
      g.drawOval(0, 0, d.width-3, d.height-3);
   }
}
