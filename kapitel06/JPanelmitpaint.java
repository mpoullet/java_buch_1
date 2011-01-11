import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
public class JPanelmitpaint extends JPanel {
   private static JButton b1 = new JButton();
   private static JLabel l1 = new JLabel("Button1");
   private static JButton b2 = new JButton(); 
   private static JLabel l2 = new JLabel("Button2");
// Konstruktordefinition
   public JPanelmitpaint() {
      setBackground(Color.green);
      b1.setBackground(Color.yellow);
      b1.add(l1);
      b2.setBackground(Color.cyan);
      b2.add(l2); 
      add(b1);
      add(b2);
   }
   protected void paintComponent(Graphics g) {
// Die Oberklasse soll zuerst ihre Inhalte malen, damit der 
// Hintergrund für eine Instanz der Klasse vor der Anzeige der 
// JButton-Komponenten gesetzt wird
      super.paintComponent(g);  
      g.setColor(Color.red); 
      g.fillOval(50,40,100,50);
   }
// Ein Fenster erstellen und zu diesem ein Objekt der Klasse 
// hinzufügen
   public static void main(String[] args) {
      JFrame frame = new JFrame("Der Standard-UI-Delegate"); 
      frame.setBounds(10,10,200,130);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanelmitpaint panel = new JPanelmitpaint();
// Das zugewiesene UI-Delegationsobjekt, welches die Komponenten 
// trägt, und die Anzahl ihrer Kindkomponenten ermitteln; deren 
// Namen anzeigen
      ComponentUI pnlUI = panel.getUI();
      System.out.println(pnlUI.toString() +
        "Anzahl der Kindkomponenten:" +
          pnlUI.getAccessibleChildrenCount(panel));
      ComponentUI btnUI = b1.getUI();
      System.out.println(btnUI.toString() +
        " Anzahl der Kindkomponenten:" + 
           btnUI.getAccessibleChildrenCount(b1));
      frame.add(panel);
      frame.setVisible(true);
   }
}
