import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
public class JFramemitUserModell extends JFrame 
                                     implements ActionListener {
   private IconButton[] b = new IconButton[3];
   private JTextField[] t = new JTextField[3];
   private JTextArea tArea = new JTextArea();
   private JEditorPane ePane = new JEditorPane();
// Konstruktordefinition
   public JFramemitUserModell() {
      super("Model-Klassen und Model-Interfaces");
      setBounds(20,20,200,225);
      getContentPane().setLayout(new GridLayout(8,1));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(int i=0; i<3; i++) {
         b[i] = new IconButton("Button"+(i+1));
         b[i].addActionListener(this);
         t[i] = new JTextField();
      }
// Setzen eines Modells vom Typ der Moddellklasse GrossBuchstaben
// für die erste JTextField- und die JEditorPane-Komponente 
      t[0].setDocument(new GrossBuchstaben());
      ePane.setDocument(new GrossBuchstaben());
      getContentPane().add(tArea);
      getContentPane().add(ePane);
// Das Modell von "Button1" wird ermittelt und "Button2" 
// zugewiesen; so wird bei der Betätigung eines der Buttons auch
// der andere automatisch gedrückt
      ButtonModel model = b[0].getModel();
      b[1].setModel(model);
      for(int i=0; i<3; i++) {
         getContentPane().add(b[i], null);
      }
// Das Modell vom 1.Textfeld wird ermittelt und dem 2.Textfeld 
// zugewiesen; damit werden auch seine Inhalte in 
// Grossbuchstaben geschrieben
      Document modell = t[0].getDocument();
      t[1].setDocument(modell);
      t[1].setBackground(Color.pink);
      tArea.setBackground(Color.pink);
// Die Komponenten zum Fenster hinzufügen
      getContentPane().add(tArea);
      getContentPane().add(ePane);
      for(int i=0; i<3; i++) {
         getContentPane().add(b[i], null);
      }
      for(int i=0; i<3; i++) {
         getContentPane().add(t[i], null);
      }
      for(int i=0; i<3; i++) {
         getContentPane().add(t[i], null);
      }
   }
// Eine Nachricht in die 3. JTextField- und in die JEditorPane- 
// Komponente schreiben
   public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("Button1"))
         t[2].setText(e.getActionCommand()+ " betätigt");
      else
         ePane.setText(e.getActionCommand()+ " betätigt"); 
}
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitUserModell frame = new JFramemitUserModell();   
      frame.setVisible(true);
   }
}
  
