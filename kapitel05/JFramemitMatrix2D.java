import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class JFramemitMatrix2D extends JFrame {
   Shape[][] shapes = new Shape[10][10];   
   float[] x = new float[11];
   float[] y = new float[11];
// Konstruktordefinition
   public JFramemitMatrix2D() {
      super("2D-Graphiken");
      setBounds(15,20,150,175);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Instanzfelder initialisieren
      x[0] = 20;
      y[0] = 55;
      for(int j=0; j<10; j++) {
         for(int i=0; i<10; i++) {
            shapes[i][j] =new Rectangle2D.Float(x[i],y[j],10,10);
            x[i+1] = x[i]+10;
         }
         y[j+1] = y[j]+10;
      }
      setVisible(true);
   }
   public void paint(Graphics g1) {
      super.paint(g1);
      Font f = new Font("TimesRoman", Font.BOLD, 16);
      g1.setFont(f);
      g1.drawString("2D-Matrix",30,45);
      Graphics2D g = (Graphics2D)g1;
      for(int j=0; j<10; j++) {
         for(int i=0; i<10; i++) {
            g.setColor(Color.pink);
            g.fill(shapes[i][j]);
            g.setColor(Color.black);
            g.draw(shapes[i][j]);
         }
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitMatrix2D frame = new JFramemitMatrix2D();
   }
}
