import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitDefaultComboBoxModel extends JFrame 
                                     implements ActionListener {
   private JButton button1 = new JButton("Anfuegen");
   private String [] data = {"j", "a", "v", "a"};
// Ein Modell vom Typ DefaultComboBoxModel, welches die Daten aus 
// dem Array data speichert, erzeugen 
   private DefaultComboBoxModel defaultModel = new 
              DefaultComboBoxModel(data);
// Die Modell-Instanz im Konstruktoraufruf der Viewer-Komponente 
// vom Typ JComboBox als Referenz übergeben
   private JComboBox comboBox = new JComboBox(defaultModel);
// Eine AWT-Komponente vom Typ List erzeugen
   private List liste = new List();
// Konstruktordefinition
   public JFramemitDefaultComboBoxModel() {
      super("AWT-List- und JComboBox-Komponenten");
      setBounds(20,20,200,175);
// Die Einträge für die Liste müssen einzeln über die add()-
// Methode der Klasse vorgenommen werden
      liste.add("J");
      liste.add("A");
      liste.add("V");
      liste.add("A");
      JPanel c = (JPanel)getContentPane();
      c.setLayout(new FlowLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      button1.addActionListener(this);
// Die Komponenten zum Fenster hinzufügen
      c.add(comboBox);
      c.add(liste);
      c.add(button1);
   }
// Die Methoden des ActionListener registrieren
   public void actionPerformed(ActionEvent e) {
// Bei einer Betätigung des Buttons werden neue Daten beiden 
// Komponenten hinzugefügt 
// Der ComboBox über ihr Modell
      defaultModel.addElement("!");
// und der Liste mit Hilfe ihrer add()-Methode
      liste.add("?");
   }
// Objekt der Klasse erzeugen
   public static void main (String args[]) {
      JFramemitDefaultComboBoxModel frame = 
        new JFramemitDefaultComboBoxModel();
      frame.setVisible(true);
      
   }
}
