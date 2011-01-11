import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
public class UIDefaultsTreeModelmitTreeModelListener 
                                          implements TreeModel {
   private DefaultTreeModel treeModel;
   private EventListenerList listenerList = 
     new EventListenerList();
   private DefaultMutableTreeNode wurzelKnoten = 
     new DefaultMutableTreeNode(
       "UIDefaults Werte fuer Komponenten");
   private DefaultMutableTreeNode treeKnoten = 
     new DefaultMutableTreeNode(
       "Eigenschaften von JTree-Komponenten");
   private DefaultMutableTreeNode buttonKnoten = 
     new DefaultMutableTreeNode(
       "Eigenschaften von JButton-Komponenten");
   private DefaultMutableTreeNode listKnoten = 
     new DefaultMutableTreeNode(
       "Eigenschaften von JList-Komponenten");
// Konstruktordefinition
   public UIDefaultsTreeModelmitTreeModelListener() {
      treeModel = new DefaultTreeModel(wurzelKnoten);
      treeModel.insertNodeInto(buttonKnoten, wurzelKnoten, 0);
      treeModel.insertNodeInto(listKnoten, wurzelKnoten, 1);
      treeModel.insertNodeInto(treeKnoten, wurzelKnoten, 2);
   }
// Die Werte der UIDefaults-Tabelle als Knoten in das Modell 
// einfügen und alle Listener der Klasse mittels Aufruf von 
// firexxx Methoden darüber informieren
   public void uiDefaultsDefTreeModel(UIDefaults defaults) {
      Enumeration keys = defaults.keys();
      Object keyName;
      Object valueForKey;
      while(keys.hasMoreElements()) {
         DefaultMutableTreeNode newKeyNode;
         DefaultMutableTreeNode newValueNode;
         keyName = keys.nextElement();
         valueForKey = defaults.get(keyName);
         newKeyNode = new DefaultMutableTreeNode(keyName);
         newValueNode = new DefaultMutableTreeNode(valueForKey);
         String s = new String(); 
         String s1 = keyName.toString();
         if(s1.indexOf(".") > 0) {
            s = s1.substring(0,s1.indexOf("."));
            if(s.equals("Button")) {
               treeModel.insertNodeInto(
                 newKeyNode, buttonKnoten, 0);
               fireTreeNodesInserted(buttonKnoten, treeModel.
                 getPathToRoot(buttonKnoten), new int [] {0}, 
                   new DefaultMutableTreeNode[] {newKeyNode});
            }
            else if(s.equals("List")) {
               treeModel.insertNodeInto(newKeyNode, 
                 listKnoten, 0);
               fireTreeNodesInserted(listKnoten, treeModel.
                 getPathToRoot(listKnoten), new int [] {0}, 
                   new DefaultMutableTreeNode[] {newKeyNode});
            }
            else if(s.equals("Tree")) {
               treeModel.insertNodeInto(newKeyNode, 
                 treeKnoten, 0);
               fireTreeNodesInserted(treeKnoten,treeModel.
                 getPathToRoot(treeKnoten), new int [] {0}, 
                   new DefaultMutableTreeNode[] {newKeyNode});
            }
            treeModel.insertNodeInto(newValueNode, 
              newKeyNode, 0);
            fireTreeNodesInserted(newKeyNode,treeModel.
              getPathToRoot(newKeyNode), new int [] {0}, 
                new DefaultMutableTreeNode[] {newValueNode});
         }
      }
   }
// Eine Methode für das Ermitteln der Listener vom Typ der Klasse 
// TreeModelListener aus der von dieser Klasse definierten Liste
// vom Typ EventListenerList
   public TreeModelListener [] getTreeModelListeners() {
      return (TreeModelListener [])listenerList.getListeners(
        TreeModelListener.class);
   }
// Das Modell definiert eigene Methoden zur Benachrichtigung der 
// Event-Listener
   public void fireTreeNodesInserted(Object source, 
          Object[] path, int[] childIndices, Object[] children) {
      TreeModelEvent event = new TreeModelEvent(source, path, 
        childIndices, children); 
      TreeModelListener[] listeners = getTreeModelListeners(); 
      for(int i=listeners.length-1; i>=0; i--) 
         listeners[i].treeNodesInserted(event); 
   } 
   public void fireTreeNodesChanged(Object source, 
          Object[] path, int[] childIndices, Object[] children) {
      TreeModelEvent event = new TreeModelEvent(source, path, 
        childIndices, children);
      TreeModelListener[] listeners = getTreeModelListeners(); 
      for(int i=listeners.length-1; i>=0; i--) 
         listeners[i].treeNodesChanged(event); 
   }
   public void fireTreeNodesRemoved(Object source, 
          Object[] path, int[] childIndices, Object[] children) {
      TreeModelEvent event = new TreeModelEvent(source, path, 
        childIndices, children); 
      TreeModelListener[] listeners = getTreeModelListeners(); 
      for(int i=listeners.length-1; i>=0; i--) 
         listeners[i].treeNodesRemoved(event); 
   }
// Die Methoden des Interface TreeModel implementieren
   public void addTreeModelListener(TreeModelListener l) {
      listenerList.add(TreeModelListener.class,l);
   }
   public void removeTreeModelListener(TreeModelListener l) {
      listenerList.remove(TreeModelListener.class,l);
   } 
// Alle anderen Methodenaufrufe des Interface TreeModel an das 
// interne Modell delegieren
   public Object getRoot() {
      return treeModel.getRoot();
   }
   public Object getChild(Object objekt1, int objekt2) {
      return treeModel.getChild(objekt1, objekt2);
   }
   public int getChildCount(Object objekt) {
      return treeModel.getChildCount(objekt);
   }
   public boolean isLeaf(Object objekt) {
      return treeModel.isLeaf(objekt);
   }
   public void valueForPathChanged(TreePath path, Object objekt){
      treeModel.valueForPathChanged(path, objekt);
   }
   public int getIndexOfChild(Object objekt1, Object objekt2) {
      return treeModel.getIndexOfChild(objekt1, objekt2);
   }
}
