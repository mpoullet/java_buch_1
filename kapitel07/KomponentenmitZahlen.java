import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class KomponentenmitZahlen extends JPanel {
// Globale Referenz vom Typ der Klasse KomponentenListener 
   private KomponentenListener listener;
// Globale String-Referenzen 
   private String[][] komponenten; 
   private String komponentenName;
   private String komponentenTyp;
// Konstanten, welche den Typ der Standard-Komponenten definieren
   public static final String JBUTTON = "BUTTON"; 
   public static final String JTEXTFIELD = "TEXTFIELD"; 
// Konstruktordefinition 
   public KomponentenmitZahlen(String komponentenTyp, 
                            String[][] komponenten) {
      setLayout (new GridLayout(3,3,1,1));
      this.komponentenTyp = komponentenTyp;
      this.komponenten = komponenten;
 // Initialisierung von Komponenten 
      if(komponentenTyp == "BUTTON") 
         defJButton(); 
      else if (komponentenTyp == "TEXTFIELD") 
         defJTextField();
   } 
// Methode zum Erzeugen von JButton-Objekten 
public void defJButton() {
      JButton [][] button = new JButton[3][3];  
      for(int i=0; i<3; i++) {
         for(int j=0; j<3; j++) {
            button[i][j] = new JButton(komponenten[i][j]);
            add(button[i][j]);
// Interne Event-Listener für die JButton-Komponenten 
// als anonyme Klassen definieren und registrieren 
// und darin beim Empfangen eines internen Evenst mit der 
// Methode erzeugeEvent(), am aktuellen Objekt dieser Klasse 
// aufgerufen, eine benutzerdefinierte Event-Komponente erzeugen 
            button[i][j].addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  KomponentenmitZahlen.this.
                    erzeugeEvent(e.getActionCommand());  
               }
            });
         }
      }
   }   
// Methode zum Erzeugen von JTextField-Objekten 
   public void defJTextField() {
      JTextField [][] textField = new JTextField[3][3];  
      for(int i=0; i<3; i++) {
         for(int j=0; j<3; j++) {
            textField[i][j] = new JTextField(komponenten[i][j]);
// Den Text zentrieren
            textField[i][j].setHorizontalAlignment(JTextField.
              CENTER);
            add(textField[i][j]);
// Interne Event-Listener für die JTextField-Komponenten 
// als anonyme Klassen definieren und registrieren
            textField[i][j].addActionListener(new 
              ActionListener(){
               public void actionPerformed(ActionEvent e) {
                  KomponentenmitZahlen.this.erzeugeEvent(e.
                    getActionCommand());  
               }
            });
         }
      }
   }   
// Zugriffsmethoden für die Instanzfelder der umgebenden Klasse
   public String getkomponentenName() {
      return komponentenName;
   }
   public Object[][] getkomponenten() { 
      return komponenten; 
   }
   public String getkomponentenTyp() {
      return komponentenTyp;
   }
// Methode für das Registrieren des KomponentenListener
   public void addKomponentenListener(KomponentenmitZahlen.
     KomponentenListener l) {
      listener = l;
   } 
// Die Methode, welche bei jeder Komponentenauswahl ein neues 
// KomponentenEvent-Objekt erzeugt
   public void erzeugeEvent(String komponentenName) {
// Den Komponentenname für das aktuelle KomponentenmitZahlen- 
// Objekt zuweisen 
      this.komponentenName = komponentenName;  
// Ein KomponentenEvent-Objekt, das diesem zugeordnet wird,
// erzeugen
      KomponentenmitZahlen.KomponentenEvent ke = new 
        KomponentenmitZahlen.KomponentenEvent(this, 
          komponentenName);
// Den Listener mit dem Aufruf der im KomponentenListener- 
// Interface definierten Methode von der durchgeführten Auswahl
// über das zugeordnete KomponentenEvent-Objekt benachrichtigen 
      listener.komponentenAuswahl(ke);  
   } 
// Definition von inneren Klassen und Interfaces
// Static-Member-Klasse, die für Objekte der Klasse 
// KomponentenmitZahlen einen eigenen Eventtyp definiert
   public static class KomponentenEvent 
                               extends java.util.EventObject {
// Name der ausgewählten Komponente 
      String name;
// Konstruktordefinition der Static-Member-Klasse
      public KomponentenEvent(KomponentenmitZahlen kmz, 
        String name) {
         super(kmz);
         this.name = name;
      }
// Zugriffsmethoden der Static-Member-Klasse
      public KomponentenmitZahlen getKomponentenmitZahlen () { 
         return (KomponentenmitZahlen)getSource();
      }
      public String getName() {
         return name; 
      }
   }
// Static-Member-Interface, das von jedem KomponentenmitZahlen- 
// Objekt implemetiert werden muss, welches benachrichtigt werden
// soll, wenn eine beliebige Zahl ausgewählt wird
   public static interface KomponentenListener 
                               extends java.util.EventListener {
      public void komponentenAuswahl(KomponentenmitZahlen.
        KomponentenEvent e);
   }
}
