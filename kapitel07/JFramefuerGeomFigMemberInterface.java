import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class JFramefuerGeomFigMemberInterface extends JFrame {
   GeomFigMemberInterface.FigMalen interfaceGFM;
// Konstruktordefinition
   public JFramefuerGeomFigMemberInterface() {
      super("Static-Member-Interface");
      setBounds(200,200,200,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Das Interface FigMalen mittels einer anonymen Klasse 
// implementieren
      interfaceGFM = new GeomFigMemberInterface.FigMalen() {
         public void drawFig(Graphics2D g, 
                             GeomFigMemberInterface komponente) {
            g.setColor(Color.pink);
            g.fill(komponente.shape);
            g.setColor(Color.black);
            g.setStroke(new BasicStroke(2.0f));
            g.draw(komponente.shape);
         } 
      }; 
      setVisible(true);
   } 
// Figuren zeichnen
   public void paint(Graphics g) {
      super.paint(g);   
      for(int i=0; i<4; i++) 
         interfaceGFM.drawFig((Graphics2D)g, 
           new GeomFigMemberInterface(i)); 
   }  
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramefuerGeomFigMemberInterface frame = new 
        JFramefuerGeomFigMemberInterface();
   }
}   
