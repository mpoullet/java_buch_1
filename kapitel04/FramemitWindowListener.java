import java.awt.*;
import java.awt.event.*;
public class FramemitWindowListener extends Frame
                                      implements WindowListener {
// Konstruktordefinition
   public FramemitWindowListener() {
      super("Fenster schließen");
// Eine Instanz der eigenen Klasse als WindowListener 
// registrieren
      this.addWindowListener(this);   
      this.setBounds(10,10,100,75);
      this.setBackground(Color.cyan);
      this.setVisible(true);
   }
// Alle Methoden des WindowListener müssen implementiert werden, 
// die nicht benutzten Methoden mit leerem Rumpf 
// Der Benutzer will das Fenster schließen 
   public void windowClosing(WindowEvent e) {
      System.exit(0);            
   }
// Das Fenster wurde geschlossen 
   public void windowClosed(WindowEvent e) {}
// Das Fenster wurde zum Icon verkleinert 
   public void windowIconified(WindowEvent e) {} 
// Das Fenster wurde wieder hergestellt
   public void windowDeiconified(WindowEvent e) {}
// Das Fenster wurde aktiviert
   public void windowActivated(WindowEvent e) {}
// Das Fenster wurde deaktiviert
   public void windowDeactivated(WindowEvent e) {}
// Das Fenster wurde geöffnet
   public void windowOpened(WindowEvent e) {}
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
// Fenster erzeugen und initialisieren
      FramemitWindowListener frame = 
        new FramemitWindowListener();
   }
}
