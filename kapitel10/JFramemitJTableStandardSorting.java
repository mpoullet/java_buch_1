import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JFramemitJTableStandardSorting extends JFrame 
                                            implements Tabelle {
// Konstruktordefinition
   public JFramemitJTableStandardSorting() { 
// Den Konstruktor der Oberklasse aufrufen
      super("Sortieren der Spalten von Tabellen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine Referenzvariable vom Typ TableModel kann eine Referenz
// auf eine Instanz der Klasse DefaultTableModel, die ein Java-
// Standard-Model definiert, aufnehmen
      TableModel tableModel = 
        new DefaultTableModel(rows, columns);
// Das Tabellenmodell wird in den Konstruktoren der Klassen 
// JTable und TableRowSorter<TableModel> per Referenz übergeben 
      JTable table = new JTable(tableModel); 
      RowSorter<TableModel> tableSorter = 
        new TableRowSorter<TableModel>(tableModel);
// Die Instanz vom Typ der parametrisierten Standard-Klasse 
// RowSorter<TableModel> wird der Tabelle zugewiesen, die 
// ihrerseits in einer JScrollPane-Komponente angezeigt wird
      table.setRowSorter(tableSorter);
      JScrollPane pane = new JScrollPane(table);
      add(pane, BorderLayout.CENTER);
      setSize(350,175);
      setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTableStandardSorting frame = 
        new JFramemitJTableStandardSorting();
   }
}
