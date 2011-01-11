import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
public class JFramemitUIDefaultsTreeModelundLookAndFeel 
   extends JFrame implements ActionListener, TreeModelListener {
   private JTree tree = new JTree();
   private UIDefaultsTreeModelundLookAndFeel model; 
   private static JToolBar toolBar = new JToolBar();
// Konstruktordefinition
   public JFramemitUIDefaultsTreeModelundLookAndFeel() {
      super("Die UIDefaults-Tabelle");
      setBounds(20,20,300,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Verfügbare LookAndFeels lesen
      UIManager.LookAndFeelInfo[] plafs = 
        UIManager.getInstalledLookAndFeels();
// JToolBar-Einträge mit dem Namen der PLAFs erstellen 
      for(int i=0; i<plafs.length; i++) {
         JButton button = new JButton(plafs[i].getName());
         button.setActionCommand(plafs[i].getClassName());
         button.addActionListener(this);
         toolBar.add(button);
      } 
// Eine TreeModel-Instanz vom Typ der Klasse 
// UIDefaultsTreeModelundLookAndFeel erzeugen und die Methode 
// für das Abändern der Datenstruktur aufrufen
      model = new UIDefaultsTreeModelundLookAndFeel();
      model.uiDefaultsUpdate(UIManager.getDefaults());
// Den TreeModelListener für das Modell registrieren
      model.addTreeModelListener(this);
// und das Modell für eine JTree-Komponente setzen
      tree.setModel(model);      
      JScrollPane jsPane = new JScrollPane(tree);
      add(toolBar,BorderLayout.NORTH);
      add(jsPane,BorderLayout.CENTER);      
      setVisible(true);
   }
// Die Methode des ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
      try {
         final String plafsClassName = e.getActionCommand();
         UIManager.setLookAndFeel(plafsClassName);
// Jede im Fenster angezeigte Komponente soll ihr LookAndFeel 
// ändern
         SwingUtilities.updateComponentTreeUI(this);
// Die Methode zum Ändern der Datenstruktur des Modells aufrufen
         model.uiDefaultsUpdate(UIManager.getDefaults());
         tree.scrollPathToVisible(new TreePath(model.getRoot()));
      }   
      catch(Exception ex) {
         System.out.println(ex);
      }
   }
// Methoden von TreeModelListener implementieren
   public void treeNodesInserted(TreeModelEvent e) {
     System.out.println("Im Modell wurde ein Knoten eingefuegt");
   }
   public void treeNodesChanged(TreeModelEvent e) {
     System.out.println("Im Modell wurde ein Knoten veraendert");
   }
   public void treeNodesRemoved(TreeModelEvent e) {
     System.out.println("Im Model wurde ein Knoten geloescht");
   }   
   public void treeStructureChanged(TreeModelEvent e) {
     System.out.println("Das Modell wurde abgeaendert");
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitUIDefaultsTreeModelundLookAndFeel frame = 
        new JFramemitUIDefaultsTreeModelundLookAndFeel();
   }
}
