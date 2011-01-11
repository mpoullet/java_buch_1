import javax.swing.*;import javax.swing.tree.*;
import javax.swing.event.*;
public class UserDefaultTreeModel extends DefaultTreeModel { 
// Definition der Listener für das benutzerdefinierte Modell
   private EventListenerList listenerList = 
     new EventListenerList();
// Konstruktordefinition
    public UserDefaultTreeModel(TreeNode treeNode) {
      super(treeNode);
   }
// Methode zum Ermitteln der in einer Liste vom Typ 
// ListenerList abgelegten Listener
   public TreeModelListener [] getTreeModelListeners() {
      return (TreeModelListener []) 
        listenerList.getListeners(TreeModelListener.class);
   }
// Die Methoden der Oberklasse überschreiben
   public void fireTreeNodesInserted(Object source, 
          Object[] path, int[] childIndices, Object[] children) {
      TreeModelEvent event = new TreeModelEvent(source, path, 
        childIndices, children); 
      TreeModelListener[] listeners = getTreeModelListeners(); 
      for(int i=listeners.length-1; i>=0; --i) { 
         listeners[i].treeNodesInserted(event); 
      }
   } 
   public void fireTreeNodesRemoved(Object source, Object[] path,
                         int[] childIndices, Object[] children) {
      TreeModelEvent event = new TreeModelEvent(source, path,
        childIndices, children); 
      TreeModelListener[] listeners = getTreeModelListeners(); 
      for(int i=listeners.length-1; i>=0; --i) 
         listeners[i].treeNodesRemoved(event); 
   } 
   public void addTreeModelListener(TreeModelListener l) {
      listenerList.add(TreeModelListener.class,l);
   }
   public void removeTreeModelListener(TreeModelListener l) {
      listenerList.remove(TreeModelListener.class,l);
   }
}
