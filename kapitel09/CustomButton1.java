import java.awt.*;
import javax.swing.*;
public class CustomButton1 extends JButton {
   private String string;
   public CustomButton1(String string) {
      super(string);
      this.string = string;
      setPreferredSize(new Dimension(100,100));
   }
   protected void paintComponent(Graphics g) {
      if(getModel().isArmed()) 
         g.setColor(Color.green);
      else 
         g.setColor(getBackground());
      g.fillRect(0, 0, getSize().width-1, getSize().height-1);
      super.paintComponent(g);
   }
}
