import java.awt.*;
import javax.swing.*;
public class KreisContainer extends JPanel { 
   private Color[] color;
// Konstruktordefinition
   public KreisContainer(Color[] color) {
      setBounds(0,0,300,300);
// Das Standard-Layout des Containers ausschalten
      setLayout(null); 
      this.color = color;
   }
   protected void paintComponent(Graphics g) {
// Mit gleicher Auswirkung kann auch die Methode paintChildren() 
// überschrieben werden 
// protected void paintChildren(Graphics g) { 
      int laenge = 5;
      for(int y=0; y+laenge<=getSize().height; y+=laenge) {
         for(int x=0; x+laenge<=getSize().width; x+=laenge) {
            g.setColor(color[x % color.length]);
            g.fillRect(x, y, laenge, laenge);
         }
// Die Reihenfolge der Farben wechseln
         Color[] c = new Color[color.length];
         for(int i=0; i<color.length; i++)
            c[i] = color[color.length-(1+i)];
         color = c; 
      }
// Der Aufruf der Methode der Oberklasse ist erforderlich
   // super.paintChildren(g); 
   } 
}
