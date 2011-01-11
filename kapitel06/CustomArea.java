import java.awt.*;
import javax.swing.*;
public class CustomArea extends JTextArea {
   private static Font f = new Font("Arial", Font.PLAIN, 24);
// Konstruktordefinition
   public CustomArea() {
// Das UI-Delegationsobjekt daran hindern, den Hintergrund 
// der TextArea zu malen
      setOpaque(false);
   }
   protected void paintChildren(Graphics g) {
// Eine Überschrift über die TextArea an Position (40,40) zeichnen 
      g.setColor(Color.red);
      g.setFont(f);
      g.drawString("TextArea",60,40);
   }
}
