import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JFramemitJTableUserSorting extends JFrame 
                                            implements Tabelle {
// Konstruktordefinition
   public JFramemitJTableUserSorting() { 
      super("Sortieren der Spalten von Tabellen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine Referenzvariable vom Typ TableModel kann eine Referenz 
// auf eine Instanz der Klasse UserTableModel, die ein 
// benutzerdefiniertes Modell definiert, aufnehmen
      TableModel tableModel = new UserTableModel(rows, columns);
// Das Tabellenmodell wird in den Konstruktoren der Klassen 
// JTable und TableRowSorter<TableModel> per Referenz übergeben 
      JTable table = new JTable(tableModel); 
      RowSorter<TableModel> tableSorter = 
        new TableRowSorter<TableModel>(tableModel);
// Die Instanz vom Typ RowSorter<TableModel> wird der Tabelle 
// zugewiesen, welche ihrerseits in einer JScrollPane-Komponente
// angezeigt wird
      table.setRowSorter(tableSorter);
      JScrollPane pane = new JScrollPane(table);
      add(pane, BorderLayout.CENTER);
      setSize(350,175);
      setVisible(true);
    }
// Objekt der Klasse erzeugen 
    public static void main(String[] args) {
       JFramemitJTableUserSorting frame = 
         new JFramemitJTableUserSorting();
    }
} 
// Die Definition der externen Klasse in derselben Java-Datei
// muss ohne den Modifikator public erfolgen
class UserTableModel extends DefaultTableModel {
// Konstruktordefinition
   public UserTableModel(Object[][] rows, Object[] columns){
// Den Konstruktor der Oberklasse aufrufen
      super(rows,columns);
   }
// Die Methode der Oberklasse wird überschrieben
   public Class getColumnClass(int col) {
      if((col >= 0) && (col < getColumnCount())) {
// Für jede Spalte die Klasse des Elementes aus ihrer 
// ersten Zeile ermitteln
         return getValueAt(0, col).getClass();
      }
      else {
         return Object.class;
      }
   }
}
