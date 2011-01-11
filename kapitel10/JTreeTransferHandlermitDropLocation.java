import javax.swing.*;import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.*;
public class JTreeTransferHandlermitDropLocation 
                                       extends TransferHandler {
   private JTree tree;
   private DefaultTreeModel model;
// Konstruktordefinition
   JTreeTransferHandlermitDropLocation(JTree tree) {
      this.tree = tree;
// Das Modell der im Konstruktor übergebenen JTree-Komponente
// ermitteln
      model = (DefaultTreeModel)tree.getModel();
   }
// Die Methoden der Klasse TransferHandler überschreiben.
// Die Methode definiert, was, wann und wohin transferiert 
// werden kann, und gibt true zurück wenn ein Transfer positiv 
// quitiert werden soll 
   public boolean canImport(TransferHandler.
                            TransferSupport support) {
      if(!support.isDataFlavorSupported(DataFlavor.stringFlavor)
        || !support.isDrop()) {
         return false;
      }
      JTree.DropLocation dropLocation =
        (JTree.DropLocation)support.getDropLocation();
      return dropLocation.getPath()!= null;
   }
// Die Methode liest die zu transferierenden Daten aus der 
// Zwischenablage und speichert diese, je nach definiertem Drop-
// Modus und anhand des selektierten Knoten 
   public boolean importData(TransferHandler.
                             TransferSupport support) {
      if(!canImport(support)) {
         return false;
      }
      JTree.DropLocation dropLocation =
        (JTree.DropLocation)support.getDropLocation();
      Transferable trans = support.getTransferable();
      String string;
      try {
         string = (String)trans.getTransferData(
           DataFlavor.stringFlavor);
      } 
      catch(Exception e) {
         e.printStackTrace();
         return false;
      }
// Mit den Methoden getPath() und getindex() der Klasse 
// JTree.DropLocation den Pfad und Index des selektierten Knotens 
// ermitteln
      TreePath path = dropLocation.getPath(); 
         int index = dropLocation.getChildIndex();
         if(index == -1) {
            index = model.getChildCount(
              path.getLastPathComponent());
         }
// und einen neuen Knoten zu der JTree-Komponente je nach 
// ausgewähltem Drop-Modus hinzufügen
         DefaultMutableTreeNode newNode = 
           new DefaultMutableTreeNode(string);
         DefaultMutableTreeNode parentNode = 
           (DefaultMutableTreeNode)path.getLastPathComponent();
         model.insertNodeInto(newNode, parentNode, index);
// Die Anzeige aktualisieren
         TreePath newPath = path.pathByAddingChild(newNode);
         tree.makeVisible(newPath);
         tree.scrollRectToVisible(tree.getPathBounds(newPath));
         return true;
    }
}
