import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;
public class UIDefaultsTreeModel implements TreeModel {
   private DefaultTreeModel treeModel;
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
   public UIDefaultsTreeModel() {
      treeModel = new DefaultTreeModel(wurzelKnoten);
      treeModel.insertNodeInto(buttonKnoten, wurzelKnoten, 0);
      treeModel.insertNodeInto(listKnoten, wurzelKnoten, 1);
      treeModel.insertNodeInto(treeKnoten, wurzelKnoten, 2);
   }
// Die Werte der UIDefaults-Tabelle als Knoten in das Modell 
// einfügen
   public void uiDefaultsDefTreeModel(UIDefaults defaults) {
      Enumeration<Object> keys = defaults.keys();
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
// In das Modell werden nur Eigenschaften von JButton-, JList- 
// und JTree-Komponenten übernommen
         if(s1.indexOf(".") > 0) {
            s = s1.substring(0,s1.indexOf("."));
            if(s.equals("Button")) {
               treeModel.insertNodeInto(
                 newKeyNode, buttonKnoten, 0);
            }
            else if(s.equals("List")) {
               treeModel.insertNodeInto(
                 newKeyNode, listKnoten, 0);
            }
            else if(s.equals("Tree")) {
               treeModel.insertNodeInto(
                 newKeyNode, treeKnoten, 0);
            }
         }
         treeModel.insertNodeInto(newValueNode, newKeyNode, 0);
      }
   }
// Alle Methoden des TreeModel-Interface implementieren und 
// darin die gleichnamigen Methoden des internen Modells 
// aufrufen
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
   public void valueForPathChanged(TreePath path, Object objekt) {
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
