import java.awt.*;
import javax.swing.*;
public class GrundMaskefuerAWT implements LabelFarben {
// Globale Referenzen und Konstantendefinitionen 
   private FrameMaske frame;
   private LayoutManager layout;
// Konstruktordefinition
   GrundMaskefuerAWT(FrameMaske f, LayoutManager layout) {
      frame = f; this.layout = layout;
   }
// Methode zum Starten des Prototypen
   public void anzeige() {
      frame.setLayout(layout);
// Die Klasse AWTLabel erweitert die Klasse Label
      AWTLabel[] label = new AWTLabel[6]; 
      for(int i=0; i<textLabel.length; i++) { 
         label[i] = new AWTLabel(textLabel[i], farbeLabel[i]);
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
