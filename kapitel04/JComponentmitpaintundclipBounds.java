import java.awt.*;
import javax.swing.*;
public class JComponentmitpaintundclipBounds extends JComponent {
   private int zaehlerKreis1 = 0;
   private int zaehlerKreis2 = 0;
// Überschreiben der paintComponent()-Methode
   protected void paintComponent(Graphics g) {
// Lesen der Grenzen der neu aufzubauenden Regionen
      Rectangle r = g.getClipBounds();
      int clipBoundsx = r.x;
      int clipBoundsy = r.y;
      int clipBoundsw = r.width;
      int clipBoundsh = r.height;
// Nur die betroffene Region wird neu gemalt
      g.setColor(Color.lightGray);
      g.fillRect(clipBoundsx, clipBoundsy, clipBoundsw,
        clipBoundsh);
// Den ersten Kreis neu malen, falls die mit clipBounds() 
// ermittelten Koordinaten sich in dessen Region befinden
      if(clipBoundsx<=50 && clipBoundsy<=50) {
         g.setColor(Color.red);
         g.fillOval(0,0,50,50); 
         zaehlerKreis1++;
      }
// Den zweiten Kreis neu malen, falls dieser betroffen ist 
      if(clipBoundsx+clipBoundsw>=50 && clipBoundsx<=100
       && clipBoundsy+clipBoundsh>=50 && clipBoundsy<=100) {
         g.setColor(Color.gray);
         g.fillOval(50,50,50,50);
         zaehlerKreis2++;
      }
// Ausgabe der Zähler
      System.out.println("Kreis1: " + zaehlerKreis1 +" *Kreis2: "
        + zaehlerKreis2);
   }
// Die bevorzugte Größe der Komponente definieren
   public Dimension getPreferredSize() {
      return new Dimension(150,150);
   }
// Objekt der Klasse erzeugen und einem Fenster hinzufügen
   public static void main(String args[]) {
      JComponentmitpaintundclipBounds component = 
        new JComponentmitpaintundclipBounds();
      JFrame frame = new JFrame();
      frame.setTitle("Clipping Region");
      frame.add(component);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      frame.setVisible(true);
   }
}
