import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.plaf.*;
public class MyButton extends JButton {
   private Shape button;
// Konstruktordefinition
   public MyButton(String sString) {
      super(sString);
// Den UI-Delegate zuweisen
      setUI(new MyButtonUI());
// Verhindert das Malen einer viereckigen Oberfläche
      setContentAreaFilled(false);
   }
   protected void paintComponent(Graphics g) {
// Die Klasse malt zuerst ihre eigenen Inhalte 
      g.setColor(Color.lightGray);
      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
// und ruft dann die Methode der Oberklasse auf, damit in ihren 
// UI-Delegate verzweigt wird, um die als String-Referenz 
// übergebene Beschriftung und das Focus-Rectangle zu zeichnen
      super.paintComponent(g);
   }
// Diese Definition der bevorzugten Größe für Komponenten 
// hat Priorität gegenüber der Definition aus der 
// UI-Delegationsklasse
   /* public Dimension getPreferredSize() {
      return new Dimension(75,75);
   } */
// Diese Methode, die den Bereich innerhalb der Komponente 
// festlegt, muss überschrieben werden, weil der Bereich
// in diesem Fall nicht rechteckig, sondern rund ist.
   public boolean contains (int x, int y) {
// Eine Arc2D.Float Instanz mit den neuen Dimensionen erzeugen
      if (button == null || !button.getBounds().
        equals(getBounds())) {
         button = new Arc2D.Float(0, 0,getWidth()- 1, 
           getHeight()- 1,0, 360, Arc2D.Float.OPEN);
      }
// und true, nur für die darin enthaltene Punkte, returnieren
          return button.contains(x, y);
     }
// Diese Methode muss überschrieben werden, um einen runden Rand 
// zu malen
    protected void paintBorder(Graphics g) {
       g.setColor(getForeground());
       g.drawOval(0, 0, getSize().width-1,getSize().height-1);
    }
}
