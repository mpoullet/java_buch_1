import java.awt.*;
import javax.swing.*;
public class JFramemitJInternalFrame extends JFrame {
// Konstruktordefinition
   public JFramemitJInternalFrame() { 
      super("Interne Fenster");
      setSize(175,180);
// Drei interne Fenster zur LayeredPane hinzufügen
      JInternalFrame[] frames = new JInternalFrame[3];
      for(int i=0; i<3; i++) {
         frames[i] = new JInternalFrame("Fenster" + i);
         frames[i].setBounds(10+i*20,10+i*20,100,100);
         frames[i].setVisible(true);
         getLayeredPane().add(frames[i]);
      }
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) { 
      JFramemitJInternalFrame f = new JFramemitJInternalFrame();
   }
}
