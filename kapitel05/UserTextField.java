import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserTextField extends TextField 
                                       implements TextListener {
// Globale Referenzen
   private String name;
   private KomponentenListener listener;
// Konstruktordefinition 
   public UserTextField(String name) {
      super(name); 
      this.name = name;
      addTextListener(this);
   } 
// Die Methode von TextListener implementieren
   public void textValueChanged(TextEvent e) {
// KomponentenEvent-Objekt erzeugen und den von der Klasse 
// registriereten KomponentenListener benachrichtigen
      KomponentenEvent ke = new KomponentenEvent(
        (Component)this,name); 
      listener.komponentenAuswahl(ke);
   }
// Methode für das Registrieren von KomponentenListener 
   public void addKomponentenListener(KomponentenListener l) {
       listener = l;
   } 
}
