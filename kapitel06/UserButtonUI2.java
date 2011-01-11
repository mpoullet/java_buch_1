import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.ComponentUI;
public class UserButtonUI2 extends MetalButtonUI {
// Ein selbstreferenzierndes Klassenfeld zeigt auf eine 
// gemeinsame, nicht änderbare Instanz der Klasse, die von der
// createUI()-Methode returniert wird
   private final static UserButtonUI2 userButtonUI2 = 
     new UserButtonUI2();
   private Color farbe1, farbe2, farbe3, farbe4;
   private Color grundFarbe;
// Konstruktordefinition
   public UserButtonUI2() {
// Vier Farben für einen Farbverlauf definieren
// Die Farbe rot
      farbe1 = new Color(255,0,0,0);
// Die gleiche Farbe mit dem Transparenz-Wert = 124
      farbe2 = new Color(255,0,0,124);
// Zwei weitere Farben
      grundFarbe = Color.MAGENTA;
      farbe3 = new Color(grundFarbe.getRed(),
        grundFarbe.getGreen(), grundFarbe.getBlue(),0);
      farbe4 = new Color(grundFarbe.getRed(),
        grundFarbe.getGreen(), grundFarbe.getBlue(),124);
   }
// Klassenmethode für die Referenz auf die Instanz der Klasse
   public static ComponentUI createUI(JComponent c) {
      return userButtonUI2;
   }
// Einen Farbverlauf mit einem GradientPaint-Objekt erzeugen
   public void paint(Graphics g, JComponent c) {
      super.paint(g, c);
      Graphics2D g2D = (Graphics2D)g;
      GradientPaint gradient1 = new GradientPaint(0.0F, 
        (float)c.getHeight()/(float)2,farbe1,0.0F,0.0F,farbe2);
      Rectangle r1 = new Rectangle(0,0,c.getWidth(),
        c.getHeight()/2);
      g2D.setPaint(gradient1);
      g2D.fill(r1);
      GradientPaint gradient2= new GradientPaint(0.0F,(float)c.
        getHeight()/(float)2,farbe3,0.0F,c.getHeight(),farbe4);
      Rectangle r2 = new Rectangle(0,c.getHeight()/2, 
      c.getWidth(),c.getHeight());
      g2D.setPaint(gradient2);
      g2D.fill(r2);
   }
// Bevorzugte Größe des Buttons
   public Dimension getPreferredSize(JComponent c) {
      return new Dimension(300,150);
   }
}
