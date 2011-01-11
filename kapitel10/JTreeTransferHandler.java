import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.*;
public class JTreeTransferHandler extends TransferHandler {
// Die Referenz eines selektierten Knoten wird �ber eine globale 
// Refernzvariable festgehalten, damit dieser im Falle einer 
// MOVE-Operation gel�scht werden kann 
   private DefaultMutableTreeNode node;
// Das zugelassene Datenformat f�r diesen TransferHandler ist 
// DataFlavor.stringFlavor
   private static final DataFlavor flavors[] = {
     DataFlavor.stringFlavor};
// Die Methoden der Klasse TransferHandler �berschreiben
// Ein Transferable-Objekt erzeugen, das genutzt wird, um die 
// Daten der im Methodenaufruf referenzierten Komponente zu 
// �bertragen    
   public Transferable createTransferable(JComponent c) {
        JTree tree = (JTree)c;
// Ermitteln der selektierten Komponente
        Object value = tree.getLastSelectedPathComponent();
// Ermitteln des selektierten Pfades
        TreePath treePath = tree.getSelectionPath(); 
        if(treePath != null)
// Ermitteln des selektierten Knotens 
            node = (DefaultMutableTreeNode)treePath.
               getLastPathComponent(); 
        return new StringSelection(value.toString());
   }
// Den Typ der Transferoperation zur�ckgeben
   public int getSourceActions(JComponent c) {
      return COPY_OR_MOVE;
   }
// Ein Datentransfer von einem Transferable-Objekt zu der 
// spezifizierten Komponente durchf�hren
   public boolean importData(JComponent c, Transferable trans) {
      if(c instanceof JTree) {  
         JTree tree = (JTree)c;
         DefaultTreeModel model = (DefaultTreeModel)tree.
           getModel();
         try {
// Importierte Strings werden in einen Knoten vom Typ der Klasse
// DefaultMutableTreeNode umgesetzt
            String string = (String)trans.
              getTransferData(DataFlavor.stringFlavor);
            DefaultMutableTreeNode newNode = 
              new DefaultMutableTreeNode(string);
// Den Wurzel-Knoten der Komponente ermitteln
            DefaultMutableTreeNode parentNode =
              (DefaultMutableTreeNode)model.getRoot();
// und den neuen Knoten an Position 0 einf�gen
            model.insertNodeInto(newNode, parentNode, 0);
// Die Anzeige aktualisieren
            TreePath newPath = tree.getSelectionPath();
            tree.makeVisible(newPath);
            tree.scrollRectToVisible(tree.
              getPathBounds(newPath));
            return true;
         }
         catch(Exception e) {
            e.printStackTrace();
         }
      }
      return false;
   }
// Die Methode exportDone() wird aufgerufen, nachdem die Daten 
// exportiert wurden; nachdem die Drop-Operation erfolgreich 
// beendet wurde, muss im Fall einer MOVE-Operation der 
// selektierte Knoten gel�scht werden, im Falle einer COPY-
// Operation wird die JTree-Komponente nicht abge�ndert 
   public void exportDone(JComponent c, Transferable data, 
                          int action) {
      if(action == MOVE) {
         JTree tree = (JTree)c;
         DefaultTreeModel model = (DefaultTreeModel)tree.
           getModel();
         TreeNode previousNode = node.getPreviousNode();
         TreeNode[] pathtoRoot = model.
           getPathToRoot(previousNode);
// Knoten im Pafd l�schen
         model.removeNodeFromParent(node);
// und die Anzeige aktualisieren
         tree.setSelectionPath(new TreePath(pathtoRoot));
      }
   }
// Die Methode canImport() spezifiziert das zugelassene 
// Datenformat f�r die Daten welche von der Komponente importiert
// werden k�nnen, f�r diesen TransferHandler ist es der Typ 
// DataFlavor.stringFlavor    
   public boolean canImport(JComponent c, DataFlavor flavors[]) {
      for(int i=0; i<flavors.length; i++) {
         for(int j=0; j<this.flavors.length; j++) {
            if(flavors[i].equals(this.flavors[j])) {
               return true;
            }
         }
      }
      return false;
   }
}
