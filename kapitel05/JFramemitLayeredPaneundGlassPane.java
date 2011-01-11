import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitLayeredPaneundGlassPane extends JFrame 
                                       implements MouseListener {
   private Component glass;
   private JButton[] b = new JButton [3];
   private ImageIcon icon = new ImageIcon("sample1.jpg");
   private JLabel hintergrund = new JLabel(icon);
// Konstruktordefinition
   public JFramemitLayeredPaneundGlassPane() {
      super("Fenster mit LayeredPane und GlassPane");
      setBounds(20,20,256,200);
// Buttons als Ersatz für Häuser zu einem Panel hinzufügen und 
// dieses transparent machen      
      for(int i=0; i<3; i++) {
         b[i] = new JButton("Haus" + (i+1));
         b[i].setBackground(new Color(i*40, 255, i));
      }
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel content = new JPanel();
      content.setOpaque(false); 
      for(int i=0; i<3; i++) {
         content.add(b[i]); 
      }
// Das Panel zur ContentPane hinzufügen und diese transparent 
// machen, damit der Hintergrund, der als Objekt der Klasse 
// JLabel in gleicher Ebene hinterlegt wird, zu sehen ist
      getContentPane().add(content, BorderLayout.SOUTH);
      ((JPanel)getContentPane()).setOpaque(false);
// Zur LayeredPane des Fensters das Label mit Icon 
// als Hintergrund hinzufügen
      getLayeredPane().add(hintergrund, new Integer(-30000)); 
      hintergrund.setBounds(0, 0, icon.getIconWidth(),
        icon.getIconHeight());
// Die GlassPane definieren 
      glass = new JLabel("Eine GlassPane, "
        + "aus der es regnen kann");
      setGlassPane(glass);
      glass.setVisible(true);
// den MouseListener für die GlassPane registrieren
      glass.addMouseListener(this);
   }
// Die Methoden des MouseListener implementieren und auf die 
// GlassPane zeichnen
   public void mousePressed(MouseEvent e) {
// Den Graphikkontext der GlassPane ermitteln
      Graphics g = glass.getGraphics();
// Die Koordinaten des Mausklicks mit den Methoden der Klasse 
// MouseEvent lesen
      int x = e.getX();
      int y = e.getY();
// Die Ovale werden auf dem Bildschirm an den Koordinaten (x,y) 
// gezeichnet 
      g.setColor(Color.blue);
      g.fillOval(x, y, (int)Math.round(Math.random()*10),
        (int)Math.round(Math.random()*30));
   } 
   public void mouseClicked(MouseEvent e) {};
   public void mouseReleased(MouseEvent e) {};
   public void mouseEntered(MouseEvent e) {};
   public void mouseExited(MouseEvent e) {};
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitLayeredPaneundGlassPane frame = 
        new JFramemitLayeredPaneundGlassPane();      
      frame.setVisible(true);
   }
}
