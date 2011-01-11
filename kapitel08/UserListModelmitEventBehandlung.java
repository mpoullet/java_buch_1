import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class UserListModelmitEventBehandlung 
                                          implements ListModel {
   private List<Object> list;
// Ein ArrayList-Objekt vom Typ ListDataListener erzeugen
   private List<ListDataListener> listeners = 
     new ArrayList<ListDataListener>(); 
// Konstruktordefinition
   public UserListModelmitEventBehandlung(List<Object> list) {
      this.list = list;
   }
// Die Methoden der ListModel-Schnittstelle zum Ermitteln
// der Größe und für Abfragen der Modellstruktur implementieren
   public int getSize() {
      return list.size();
   }
   public int indexOf(Object elem) {
      return list.indexOf(elem);
   }
// Das Element der List-Instanz mit dem spezifizierten Index 
// wird zurückgegeben
   public Object getElementAt(int index) {
      return list.get(index);
   }
// Die Methoden der Schnittstelle ListModel zum Registrieren und 
// Deregistrieren von ListDataListener-Objekten implementieren
   public void addListDataListener(ListDataListener l) {
      listeners.add(l);
   }
   public void removeListDataListener(ListDataListener l) {
      listeners.remove(l);
   }
// Die Methode toString() der Klasse Object überschreiben
   public String toString() {
      return list.toString();
   }
// Eine zweite Art von Methoden dient der Manipulation von 
// Modelldaten und der Benachrichtigung des ListDataListener 
// über die durchgeführten Operationen
   public void addElement(Object obj) {
      int index = list.size();
      list.add(obj);
      fireIntervalAdded(this, index, index);
   }
   public void setElementAt(Object obj, int index) {
      list.set(index, obj);
      fireContentsChanged(this, index, index);
   }
   public boolean removeElement(Object obj) {
      int index = indexOf(obj);
      if(index >= 0) {
         fireIntervalRemoved(this, index, index);
      }
         return list.remove(obj);
   }
// Die Methoden, über welche der ListDataListener benachrichtigt
// wird
   public void fireIntervalAdded(Object source, int index1, 
                                 int index2) {
      ListDataEvent event = null;
      Iterator<ListDataListener> iterator = listeners.iterator();
      while(iterator.hasNext()) {
         if(event == null) {
            event = new ListDataEvent(source, 
              ListDataEvent.INTERVAL_ADDED, index1, index2);
         }
         ListDataListener listener = iterator.next();
         listener.intervalAdded(event);
      }
   }
   public void fireContentsChanged(Object source, int index1, 
                                   int index2) {
      ListDataEvent event = null;
      Iterator<ListDataListener> iterator = listeners.iterator();
      while(iterator.hasNext()) {
         if(event == null) {
            event = new ListDataEvent(source, 
              ListDataEvent.CONTENTS_CHANGED, index1, index2);
         }
         ListDataListener listener = iterator.next();
         listener.contentsChanged(event);
      }
   }
   public void fireIntervalRemoved(Object source, int index1, 
                                   int index2) {
      ListDataEvent event = null;
      Iterator<ListDataListener> iterator = listeners.iterator();
      while(iterator.hasNext()) {
         if(event == null) {
            event = new ListDataEvent(source, 
              ListDataEvent.INTERVAL_REMOVED, index1, index2);
         }
         ListDataListener listener = iterator.next();
         listener.intervalRemoved(event);
      }
   }
}
