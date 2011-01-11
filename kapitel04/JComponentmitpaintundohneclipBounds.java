import java.awt.*;
import javax.swing.*;
public class JComponentmitpaintundohneclipBounds 
                                            extends JComponent {
   private int zaehlerKreis1 = 0;
   private int zaehlerKreis2 = 0;
// Überschreiben der paintComponent()-Methode
   protected void paintComponent(Graphics g) {
      zaehlerKreis1++;
      zaehlerKreis2++;
      g.setColor(Color.lightGray);
      g.fillRect(0,0,150,150);
      g.setColor(Color.red);
      g.fillOval(0,0,50,50);
      g.setColor(Color.gray);
      g.fillOval(50,50,50,50);
// Ausgabe der Zählerwerte 
      System.out.println("Kreis1: " + zaehlerKreis1
         + " *Kreis2: " + zaehlerKreis2);
   }
// Die bevorzugte Größe der Komponente definieren
   public Dimension getPreferredSize() {
      return new Dimension(150,150);
   }
// Objekt der Klasse erzeugen und einem Fenster hinzufügen
   public static void main(String args[]) {
      JComponentmitpaintundohneclipBounds component =
         new JComponentmitpaintundohneclipBounds();
      JFrame frame = new JFrame();
      frame.setTitle("Clipping-Region");
      frame.add(component);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
