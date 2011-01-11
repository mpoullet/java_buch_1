import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;
public class UserListModelohneEventBehandlung 
                                          implements ListModel {
   private List<Object> list;
   private List<ListDataListener> listeners = 
     new ArrayList<ListDataListener>();   
// Konstruktordefinition
   public UserListModelohneEventBehandlung(List<Object> list) {
      this.list = list;
   }
// Die Methoden der ListModel-Schnittstelle zum Ermitteln der 
// Größe und für Abfragen der Modelldatenstruktur implementieren
   public int getSize() {
      return list.size();
   }
// Das Element der List-Instanz mit dem spezifizierten Index wird
// zurückgegeben
   public Object getElementAt(int index) {
      return list.get(index);
   }
// Die Methoden der Schnittstelle ListModel zum Registrieren und 
// Deregistrieren von ListDataListener-Objekte
   public void addListDataListener(ListDataListener l) {
      listeners.add(l);
   }
   public void removeListDataListener(ListDataListener l) {
      listeners.remove(l);
   }
// Die Methoden der List-Schnittstelle, über welche auf die 
// Modelldaten zugegriffen werden kann, implementieren
   public void addElement(Object obj) {
      list.add(obj);
   }
   public void setElementAt(Object obj, int index) {
           list.set(index, obj);
   }
   public boolean removeElement(Object obj) {
      return list.remove(obj);
   }
// Die Methode toString() der Klasse Object überschreiben
   public String toString() {
      return list.toString();
   }
}
