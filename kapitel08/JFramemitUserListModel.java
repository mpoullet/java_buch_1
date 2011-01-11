import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class JFramemitUserListModel extends JFrame {
   private JButton button1 = new JButton("Modell abaendern");
   private JButton button2 =new JButton("List-Objekt abaendern");
   private final JList liste;
   private ListDataListener dataListener; 
// Konstruktordefinition
   public JFramemitUserListModel() {
      super("Model-Klassen und Model-Interfaces");
      setBounds(20,20,200,225);
      JPanel c = (JPanel)getContentPane();
      c.setLayout(new BoxLayout(getContentPane(),
        BoxLayout.Y_AXIS));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine Referenz vom Typ List<Object> zeigt auf eine Instanz 
// der Klasse ArrayList<Object>  
      final List<Object> list = new ArrayList<Object>();
      list.add("J");
      list.add("A");
      list.add("V");
      list.add("A");
      list.add("!");
// Im Konstruktor der Klasse UserListModel k�nnen Referenzen von 
// Objekten vom Typ aller Klassen, welche das Interface 
// List<Object> implementieren, �bergeben werden
      final UserListModel userModel = new UserListModel(list);
// Den ListDataListener f�r das benutzerdefinierte Modell 
// registrieren; alle Methoden des ListDataListener m�ssen 
// �berschrieben werden, auch wenn, wie in diesem Beispiel, 
// nur Events vom Typ CONTENTS_CHANGED erzeugt werden 
      userModel.addListDataListener(dataListener = 
        new ListDataListener() {
         public void intervalAdded(ListDataEvent e) {
            System.out.println("Hinzufuegen im Modell: " + e);
         }   
         public void intervalRemoved(ListDataEvent e) {
            System.out.println("Loeschen im Modell: " + e);
         }
         public void contentsChanged(ListDataEvent e) {
            System.out.println("Aendern im Modell: " + e);
         }
      });
// Im Modell Objekte hinzuf�gen
      System.out.println(userModel);
      userModel.setElementAt("6.0",4);
      System.out.println(userModel);
// Eine JList-Komponente mit dem Modell userModel erstellen 
      liste = new JList();
      liste.setModel(userModel);
// Ist gleichwertig mit
   //  liste = new JList(userModel);
// Den ActionListener f�r die Buttons registrieren
// Zum Modell neue Elemente bei einer Bet�tigung der Buttons 
// hinzuf�gen 
      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            userModel.addElement("!");
            System.out.println(userModel);
         }
      });
// Zu dem im Konstruktor �bergebenen List-Objekt neue Elemente 
// bei einer Bet�tigung der Buttons hinzuf�gen 
      button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            list.add("?");
            System.out.println(list);
            int index = list.size()-1;
// Den ListDataListener �ber die durchgef�hrte �nderung 
// benachrichtigen
            userModel.fireListUpdate(this, index, index); 
            System.out.println(userModel);
            System.out.println(list);
         }
      });
// Die Komponenten zum Fenster hinzuf�gen
      c.add(liste);
      c.add(button1);
      c.add(button2);
   }
// Objekt der Klasse erzeugen und sichtbar machen
   public static void main (String args[]) {
      JFramemitUserListModel frame =new JFramemitUserListModel();
      frame.setVisible(true);
   }
}
