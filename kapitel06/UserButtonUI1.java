import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.ComponentUI;
public class UserButtonUI1 extends MetalButtonUI {
// Ein selbstreferenzierndes Klassenfeld zeigt auf eine 
// gemeinsame, nicht änderbare Instanz der Klasse, die von der
// createUI()-Methode returniert wird
   private final static UserButtonUI1 userButtonUI1 = 
     new UserButtonUI1();
// Klassenmethode für die Referenz auf die Instanz der Klasse
   public static ComponentUI createUI(JComponent c) {
      return userButtonUI1;
   }
// Die Methode der Klasse MetalButtonUI, welche das Focus-
// Rectangle malt, wird mit einer leeren Methode überschrieben
   protected void paintFocus(Graphics g, AbstractButton b,
    Rectangle viewRect, Rectangle textRect, Rectangle iconRect){}
}
