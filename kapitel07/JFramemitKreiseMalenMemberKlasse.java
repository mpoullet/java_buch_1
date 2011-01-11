import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenMemberKlasse extends JFrame {
// Konstruktor der umgebenden Klasse
   public JFramemitKreiseMalenMemberKlasse() {
      super("Member-Klasse");
      setBounds(10,10,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container cPanel = getContentPane();
// Eine innere Instanz wird automatisch mit dem aktuellen Objekt 
// der umgebenden Klasse verknüpft 
      KreiseMalen km = new 
       JFramemitKreiseMalenMemberKlasse.KreiseMalen(55,35,30,20);
// Korrekt ist auch der Aufruf ohne den Namen der umgebenden 
// Klasse
   // KreiseMalen km = new KreiseMalen(55,35,30,20); 
// Wird die umgebende Instanz explizit angegeben, darf der 
// Klassennamen der umgebenden Klasse nicht angegeben werden
   // KreiseMalen km = this.new KreiseMalen(55,35,30,20); 
      cPanel.add(km);
      setVisible(true);
   } 
// Innere Klasse (Member-Klasse)
   public class KreiseMalen extends JComponent {
      int x;
      int y;
      int r1;
      int r2;
// Konstruktor der Member-Klasse mit Mittelpunkt und zwei Radien
      KreiseMalen(int x, int y, int r1, int r2) {
         this.x = x;
         this.y = y;
         this.r1 = r1;
         this.r2 = r2;
      }
// zwei Kreise malen
      protected void paintComponent(Graphics g) {      
         g.setColor(Color.gray);
         g.fillOval(x-r1,y-r1,2*r1,2*r1);
         g.setColor(Color.pink);
         g.fillOval(x-r2,y-r2,2*r2,2*r2);
      }
   } 
// Objekt der äußeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKreiseMalenMemberKlasse frame =
        new JFramemitKreiseMalenMemberKlasse();
   }
}
