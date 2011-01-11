import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import java.awt.event.*;
public class JFramemitClipBoard extends JFrame {
   private Clipboard clipboard; 
   private JTextArea textArea1 = new JTextArea("Java ",3,3);
   private JTextArea textArea2 = new JTextArea("lernen",3,3);
   private JMenuBar menueBar = new JMenuBar();
// Konstruktordefinition
   public JFramemitClipBoard() {
      super("Die Klassen Clipboard, StringSelection und "
        + "DataFlavor");
      clipboard = Toolkit.getDefaultToolkit().
        getSystemClipboard();
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("TextArea1: "));
      add(textArea1);
      add(new JLabel("TextArea2: "));
      add(textArea2);
// MenuBar für die Auswahl der Bearbeitungsvorgänge im Fenster 
// einrichten
      setJMenuBar(menueBar);
// Ein Menü mit allen verfügbaren Bearbeitungsvorgängen erzeugen
// und zu der Menüleiste hinzufügen
      JMenu menue = defmenueEdit(); 
      menueBar.add(menue);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setSize(350,125);
   }
// Instanzmethode, die eine JMenue-Komponente erzeugt
   public JMenu defmenueEdit() {
      String[] name = {"Copy", "Cut", "Paste"};
      ImageIcon[]icon = {new ImageIcon("copy.gif"), 
        new ImageIcon("cut.gif"), new ImageIcon("paste.gif")};
// JMenu-Komponente instantiieren
      JMenu menueEdit = new JMenu("Edit");
// ButtonGroup für das Ausschließen von Menueeinträgen erzeugen
      ButtonGroup radiogroup = new ButtonGroup();  
// Menüeintrag als JRadioButtonMenuItem-Komponente erzeugen
      for(int i=0; i<name.length; i++) {
         JMenuItem item = menueEdit.add( 
           new JRadioButtonMenuItem(name[i],icon[i]));
// Aktionen, die bei der Auswahl eines Menüeintrags durchgeführt 
// werden, über die Definition einer anonymen Klasse festlegen
         item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               try {                  
                  if(ae.getActionCommand().equals("Paste")) {
// Daten aus der Zwischenablage lesen 
                  Transferable trans = 
                    clipboard.getContents(clipboard);
// und die Daten auswerten; das Datenformat ist vom Typ der Klasse 
// DataFlavor
                  DataFlavor[] flavors = 
                    trans.getTransferDataFlavors();
// Alle Datenformate anzeigen
                  for(int i=0; i<flavors.length; i++) 
                     System.out.println("Datenformate aus der "
                       + "Zwischenablage: " + flavors[i].
                         getMimeType() + "*" + flavors.length);
// und nur Daten vom Typ DataFlavor.stringFlavor zu der zweiten 
// JTextArea-Komponente an Position 0 hinzufügen
                     String str = trans.getTransferData(
                     DataFlavor.stringFlavor).toString();
                     textArea2.insert(str,0);        
                  }
                  else {
// Den aus textArea1 gelesenen Text in die Zwischenablage des 
// Systems legen
                     StringSelection strSelection = 
                       new StringSelection(textArea1.getText());
                     clipboard.setContents(strSelection,
                       strSelection);
                     if(ae.getActionCommand().equals(
                       "Cut")) 
// Den Inahlt der TextArea löschen
                     textArea1.setText("");
                  }
               }
               catch(Exception ex) {
                  System.err.println(ex);
               }
            }
         });
// MenueItem zu der radioGroup-Komponente hinzufügen
         radiogroup.add(item);  
      }
// das so erstellte Menue returnieren 
      return menueEdit;
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitClipBoard frame = new JFramemitClipBoard();
   }
}
