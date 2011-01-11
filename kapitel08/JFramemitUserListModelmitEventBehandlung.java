import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class JFramemitUserListModelmitEventBehandlung 
                                                extends JFrame {
   private JButton button1 = new JButton("Anfuegen");
   private final JList liste;
   private ListDataListener dataListener; 
// Konstruktordefinition
   public JFramemitUserListModelmitEventBehandlung () {
      super("Model-Klassen und Model-Interfaces");
      setBounds(20,20,100,150);
      JPanel c = (JPanel)getContentPane();
      c.setLayout(new BoxLayout(getContentPane(),
        BoxLayout.Y_AXIS));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Im Konstruktor der Klasse UserListModel können Referenzen von
// Objekten vom Typ aller Klassen, welche das Interface 
// List<Object> implementieren, übergeben werden
      final UserListModelmitEventBehandlung userModel = 
        new UserListModelmitEventBehandlung(
          new ArrayList<Object>());
// Den ListDataListener implementieren und für das 
// benutzerdefinierte Modell registrieren
      userModel.addListDataListener(dataListener = 
        new ListDataListener() {
         public void intervalAdded(ListDataEvent e) {
            System.out.println("Hinzufuegen: " + e);
         }
         public void intervalRemoved(ListDataEvent e) {
            System.out.println("Loeschen: " + e);
         }
         public void contentsChanged(ListDataEvent e) {
            System.out.println("Aendern: " + e);
         }
      });
// Im Modell Objekte hinzufügen und löschen 
      userModel.addElement("J");
      userModel.addElement("A");
      userModel.addElement("V");
      userModel.addElement("A");
      userModel.addElement("!");
      System.out.println(userModel);
      userModel.setElementAt("6.0",4);
      System.out.println(userModel);
// Den ListDataListener deregistrieren, die nachfolgenden 
// Änderungen im Modell werden nicht mehr gemeldet
   // userModel.removeListDataListener(dataListener); 
      userModel.removeElement("6.0");
      System.out.println(userModel);
// Eine JList-Komponente mit dem Modell userModel erstellen 
      liste = new JList(userModel);
// Das Modell bei einer Betätigung des Buttons erweitern
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
      JFramemitUserListModelmitEventBehandlung frame = 
        new JFramemitUserListModelmitEventBehandlung();
      frame.setVisible(true);
   }
}

