import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
public class BaumStruktur {
   public JTree tree;
   public DefaultMutableTreeNode schule, klasse, schueler;
// Konstruktordefinition
   public BaumStruktur() {   
// Wurzel, Knoten und Blätter der Baumstruktur definieren
      schule = new DefaultMutableTreeNode("Schule"); 
      for(int i=0; i<2; i++) {
         klasse = new DefaultMutableTreeNode("Klasse " + (i+1));
         schule.add(klasse);
         for(int j=0; j<2; j++) {
            schueler = new DefaultMutableTreeNode("Schueler "
              + (i+1) + (j+1));
            klasse.add(schueler);
         }
      }
      tree = new JTree(schule);
   }
}
