import javax.swing.*;
import javax.swing.event.*;
import java.awt.List;
public class UserComboBoxModelohneEventBehandlung 
                                      implements ComboBoxModel {
private List list;
   private EventListenerList listenerList = 
     new EventListenerList();
   private Object objekt;
// Konstruktordefinition
   public UserComboBoxModelohneEventBehandlung(List list) {
      this.list = list;
   }
// Die Methoden der Schnittstelle ListModel implementieren
   public int getSize() {
      return list.getItemCount();
   }
// Das Element der List-Instanz mit dem spezifizierten Index
// wird zurückgegeben
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
// Deregistrieren von ListDataListener-Instanzen implementieren
   public ListDataListener [] getListDataListeners() {
      return (ListDataListener [])  
        listenerList.getListeners(ListDataListener.class);
   }
   public void addListDataListener(ListDataListener l) {
      listenerList.add(ListDataListener.class,l);
   }
   public void removeListDataListener(ListDataListener l) {
      listenerList.remove(ListDataListener.class,l);
   }
// Methoden zur Manipulation der Modelldaten mit Hilfe von 
// Methoden der Klasse List definieren
   public void add(String str) {
      list.add(str);
   }
   public void addElement(String str, int index) {
      list.add(str,index);
   }
   public void remove(String str) {
      list.remove(str);
   }
   public String toString() {
      return (java.util.Arrays.asList(
        list.getItems()).toString());
   }
}
