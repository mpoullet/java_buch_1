import java.awt.*;
public class KreisComponent extends Canvas { //Component {
// Konstruktordefinition 
   public KreisComponent() {
      setBackground(Color.green);
   }
   public Dimension getPreferredSize() {
      return new Dimension(100,100);
   }
// Die Methode paint() wird aufgerufen, wenn eine 
// Komponente zum erstemmal gemalt wird oder wenn sich
// ihre Sichtbarkeit oder Größe ändert
   public void paint(Graphics g) {
// Dynamisch ermittelte Größenwerte für die Komponente
      Dimension size = getSize();
      int d = Math.min(size.width, size.height); 
// Konzentrische Kreise zeichnen
      int x = 0;
      int y = 0;
      int i = 0;
      while(x<size.width && y<size.height) {
         g.setColor(i%2==0 ? Color.white : Color.black);
         g.fillOval(x, y, size.width-(2*x), size.height-(2*y));
         x+=2;
         y+=2;
         i++;
      }
   } 
}
