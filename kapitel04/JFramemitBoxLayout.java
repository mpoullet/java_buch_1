import java.awt.*;
import javax.swing.*;
public class JFramemitBoxLayout extends JPanel 
                                        implements LabelFarben {
//Konstruktordefinition
   public JFramemitBoxLayout () {
      setBorder(BorderFactory.createTitledBorder(
        "Container mit BoxLayout"));
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
// Drei Labels dem Panel hinzufügen
      for(int i=0; i<3; i++) { 
         SwingLabel label = new SwingLabel(textLabel[i],
           farbeLabel[i]);
         add(label);
      }
// Ein Box-Objekt erzeugen 
      Box b = new Box(BoxLayout.Y_AXIS);
      for(int i=3; i<=5; i++) {
// Drei Labels zur Box-Instanz hinzufügen
         SwingLabel label = new SwingLabel(textLabel[i],
           farbeLabel[i]);
         b.add(label);
      }
// Die Box-Instanz zum Panel hinzufügen
      add(b);
   }
// Objekt der Klasse erzeugen und einem Fenster hinzufügen
   public static void main(String[] args) {
      JFrame frame = new JFrame("BoxLayout");
      JFramemitBoxLayout panel = new JFramemitBoxLayout();
      panel.setPreferredSize(new Dimension(150,80));
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
