import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JFramemitUserComboBoxModel extends JFrame 
                   implements ListDataListener, ActionListener {
   private JButton button1 = new JButton("Anfuegen");
   private String [] data = {"j", "a","v", "a"};
   private JComboBox comboBox1 = new JComboBox(data);
   private JComboBox comboBox = new JComboBox();
   private UserComboBoxModel userModel;
// Konstruktordefinition
   public JFramemitUserComboBoxModel() {
      super("Model-Klassen und Model-Interfaces");
      setBounds(20,20,100,175);
      JPanel c = (JPanel)getContentPane();
      c.setLayout(new FlowLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Im Konstruktor der Klasse UserComboBoxModel wird eine 
// Referenz vom Typ der AWT-Klasse List �bergeben 
      userModel = new UserComboBoxModel(new List());
// Den ListDataListener f�r das benutzerdefinierte Modell 
// registrieren
      userModel.addListDataListener(this);
// Im Modell Daten hinzuf�gen und loeschen 
      userModel.add("J");
      userModel.add("A");
      userModel.add("V");
      userModel.add("A");
      userModel.add("!");
      System.out.println(userModel);
      userModel.addElement("6.0",4);
      System.out.println(userModel);
// Den ListDataListner deregistrieren, die nachfolgenden 
// �nderungen im Modell werden nicht mehr gemeldet
      userModel.removeListDataListener(this); 
      userModel.remove("!");
      System.out.println(userModel);
// Das Modell userModel f�r die JComboBox-Komponente setzen 
      userModel.setSelectedItem("6.0");
      comboBox.setModel(userModel);
      button1.addActionListener(this);
// Die Komponenten zum Fenster hinzuf�gen
      c.add(comboBox1);
      c.add(comboBox);
      c.add(button1);
   }
// Die Methoden der Event-Listener registieren
   public void actionPerformed(ActionEvent e) {
// Bei einer Bet�tigung des Buttons werden neue Daten im Modell
// eingetragen 
      userModel.add("!");
      userModel.setSelectedItem("!");
      System.out.println(userModel);
   }
   public void intervalAdded(ListDataEvent e) {
      System.out.println("Hinzufuegen: " + e);
   }
   public void intervalRemoved(ListDataEvent e) {
      System.out.println("Loeschen: " + e);
   }
   public void contentsChanged(ListDataEvent e) {
      System.out.println("Aendern: " + e);
   }
// Objekt der Klasse erzeugen
   public static void main (String args[]) {
      JFramemitUserComboBoxModel frame = 
        new JFramemitUserComboBoxModel();
      frame.setVisible(true);
   }
}
