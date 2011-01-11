import java.awt.*;
import javax.swing.*;
public class IconButton extends JButton {
   private ImageIcon icon1 = new ImageIcon("HEARTS.GIF");
   private Image   bild1 = icon1.getImage();
   private ImageIcon icon2 = new ImageIcon("CLUBS.GIF");
   private Image   bild2 = icon2.getImage();
// Konstruktordefinition
   public IconButton(String s) {
      super(s);
      setContentAreaFilled(false);
   }
// Ein Bild auf den Button zeichnen
   protected void paintComponent(Graphics g) {
      if(getModel().isArmed()) {
         g.drawImage(bild1, getSize().width-50,
           getSize().height/6, this);
      }
      else {
         g.drawImage(bild2, getSize().width-50,
           getSize().height/6, this);
      }
// Label und Focus-Rectangle für die Komponente zeichnen 
         super.paintComponent(g);
     }
// Runde Konturen um das Bild malen
   protected void paintBorder(Graphics g) {
      g.setColor(getForeground());
      g.drawOval(getSize().width-50,getSize().height/6,20,20);
   }
}
