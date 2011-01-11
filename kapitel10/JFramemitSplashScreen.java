import javax.swing.*;
import java.awt.*;
public class JFramemitSplashScreen extends JFrame {
   private ImageIcon icon = new ImageIcon("Vron.jpg");
   private Image bild = icon.getImage();
   static boolean anzeige = true;
// Konstruktordefinition
   public JFramemitSplashScreen() {
      SplashScreen splash = SplashScreen.getSplashScreen();
      Graphics g = splash.createGraphics();
      for(int i=0; i<=1000; i++) {
         g.setColor(Color.red);
         g.drawString("VRONI",10,35);
         splash.update();
      }
// Eine Instanz der Klasse in die Mitte des Bildschirms 
// positionieren
      setPreferredSize(new Dimension(100,125));   
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((d.width -getSize().width)/2,
        (d.height-getSize().height)/2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      pack();
   }
// Die paint()-Methode überschreiben 
   public void paint(Graphics g) {
// Das Bild wird auf dem Bildschirm an den Pixelkoordinaten 
// (50,75) ausgegeben
      g.drawImage(bild,0,25,this);
// Die Farbe für das Zeichnen setzen
      g.setColor(Color.red);
// Den Text über dem Bild anzeigen
      g.drawString("VRONI",10,50); 
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitSplashScreen frame = new JFramemitSplashScreen();
   }
}
