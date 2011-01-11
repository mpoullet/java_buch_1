import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenAnonymeKlasse extends JFrame {
   int x = 55;;
   int y = 35;
// Konstruktordefinition
   public JFramemitKreiseMalenAnonymeKlasse() {
      super("Anonyme Klasse");
      setBounds(10,10,100,100);
      final int r1 = 30;
      final int r2 = 20;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Definition der anonymen Klasse innerhalb der 
// Parameterliste der add()-Methode
      getContentPane().add(new JComponent() {
         Color farbe = Color.gray;
         protected void paintComponent(Graphics g) {
            g.setColor(farbe);
            g.fillOval(x-r1,y-r1,2*r1,2*r1);
            g.setColor(Color.pink);
            g.fillOval(x-r2,y-r2,2*r2,2*r2);
         } 
      }); // Ende der anonymen Klasse und der add-Anweisung
      setVisible(true);
   }
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKreiseMalenAnonymeKlasse frame = new 
        JFramemitKreiseMalenAnonymeKlasse();
   }
}
