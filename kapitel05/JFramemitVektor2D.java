import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class JFramemitVektor2D extends JFrame {
   private Shape[] shapes = new Shape[10];
   private Rectangle2D.Float[] rectangle2D = new  
     Rectangle2D.Float[10];
   private float x = 10;
   private float y = 50;
   private Rectangle r1[] = new Rectangle[10];
   private Rectangle r2[] = new Rectangle[10];
// Konstruktordefinition
   public JFramemitVektor2D() {
      super("2D-Graphiken");
      setBounds(20,20,200,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(int i=0; i<10; i++) {
// Rectangle2D.Float-Instanzen einer Referenz vom Typ des 
// Interface Shape zuweisen 
         shapes[i] = new Rectangle2D.Float(x,y,10,10);
// Rectangle2D.Float-Instanzen einer Referenz vom gleichen Typ 
// zuweisen 
         rectangle2D[i] = new Rectangle2D.Float(x,y+20,10,10);
// Rectangle-Instanzen mit der Methode getBounds() erzeugen
         r1[i] = shapes[i].getBounds();
// Die Rectangle-Instanzen mit der Methode translate() 
// verschieben
         r1[i].translate((int)x, (int)y+10);
         r2[i] = rectangle2D[i].getBounds();
         r2[i].translate((int)x, (int)y+10);
         x = x+10;
      }
      setVisible(true);
   }
   public void paint(Graphics g1) {
      super.paint(g1);
      Font f = new Font("TimesRoman", Font.BOLD, 16);
      g1.setFont(f);
      g1.drawString("2D-Vektoren",30,45);
      Graphics2D g = (Graphics2D)g1;
// Die Rechtecke aneinender reihen
      for(int i=0; i<10; i++) {
         g.setColor(Color.yellow);
         g.fill(shapes[i]);
         g.setColor(Color.black);
// Den Rand der Rechtecke mit einer 2-Pixel Breite zeichnen
         g.setStroke(new BasicStroke(2.0f));
         g.draw(shapes[i]);
         g.setColor(Color.green);
         g.fill(rectangle2D[i]);
         g.setColor(Color.black);
         g.draw(rectangle2D[i]);
         g.setColor(Color.yellow);
         g.fill(r1[i]);
         g.setColor(Color.black);
         g.draw(r1[i]);
         g.setColor(Color.green);
         g.fill(r2[i]);
         g.setColor(Color.black);
         g.draw(r2[i]);
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitVektor2D frame = new JFramemitVektor2D();
   }
}
