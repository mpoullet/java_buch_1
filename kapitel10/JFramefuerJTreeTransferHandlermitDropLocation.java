import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
public class JFramefuerJTreeTransferHandlermitDropLocation 
                                               extends JFrame {
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
   private JTextArea textArea = new JTextArea("Java lernen");
   private JMenuBar menueBar = new JMenuBar();
   private BaumStruktur schule = 
     new BaumStruktur();
// Konstruktordefinition
   public JFramefuerJTreeTransferHandlermitDropLocation() {
      super("Benutzerdefinierte Transfer-Handler");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JMenu menue = defmenueDropMode(); 
      menueBar.add(menue);                  
// MenueBar für die Auswahl der Drop-Modi im Fenster einrichten
      setJMenuBar(menueBar);
// Die Drag-Fähigkeit für die Komponenten einschalten
      textArea.setDragEnabled(true);
      schule.tree.setDragEnabled(true);
// Eine Instanz der Klasse JTreeTransferHandlermitDropLocation 
// der JTree-Komponente zuweisen 
      JTreeTransferHandlermitDropLocation transHandler = 
        new JTreeTransferHandlermitDropLocation(schule.tree);
      schule.tree.setTransferHandler(transHandler);
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("JTextArea: "));
      add(textArea);
      add(new JLabel("JTree: "));
      add(schule.tree);
      setSize(350,200);
      setVisible(true);
   }
// Die Methode returniert eine JMenu-Komponente für die Auswahl 
// der Drop-Modi
   public JMenu defmenueDropMode() {
// JMenu-Komponente instantiieren
      JMenu menueDropMode = new JMenu("DropMode");
// ButtonGroup für das Ausschließen von Menüeinträgen erzeugen
      ButtonGroup radiogroup = new ButtonGroup();  
// Menüeintrag erstellen
      for(int i = 0; i < name.length; i++) {
         JMenuItem item = menueDropMode.add(
           new JRadioButtonMenuItem(name[i]));
         final int n = i;
// Aktionen, die bei der Auswahl eines Menüeintrags durchgeführt 
// werden, mittels einer anonymen Klasse festlegen
         item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               schule.tree.setDropMode(dropMode[n]);
            }
         });
// MenueItem zu der RadioGroup-Komponente hinzufügen 
         radiogroup.add(item);  
      }
// und das so erstellte Menü returnieren 
      return menueDropMode;
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramefuerJTreeTransferHandlermitDropLocation frame =  
        new JFramefuerJTreeTransferHandlermitDropLocation();
   }
}
