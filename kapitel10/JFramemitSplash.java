import javax.swing.*;
import java.awt.*;
public class JFramemitSplash extends JFrame {
// Konstruktordefinition
   public JFramemitSplash() {
      setPreferredSize(new Dimension(100,100)); 
// Eine Instanz der Klasse in die Mitte des Bildschirms 
// positionieren
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((d.width -getSize().width)/2,
        (d.height-getSize().height)/2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// JLabel-Komponente zu dem Fenster hinzufügen
      JLabel label = new JLabel("Java 6.0", JLabel.CENTER);
      add(label);
      setVisible(true);
      pack();
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitSplash frame = new JFramemitSplash();
   }
}
