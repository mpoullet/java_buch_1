import javax.swing.*;
import javax.swing.event.*;
public class JFramefuerUIDefaultsTreeModelmitTreeModelListener 
                   extends JFrame implements TreeModelListener {
   private JTree tree = new JTree();
   private UIDefaultsTreeModelmitTreeModelListener model;
// Konstruktordefinition
   public JFramefuerUIDefaultsTreeModelmitTreeModelListener() {
      super("Die UIDefaults-Tabelle");
      setBounds(20,20,300,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      model = new UIDefaultsTreeModelmitTreeModelListener();
// TreeListener für das Modell registrieren
      model.addTreeModelListener(this);
// Baumstruktur erzeugen und einer ScrollPane hinzufügen
      model.uiDefaultsDefTreeModel(UIManager.getDefaults());
      tree.setModel(model);   
      JScrollPane jsPane = new JScrollPane(tree);
      add(jsPane);
      setVisible(true);
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
      JFramefuerUIDefaultsTreeModelmitTreeModelListener frame =
        new JFramefuerUIDefaultsTreeModelmitTreeModelListener();
   }
}
