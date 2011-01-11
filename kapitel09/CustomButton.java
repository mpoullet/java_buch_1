import java.awt.*;
import javax.swing.*;
public class CustomButton extends JButton {
   private String string;
   public CustomButton(String string) {
      super(string);
      this.string = string;
      setPreferredSize(new Dimension(100,100));
         setContentAreaFilled(false);
   }
   protected void paintComponent(Graphics g) {
// Die Methode isArmed() wird von der Klasse ButtonModel 
// definiert; darum wird ein Objekt der Klasse erzeugt, an 
// welchem die Methode aufgerufen werden kann
      if(getModel().isArmed()) 
         g.setColor(Color.green);
      else 
         g.setColor(getBackground());
      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
      super.paintComponent(g);
   }
   protected void paintBorder(Graphics g) {
      g.setColor(getForeground());
      g.drawOval(0, 0, getSize().width-1, getSize().height-1);
   }
}
