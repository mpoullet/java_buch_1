import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserGlassPane extends JComponent {
 private ImageIcon icon = new ImageIcon("Vron.jpg");
   private Image   bild = icon.getImage();
   protected void paintComponent(Graphics g) {
// Ein Bild wird auf dem Bildschirm an den Pixelkoordinaten 
// (10,50) ausgegeben    
      g.drawImage(bild,30,15,this);
// Die Farbe für die Schrift setzen
      g.setColor(Color.red);
      g.drawString("VRONI",35,35); 
   }
}
