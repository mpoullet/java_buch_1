import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class UserListModel implements ListModel {
   private List<Object> list;
// Ein ArrayList-Objekt vom Typ ListDataListener erzeugen
   private List<ListDataListener> listeners = 
     new ArrayList<ListDataListener>(); 
// Konstruktordefinition
   public UserListModel(List<Object> list) {
      this.list = list;
   }
// Die Methoden der ListModel-Schnittstelle zum Ermitteln der 
// Größe und für Abfragen der Modellstruktur implementieren
   public int getSize() {
      return list.size();
   }
   public int indexOf(Object elem) {
      return list.indexOf(elem);
   }
// Das Element der List-Instanz mit dem spezifizierten Index wird
// zurückgegeben
   public Object getElementAt(int index) {
      return list.get(index);
   }
// Die Methoden der Schnittstelle ListModel zum Registrieren und 
// Deregistrieren von ListDataListener Objekte implementieren
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
// Modelldaten 
   public void addElement(Object obj) {
      int index = list.size();
      list.add(obj);
      fireListUpdate(this, index, index);
   }
   public void setElementAt(Object obj, int index) {
      list.set(index, obj);
      fireListUpdate(this, index, index);
   }
   public boolean removeElement(Object obj) {
      int index = indexOf(obj);
      if(index >= 0) {
         fireListUpdate(this, index, index);
      }
      return list.remove(obj);
   }
// Die Methode, über welche die ListDataListener benachrichtigt
// werden
   public void fireListUpdate(Object source, int index1, 
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
}
