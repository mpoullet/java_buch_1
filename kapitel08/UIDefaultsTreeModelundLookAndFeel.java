import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
public class UIDefaultsTreeModelundLookAndFeel 
                                          implements TreeModel {
   private DefaultTreeModel treeModel;
   private DefaultMutableTreeNode wurzelKnoten = 
     new DefaultMutableTreeNode(
       "UIDefaults Werte fuer Komponenten");
   private DefaultMutableTreeNode stringKnoten = 
     new DefaultMutableTreeNode(
       "String Resources");
// Konstruktordefinition
   public UIDefaultsTreeModelundLookAndFeel() {
      treeModel = new DefaultTreeModel(wurzelKnoten);
      treeModel.insertNodeInto(stringKnoten,wurzelKnoten, 0);
   }
   public void uiDefaultsUpdate(UIDefaults defaults) {
// Vorhandene Knoten löschen
      int nrstringKnoten = stringKnoten.getChildCount();
      for(int i=0; i<nrstringKnoten; i++) {
         DefaultMutableTreeNode knoten =(DefaultMutableTreeNode)
           getChild(stringKnoten,0);
         treeModel.removeNodeFromParent(knoten);
      }
// Die Werte der UIDefaults-Tabelle vom Typ der Klasse String
// in das Modell aufnehmen
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
         if(valueForKey instanceof java.lang.String) {
           treeModel.insertNodeInto(newKeyNode, stringKnoten, 0);
         }
         treeModel.insertNodeInto(newValueNode, newKeyNode, 0);
      }
   }
// Alle Methodenaufrufe des Interfaces TreeModel an das interne 
// Modell delegieren
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
   public void addTreeModelListener(TreeModelListener l) {
      treeModel.addTreeModelListener(l);
   }
   public void removeTreeModelListener(TreeModelListener l) {
      treeModel.removeTreeModelListener(l);
   }
}
