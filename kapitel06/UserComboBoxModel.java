import java.awt.List;
import javax.swing.*;
import javax.swing.event.*;
public class UserComboBoxModel implements ComboBoxModel {
   private List list;
   private EventListenerList listenerList = 
     new EventListenerList();
   private Object objekt;
// Konstruktordefinition
   public UserComboBoxModel(List list) {
      this.list = list;
   }
// Die Methoden der Schnittstelle ListModel implementieren
   public int getSize() {
      return list.getItemCount();
   }
// Das Element der List-Instanz mit dem spezifizierten Index wird
// zurückgegeben
   public Object getElementAt(int index) {
      return list.getItem(index);
   }
// Die Methoden der Schnittstelle ComboBoxModel zum Selektieren 
// und Deselektieren von Einträgen implementieren
   public Object getSelectedItem() {
      return objekt;
   }
   public void setSelectedItem(Object objekt) {
      this.objekt = objekt;
   }
// Die Methoden der Schnittstelle ListModel zum Registrieren und
// Deregistrieren von ListDataListener-Objekte implementieren
   public ListDataListener [] getListDataListeners() {
      return (ListDataListener [])listenerList.
         getListeners(ListDataListener.class);
   }
   public void addListDataListener(ListDataListener l) {
      listenerList.add(ListDataListener.class,l);
   }
   public void removeListDataListener(ListDataListener l) {
      listenerList.remove(ListDataListener.class,l);
   }
   public String toString() {
      return (java.util.Arrays.asList(list.getItems()).
        toString());
   }
// Eine zweite Art von Methoden dient der Manipulation von 
// Modelldaten und der Benachrichtigung des ListDataListener 
// über die durchgeführten Operationen
   public void add(String str) {
      int index = list.getItemCount();
      list.add(str);
      fireIntervalAdded(this, index, index);
   }
   public void addElement(String str, int index) {
      list.add(str,index);
      fireContentsChanged(this, index, index);
   }
   public void remove(String str) {
      int index = list.getItemCount();
      fireIntervalRemoved(this, index, index);
      list.remove(str);
   }
// Die Methoden, über welche die ListDataListener-Instanzen 
// benachrichtigt werden sollen, definieren
   public void fireIntervalAdded(Object source, int index1, 
                                 int index2) {
      ListDataEvent event = new ListDataEvent(
        source, ListDataEvent.INTERVAL_ADDED, index1, index2);
      ListDataListener[] listeners = getListDataListeners(); 
      for(int i=listeners.length-1; i>=0; i--) { 
         listeners[i].intervalAdded(event); 
      }
   }
   public void fireContentsChanged(Object source, int index1, 
                                   int index2) {
      ListDataEvent event = new ListDataEvent(
        source, ListDataEvent.INTERVAL_ADDED, index1, index2);
      ListDataListener[] listeners = getListDataListeners(); 
      for(int i=listeners.length-1; i>=0; i--) { 
         listeners[i].contentsChanged(event);
      }
   }
   public void fireIntervalRemoved(Object source, int index1, 
                                   int index2) {
      ListDataEvent event = new ListDataEvent(
        source, ListDataEvent.INTERVAL_ADDED, index1, index2);
      ListDataListener[] listeners = getListDataListeners(); 
      for(int i = listeners.length-1; i>=0; i--) { 
         listeners[i].intervalRemoved(event);
      }
   }
}
