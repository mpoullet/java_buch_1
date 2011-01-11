import java.awt.*;
import javax.swing.*;
public class JWindowmitpaint extends JWindow {
// Die Schrift für die Textanzeige definieren
   private Font f = new Font("TimesRoman", Font.BOLD, 26);
// Konstruktordefinition	
   public JWindowmitpaint() {
      setBounds(300,300,150,100);
   }
   public void paint(Graphics g) {
// Ein Rechteck als Hintergrund für das Fenster malen 
      g.setColor(Color.cyan);
      g.fillRect(0,0,150,100);   
      g.setColor(Color.red); 
      g.setFont(f);
// Die metrischen Daten des Font-Objektes mit Hilfe eines 
// Objektes der Klasse FontMetrics ermitteln
      FontMetrics fm = g.getFontMetrics();
      int ascent = fm.getAscent();
      int descent = fm.getDescent();   
      g.drawString("Java 6.0",10,50);
// Oberhalb und unterhalb des Textes werden zwei Linien 
// gezeichnet
      g.drawLine(0,50-ascent,150,50-ascent);
      g.drawLine(0,50+descent,150,50+descent); 
   }
// Objekt der Klasse erzeugen und sichtbar machen
   public static void main(String[] args) {
      JWindowmitpaint window = new JWindowmitpaint();
      window.setVisible(true);
   }
}
