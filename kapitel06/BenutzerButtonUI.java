import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
public class BenutzerButtonUI extends MetalButtonUI {
// Eine unveränderbare Instanz der Klasse erzeugen
   private final static BenutzerButtonUI benutzerButtonUI = 
     new BenutzerButtonUI();
// Die Methoden der Klasse MetalButtonUI werden überschrieben
   public static ComponentUI createUI(JComponent c) {
      return benutzerButtonUI;
   }
   public void installUI(JComponent c) {
      super.installUI(c);
// Einen benutzerdefinierten Rand, vom Typ der Klasse 
// BenutzerBorder, für die Komponente setzen
      c.setBorder(new BenutzerBorder(4,4,4,4));
      c.setBackground(Color.pink);
   }
   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
   }
   public Dimension getPreferredSize(JComponent c) {
      return new Dimension(100,50);
   }
}
