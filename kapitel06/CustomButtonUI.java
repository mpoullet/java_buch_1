import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.*;
public class CustomButtonUI extends MetalButtonUI {
// Eine gemeinsame, unver�nderbare Instanz der Klasse 
// CustomBorder erzeugen
   private final static Border customBorder = 
     CustomBorder.getButtonBorder();
   private Border standardBorder;
// Eine gemeinsame, unver�nderbare Instanz der eigenen Klasse 
// erzeugen
   private final static CustomButtonUI buttonUI = 
      new CustomButtonUI();
// Die Methoden der Klasse MetalButtonUI �berschreiben
   public static ComponentUI createUI(JComponent c) {
      return buttonUI;
   }
   public void installUI(JComponent c) {
      super.installUI(c);
// Den Standard-Border der �begebenen Komponente speichern
      standardBorder = c.getBorder();
// Einen benutzerdefinierten Border f�r die Komponente setzen
      c.setBorder(customBorder);
   }
   public void uninstallUI(JComponent c) {
// Den Standard-Border f�r die Komponente zur�cksetzen
      if(c.getBorder() == customBorder)
         c.setBorder(standardBorder);
      super.uninstallUI (c);
   }
// Das Muster auf dem Button erg�nzen
   public void paint(Graphics g, JComponent c) {
      Graphics2D g1 = (Graphics2D)g;
      Rectangle r1 = new Rectangle(0, c.getHeight()/4,
        c.getWidth(), c.getHeight()/4);
      g1.setColor(Color.MAGENTA);
      g1.fill(r1);
      Rectangle r2 = new Rectangle(0, c.getHeight()/2, 
        c.getWidth(), c.getHeight()/4);
      g1.setColor(Color.GRAY);
      g1.fill(r2);
   }
}
