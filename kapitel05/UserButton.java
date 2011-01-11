import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserButton extends JButton 
                                    implements ActionListener {
// Globale Referenzen
   private String name;
   private KomponentenListener listener;
// Konstruktordefinition 
   public UserButton(String name) {
      super(name); 
      this.name = name;
      addActionListener(this);
   } 
// Die Methode von ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
      KomponentenEvent  ke = new KomponentenEvent(
        (Component)this,name); 
      listener.komponentenAuswahl(ke);
   }
// Methode für das Registrieren von KomponentenListener
   public void addKomponentenListener(KomponentenListener l) {
      listener = l;
   } 
}
