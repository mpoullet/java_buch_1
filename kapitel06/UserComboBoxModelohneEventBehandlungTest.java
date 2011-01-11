import java.awt.*;
public class UserComboBoxModelohneEventBehandlungTest {
   public static void main(String args[]) {
// Objekt der Klasse UserComboBoxModelohneEventBehandlung 
// erzeugen
      UserComboBoxModelohneEventBehandlung userModel = 
        new UserComboBoxModelohneEventBehandlung(new List()); 
// Im Modell Daten hinzufügen und löschen 
      userModel.add("J");
      userModel.add("A");
      userModel.add("V");
      userModel.add("A");
      userModel.add("!");
// Die Methode toString()der Klasse 
// UserComboBoxModelohneEventBehandlung wird für die Ausgabe der
// Modelldaten automatisch aufgerufen
      System.out.println(userModel);
      userModel.addElement("6.0",4);
      System.out.println(userModel);
      userModel.remove("6.0");
      System.out.println(userModel);
   }
}
