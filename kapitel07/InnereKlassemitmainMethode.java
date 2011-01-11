import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class InnereKlassemitmainMethode extends JFrame 
                                implements MouseMotionListener {
   private JLabel status;
   private Canvas malflaeche;
   private Graphics g;
// Konstruktordefinition
   public InnereKlassemitmainMethode() {
      super("Programmaufruf über eine innere Klasse");
      setBounds(10,10,250,150);
      getContentPane().setLayout(new BorderLayout());
      malflaeche = new Canvas();
      malflaeche.setBackground(Color.pink);
      malflaeche.setSize(100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      malflaeche.addMouseMotionListener(this);
      status = new JLabel(" ");
      getContentPane().add(status, BorderLayout.SOUTH);
// Eine lokale Referenz vom Typ des Interface Action zeigt auf 
// ein Objekt vom Typ der inneren Klasse SelectColorAction 
      Action select = new SelectColorAction();
// Zu einer JToolBar-Komponente wird eine JButton-Komponente,
// welche die vorher definierte Aktion ausführt, hinzugefügt 
      JToolBar toolbar = new JToolBar("Farbe wählen");
      JButton b = toolbar.add(select);
      getContentPane().add(toolbar, BorderLayout.WEST);
      getContentPane().add(malflaeche, BorderLayout.EAST);
      setVisible(true);
// Den Graphikkontext des Canvas ermitteln
      g = malflaeche.getGraphics();
   } 
// Die Methoden des Interface MouseMotionListener implementieren
   public void mouseDragged(MouseEvent e) {
// Die Koordinaten des Mausklicks lesen
      int x = e.getX();
      int y = e.getY();
// und mit der Maus malen
      g.fillRect(x,y,3,3); 
   }  
   public void mouseMoved(MouseEvent e) {};
// Definition der inneren Klassen
   public class SelectColorAction extends AbstractAction {
      public SelectColorAction() {
         super("Farbe setzen");
      }
      public void actionPerformed(ActionEvent e) {
         Color color = JColorChooser.showDialog(
         InnereKlassemitmainMethode.this, "Eine Farbe wählen",
           Color.red);
         if(color != null) { 
            g.setColor(color);
            status.setText("Farbe mit JColorChooser abgeändert");
         }
      }
   }
// Eine Instanz der umgebenden Klasse in einer inneren Klasse 
// mit dem Namen Test erzeugen
   public static class Test {
      public static void main(String[] args) {
         InnereKlassemitmainMethode frame = 
           new InnereKlassemitmainMethode();
      }
   }
}
