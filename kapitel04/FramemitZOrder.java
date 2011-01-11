import java.awt.*;
import javax.swing.*;
public class FramemitZOrder {
   private final static Color color[] = {Color.black, 
     Color.white}; 
   public static void main(String[] args) {
      Frame f = new Frame("Kreise malen");
      f.setBounds(0,0,100,100);
      Dimension size = f.getSize();
// Durchmesser des Fensters
      int d = Math.min(size.width, size.height); 
// Position für die Komponenten
int x = (size.width - d)/2+12;
      int y = (size.height - d)/2+38;
// AWTContainer-Objekt erzeugen
      AWTContainer c = new AWTContainer(color);
      f.setLayout(null);
// Objekte der Klasse AWTPaintKreis (vom Typ Component) erzeugen 
      AWTPaintKreis k1 = new AWTPaintKreis(x-6, y-6, d+15, d+15, 
        Color.white);
      AWTPaintKreis k2 = new AWTPaintKreis(x-4, y-4, d+10, d+10, 
        Color.pink);
      AWTPaintKreis k3 = new AWTPaintKreis(x, y, d, d,
        Color.red);
      AWTPaintKreis k4 = new AWTPaintKreis(x+5, y+5, d-10, d-10, 
        Color.gray);
// und dem Container hinzufügen  
      c.add(k1);
      c.add(k2);
      c.add(k3);
      c.add(k4);
// Die AWTPaintKreis-Objekte, im Container, in die über den
// Z-Order-Index spezifizierte Ebene bewegen
      c.setComponentZOrder(k1,3);
      c.setComponentZOrder(k2,2);
      c.setComponentZOrder(k3,1);
      c.setComponentZOrder(k4,0);
// Den Container dem Fenster hinzufügen
      f.add(c);
      f.setSize(new Dimension(100,150));
      f.setVisible(true);
   }
}
