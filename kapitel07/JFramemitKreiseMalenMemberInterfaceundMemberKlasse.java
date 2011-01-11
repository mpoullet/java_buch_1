import java.awt.*;
import javax.swing.*;
public class JFramemitKreiseMalenMemberInterfaceundMemberKlasse 
                                                extends JFrame {
   private KreiseMalen interfaceKM;
// Konstruktor der umgebenden Klasse   
   public JFramemitKreiseMalenMemberInterfaceundMemberKlasse(){
      super("Member-Klasse und Member-Interface");
      setBounds(10,10,100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Instanz der inneren Klasse erzeugen und zum Fenster hinzufügen
      getContentPane().add(new 
        JFramemitKreiseMalenMemberInterfaceundMemberKlasse.
          KreiseMemberKlasse(55,35,30,20));
// Das innere Interface mittels einer anonymen Klasse 
// implementieren
      interfaceKM = new 
        JFramemitKreiseMalenMemberInterfaceundMemberKlasse.
          KreiseMalen() {
         public void drawKreise(Graphics g,
           JFramemitKreiseMalenMemberInterfaceundMemberKlasse.
             KreiseMemberKlasse km) {
            g.setColor(Color.gray);
// Auf die Felder der Member-Klasse kann nur über eine Instanz 
// dieser Klasse zugegriffen werden
            g.fillOval(km.x-km.r1,km.y-km.r1,2*km.r1,2*km.r1);
            g.setColor(Color.pink);
            g.fillOval(km.x-km.r2,km.y-km.r2,2*km.r2,2*km.r2);
         } 
      }; 
      setVisible(true); 
   }
// Definition der Member-Klasse
   public class KreiseMemberKlasse extends JComponent {
      int x; 
      int y;
      int r1;
      int r2;
// Konstruktor der Member-Klasse
      KreiseMemberKlasse(int x, int y, int r1, int r2) {
         this.x = x;
         this.y = y;
         this.r1 = r1;
         this.r2 = r2;
      }
// Methode der Member-Klasse (Kreise zeichnen)
      protected void paintComponent(Graphics g) {
         interfaceKM.drawKreise(g,this); 
      }
   } 
// Definition des Static-Member-Interface
   public static interface KreiseMalen {
      public void drawKreise(Graphics g, KreiseMemberKlasse km);
   } 
// Objekt der äußeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKreiseMalenMemberInterfaceundMemberKlasse frame = 
       new JFramemitKreiseMalenMemberInterfaceundMemberKlasse ();
   }
}   
