import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BuchalsLayeredPane extends JPanel 
                               implements MouseMotionListener {
// Globale Referenzen vom Typ der Klassen JLayeredPane und 
// UserLabel
   private JLayeredPane layeredPane;
   private UserLabel label;
   private JMenuBar mbBuch = new JMenuBar();
   private JMenu menuSeiten;
   private JMenu menuLesezeichen;
   private static JMenuBar mbLesezeichen = new JMenuBar();
   private static JMenu m = new JMenu("Lesezeichen setzen");
// Der Wert 0 definiert die erste Position in einer Ebene
// und der Wert -1 entspricht der letzten Position
   private int position = 0; 
// Ursprung und Distanz für das Anordnen von Komponenten
   private Point orig = new Point(10, 50);
   private int offset = 15;
// Konstruktordefinition
   public BuchalsLayeredPane(final JLayeredPane layeredPane) {
      super(new GridLayout(1,1));
      this.layeredPane = layeredPane;
      layeredPane.addMouseMotionListener(this);
      menuSeiten = new JMenu("Buchseiten");
      menuLesezeichen = new JMenu("Lesezeichen");
      mbBuch.add(menuSeiten);
      mbBuch.add(menuLesezeichen);
      JMenuItem[] itemSeiten = new JMenuItem[5];
      JMenuItem[] itemLesezeichen = new JMenuItem[2];
// Einträge für das Menü Buchseiten definieren und den 
// ActionListener für diese als anonyme Klasse registrieren
      for(int i=0; i<5; i++) {
         itemSeiten[i] = new JMenuItem("Seite"+(i+1));
         final int layer = i;
         itemSeiten[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
// Das Lesezeichen für eine ausgewählte Seite setzen
               layeredPane.setLayer(label, layer, position);
            }
         });
         menuSeiten.add(itemSeiten[i]);
// Eine lokale Referenz vom Typ der Klasse UserLabel trägt den 
// gleichen Namen wie die globale Referenz vom Typ dieser Klasse
         UserLabel label = new UserLabel("Seite"+(i+1),
           Color.pink, orig, new Dimension(100,100));
// Buchseiten erzeugen und in unterschiedliche Ebenen hinterlegen
         layeredPane.add(label, new Integer(i));
         orig.x += offset;
         orig.y += offset;
      }
// Einträge für das Menü Lesezeichen definieren und den 
// ActionListener für diese als anonyme Klasse registrieren
      itemLesezeichen[0] = new JMenuItem(
        "Lesezeichen vor die Seite setzen");
      itemLesezeichen[1] = new JMenuItem(
        "Lesezeichen hinter die Seite setzen");
      for(int i=0; i<2; i++) {
         final int layer = i;
         menuLesezeichen.add(itemLesezeichen[i]); 
         itemLesezeichen[i].addActionListener(
           new ActionListener() {
// Das Lesezeichen vor oder hinter eine Seite setzen
            public void actionPerformed(ActionEvent e) {
               if(layer==0) {   
                  layeredPane.moveToFront(label);
                  position = 0;
               }
               else {
                  layeredPane.moveToBack(label);
                  position = -1;
               }
            }
         });
      }
// Die MenuBar mbBuch zu der LayeredPane in der Ebene mit dem 
// Index 0 hinzufügen
      mbBuch.setBounds(0,25,300,20);
      layeredPane.add(mbBuch, new Integer(0)); 
// Eine JLabel-Komponente als Lesezeichen zu der LayeredPane in 
// der Ebene 0 hinzufügen
      label = new UserLabel("Lesen",Color.gray,
        new Point(15,15), new Dimension(40,150));
      layeredPane.add(label, new Integer(0),0);
   } 
// Member-Klasse 
   public class UserLabel extends JLabel {
// Konstruktordefinition
      public UserLabel(String string, Color color, Point point, 
                       Dimension dimension) {
         super(string);
         setVerticalAlignment(JLabel.TOP);
         setHorizontalAlignment(JLabel.CENTER);
         setOpaque(true);
         setBackground(color);
         setForeground(Color.black);
         setBorder(BorderFactory.createLineBorder(Color.black));
         setBounds(point.x, point.y, dimension.width, 
           dimension.height);
      }
   } 
// Das Lesezeichen mit der Maus bewegen
   public void mouseDragged (MouseEvent e) {
      label.setLocation(e.getX()-offset, e.getY()-offset);
   }
   public void mouseMoved (MouseEvent e) {} 
// Ein Fenster erzeugen und seine LayeredPane im Konstruktor der
// umgebenden Klasse übergeben
   private static void starteGUI() {
      JFrame frame = new JFrame("BuchalsLayeredPane");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Objekt der umgebenden Klasse erzeugen und als ContentPane 
// setzen
      BuchalsLayeredPane newContentPane = new 
        BuchalsLayeredPane(frame.getLayeredPane());
      frame.setContentPane(newContentPane);
// Die MenuBar mbLesezeichen setzen
      mbLesezeichen.add(m);
      frame.setJMenuBar(mbLesezeichen);
// Das Fenster anzeigen
      frame.setSize(new Dimension(200,250));
      frame.setVisible(true);
   }
// Static-Member-Klasse 
   public static class Test{
      public static void main(String[] args) {
         starteGUI();
      }
   }   
}
