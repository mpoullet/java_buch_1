import java.awt.*;
public class FramemitPaintKreis {
   public static void main(String[] args) {
      Frame f = new Frame("Kreise malen");
      f.setBounds(0,0,100,100);
      Dimension size = f.getSize();
// Durchmesser des Fensters
      int d = Math.min(size.width, size.height); 
// Durchmesser der kleinen Kreise
      int d1 = d/5; 
// Ausgangspunkt f�r die Positionierung der Komponenten im Fenster
      int x = (size.width - d)/2+12;
      int y = (size.height - d)/2+30;
// Layout-Manager ausschalten
      f.setLayout(null);
// Die kleinen Kreise zum Fenster hinzuf�gen
      f.add(new AWTPaintKreis(x+d/3-(d1/2), y+d/3-(d1/2), 
        d1, d1, Color.white));
      f.add(new AWTPaintKreis(x+(2*(d/3))-(d1/2), y+d/3-(d1/2), 
        d1, d1, Color.white));
      f.add(new AWTPaintKreis(x+d/3-(d1/2), y+2*(d/3)-(d1/2), 
        d1, d1, Color.white));
      f.add(new AWTPaintKreis(x+(2*(d/3))-(d1/2), y+2*(d/3)
        -(d1/2), d1, d1, Color.white));
// Den gro�en Kreis zum Fenster hinzuf�gen
      f.add(new AWTPaintKreis(x, y, d, d, Color.gray));
// Die Fenstergr��e der Gr��e der Komponenten anpassen
      f.setSize(new Dimension(100,135));
      f.setVisible(true);
   }
}
