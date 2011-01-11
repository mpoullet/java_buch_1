import java.awt.*;
import javax.swing.*;
public class JFramemitgetLayeredPane extends JFrame {
   private Point orig = new Point(20,20);
   private int offset = 25;
   private JButton []b = new JButton[3];
   private JMenuBar mb = new JMenuBar();
   private JMenu []m = new JMenu[3];
// Konstruktordefinition
   public JFramemitgetLayeredPane() {
      super("Die LayeredPane einer JFrame-Komponente" );
      setSize(200,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLayeredPane layeredPane = this.getLayeredPane(); 
      for(int i=0; i<3; i++) {
         Color farbe = new Color(i*50,255,i*75);
         b[i] = new JButton(""+(i+1));
         m[i] = new JMenu("Menue"+(i+1));
         b[i].setBackground(farbe);
// Die Menüs undurchsichtig machen und eine Hintergrundfarbe 
// für diese setzen              
         m[i].setOpaque(true);
         m[i].setBackground(farbe);
         b[i].setBounds(orig.x,orig.y,50,50);
         mb.add(m[i]);
// Die Buttons werden geschachtelt in drei verschiedene Ebenen 
// abgelegt
         layeredPane.add(b[i], new Integer(i)); 
         orig.x = orig.x+offset;
         orig.y = orig.y+offset;
      }
      setJMenuBar(mb);
// Den zugeordneten Z-Order-Index, der die Reihenfolge bestimmt, 
// in welcher die Komponenten gemalt werden, 
// am Bildschirm anzeigen
      System.out.print("Der Z-Order-Index fuer Komponenten: ");
      for(int i=0; i<3; i++)
         System.out.print(layeredPane.getComponentZOrder(
           b[i])+" ");
      System.out.print(layeredPane.getComponentZOrder(
        getContentPane())+" "); 
      System.out.println(layeredPane.getComponentZOrder(
        getJMenuBar())); 
      setVisible(true);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitgetLayeredPane frame = 
        new JFramemitgetLayeredPane();
   }
}
