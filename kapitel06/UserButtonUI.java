import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.ComponentUI;
public class UserButtonUI extends BasicButtonUI {
// Ein selbstreferenzierndes Klassenfeld zeigt auf eine 
// gemeinsame, nicht änderbare Instanz der Klasse, die von der
// createUI()-Methode returniert wird
   private final static UserButtonUI userButtonUI = 
     new UserButtonUI();
// Klassenmethode für die Referenz auf die Instanz der Klasse
   public static ComponentUI createUI(JComponent c) {
      return userButtonUI;
   }
// Den Button grün färben
   protected void paintButtonPressed(Graphics g, 
                                     AbstractButton b) {
      g.setColor(Color.green);
      g.fillRect(0, 0, b.getSize().width, b.getSize().height);
   }
// Bevorzugte Größe des Buttons
   public Dimension getPreferredSize(JComponent c) {
      return new Dimension(150,50);
   }
}
