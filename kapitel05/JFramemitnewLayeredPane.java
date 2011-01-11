import java.awt.*;
import javax.swing.*;
public class JFramemitnewLayeredPane extends JFrame {
   private Point orig = new Point(20,20);
   private int offset = 25;
   private JButton []b = new JButton[3];
   private JMenuBar mb = new JMenuBar();
   private JMenu []m = new JMenu[3];
// Konstruktordefinition
   public JFramemitnewLayeredPane() {
      super("JLayeredPane-Instanzen");
      setSize(175,175);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLayeredPane layeredPane = new JLayeredPane(); 
      layeredPane.setBorder(BorderFactory.createTitledBorder(
        "Eine JLayeredPane-Instanz zur ContentPane hinzufügen"));
      for(int i=0; i<3; i++) {
         Color farbe = new Color(i*60,255,i*75);
         b[i] = new JButton(""+(i+1));
         m[i] = new JMenu("Menue"+(i+1));
         b[i].setBackground(farbe);
         m[i].setOpaque(true);
         m[i].setBackground(farbe);
         b[i].setBounds(orig.x, orig.y, 50, 50);
         mb.add(m[i]);
         layeredPane.add(b[i], new Integer(i)); 
         orig.x = orig.x+offset;
         orig.y = orig.y+offset;
      }
// JLayeredPane-Objekt zur ContentPane hinzufügen
      getContentPane().add(layeredPane); 
// Ein JLayeredPane-Objekt kann auch als Standard-LayeredPane
// für das Fenster gesetzt werden
   // setLayeredPane(layeredPane); 
// Der nachfolgende Aufruf ist äquivalent mit 
// getRootPane().setJMenuBar(mb);
      setJMenuBar(mb);
// Den zugeordneten Z-Order-Index, der die Reihenfolge bestimmt, 
// in welcher die Komponenten gemalt werden, am Bildschirm 
// anzeigen
      System.out.print("Der Z-Order-Index fuer Komponenten: ");
      for(int i=0; i<3; i++)
         System.out.print(layeredPane.getComponentZOrder(
           b[i]) + " ");
      System.out.print(layeredPane.getComponentZOrder(
        getContentPane())+" "); 
      System.out.println(layeredPane.getComponentZOrder(
        getJMenuBar())); 
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitnewLayeredPane frame = 
        new JFramemitnewLayeredPane();
      frame.setVisible(true);
   }
}
