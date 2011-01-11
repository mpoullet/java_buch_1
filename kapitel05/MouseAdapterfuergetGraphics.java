import java.awt.*;
import java.awt.event.*;
public class MouseAdapterfuergetGraphics 
                                          extends MouseAdapter {
// Globale Referenz vom Typ der Klasse Graphics
   private Graphics g;
// Konstruktordefinition
   public MouseAdapterfuergetGraphics(Graphics g) {
      this.g = g;
   }
// Die benötigte Methode der Klasse MouseAdapter überschreiben
   public void mousePressed(MouseEvent e) {
// Die Koordinaten des Mausklicks lesen
      int x = e.getX();
      int y = e.getY();
// Der Text wird auf dem Bildschirm an den Pixelkoordinaten 
// (x,y) ausgegeben 
      g.drawString("Java6.0",x,y);
   } 
}
