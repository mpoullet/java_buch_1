import javax.swing.tree.*;
import javax.swing.*;
import java.util.*;
public class JFramemitJTree extends JFrame {
   private JTree tree;
   private DefaultMutableTreeNode gliederung, stufe1, stufe2, 
     stufe3;
// Konstruktordefinition
   public JFramemitJTree() {
      super("Definition einer Baumstruktur");
      setBounds(20,20,200,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Wurzel, Knoten und Blätter der Baumstruktur definieren
      gliederung = new DefaultMutableTreeNode("Gliederung"); 
      for(int i=0; i<2; i++) {
         stufe1 = new DefaultMutableTreeNode(" " + (i+1));
         gliederung.add(stufe1);
         for(int j=0; j<2; j++) {
            stufe2 = new DefaultMutableTreeNode(" "
              + (i+1) + (j+1));
            stufe1.add(stufe2);
            for(int k=0; k<3; k++) {
               stufe3 = new DefaultMutableTreeNode(" " 
                 + (i+1) + (j+1) + (k+1));
               stufe2.add(stufe3);
            }
         }
      }
// Baumstruktur erzeugen und zu einer ScrollPane hinzufügen
      tree = new JTree(gliederung);
      JScrollPane jsPane = new JScrollPane(tree);
      getContentPane().add(jsPane);      
      setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTree frame = new JFramemitJTree();
   }
}
