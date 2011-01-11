import java.awt.*;
import javax.swing.*;
public class DefinitionvonFarben extends JFrame {
   private int x = 150;
   private int y = 160;
   private int r = 0;
// Konstruktordefinition   
   public DefinitionvonFarben(int radius) { 
      super("Eigene Farben definieren");
      r = radius;
      setBounds(30,30,300,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   public void paint(Graphics g) {
// Das normale Aussehen des JFrame setzen
      super.paint(g);
// Die Kreise in den verschiedenen Farben malen
      for(int i=0; i<255; i=i+100) {
         for(int j=0; j<255; j=j+100) {
            for(int k=0; k<255; k=k+100) {
               Color farbe = new Color(i,j,k);
               g.setColor(farbe);
               r = r + 5;
               g.drawOval(x-r,y-r,2*r,2*r);
            }
         }
      }
   } 
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      DefinitionvonFarben kreise = new DefinitionvonFarben(0);
   }
}   
