import java.awt.*;
import javax.swing.*;
public class JButtonmitCustomButtonUI extends JButton {
// Konstruktordefinition
   public JButtonmitCustomButtonUI() {
      setPreferredSize(new Dimension(100,100));
// Weil die Komponente standardmässig opaque ist, wird ihr 
// Hintergrund gemalt
      setBackground(Color.lightGray);
      setUI(new CustomButtonUI());
   }
   protected void paintComponent(Graphics g) {
// Die paint()-Methode der UI-Delegationsklasse über die Methode
// der Oberklasse aufrufen
      super.paintComponent(g);
// Danach die eigenen Inhalte malen
      Graphics2D g1 = (Graphics2D)g;
      Rectangle r1 = new Rectangle(getWidth()/4, 0,
        getWidth()/4, getHeight());
      g1.setColor(Color.magenta);
      g1.fill(r1);
      Rectangle r2 = new Rectangle(getWidth()/2, 0,
        getWidth()/4, getHeight()); 
      g1.setColor(Color.gray);
      g1.fill(r2);
// Erfolgt der Aufruf der Methode der Oberklasse an dieser 
// Stelle, wird das von der Komponente gemalte Muster von ihrem 
// Hintergrund überdeckt
   //   super.paintComponent(g);
   }
// Objekt der Klasse erzeugen und in einem Fenster sichtbar machen
   public static void main(String[] args) {
      JButton button = new JButtonmitCustomButtonUI();
      JFrame frame = new JFrame();
      frame.getContentPane().add(button);
      frame.getContentPane().setLayout(new FlowLayout()); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(150,150);
      frame.setVisible(true);
   }
}
