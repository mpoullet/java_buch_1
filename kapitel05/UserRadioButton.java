import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserRadioButton extends JRadioButton 
                                       implements ItemListener {
// Globale Referenzen
   private String name;
   private KomponentenListener listener;
// Konstruktordefinition 
   public UserRadioButton(String name) {
      super(name); 
      this.name = name;
      addItemListener(this);
   }  
// Die Methode von ItemListener implementieren    
   public void itemStateChanged(ItemEvent e) {
      KomponentenEvent  ke = new KomponentenEvent(
        (Component)this,name); 
      listener.komponentenAuswahl(ke);
   }
// Methode für das Registrieren von KomponentenListener
   public void addKomponentenListener(KomponentenListener l) {
      listener = l;
   } 
}
