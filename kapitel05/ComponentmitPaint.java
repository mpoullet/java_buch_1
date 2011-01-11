import java.awt.*;
import java.awt.event.*;
public class ComponentmitPaint extends Canvas 
                                      implements MouseListener {
   protected Point[] array = new Point[100];
   protected int letztElem;
   protected int anzahlElem;
// Konstruktordefinition
   public ComponentmitPaint(Point[] array) {
      this.array = array;
      setBackground(Color.lightGray);
      setSize(80,80);
      addMouseListener(this);
   }
// Die Methoden des MouseListener implementieren
   public void mousePressed(MouseEvent e) {
// Die Koordinaten des angeklickten Punktes werden gelesen und 
// in das erste freie Element des Arrays mit dem Namen array 
// abgelegt, danach wird repaint() aufgerufen
      if(anzahlElem < 99) {
         array[anzahlElem]= e.getPoint();
         anzahlElem++;
         repaint();
      }     
   } 
   public void mouseClicked(MouseEvent e) {};
   public void mouseReleased(MouseEvent e) {};
   public void mouseEntered(MouseEvent e) {};
   public void mouseExited(MouseEvent e) {}
// Der Text wird an die im "i"-ten Arrayelement gespeicherten 
// Punktkoordinaten geschrieben 
   public void paintString(Graphics g, int i) {
      g.setColor(Color.black);
      g.drawString("Java " + i, array[i].x, array[i].y);
      letztElem++;
   }
// Für alle im Array-Objekt gespeicherten Werte wird die 
// Methode paintString() aufgerufen
   public void paint(Graphics g) {
      letztElem = 0;
      for(int i=0; i<anzahlElem; i++) {
          paintString(g, i);
      }
   }
}
