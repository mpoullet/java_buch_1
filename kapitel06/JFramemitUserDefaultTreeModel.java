import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.*;
import javax.swing.event.*;
public class JFramemitUserDefaultTreeModel extends JFrame 
                   implements ActionListener, TreeModelListener, 
                     TreeSelectionListener {
   private JTree tree;
   private UserDefaultTreeModel modell;
   private MutableTreeNode gliederung, stufe1; 
   private DefaultMutableTreeNode stufe;
   private JButton[] b = new JButton[2];
   private JPanel p = new JPanel();
   private String [] sButton = {"Hinzufuegen", "Entfernen"};
   private JLabel message = new JLabel("");
// Konstruktordefinition
   public JFramemitUserDefaultTreeModel () {
      super("Hinzufügen und Entfernen von Knoten einer "
        + "Baumstruktur");
      setBounds(20,20,250,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container cPanel = getContentPane();
      cPanel.setLayout(new BorderLayout());
      for(int i=0; i<2; i++) {
         b[i] = new JButton(sButton[i]);
         p.add(b[i]);
         b[i].addActionListener(this);
      } 
// Die Wurzel für eine Baumstruktur definieren
      gliederung = new DefaultMutableTreeNode("Gliederung"); 
// Ein TreeModel, in welchem jeder Knoten Kindkomponenten
// besitzen kann, erzeugen 
      modell = new UserDefaultTreeModel(gliederung);
// Den ersten Knoten erzeugen und zum Modell hinzufügen
      stufe1 = new DefaultMutableTreeNode (" 1");
      modell.insertNodeInto(stufe1,gliederung, 
      gliederung.getChildCount());
// Mit Hilfe des Modells eine JTree-Komponente erzeugen und 
// diese zu einer JScrollPane-Komponente hinzufügen
      tree = new JTree(modell);
      JScrollPane jsPane = new JScrollPane(tree);
// Den TreeListener für das Modell und 
// den TreeSelectionListener für die Komponente registrieren
      modell.addTreeModelListener(this);
      tree.addTreeSelectionListener(this);
// Die Komponenten zum Fenster hinzufügen
      cPanel.add(jsPane, BorderLayout.CENTER);
      cPanel.add(p, BorderLayout.SOUTH);
      cPanel.add(message, BorderLayout.NORTH);
      setVisible(true);
   }
// Die Methoden des TreeModelListener implementieren
   public void treeNodesInserted(TreeModelEvent e) {
      message.setText("Ein neuer Knoten wurde hinzugefügt");
   }
   public void treeNodesChanged(TreeModelEvent e) {};
   public void treeNodesRemoved(TreeModelEvent e) {
      message.setText("Ein Knoten wurde gelöscht");

   }   
   public void treeStructureChanged(TreeModelEvent e) {};
// Die Methode des TreeSelectionListener implementieren
   public void valueChanged(TreeSelectionEvent e) {
      System.out.println("Ein Knoten wurde selektiert");
   }
// Die Methode des ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
// Den ausgewählten Pfad mit der Methode des Interface 
// TreeSelectionModel lesen
      TreePath treePath = tree.getSelectionPath(); 
      if(treePath != null) {
// Ermitteln des selektierten Knoten 
         stufe = (DefaultMutableTreeNode)treePath.
           getLastPathComponent(); 
// Der Button "Hinzufuegen" wurde gedrückt
         if(e.getActionCommand().equals("Hinzufuegen")) {
// Den Namen der ausgewählten und hinzuzufügenden Komponente 
// ermitteln
            int n = 0;
            String name = stufe.toString();
// Ist der Knoten kein Blatt, besitzt er Kindkomponenten und 
// kann eine weitere Komponente hinzugefügt bekommen
            if(!stufe.isLeaf()) {
               name = stufe.getLastChild().toString();
               String s = name.substring(name.length()-1);
               name = name.substring(0,(name.length()-1));
               n = Integer.parseInt(s.trim());
            }
// ist er ein Blatt, bekommt er eine erste Komponente hinzugefügt
            DefaultMutableTreeNode neueStufe =
              new DefaultMutableTreeNode(name+(n+1));
// Das Hinzufügen von Knoten über die Methode insert() der Klasse 
// DefaultMutableTreeNode durchführen
            stufe.insert(neueStufe, stufe.getChildCount());
// Die Listener des Modells benachrichtigen
            modell.fireTreeNodesInserted(modell, 
              modell.getPathToRoot(stufe), new int [] {
                stufe.getChildCount()-1}, 
                  new DefaultMutableTreeNode[] {neueStufe});
// Aktualisieren der Anzeige
            tree.scrollPathToVisible(new 
              TreePath(neueStufe.getPath()));
         }
// Der Button "Entfernen" wurde gedrückt
         else {
            if(stufe != gliederung) {
// Pfad der Vaterkomponente für die Anzeige sichern
               DefaultMutableTreeNode vorigeStufe = 
                 (DefaultMutableTreeNode)stufe.getParent();
               TreeNode[] pfadName = 
                 modell.getPathToRoot(vorigeStufe);
// Index des Knoten festhalten
               int index = vorigeStufe.getIndex(stufe);
// Das Entfernen von Knoten über die Methode remove() der Klasse 
// DefaultMutableTreeNode durchführen
               vorigeStufe.remove(stufe);
// Die Listener des Modells benachrichtigen
               modell.fireTreeNodesRemoved(modell,
                 modell.getPathToRoot(vorigeStufe), 
                   new int [] {index}, 
                     new DefaultMutableTreeNode[] {stufe});   
// Aktualisieren der Anzeige
               tree.setSelectionPath(new
                  TreePath(pfadName));
            }
         }   
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitUserDefaultTreeModel frame = 
        new JFramemitUserDefaultTreeModel();
   }
}
