import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitpaintundgetGraphics extends JFrame  {
// Globale Referenzen vom Typ der Klassen Canvas und Font
   private Canvas c; 
   private Font f = new Font("TimesRoman", Font.BOLD, 16); 
// Konstruktordefinition
   public JFramemitpaintundgetGraphics() {
      super("Malen mit paint() und getGraphics()");
      setBounds(10,20,200,100);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      c = new Canvas();
      c.setSize(new Dimension(100,100));
      c.setBackground(Color.pink);
      getContentPane().add(c, BorderLayout.WEST);
// Mit der getGraphics()-Methode den Graphikkontext für den 
// Canvas ermitteln, Farbe und Schrift für das Zeichnen setzen
      Graphics g = c.getGraphics();   
      g.setColor(Color.blue);
      g.setFont(f); 
// Den MouseListener für den Canvas registrieren
      c.addMouseListener(
        new MouseAdapterfuergetGraphics(g));    
   }
// Auf das Fenster wird mit paint() gezeichnet
   public void paint(Graphics g) {
      g.setColor(Color.white);
      g.fillRect(100,0,150,100); 
// Die Farbe und Schrift für das Zeichnen setzen
      g.setColor(Color.red); 
      g.setFont(f);
      g.drawString("Java6.0",120,70);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitpaintundgetGraphics frame = 
        new JFramemitpaintundgetGraphics();
   }
} 
