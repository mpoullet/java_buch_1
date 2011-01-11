import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class JFramemitUserListModelohneEventBehandlung 
                                                extends JFrame {
   private JButton button1 = new JButton("Anfuegen");
   private final JList liste;
// Konstruktordefinition
   public JFramemitUserListModelohneEventBehandlung() {
      super("Model-Klassen und Model-Interfaces");
      setBounds(20,20,100,150);
      JPanel c = (JPanel)getContentPane();
      c.setLayout(new BoxLayout(getContentPane(),
        BoxLayout.Y_AXIS));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Im Konstruktor der Klasse UserListModelohneEventBehandlung 
// können Referenzen von Objekten vom Typ aller Klassen, welche 
// das Interface List<Object> implementieren, übergeben werden
      final UserListModelohneEventBehandlung userModel = 
        new UserListModelohneEventBehandlung(
          new ArrayList<Object>());
// Im Modell Objekte hinzufügen und löschen 
      userModel.addElement("J");
      userModel.addElement("A");
      userModel.addElement("V");
      userModel.addElement("A");
      userModel.addElement("!");
      System.out.println(userModel);
      userModel.setElementAt("6.0",4);
      System.out.println(userModel);
      userModel.removeElement("6.0");
      System.out.println(userModel);
// Eine JList-Komponente mit dem Modell erstellen 
      liste = new JList(userModel);
// Die Daten des Modells bei einer Betätigung des Buttons
// abändern 
      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            userModel.addElement("!");
            System.out.println(userModel);
         }
      });
// Die Komponenten zum Fenster hinzufügen
      c.add(liste);
      c.add(button1);
   }
// Objekt der Klasse erzeugen und sichtbar machen
   public static void main (String args[]) {
      JFramemitUserListModelohneEventBehandlung frame =
        new JFramemitUserListModelohneEventBehandlung();
      frame.setVisible(true);
   }
}
