import java.awt.*;
public class FramemitContainerundPaintKreis {
   private final static Color color[] = {Color.black, 
     Color.white, Color.black, Color.white};
   public static void main(String[] args) {
      Frame f = new Frame("Kreise malen");
      f.setBounds(0,0,100,100);
      Dimension size = f.getSize();
// Durchmesser des Fensters
      int d = Math.min(size.width, size.height); 
// Durchmesser der kleinen Kreise
      int d1 = d/5; 
// Positionierung von Komponenten
      int x = (size.width - d)/2 + 12;
      int y = (size.height - d)/2 + 38;
      AWTContainer c = new AWTContainer(color);
      f.setLayout(null);
// Die kleinen Kreise dem Container hinzufügen 
      c.add(new AWTPaintKreis(x+d/3-(d1/2), y+d/3-(d1/2), 
        d1, d1, Color.white));
      c.add(new AWTPaintKreis(x+(2*(d/3))-(d1/2), y+d/3-(d1/2), 
        d1, d1, Color.white));
      c.add(new AWTPaintKreis(x+d/3-(d1/2), y+2*(d/3)-(d1/2), 
        d1, d1, Color.white));
      c.add(new AWTPaintKreis(x+(2*(d/3))-(d1/2), y+2*(d/3)
        -(d1/2), d1, d1, Color.white));
// Den grossen Kreis dem Container hinzufügen
      c.add(new AWTPaintKreis(x, y, d, d, Color.gray));
// Den Container dem Fenster hinzufügen
      f.add(c);
// Die Fenstergröße der Größe von Komponenten anpassen
      f.setSize(new Dimension(100,150));
      f.setVisible(true);
   }
}
