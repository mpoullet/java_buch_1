import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitKeyListener extends JFrame 
                                         implements KeyListener {
   private JLabel l1 = new JLabel("Eingabe");
   private JTextField t1 = new JTextField();
   private JLabel l2 = new JLabel("Ausgabe");
   private JTextField t2 = new JTextField();
// Konstruktordefinition
   public JFramemitKeyListener() {
      super("Fenster mit Tastatureingaben");
      setBounds(20,20,700,100);
// Die Komponenten zum Fenster hinzufügen
      setLayout(new GridLayout(4,1));
      add(l1);
      add(t1);
      add(l2);
      add(t2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Das Textfeld t1 registriert den von der Klasse 
// implementierten KeyListener
      t1.addKeyListener(this);
   }
// Die Methoden des KeyListener implementieren
   public void keyPressed(KeyEvent e) {
      String string = "Zeichen <" + e.getKeyChar() + " >";
      string += "mit der Codierung <" + e.getKeyCode()+
        " > eingegeben.";
      string += " Taste <" + KeyEvent.getKeyText(e.getKeyCode());
      string += "> mit den Modifikatoren <" + KeyEvent.
        getKeyModifiersText(e.getModifiers()) + " > gedrückt";
      t2.setText(string);
   }
   public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e) {}
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitKeyListener frame = new JFramemitKeyListener();   
      frame.setVisible(true);
   }
}
