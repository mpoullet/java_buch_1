import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFramemitActionListenerundAnonymeKlasse 
                                              extends JFrame {
   private JButton b; 
// Konstruktor der umgebenden Klasse
   public JFramemitActionListenerundAnonymeKlasse() {
      super("Fenster schlie�en");
      b = new JButton("Fenster schlie�en");
      b.setBackground(Color.green);
      this.getContentPane().add(b, BorderLayout.SOUTH);
// ActionListener als anonyme Klasse f�r den Button registrieren
      this.b.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);            
         }
      });
      this.setBounds(20,20,200,100);
      this.getContentPane().setBackground(Color.cyan);
      this.setVisible(true);
   }
// Objekt der �u�eren Klasse erzeugen
   public static void main(String[] args) {
      JFramemitActionListenerundAnonymeKlasse frame = new
        JFramemitActionListenerundAnonymeKlasse();
   }
}
