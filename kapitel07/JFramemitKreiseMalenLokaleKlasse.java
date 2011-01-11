import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenLokaleKlasse extends JFrame {
// Konstruktordefinition
   public JFramemitKreiseMalenLokaleKlasse() {
      super("Lokale Klasse");
      setBounds(10,10,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine lokale Klasse wird innerhalb einer Methode definiert,
// hier ist es der Konstruktor der umgebenden Klasse
      class KreiseMalenLokal extends JComponent {
         int x;
         int y;
         int r1;
         int r2;
// Konstruktor der lokalen Klasse
         KreiseMalenLokal(int x, int y, int r1, int r2) {
            this.x = x;
            this.y = y;
            this.r1 = r1;
            this.r2 = r2;
         }
// Methode der lokalen Klassse
         protected void paintComponent(Graphics g) {
            g.setColor(Color.gray);
            g.fillOval(x-r1,y-r1,2*r1,2*r1);
            g.setColor(Color.pink);
            g.fillOval(x-r2,y-r2,2*r2,2*r2);
         }
      } 
// Eine Instanz der lokalen Klasse erzeugen
      KreiseMalenLokal km = new KreiseMalenLokal(55, 35, 30, 20); 
      getContentPane().add(km);
      setVisible(true);
   }
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKreiseMalenLokaleKlasse frame = new 
        JFramemitKreiseMalenLokaleKlasse();
   }
}
