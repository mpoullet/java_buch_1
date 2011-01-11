import java.awt.*;
import java.awt.event.*;
public class FramemitWindowAdapterundMemberKlasse extends Frame {
// Konstruktor der umgebenden Klasse
   public FramemitWindowAdapterundMemberKlasse() {
      super("Member-Klasse f�r WindowAdapter");
// Ein WindowAdapter-Objekt vom Typ der inneren Klasse
// f�r die umgebende Klasse registrieren
      this.addWindowListener(new UnterklassevonWindowAdapter());
      this.setBounds(10,10,100,100);
      this.setBackground(Color.cyan);
      this.setVisible(true);
   }
// Definition der inneren Klasse
   public class UnterklassevonWindowAdapter extends WindowAdapter{
      public void windowClosing(WindowEvent e) {
         System.exit(0);            
      }
   }
// Objekt der umgebenden Klasse erzeugen
   public static void main(String[] args) {
      FramemitWindowAdapterundMemberKlasse frame = new 
        FramemitWindowAdapterundMemberKlasse();
   }
}
