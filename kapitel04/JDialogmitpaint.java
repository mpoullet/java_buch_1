import java.awt.*;
import javax.swing.*;
public class JDialogmitpaint extends JDialog {
   private ImageIcon icon = new ImageIcon("javalogo.gif");
   private Image   bild = icon.getImage();
// Konstruktordefinition
   public JDialogmitpaint() {
      setBounds(10,10,100,150);
   }
// Die paint()-Methode der Klasse JDialog überschreiben 
   public void paint(Graphics g) {
// Die Methode der Oberklasse aufrufen
      super.paint(g);
// Das Bild wird auf dem Bildschirm an den Pixelkoordinaten 
// (10,50) ausgegeben    
      g.drawImage(bild,10,50,this);
   }
// Objekt der Klasse erzeugen und sichtbar machen
   public static void main(String[] args) {
      JDialogmitpaint dialog = new JDialogmitpaint();
      dialog.setVisible(true);
   }
}
