import java.awt.*;
import javax.swing.*;
public class JFramefuerUserEventundListener extends JFrame 
                                 implements KomponentenListener {
   private UserButton button = new UserButton("Anklicken");
   private UserRadioButton radiobutton = 
     new UserRadioButton("Wert wählen");
   private UserTextField textfield = 
     new UserTextField("Wert ändern");  
// Ein Panel zur Aufnahme der Komponenten erzeugen 
   private JPanel cPanel = new JPanel();
// Eine Statusmeldung wird in einer Komponente vom Typ JLabel
// angezeigt
   private JLabel status = new JLabel(" "); 
// Konstruktordefinition 
   public JFramefuerUserEventundListener() {
      super("Benutzerdefinierte EventObject- und EventListener- " 
        + "Komponenten");
      setBounds(20,20,300,130);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      button.setBackground(Color.pink); 
      radiobutton.setBackground(Color.green); 
      textfield.setBackground(Color.lightGray); 
      cPanel.add(button);
      cPanel.add(radiobutton);
      cPanel.add(textfield);
// Den KomponentenListener für alle Komponenten registrieren
      button.addKomponentenListener(this); 
      radiobutton.addKomponentenListener(this); 
      textfield.addKomponentenListener(this); 
// Das Panel und die Statuszeile zum Fenster hinzufügen
      Container contentPane = getContentPane();
      contentPane.add(new Label(
       "Angegebenes Ereignis durchführen:"), BorderLayout.NORTH);
      contentPane.add(cPanel, BorderLayout.CENTER);
      contentPane.add(status, BorderLayout.SOUTH);
      setVisible(true);
   } 
// Die Methode von KomponentenListener implementieren 
   public void komponentenAuswahl(KomponentenEvent e) {
      int index = e.getComponent().toString().indexOf('[');
      String name=e.getComponent().toString().substring(0,index);
      status.setText("Ereignis von Komponente: " + name + ": " +
         e.getName() + " empfangen");
      }            
// Objekt der Klasse erzeugen
      public static void main(String[] args) {
         JFramefuerUserEventundListener frame = 
           new JFramefuerUserEventundListener();
   }
}
