import javax.swing.*;
import java.awt.*;
public class JFramemitBenutzerButtonUI extends JFrame {
// Konstruktordefinition
   public JFramemitBenutzerButtonUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JButton b = new JButton("Button");
      getContentPane().setLayout(new FlowLayout());
      add(b);
   }
// Den UI-Delegate setzen, ein Objekt der Klasse erzeugen und in
// einem Fenster sichtbar machen
   public static void main(String[] args) {
      UIManager.put("ButtonUI","BenutzerButtonUI");
      JFrame frame = new JFramemitBenutzerButtonUI();
      frame.pack();
      frame.setVisible(true);
   }
}
