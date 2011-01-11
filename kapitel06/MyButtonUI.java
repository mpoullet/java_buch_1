import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicBorders;
public class MyButtonUI extends BasicButtonUI 
                                     implements MouseListener {
// Eine unveränderbare Instanz der Klasse erzeugen
   private final static MyButtonUI myButtonUI = new MyButtonUI();
// Klassenfelder für neue Bordertypen definieren und 
// initialisieren
   private final static Border compoundBorder1 = new 
     CompoundBorder(BorderFactory.createEmptyBorder(20,20,20,20),
       BorderFactory.createEmptyBorder(10,10,10,10));
   private final static Border compoundBorder2 = new 
     CompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10),
       BorderFactory.createEmptyBorder(5,5,5,5));
// Instanzfelder für Farben definieren
   private Color foregroundPressed = null;
   private Color foregroundClicked = null;
// Die Methoden der Klasse BasicButtonUI werden überschrieben
   public static ComponentUI createUI(JComponent c) {
      return myButtonUI;
   }
   public void installUI(JComponent c) {
      super.installUI(c);
// Instanzfelder initialisieren und Event-Listener registrieren
      foregroundPressed =UIManager.getColor("Button.darkShadow");
      foregroundClicked =UIManager.getColor("Button.shadow");
      c.addMouseListener(this);
   }
   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
// Event-Listener entfernen
      c.removeMouseListener(this);
   }
   public Dimension getPreferredSize(JComponent c) {
      return new Dimension(100,100);
   }
// Benutzerdefinierte Wiedergabe für die Komponente definieren
   public void paint(Graphics g, JComponent c) {
      Dimension size = c.getSize();
      FontMetrics fm = g.getFontMetrics();
      Insets insets = c.getInsets();
      g.setColor(Color.green);
      g.fillOval(5, 5, size.width - 10, size.height - 10);
      g.setColor(c.getForeground());
      g.drawString(((JButton)c).getText(), insets.left - 5, 
        insets.top + fm.getAscent() + 10);
   }
// Die Methoden des MouseListener implementieren 
   public void mousePressed(MouseEvent e ) {
      JComponent c = (JComponent)e.getComponent();
      c.setBorder(compoundBorder1);
      c.setForeground(foregroundPressed);
      System.out.println("mousePressed: " + foregroundPressed); 
      c.repaint();
   }
   public void mouseClicked(MouseEvent e) {
      JComponent c = (JComponent)e.getComponent();
      c.setBorder(compoundBorder2);
      c.setForeground(foregroundClicked);
      System.out.println("mouseClicked: " + foregroundClicked); 
      c.repaint();
   }
   public void mouseReleased( MouseEvent e) {}
   public void mouseEntered( MouseEvent e) {}
   public void mouseExited( MouseEvent e) {}
}
