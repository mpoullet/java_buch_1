import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.plaf.*;
public class CustomCaret extends DefaultCaret {
   private int caretWidth = 5;
// Eine benutzerdefinierte Wiedergabe für die Komponente 
// definieren
   public void paint(Graphics g) {
      try {
// Das User-Interface-Objekt der Komponente, welcher der 
// Cursor zugeordnet wird, ermitteln
         TextUI textUI = getComponent().getUI();
// Zwischen dem Model- und View-Koordinatensystem wechseln. 
// Die Methode modelToView() der Klasse TextUI wirft eine 
// Exception, die mit einem try/catch-Block abgefangen wird 
         Rectangle r = textUI.modelToView(getComponent(),   
         getComponent().getCaretPosition());
         g.setColor(getComponent().getCaretColor());
         g.fillRect(r.x, r.y, caretWidth, r.height - 1);
      } 
      catch (Exception e) {
         System.out.println("Der Cursor wurde nicht gezeichnet");
      }
   }
   public void mouseClicked(MouseEvent e) {
      JComponent c = (JComponent)e.getComponent();
      c.repaint();
   }
}
