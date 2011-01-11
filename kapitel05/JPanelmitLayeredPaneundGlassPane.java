import java.awt.*;
import javax.swing.*;
public class JPanelmitLayeredPaneundGlassPane extends JPanel {
   private JLayeredPane layeredPane;
   private JButton[] b = new JButton [3];
   private JMenuBar mb = new JMenuBar();
   private static JMenuBar mb1 = new JMenuBar();
   private JMenu [] m = new JMenu[3];
   private static JMenu m1 = new JMenu("Goethe Strasse");
// Konstruktordefinition
   public JPanelmitLayeredPaneundGlassPane (
                                     JLayeredPane layeredPane) {
      super(new GridLayout(1,1));
// Die Instanzfelder der Klasse initialisieren
      this.layeredPane = layeredPane;
      mb1.setBounds(0,0,200, 10);
      mb.setBounds(0,20,200,20);
// JMenu- und JButton-Objekte erzeugen       
      for(int i=0; i<3; i++) {
         b[i] = new JButton("H" + (i+1));
         m[i] = new JMenu("Haus" + (i+1));
         mb.add(m[i]);
      }
// Die MenuBar mb zur LayeredPane mit der Schachtelungstiefe 
// -30000 hinzufügen
      layeredPane.add(mb, JLayeredPane.FRAME_CONTENT_LAYER);
// Die Buttons der LayeredPane in geschachtelte Ebenen hinzufügen
// Anstatt der eigenen Klasse Punkt wird hier die Standard- 
// Klasse-Point von Java eingesetzt
      Point orig = new Point(10,100);
      int offset = 35;
      for(int i=0; i<3; i++) {
         b[i].setBounds(orig.x+i*offset, orig.y, 50, 50);
         layeredPane.add(b[i], new Integer(i)); 
      }
   } 
// Ein Fenster erzeugen und als ContentPane ein Objekt der 
// eigenen Klasse setzen
   public static void main(String[] args) {
      JFrame frame = new JFrame(
        "Fenster mit LayeredPane und GlassPane");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(175,175));
      JPanelmitLayeredPaneundGlassPane contentPane =    
        new JPanelmitLayeredPaneundGlassPane(
          frame.getLayeredPane());
      frame.setContentPane(contentPane);
// Die MenuBar mb1 als die MenuBar der RootPane setzen
      mb1.add(m1);
      frame.setJMenuBar(mb1);
// Eine benutzerdefinierte GlassPane für das Fenster setzen 
// und diese sichtbar machen
      UserGlassPane glassPane = new UserGlassPane();
      frame.setGlassPane(glassPane);
      glassPane.setVisible(true);
// Fenster anzeigen
      frame.setVisible(true);
   }
}
