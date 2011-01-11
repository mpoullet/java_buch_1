import java.awt.*;
import javax.swing.*;
public class JButtonmitUeberschrift extends JButton {
   private String label;
   private Font lucidaHand = new Font("Lucida HandWriting", 
     Font.PLAIN, 16);
// Konstruktordefinition
   public JButtonmitUeberschrift(String label) {
      this.label = label;
      setBackground(Color.pink);
      setContentAreaFilled(false);
      setFont(lucidaHand);
   }
   protected void paintComponent(Graphics g) {
// Die Methode getFocus() aufrufen, um unterschiedliche Farben 
// für das Zeichnen zu setzen 
      if(((AbstractButton)this).hasFocus()) {
         g.setColor(getBackground().darker());
      } 
      else {
          g.setColor(getBackground());
      }
      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
// Schriftmerkmale ermitteln 
      FontMetrics fm = getFontMetrics(getFont());
// Die Schriftfarbe auf die Vordergrundfarbe setzen,
// die ungleich der Hintergrundfarbe sein muss.
      g.setColor(getForeground());
      g.drawString(label,getSize().width/2 - fm.stringWidth(
        label)/2, getSize().height /2 + fm.getMaxDescent());
   }
// Die bevorzugte Größe für den Button in Abhängigkeit von der 
// Größe der verwendeten Schrift bestimmen
   public Dimension getPreferredSize() {
      Font f = getFont();
      if(f != null) {
         FontMetrics fm = getFontMetrics(getFont());
         int size = Math.max(fm.stringWidth(label) 
           + 50,fm.getHeight()+50);
         return new Dimension(size,size);
      }
      else {
         return new Dimension(100,100);
      }
   }
// Eine minimale Größe für den Button setzen
   public Dimension getMinimumSize() {
      return getPreferredSize();
   }
// Runde Konturen für die Komponente malen
   protected void paintBorder(Graphics g) {
      g.setColor(getBackground().darker().darker());
      g.drawOval(0, 0, getSize().width-1, getSize().height-1);
   }
   public static void main(String[] args) {
// Ein Fenster erzeugen und die neue Fensterleiste entsprechend 
// dem aktuellen "look and feel" setzen
      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame = new JFrame("Der Standard-UI-Delegate wird "
        + "nicht aufgerufen"); 
// Bleibt das Standard-BorderLayout für die JFrame-Komponente
// gesetzt, passt sich die Größe der Komponente der Fenstergröße
// bei Veränderungen an, nicht aber beim FlowLayout
      // frame.getContentPane().setLayout(new FlowLayout());
      frame.getContentPane().add(new JButtonmitUeberschrift(
        "Java 6.0"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      frame.pack();
      frame.setVisible(true);
   }
}
