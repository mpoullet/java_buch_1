import java.util.*;
public class UserListModelohneEventBehandlungTest {
   public static void main (String args[]) {
// Objekt der Klasse UserListModelohneEventBehandlung erzeugen   
      UserListModelohneEventBehandlung userModel = new
       UserListModelohneEventBehandlung(new ArrayList<Object>()); 
// Im Modell Objekte hinzufügen und löschen 
      userModel.addElement("J");
      userModel.addElement("A");
      userModel.addElement("V");
      userModel.addElement("A");
      userModel.addElement("!");
// Die Methode toString() der Klasse 
// UserListModelohneEventBehandlung wird für die Ausgabe der 
// Modelldaten automatisch aufgerufen
      System.out.println(userModel);
      userModel.setElementAt("6.0",4);
      System.out.println(userModel);
      userModel.removeElement("6.0");
      System.out.println(userModel);
   }
}
