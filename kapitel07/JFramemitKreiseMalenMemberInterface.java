import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenMemberInterface extends JFrame {
   private int x; 
   private int y;
   private int r = 25;
// Konstruktordefinition
   public JFramemitKreiseMalenMemberInterface() {
      super("Static-Member-Interface");
      setBounds(100,100,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Die aktuellen Koordinaten des oberen rechten Eckes der 
// Komponente mit den von der Klasse Component geerbten
// Methoden lesen
      y = getX();
      x = getY();
      setVisible(true);
   } 
   public void paint(Graphics g) {
      super.paint(g);   
      g.setColor(Color.pink);
      rechtsOben(g);
      linksUnten(g);
      idMitte(g);
   } 
// Ein Static-Member-Interface als inneres Interface definieren
   public static interface KreisePositionieren {
      public void rechtsOben(Graphics g);
      public void linksUnten(Graphics g);
      public void idMitte(Graphics g);
   } 
// Die Methoden des Interface in der ‰uﬂeren Klasse 
// implementieren
   public void rechtsOben(Graphics g) {
      g.fillOval(r,r,r,r);
   } 
   public void linksUnten(Graphics g) {
      g.fillOval(x-r,y-r,r,r);
   } 
   public void idMitte(Graphics g) {
      g.fillOval((x/2),(y/2),r,r);
   } 
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
    JFramemitKreiseMalenMemberInterface frame = new 
      JFramemitKreiseMalenMemberInterface();
   }
}      
