import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
public class JListTransferHandler extends TransferHandler {
// Der Index eines selektierten Listenelementes wird in einer 
// globalen int-Variablen gespeichert, damit dieses, im Falle 
// einer MOVE-Operation gelöscht werden kann 
   private int index = 0;
// Das zugelassene Datenformat für diesen TransferHandler ist: 
// DataFlavor.stringFlavor
   private static final DataFlavor flavors[] = {
     DataFlavor.stringFlavor};
// Die Methoden der Klasse TransferHandler überschreiben
// Ein Transferable-Objekt erzeugen, welches genutzt wird, um die
// Daten der im Methodenaufruf referenzierten Komponente zu 
// übertragen
   public Transferable createTransferable(JComponent c) {
      JList liste = (JList)c;
      index = liste.getSelectedIndex();
      Object value = liste.getSelectedValue();
      return new StringSelection(value.toString());
   }
// Die Methode returniert den Typ der Transferoperation
   public int getSourceActions(JComponent c) {
      return COPY_OR_MOVE;
   }
// Die Methode führt ein Datentransfer von einem Transferable-
// Objekt zu der spezifizierten Komponente durch    
   public boolean importData(JComponent c, Transferable trans) {
      if(c instanceof JList) {  
         JList liste = (JList)c;
         DefaultListModel listModel = 
           (DefaultListModel)liste.getModel();
         try {
// Importierte Strings werden in der Liste eingefügt
            String string = (String)trans.getTransferData(
              DataFlavor.stringFlavor);
            index = liste.getSelectedIndex();
// Wurde kein Listenelement selektiert, wird der importierte 
// String am Anfang der Liste eingefügt
            if(index == -1)
               listModel.insertElementAt(string,0);
            else
               listModel.insertElementAt(string,index);
            return true;
         }
         catch (Exception e) {
            e.printStackTrace();
         }
      }   
      return false;
   }    
// Nachdem die Drop-Operation erfolgreich beendet wurde, 
// muss im Fall einer MOVE-Operation das selektierte Element 
// der Liste gelöscht werden; im Fall einer COPY-Operation wird 
// die Liste nicht abgeändert 
   public void exportDone(JComponent c, Transferable data, 
                          int action) {
      if(action == MOVE) {
         JList liste = (JList)c;
         DefaultListModel model = (DefaultListModel)liste.
           getModel();
         model.remove(index);
      }
   }
// Die Methode spezifiziert das zugelassene Datenformat für die 
// Daten, welche von der Komponente importiert werden können, 
// für Strings ist es der der Typ DataFlavor.stringFlavor
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
