import java.awt.*;
import javax.swing.*;
public class JButtonmitIcon extends JButton {
   private ImageIcon icon = new ImageIcon("Vron.JPG");
   private Image bild = icon.getImage();
// Konstruktordefinition
   public JButtonmitIcon(String s) {
      super(s);
// Das Focus-Rectangle in die untere linke Ecke zeichnen
      setHorizontalAlignment(JButton.SOUTH_EAST);
      setContentAreaFilled(false);
   }
// Die Methoden zum Setzen der Größe von Komponenten 
// überschreiben
   public Dimension getPreferredSize() {
      if(icon != null) {
         Insets insets = getInsets();
         return new Dimension(icon.getIconWidth() + insets.left
           + insets.right+225, icon.getIconHeight() + insets.top
           + insets.bottom+225);
      }
      else {
         return new Dimension(100,100);
      }
   }
   public Dimension getMinimumSize() {
      if(icon != null) {
// Der Button soll nur bis auf die Größe des Icons reduziert 
// werden können
         return new Dimension(icon.getIconWidth(),
           icon.getIconHeight());
      }
      else {
         return new Dimension(0,0);
      }
   }
   protected void paintComponent(Graphics g) {
// Das Icon zeichnen
      g.drawImage(bild,0,0,this);
      super.paintComponent(g);
   }
   public static void main(String[] args) {
// Ein Fenster erzeugen und die neue Fensterleiste entsprechend 
// dem aktuellen "look and feel" setzen
      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame = new JFrame("Der Standard-UI-Delegate");  
      frame.getContentPane().setLayout(new FlowLayout());
      frame.getContentPane().add(new JButtonmitIcon("Vroni"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      frame.pack();
      frame.setVisible(true);
   }
}
