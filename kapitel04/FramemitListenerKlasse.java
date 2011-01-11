import java.awt.*;
import java.awt.event.*;
public class FramemitListenerKlasse extends Frame {
   private Button b;
// Eine Globale Referenz vom Typ ListenerKlasse zeigt auf
// eine Instanz dieser Klasse 
   private ListenerKlasse listener = new ListenerKlasse();
// Konstruktordefinition
   public FramemitListenerKlasse(){ 
      super("Fenster schlie�en");
      b = new Button("Fenster schlie�en");
      this.add(b, BorderLayout.SOUTH);
      this.setBounds(10,10,100,75);
      this.setBackground(Color.cyan);
      this.setVisible(true);
// Die von der Klasse ListenerKlasse implementierten Listener 
// registrieren
      addWindowListener(listener);
      b.addActionListener(listener);
   } 
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      FramemitListenerKlasse frame = 
        new FramemitListenerKlasse();
   }
}   
