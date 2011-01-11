import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class UserListModelmitEventBehandlungTest {
   static private ListDataListener dataListener; 
   static UserListModelmitEventBehandlung userModel = new 
   UserListModelmitEventBehandlung (new ArrayList<Object>());
// Konstruktordefinition 
   public UserListModelmitEventBehandlungTest() {
// ListDataListener implementieren und für das benutzerdefinierte
// Modell registrieren
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
   }
   public static void main (String args[]) {
// Objekt der Klasse erzeugen
      UserListModelmitEventBehandlungTest testuserModel = 
        new UserListModelmitEventBehandlungTest();
// Im Modell Objekte hinzufügen und löschen 
      userModel.addElement("J");
      userModel.addElement("A");
      userModel.addElement("V");
      userModel.addElement("A");
      userModel.addElement("!");
      System.out.println(userModel);
      userModel.setElementAt("6.0",4);
      System.out.println(userModel);
// Den ListDataListener deregistrieren, die nachfolgende
// Änderung im Modell wird nicht mehr gemeldet
      userModel.removeListDataListener(dataListener); 
      userModel.removeElement("!");
      System.out.println(userModel);
   }
}
