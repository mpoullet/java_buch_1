import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JFramemitJListTransferHandler extends JFrame 
                                              implements Texte {
   private JTextArea textArea = new JTextArea(
     "Die\nVersion\nlernen",3,3);
   private DefaultListModel listModel = new DefaultListModel(); 
   private JList liste;
// Konstruktordefinition
   public JFramemitJListTransferHandler() {
      super("Benutzerdefinierte Transfer-Handler");
      for(int i=0; i<text1.length; i++) {
         listModel.add(i,text1[i]);
      }
// Die Liste wird über ein Modell vom Typ der Klasse 
// DefaultListModel erzeugt 
      liste = new JList(listModel);
// und es ist keine mehrfache Selektion von Elementen erlaubt
      liste.setSelectionMode(ListSelectionModel.
        SINGLE_INTERVAL_SELECTION);
//  Die Drag-Fähigkeit für die Komponenten einschalten
      textArea.setDragEnabled(true);
      liste.setDragEnabled(true);
// Eine Instanz der Klasse JListTransferHandler der JList-
// Komponente zuweisen 
      JListTransferHandler transHandler = 
        new JListTransferHandler();
      liste.setTransferHandler(transHandler);
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("JTextArea: "));
      add(textArea);
      add(new JLabel("JList: "));
      add(liste);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setSize(300,150);
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitJListTransferHandler frame = 
        new JFramemitJListTransferHandler();
   }
}
