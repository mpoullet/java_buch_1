import java.awt.*;
import javax.swing.*;
public class JFramemitPaintKreis {
   public static void main(String[] args) {
JFrame f = new JFrame("Kreise malen");
      f.setBounds(0,0,100,100);
      Dimension size = f.getSize();
// Durchmesser des Fensters
      int d = Math.min(size.width, size.height); 
// Durchmesser für die Komponenten
      int d1 = d/5; 
// Positionierung der Komponenten
      int x = (size.width - d)/2+8;
      int y = (size.height - d)/2;
      f.setLayout(null);
// Die PaintKreis-Objekte zum Fenster hinzufügen 
      f.add(new PaintKreis(x+d/3-(d1/2), y+d/3-(d1/2), 
        d1, d1, Color.white));
      f.add(new PaintKreis(x+(2*(d/3))-(d1/2), y+d/3-(d1/2), 
        d1, d1, Color.white));
      f.add(new PaintKreis(x+d/3-(d1/2), y+2*(d/3)-(d1/2), 
        d1, d1, Color.white));
      f.add(new PaintKreis(x+(2*(d/3))-(d1/2), y+2*(d/3)-(d1/2), 
        d1, d1, Color.white));
      f.add(new PaintKreis(x, y, d, d, Color.gray));
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(new Dimension(100,135));
      f.setVisible(true);
   }
}
