import java.awt.*;
public class FramemitWindowAdapter extends Frame {
// Konstruktordefinition
   public FramemitWindowAdapter() {
      super("Fenster schließen");
// Den WindowListener als Objekt der Klasse 
// UnterklassevonWindowAdapter für die Instanzen der Klasse 
// registrieren
      this.addWindowListener(new UnterklassevonWindowAdapter()); 
      this.setBounds(10,10,100,75);
      this.setBackground(Color.cyan);
      this.setVisible(true);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      FramemitWindowAdapter frame = new FramemitWindowAdapter();
   }
}
