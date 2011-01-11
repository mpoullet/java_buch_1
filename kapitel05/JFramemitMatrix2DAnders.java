import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class JFramemitMatrix2DAnders extends JFrame {
   private Shape[] shapes = new Shape[101];
   private float[] x = new float[11];
   private float[] y = new float[11];
   private int k;
// Konstruktordefinition   
   public JFramemitMatrix2DAnders() {
      super("2D-Graphiken");
      setBounds(15,20,150,175);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Instanzfelder initialisieren
      x[0] = 20;
      y[0] = 55;
      for(int j=0; j<10; j++) {
         for(int i=0; i<10; i++) {
            k = j*10+i;
            shapes[k] = new Rectangle2D.Float(x[i],y[j],10,10);
            x[i+1] = x[i]+10;
         }
         y[j+1] = y[j]+10;
      }
      setVisible(true);
   }
   public void paint(Graphics g) {
      super.paint(g);
      Font f = new Font("TimesRoman", Font.BOLD, 16);
      g.setFont(f);
      g.drawString("2D-Matrix",30,45);
      Graphics2D g1 = (Graphics2D)g;
// Den Rand der Rechtecke mit einer 2-Pixel Breite zeichnen
      g1.setStroke(new BasicStroke(2.0f)); 
      for(int i=0; i<=k; i++) {
         int j = i%2; 
         if(j == 0) {  
// Die Rechtecke zeichnen
            g1.setColor(Color.pink);
            g1.fill(shapes[i]);
            g1.setColor(Color.black);
            g1.draw(shapes[i]);
         }
         else {
            g1.setColor(Color.red);
            g1.fill(shapes[i]);
            g1.setColor(Color.black);
            g1.draw(shapes[i]);
         }
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitMatrix2DAnders frame = new 
        JFramemitMatrix2DAnders();
   }
}
