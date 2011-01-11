import java.awt.*;
import javax.swing.*;
public class DialogmitFrameOwner extends Dialog {
   private ImageIcon icon = new ImageIcon("T1.gif");
   public Image bild = icon.getImage();
   public String title = "";
// Konstruktordefinition
   public DialogmitFrameOwner(int x, int y, Frame f) {
      super(f);
      setBounds(x,y,150,150);
      setBackground(Color.cyan);
      setVisible(true);
   }
// Das Bild wird auf der Komponente vom Typ Dialog an den 
// Pixelkoordinaten (55,50) und der Text an (20,100) ausgegeben
   public void paint(Graphics g) {
      g.drawImage(bild,55,50,this);
      g.drawString(title,20,100);
   }
}
