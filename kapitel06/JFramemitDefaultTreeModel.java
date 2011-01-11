import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.*;
import javax.swing.event.*;
public class JFramemitDefaultTreeModel extends JFrame implements
      ActionListener, TreeModelListener, TreeSelectionListener {
   private JTree tree = new JTree();
   private DefaultTreeModel modell;
   private MutableTreeNode gliederung, stufe1; 
   private DefaultMutableTreeNode stufe;
   private JButton[] b = new JButton[2];
   private JPanel p = new JPanel();
   private String [] sButton = {"Hinzufuegen", "Entfernen"};
   private JLabel message = new JLabel("");
// Konstruktordefinition
   public JFramemitDefaultTreeModel() {
      super("Hinzuf�gen und Entfernen von Knoten einer "
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
// Die Wurzel f�r eine Baumstruktur definieren
      gliederung = new DefaultMutableTreeNode("Gliederung"); 
// Ein TreeModel, in welchem jeder Knoten Kindkomponenten 
// besitzen kann, erzeugen 
      modell = new DefaultTreeModel(gliederung);
// Den ersten Knoten erzeugen und zum Modell hinzuf�gen
      stufe1 = new DefaultMutableTreeNode (" 1");
      modell.insertNodeInto(stufe1, gliederung,
        gliederung.getChildCount());
// Das Modell f�r die JTree-Komponente setzen und diese zu einer
// JScrollPane-Komponente hinzuf�gen
      tree.setModel(modell);
      JScrollPane jsPane = new JScrollPane(tree);
// TreeListener f�r das Modell und 
// TreeSelectionListener f�r die Komponente registrieren
      modell.addTreeModelListener(this);
      tree.addTreeSelectionListener(this);
// Komponenten zum Fenster hinzuf�gen
      cPanel.add(jsPane, BorderLayout.CENTER);
      cPanel.add(p, BorderLayout.SOUTH);
      cPanel.add(message, BorderLayout.NORTH);
      setVisible(true);
   }
// Die Methoden des TreeModelListener implementieren
   public void treeNodesInserted(TreeModelEvent e) {
      message.setText("Ein neuer Knoten wurde hinzugef�gt");
   }
   public void treeNodesChanged(TreeModelEvent e) {};
   public void treeNodesRemoved(TreeModelEvent e) {
      message.setText("Ein Knoten wurde gel�scht");
   }   
   public void treeStructureChanged(TreeModelEvent e) {};
// Die Methode des TreeSelectionListener implementieren
   public void valueChanged(TreeSelectionEvent e) {
      System.out.println("Ein Knoten wurde selektiert");
   }
// Die Methode des ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
// Den ausgew�hlten Pfad mit der Methode des Interface 
// TreeSelectionModel lesen
      TreePath treePath = tree.getSelectionPath(); 
      if(treePath != null) {
// Ermitteln des selektierten Knoten 
         stufe = (DefaultMutableTreeNode)treePath.
           getLastPathComponent(); 
// Der Button "Hinzufuegen" wurde gedr�ckt
         if(e.getActionCommand().equals("Hinzufuegen")) {
// Den Namen der ausgew�hlten und hinzuzuf�genden Komponente 
// ermitteln
            int n = 0;
            String name = stufe.toString();
// Ist der Knoten kein Blatt, besitzt er Kindkomponenten und 
// kann eine weitere Komponente hinzugef�gt bekommen
            if(!stufe.isLeaf()) {
               name = stufe.getLastChild().toString();
               String s = name.substring(name.length()-1);
               name = name.substring(0,(name.length()-1));
               n = Integer.parseInt(s.trim());
            }
// ist er ein Blatt, bekommt er eine erste Komponente
// hinzugef�gt
            DefaultMutableTreeNode neueStufe =
              new DefaultMutableTreeNode(name+(n+1));
// �nderungen �ber das Modell mit einer Methode der Klasse 
// DefaultTreeModel durchf�hren
            modell.insertNodeInto(neueStufe, stufe, 
              stufe.getChildCount());
// �ber die Methoden der Klasse DefaultMutableTreeNode
// durchgef�hrte �nderungen werden in der JTree-Komponente 
// nicht angezeigt
         // stufe.insert(neueStufe, stufe.getChildCount()); 
// Aktualisieren der Anzeige
            tree.scrollPathToVisible(new TreePath(neueStufe.
              getPath()));
         }
// Der Button "Entfernen" wurde gedr�ckt
         else {
            if(stufe != gliederung) {
// Pfad der Vaterkomponente f�r die Anzeige sichern
               TreeNode vorigeStufe = 
                  stufe.getPreviousNode();
               TreeNode[] pfadName = 
               modell.getPathToRoot(vorigeStufe);
// Knoten Entfernen
               modell.removeNodeFromParent(stufe);
// Aktualisieren der Anzeige
               tree.setSelectionPath(new 
                  TreePath(pfadName));
            }
         }   
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitDefaultTreeModel frame = 
        new JFramemitDefaultTreeModel();
   }
}
