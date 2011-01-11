import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class JFramemitRectangle2DMemberInterface extends JFrame {
   private Shape shapes;
// Konstruktordefinition
   JFramemitRectangle2DMemberInterface() {
      super("Static-Member-Interface");
      setBounds(10,10,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      shapes = new Rectangle2D.Float(40,40,50,50);
      setVisible(true); 
   } 
// Das Static-Member-Interface mittels einer 
// anonymen Klasse implementieren
   JFramemitRectangle2DMemberInterface.FigurenMalen 
     interfaceShape = new JFramemitRectangle2DMemberInterface.
       FigurenMalen() {
      public void drawShape(Graphics2D g, Shape figur) {
         g.setColor(Color.green);
         g.fill(figur);
         g.setColor(Color.black);
         g.setStroke(new BasicStroke(2.0f));
         g.draw(figur);
      } 
   }; // Ende der anonymen Klasse und der Zuweisung
// Rechteck malen
   public void paint(Graphics g){
      super.paint(g);   
      interfaceShape.drawShape((Graphics2D)g,shapes); 
   } 
// Das Static-Member-Interface definieren
   public static interface FigurenMalen {
      public void drawShape(Graphics2D g, Shape figur);
   }
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitRectangle2DMemberInterface frame = new 
        JFramemitRectangle2DMemberInterface();
   }
}   
