import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitLayeredPane extends JFrame 
                                  implements ActionListener {
// Die LayeredPane des Fensters ermitteln
   private JLayeredPane layeredPane = getLayeredPane();
   private JButton [] b = new JButton[8];
// Konstruktordefinition
   public JFramemitLayeredPane() {
      super("LayeredPane, die Ebenen");
      setSize(175,175);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      for(int i=0; i<8; i++) {
         b[i] = new JButton("B"+(i+1));
         b[i].setBackground(new Color(i*30,i+200,i+50));
         b[i].setBounds(i*25, i*25, 50, 50);
// Den ActionListener für die Buttons registrieren
         b[i].addActionListener(this);
      }
// Die ContentPane und B7 transparent machen; ansonsten ist B5 
// nicht sichtbar, da dieser Button in der gleichen Ebene mit 
// der ContenPane liegt (-30000)
   // ((JPanel)getContentPane()).setOpaque(false);
   // b[6].setOpaque(false);
// Die Buttons in den unterschiedlichen Ebenen an 
// unterschiedliche Positionen platzieren
      layeredPane.add(b[1], new Integer(4), -1);
      layeredPane.add(b[2], new Integer(1));
      layeredPane.add(b[3], JLayeredPane.DRAG_LAYER);
      layeredPane.add(b[0], new Integer(4), 2);
      layeredPane.add(b[4], JLayeredPane.FRAME_CONTENT_LAYER);
      getContentPane().add(b[5], BorderLayout.NORTH); 
      getContentPane().add(b[6], BorderLayout.CENTER); 
      getContentPane().add(b[7], BorderLayout.SOUTH); 
// Den zugeordneten Z-Order-Index am Bildschirm anzeigen
      System.out.print("Der Z-Order-Index fuer Komponenten: ");
      for(int i=0; i<8; i++)
         System.out.print(layeredPane.getComponentZOrder(
           b[i]) + " ");
      System.out.println(layeredPane.getComponentZOrder(
        getContentPane())); 
   }
// Setzen einer neuen Tiefe für bestimmte Buttons
   public void actionPerformed(ActionEvent e) {
   if(e.getActionCommand().equals("B1")){
         layeredPane.setLayer(b[2], new Integer(100), 0);
         layeredPane.setLayer(b[0], new Integer(5), 0);
         layeredPane.setLayer(b[3], new Integer(400), 0);
      }
      else{
         layeredPane.setLayer(b[1], new Integer(10), 0);
         layeredPane.setLayer(b[4], new Integer(500), 0);
      }
// Den zugeordneten Z-Order-Index erneut anzeigen
      System.out.print("Der Z-Order-Index fuer Komponenten: ");
      for(int i=0; i<8; i++)
         System.out.print(layeredPane.getComponentZOrder(
           b[i]) + " ");
      System.out.println(layeredPane.getComponentZOrder(
        getContentPane())); 
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitLayeredPane frame = new JFramemitLayeredPane();
      frame.setVisible(true);
   }
}
