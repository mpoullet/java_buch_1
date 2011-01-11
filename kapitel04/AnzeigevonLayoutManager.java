import java.awt.*;
import javax.swing.*;
public class AnzeigevonLayoutManager {
// Klassenmethode für die Anzeige des Klassennamens
// und des Standard-Layout-Managers eines Containers
   public static void anzeige(Container c) {
      System.out.println(c.getClass().getName() + "**"
        + c.getLayout());
   }
   public static void main(String[] args) {
// Aufruf der Klassenmethode anzeige() für verschiedene Container.
// Alle Swing-Komponenten sind Container.
      anzeige(new JLabel());
      anzeige(new JButton());
      anzeige(new Panel());
      anzeige(new Container());
      anzeige(new JPanel());
      anzeige(new JFrame());
      anzeige(new Frame());
      anzeige(new Dialog(new Frame()));
      anzeige(new Window(new Frame()));
      anzeige((new JFrame()).getContentPane());
      anzeige(new java.applet.Applet());
      anzeige(new JRadioButton());
      anzeige(new JTextField());
      anzeige(new JTextArea());
      anzeige(new JEditorPane());
      anzeige(new JViewport());
      anzeige(new JScrollPane());
      anzeige(new Box(BoxLayout.X_AXIS));
      anzeige(new JInternalFrame());
      anzeige(new JDesktopPane());
      anzeige(new JSplitPane());
      anzeige(new JTabbedPane());
      anzeige(new JSlider());
      anzeige(new JApplet());
      anzeige(new JDialog());
      anzeige(new JRootPane());
      anzeige(new JRootPane().getLayeredPane());
      anzeige(new JRootPane().getContentPane());
      anzeige(new JMenuBar());
   }
}
