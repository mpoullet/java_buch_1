import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class JFramemitInternenFenster extends JFrame 
                                 implements MouseMotionListener {
// Globale Referenzen
   private JDesktopPane desktopPane;
   private JLabel iconLabel;   
   private static int z�hler = 0;
// Ein nicht �nderbares ImageIcon-Objekt erzeugen 
   private final ImageIcon icon = new ImageIcon("rabbit.gif");
// Konstanten f�r die Positionierung der internen Fenster und 
// des Labels definieren
   private final static int x = 100;
   private final static int y = 100;
// Konstruktordefinition
   public JFramemitInternenFenster() {
      super("Interne Fenster");
      setBounds(50,50,225,225);      
// F�r die Anzeige von internen Fenstern kann ein Objekt der 
// Klasse JDektopPane genutzt werden
      desktopPane = new JDesktopPane(); 
// Eine JLabel-Instanz mit einem Icon erzeugen
      iconLabel = new JLabel(icon);
      iconLabel.setBounds(35, 65, icon.getIconWidth(),
        icon.getIconHeight());
      for(int i = 0; i < 2; i++) {
// Interne Fenster erzeugen und diesen eine SwingLabel-Komponente
// hinzuf�gen
         JInternalFrame internalFrame = new JInternalFrame(
           "Internes Fenster" + (i+1), true, true, true, true);
         internalFrame.setSize(100,100);
         internalFrame.setLocation(x*i, y*i);
         JLabel label = new SwingLabel("Ebene"+(i*2),Color.green);
         internalFrame.getContentPane().add(label);
         internalFrame.setVisible(true);
// Interne Fenster zur JDesktopPane-Komponente hinzuf�gen 
         desktopPane.add(internalFrame, new Integer(i*2));
      }
// Das Label mit Icon in einer Ebene, die zwischen den internen 
// Fenstern liegt, zur DesktopPane hinzuf�gen
      desktopPane.add(iconLabel, new Integer(1), 0);
// Den MouseMotionListener f�r die DesktopPane registrieren
      desktopPane.addMouseMotionListener(this);
// Die DesktopPane zur ContentPane hinzuf�gen
      setContentPane(desktopPane);
   }
// Methoden des Interface MouseMotionListener implementieren
   public void mouseMoved(MouseEvent e) {
      iconLabel.setLocation(e.getX()-x, e.getY()-y);
   }
   public void mouseDragged(MouseEvent e) {
// gleiche Aktion wie bei nicht gedr�ckter Maustaste
      mouseMoved(e);
   } 
// Objekt der Klasse erzeugen  
   public static void main(String[] args) {
      JFramemitInternenFenster frame = 
        new JFramemitInternenFenster();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
