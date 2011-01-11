import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenLokaleKlasseundFinal 
                                       extends JFrame {
   private int x = 55; 
   private int y = 35;
// Konstruktor der umgebenden Klasse
   public JFramemitKreiseMalenLokaleKlasseundFinal() {
      super("Lokale Klasse");
      final int r1 = 30;
      final int r2 = 20;
      setBounds(10,10,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine lokale Klasse wird innerhalb einer Methode definiert; 
// hier ist es der Konstruktor der umgebenden Klasse
      class KreiseMalenLokal extends JComponent{
// Methode der lokalen Klasse
         protected void paintComponent(Graphics g) {
            g.setColor(Color.gray);
            g.fillOval(x-r1,y-r1,2*r1,2*r1);
            g.setColor(Color.pink);
            g.fillOval(x-r2,y-r2,2*r2,2*r2);
         } 
      } 
//Eine Instanz der lokalen Klasse erzeugen
      KreiseMalenLokal km = new KreiseMalenLokal(); 
      getContentPane().add(km);
      setVisible(true); 
   } 
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKreiseMalenLokaleKlasseundFinal frame = new
        JFramemitKreiseMalenLokaleKlasseundFinal();
   }
}   
