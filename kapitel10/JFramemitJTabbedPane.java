import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
public class JFramemitJTabbedPane extends JFrame 
                                    implements JavaKomponenten {
   private JTabbedPane pane = new JTabbedPane();
// Konstruktordefinition
   public JFramemitJTabbedPane () {
      super("JTabbedPane mit einem Text fuer Registerkarten");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Kindkomponenten für den JTabbedPane-Container dynamisch 
// erzeugen
      for(int i=0; i<komponentenName.length; i++) {  
         try {
// Komponentenklasse laden
            Component komponente = null;             
            Class componentClass = Class.forName(
              komponentenName[i]);
// und eine Instanz davon erzeugen
            komponente = (Component)componentClass.newInstance();
            komponente.setBackground(Color.blue); 
            komponente.setName(komponentenName[i]);
            String className = komponente.getClass().getName();
            String tabName = className.
              substring(className.lastIndexOf('.')+1);
// Die Komponenten zu den Tabs (Registerkarten) hinzufügen 
            pane.addTab(tabName, komponente);
         }
         catch(Exception e) {  
// Bei Fehler eine Meldung ausgeben
            System.out.println("Laden bzw. Instantiieren der "
              + "Klasse nicht möglich " + komponentenName[i]);
         }
      }
// Die JTabbedPane-Komponente zu dem Fenster hinzufügen
      add(pane);
// Größe des Fensters festlegen 
      setSize(500,100);
// Fenster auf dem Bildschirm sichtbar machen
      setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTabbedPane frame = new JFramemitJTabbedPane();
   }
}
