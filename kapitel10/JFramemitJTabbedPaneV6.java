import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
public class JFramemitJTabbedPaneV6 extends JFrame 
                    implements ActionListener, JavaKomponenten {
   private JTabbedPane pane = new JTabbedPane();
   private Vector<Component> komponenten;
// Konstruktordefinition
   public JFramemitJTabbedPaneV6 () {
      super("JTabbedPane mit Komponenten fuer Registerkarten");
// Die in den Tabs anzuzeigenden Komponenten dynamisch erzeugen
      komponenten = defKomponenten(komponentenName);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Komponenten zu den Tabs (Registerkarten) hinzufügen 
      for(int i=0; i<komponenten.size(); i++) {
         Component komponente = komponenten.elementAt(i);
         pane.addTab(null, komponente);
// An Stelle eines Textes eine JButton-Komponente mit dem 
// Klassenname der Komponente als Label direkt in die 
// Registerkarten platzieren
         String className = komponente.getClass().getName();
         String tabName = className.substring(
           className.lastIndexOf('.')+1);
         JButton button = new JButton(tabName);
         button.addActionListener(this);
         pane.setTabComponentAt(pane.getTabCount()-1, button);
      }
// Die JTabbedPane-Komponente zu dem Fenster hinzufügen
      add(pane);
      setSize(500,125);
      setVisible(true);
   }
// Die Methode des ActionListener implementieren
   public void actionPerformed(ActionEvent ae) {
// Beim Betätigen der Buttons die den Registerkarten 
// zugeordneten Kindkomponenten anzeigen
// Den Name der Kindkomponenten ermitteln,
      String s ="";
      if(((ae.getActionCommand()).equals("Canvas")) || 
        ((ae.getActionCommand()).equals("Button"))){
         s = s.concat("java.awt.");
      }
      else {
         s = s.concat("javax.swing.");
      }
      s = s.concat(ae.getActionCommand());
// diese über ihren Namen in der JTabbedPane-Komponente finden
      for(int i=0; i<komponenten.size(); i++) {
         Component komponente =pane.getComponentAt(i);
         if((komponente.getClass().getName()).equals(s)) {
// und selektieren
            pane.setSelectedComponent(komponente);
            break;
         }
      }
   }
// Ladbare Swing- und AWT-Komponenten mit Hilfe eines 
// vorgegebenen Klassennamens erzeugen und in eine Instanz vom 
// Typ Vector<Component> legen
   public static Vector<Component> defKomponenten(String[] name){
// Eine Vector<Component>-Instanz für die Aufnahme von 
// Komponenten erzeugen 
      Vector<Component> komponenten = new Vector<Component>(); 
// Aktuelle Komponente initialisieren
      Component komponente = null;
      for(int i=0; i<name.length; i++) {  
         try {
// Komponentenklasse laden
            Class componentClass = Class.forName(name[i]);
// und eine Instanz davon erzeugen
            komponente = (Component)componentClass.newInstance();
            komponente.setBackground(Color.blue); 
            komponente.setName(name[i]);
         }
         catch(Exception e) {  
// Bei Fehler eine Meldung ausgeben
            System.out.println("Laden bzw. Instantiieren der "
              + "Klasse nicht möglich " + name[i]);
         }
// Ansonsten die so erzeugte Komponente zu der Vector<Component>
// -Instanz hinzufügen und diese
         komponenten.addElement(komponente);
      }
// returnieren
      return komponenten;
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTabbedPaneV6 frame = 
        new JFramemitJTabbedPaneV6();
   }
}
