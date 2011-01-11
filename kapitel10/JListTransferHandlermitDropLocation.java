import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.*;
public class JListTransferHandlermitDropLocation 
                      extends TransferHandler implements Texte {
   private JList liste;
   private DefaultListModel model;
// Konstruktordefinition
   JListTransferHandlermitDropLocation(JList liste) {
      this.liste = liste;
      model = (DefaultListModel)liste.getModel();
   }
// Die Methode definiert, was, wann und wohin und transferiert 
// werden kann, und gibt true zurück, wenn ein Transfer positiv 
// quitiert werden soll 
   public boolean canImport(TransferHandler.
                            TransferSupport support) {
      if(!support.isDataFlavorSupported(DataFlavor.stringFlavor)
        || !support.isDrop()) {
         return false;
      }
      return true;
   }
// Die Methoden der Klasse TransferHandler überschreiben.
// Die Methode liest die zu transferierenden Daten aus der 
// Zwischenablage und speichert diese je nach definiertem Drop-
// Modus und anhand des selektierten Listenelementes 
   public boolean importData(TransferHandler.
                             TransferSupport support) {
      if(!canImport(support)) {
         return false;
      }
      JList.DropLocation dropLocation = 
        (JList.DropLocation)support.getDropLocation();
      Transferable trans = support.getTransferable();
      String string;
      try {
         string = (String)trans.getTransferData(
           DataFlavor.stringFlavor);
      } 
      catch (Exception e) {
         e.printStackTrace();
         return false;
      }
// Die Methode getIndex() der Klasse JList.DropLocation liefert
// den Index des selektierten Listenelementes 
      int index = dropLocation.getIndex();
      model.insertElementAt(string,index);
      return true;
   }
}
