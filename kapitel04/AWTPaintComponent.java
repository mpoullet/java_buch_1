import java.awt.*;
public class AWTPaintComponent {
   public static void main(String[] args) {
// Ein Objekt der Klasse ContainerfuerComponent
// in einem Fenster sichtbar machen
      Frame f = new Frame("AWT-Komponenten");
      Container c = new ContainerfuerComponent();
      c.add(new KreisComponent());
      f.add(c, BorderLayout.CENTER);
      f.pack();
      f.setVisible(true);
   }
}
