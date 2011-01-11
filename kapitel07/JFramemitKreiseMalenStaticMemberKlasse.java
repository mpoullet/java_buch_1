import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenStaticMemberKlasse 
                                             extends JFrame {
// Konstruktor der umgebenden Klasse
   public JFramemitKreiseMalenStaticMemberKlasse() {
      super("Static-Member-Klasse");
      setBounds(10,10,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Eine Instanz der inneren Klasse bilden mit
      KreiseMalenStatic km = new 
        KreiseMalenStatic(55,35,30,20); 
// oder
   // JFramemitKreiseMalenStaticMemberKlasse.KreiseMalenStatic 
   // km = new JFramemitKreiseMalenStaticMemberKlasse.
   //   KreiseMalenStatic(55,35,30,20);
// Fehlerhafte Zuweisungen
   // KreiseMalenStatic km = this.new 
   //   JFramemitKreiseMalenStaticMemberKlasse.
   //     KreiseMalenStatic(55,35,30,20); 
   // KreiseMalenStatic km = this.new 
   //    KreiseMalenStatic(55,35,30,20); 
      getContentPane().add(km);
      setVisible(true);
   } 
// Static-Member-Klasse
   public static class KreiseMalenStatic extends JComponent {
      int x;
      int y;
      int r1;
      int r2;
// Konstruktor der inneren Klasse
      KreiseMalenStatic(int x, int y, int r1, int r2) {
         this.x = x;
         this.y = y;
         this.r1 = r1;
         this.r2 = r2;
      }
// Zwei Kreise zeichnen
      protected void paintComponent(Graphics g) {      
         g.setColor(Color.gray);
         g.fillOval(x-r1,y-r1,2*r1,2*r1);
         g.setColor(Color.pink);
         g.fillOval(x-r2,y-r2,2*r2,2*r2);
      }
   } 
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKreiseMalenStaticMemberKlasse frame = new 
        JFramemitKreiseMalenStaticMemberKlasse();
   }
}  
