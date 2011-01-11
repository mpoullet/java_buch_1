import java.awt.*;
import javax.swing.*;
public class JFramemitContainerundPaintKreis {
   private final static Color color[] = {Color.black, 
     Color.white};
   public static void main(String[] args) {
      JFrame f = new JFrame("Kreise malen");
      f.setBounds(0,0,100,100);
      Dimension size = f.getSize();
// Durchmesser des Fensters
      int d = Math.min(size.width, size.height); 
// Durchmesser der Komponenten
      int d1 = d/6; 
      int d2 = d/4; 
      int x = (size.width - d)/2;
      int y = (size.height - d)/2;
// KreisContainer-Objekt erzeugen
      KreisContainer c = new KreisContainer(color);
      f.setLayout(null);
// Objekte der Klasse PaintKreis erzeugen 
      PaintKreis k1 = new PaintKreis(x+d/3-(d1/2), y+d/3-(d1/2),
        d1, d1, Color.white);
      PaintKreis k2 = new PaintKreis(x+(2*(d/3))-(d1/2), 
        y+d/3-(d1/2), d1, d1, Color.white);
      PaintKreis k3 = new PaintKreis(x+d/3-(d1/2), y+2*(d/3)
        -(d1/2), d1, d1, Color.white);
      PaintKreis k4 = new PaintKreis(x+(2*(d/3))-(d1/2), 
        y+2*(d/3)-(d1/2), d1, d1, Color.white);
      PaintKreis k5 = new PaintKreis(x+(d-2)/3-(d2/2), 
        y+(d-2)/3-(d2/2), d2, d2, Color.pink);
      PaintKreis k6 = new PaintKreis(x+(2*((d-2)/3))-(d2/2), 
        y+(d-2)/3-(d2/2), d2, d2, Color.pink);
      PaintKreis k7 = new PaintKreis(x+(d-2)/3-(d2/2), 
        y+2*((d-2)/3)-(d2/2), d2, d2, Color.pink);
      PaintKreis k8 = new PaintKreis(x+(2*((d-2)/3))-(d2/2), 
        y+2*((d-2)/3)-(d2/2), d2, d2, Color.pink);
      PaintKreis k9 = new PaintKreis(x-2, x-2, d+5, d+5, 
        Color.red);
      PaintKreis k10 = new PaintKreis(x, y, d, d, Color.gray);
// und zum Container hinzufügen  
      c.add(k1);
      c.add(k2);
      c.add(k3);
      c.add(k4);
      c.add(k5);
      c.add(k6);
      c.add(k7);
      c.add(k8);
      c.add(k9); 
      c.add(k10);
// Die PaintKreis-Objekte im Container in eine über den 
// Z-Order-Index spezifizierte Ebene bewegen
      c.setComponentZOrder(k1,1);
      c.setComponentZOrder(k2,3);
      c.setComponentZOrder(k3,8);
      c.setComponentZOrder(k4,4);
      c.setComponentZOrder(k5,2);
      c.setComponentZOrder(k6,0);
      c.setComponentZOrder(k7,9);
      c.setComponentZOrder(k8,7);
      c.setComponentZOrder(k9,6);
      c.setComponentZOrder(k10,5);
// Den Container zum Fenster hinzufügen
      f.add(c);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(new Dimension(100,135));
      f.setVisible(true);
   }
}
