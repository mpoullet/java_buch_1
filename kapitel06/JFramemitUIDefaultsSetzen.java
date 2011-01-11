import java.awt.*;
import javax.swing.*;
public class JFramemitUIDefaultsSetzen extends JFrame {
   private JButton []button = new JButton[3];
   private JPanel panel = new JPanel();
// Konstruktordefinition 
   public JFramemitUIDefaultsSetzen() {
      super("UIDefaults Setzen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      UIManager.getDefaults().put("Button.background",
        Color.pink);
      UIManager.getDefaults().put("Button.foreground", 
        Color.white);
      UIManager.getDefaults().put("Button.focus", Color.red);
      for(int i=0; i<3; i++) {
         button[i] = new JButton("Button"+i);
         panel.add(button[i]);
      }
      getContentPane().add (panel);
      pack();
      setVisible(true);
   }
// Objekt der Klasse erzeugen
   public static void main (String[] args) {
      JFramemitUIDefaultsSetzen frame = 
        new JFramemitUIDefaultsSetzen(); 
   }
}
