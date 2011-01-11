import java.awt.*;
import java.awt.event.*;
public class FramemitActionListener extends Frame 
                                      implements ActionListener {
   private Button b; 
// Konstruktordefinition
   public FramemitActionListener() {
      super("Fenster mit einem Button schließen");
      b = new Button("Fenster schließen");
      b.setBackground(Color.green);
      add(b, BorderLayout.SOUTH);
// Event-Handling für den Button aktivieren
      b.addActionListener(this);
      setBounds(10,10,100,75);
      setBackground(Color.cyan);
      setVisible(true);
   }
// Diese Methode wird aufgerufen, wenn der Button angeklickt wird
   public void actionPerformed(ActionEvent e){
      System.exit(0);
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      FramemitActionListener frame = 
        new FramemitActionListener();
   }
}
