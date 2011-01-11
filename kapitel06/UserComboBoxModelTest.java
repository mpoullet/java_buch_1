import java.awt.List;
import javax.swing.event.*;
public class UserComboBoxModelTest implements ListDataListener {
   static UserComboBoxModel userModel; 
// Konstruktordefinition
   public UserComboBoxModelTest() {
      userModel = new UserComboBoxModel(new List()); 
// Den ListDataListener für das benutzerdefinierte Modell
// registrieren
      userModel.addListDataListener(this);
   }
// Die Methoden des Interface ListDataListener implementieren
   public void intervalAdded(ListDataEvent e) {
      System.out.println("Hinzufuegen: " + e);
   }
   public void intervalRemoved(ListDataEvent e) {
      System.out.println("Loeschen: " + e);
   }
   public void contentsChanged(ListDataEvent e) {
      System.out.println("Aendern: " + e);
   }
   public static void main(String args[]) {
// Objekt der Klasse erzeugen   
      UserComboBoxModelTest testuserModel = 
        new UserComboBoxModelTest();
// Im Modell Daten hinzufügen und löschen 
      userModel.add("J");
      userModel.add("A");
      userModel.add("V");
      userModel.add("A");
      userModel.add("!");
// Die Methode toString() der Klasse UserComboBoxModel
// wird für die Ausgabe der Modelldaten automatisch aufgerufen
      System.out.println(userModel);
      userModel.addElement("6.0",4);
      System.out.println(userModel);
      userModel.remove("!");
      System.out.println(userModel);
   }
}
