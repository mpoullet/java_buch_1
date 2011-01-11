import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JFramefuerJListTransferHandlermitDropLocation 
                               extends JFrame implements Texte {
   static final String name[] = new String[4];
   static {
     name[0] = "USE_SELECTION";
     name[1] = "ON";
     name[2] = "INSERT"; 
     name[3] = "ON_OR_INSERT";
   }
   static final DropMode dropMode[] = new DropMode[4];
   static { 
     dropMode[0] = DropMode.USE_SELECTION;
     dropMode[1] = DropMode.ON;
     dropMode[2] = DropMode.INSERT; 
     dropMode[3] = DropMode.ON_OR_INSERT;
   }
   private JTextArea textArea = new JTextArea(
     "Die\nVersion\nlernen",3,3);
   private DefaultListModel model = new DefaultListModel(); 
   private JList liste;
   private JMenuBar menueBar = new JMenuBar();
// Konstruktordefinition
   public JFramefuerJListTransferHandlermitDropLocation() {
      super("Benutzerdefinierte Transfer-Handler");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JMenu menue = defmenueDropMode(); 
      menueBar.add(menue);                  
// Die MenueBar für die Auswahl der Drop-Modi im Fenster 
// einrichten
      setJMenuBar(menueBar);
// Die Liste wird über ein Modell vom Typ der Klasse 
// DefaultListModel erzeugt 
      for(int i=0; i <text1.length; i++) {
         model.add(i,text1[i]);
      }
      liste = new JList(model);
// und es ist keine mehrfache Selektion von Elementen erlaubt
      liste.setSelectionMode(ListSelectionModel.
        SINGLE_INTERVAL_SELECTION);
// Die Drag-Fähigkeit für die Komponenten einschalten
      textArea.setDragEnabled(true);
      liste.setDragEnabled(true);
// Einen benutzerdefinierten TransferHandler vom Typ der Klasse 
// JListTransferHandlermitDropLocation der JList-Komponente 
// zuweisen 
      JListTransferHandlermitDropLocation transHandler = 
        new JListTransferHandlermitDropLocation(liste);
      liste.setTransferHandler(transHandler);
// Einen Layout-Manager definieren und die einzelnen Komponenten 
// zu der ContentPane des Fensters hinzufügen
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("JTextArea: "));
      add(textArea);
      add(new JLabel("JList: "));
      add(liste);
      setSize(275,200);
      setVisible(true);
   }
// Die Methode returniert eine JMenu-Komponente für die Auswahl 
// der Drop-Modi
   public JMenu defmenueDropMode() {
// JMenu-Komponente instantiieren
      JMenu menueDropMode = new JMenu("DropMode");
// ButtonGroup für das Ausschließen von Menüeinträgen erzeugen
      ButtonGroup radiogroup = new ButtonGroup();  
// Menüeinträge erstellen
      for(int i=0; i<name.length; i++) {
         JMenuItem item = menueDropMode.add(
           new JRadioButtonMenuItem(name[i]));
         final int n = i;
// Aktionen, die bei der Auswahl eines Menüeintrags durchgeführt 
// werden, über die Definition einer anonymen Klasse festlegen
         item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               liste.setDropMode(dropMode[n]);
            }
         });
// MenueItem zu der RadioGroup-Komponente hinzufügen
         radiogroup.add(item);  
      }
// das so erstellte Menü returnieren 
      return menueDropMode;
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramefuerJListTransferHandlermitDropLocation frame =  
         new JFramefuerJListTransferHandlermitDropLocation();
   }
}
