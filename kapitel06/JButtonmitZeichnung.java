import java.awt.*;
import javax.swing.*;
public class JButtonmitZeichnung extends JButton {
// Konstruktordefinition  
   public JButtonmitZeichnung() {
      super("Button mit Zeichnung");
// Die Farbe für den Hintergrund der Komponente setzen
      setBackground(Color.green);
// Die bevorzugte Größe setzen
      setPreferredSize(new Dimension(175,150));
   }
   protected void paintComponent(Graphics g) {
// Die Oberklasse soll ihre Inhalte zeichnen 
      super.paintComponent(g);
// Die Farbe für das Zeichnen setzen
      g.setColor(Color.red); 
// Zwei Kreise auf die Komponente zeichnen
      g.fillOval(40,10,40,40);
      g.fillOval(40,100,40,40);
// Wird die Methode der Oberklasse an dieser Stelle aufgerufen,
// erscheint die Beschriftung der JButton-Komponenten, aber 
// nicht die selbst gezeichnete Graphik, weil diese mit der 
// Hintergrundfarbe überschrieben wird 
   // super.paintComponent(g); 
   }
   public static void main(String[] args) {
// Fenster erzeugen und zu diesem eine Instanz der Klasse 
// hinzufügen
      JFrame frame = new JFrame("Der Standard-UI-Delegate");   
      JButtonmitZeichnung button = new JButtonmitZeichnung();
      frame.add(button);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      frame.setVisible(true);
   }
}
