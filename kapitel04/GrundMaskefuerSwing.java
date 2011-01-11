import java.awt.*;
import javax.swing.*;
public class GrundMaskefuerSwing implements LabelFarben {
// Das Interface LabelFarben enthält die Konstantendefinitionen
// textLabel und farbeLabel.
// Globale Referenzen 
   private JFrameMaske frame;
   private LayoutManager layout;
// Konstruktordefinition 
   GrundMaskefuerSwing(JFrameMaske f, LayoutManager layout) {
      frame = f; 
      this.layout = layout;
   }
// Methode zum Starten des Prototypen
   public void anzeige() {
      frame.setLayout(layout);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Die Klasse SwingLabel erweitert die Klasse JLabel
      SwingLabel[] label = new SwingLabel[6]; 
      for(int i=0; i<textLabel.length; i++) { 
         label[i] = new SwingLabel(textLabel[i], farbeLabel[i]);
      }
      if(layout.getClass().getName().
        equals("java.awt.BorderLayout")) {
         frame.add(label[0],BorderLayout.NORTH);
         frame.add(label[1],BorderLayout.WEST);
         frame.add(label[2],BorderLayout.CENTER);
         frame.add(label[3],BorderLayout.CENTER);
         frame.add(label[4],BorderLayout.EAST);
         frame.add(label[5],BorderLayout.SOUTH);
      }
      else {
         for(int i=0; i<textLabel.length; i++) {
            frame.add(label[i]);
         }
      }
      frame.setVisible(true);
   }
}