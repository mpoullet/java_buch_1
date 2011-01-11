import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFramemitActionListenerundAnonymeKlasse 
                                              extends JFrame {
   private JButton b; 
// Konstruktor der umgebenden Klasse
   public JFramemitActionListenerundAnonymeKlasse() {
      super("Fenster schlieﬂen");
      b = new JButton("Fenster schlieﬂen");
      b.setBackground(Color.green);
      this.getContentPane().add(b, BorderLayout.SOUTH);
// ActionListener als anonyme Klasse f¸r den Button registrieren
      this.b.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);            
         }
      });
      this.setBounds(20,20,200,100);
      this.getContentPane().setBackground(Color.cyan);
      this.setVisible(true);
   }
// Objekt der ‰uﬂeren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitActionListenerundAnonymeKlasse frame = new
        JFramemitActionListenerundAnonymeKlasse();
   }
}
