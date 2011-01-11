import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JFramemitJTableCustomFiltering extends JFrame 
                                            implements Tabelle {
// Konstruktordefinition
   public JFramemitJTableCustomFiltering() { 
      super("Filtern von Tabelleneinträgen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine Referenzvariable vom Typ TableModel kann eine Referenz 
// auf eine Instanz der Klasse CustomTableModel, die ein 
// benutzerdefiniertes Modell definiert, aufnehmen
      TableModel tableModel = new CustomTableModel(rows,columns);
// Das Tabellenmodell wird in den Konstruktoren der Klassen 
// JTable und TableRowSorter<TableModel> per Referenz übergeben 
      JTable table = new JTable(tableModel); 
      final TableRowSorter<TableModel> tableSorter = 
         new TableRowSorter<TableModel>(tableModel);
      table.setRowSorter(tableSorter);
      JScrollPane pane = new JScrollPane(table);
// Einen benutzerdefinierten Filter erzeugen
      final CustomRowFilter<TableModel,Integer> alterFilter = 
         new CustomRowFilter<TableModel,Integer>();
// JButton-Komponente erzeugen und dafür den ActionListener 
// implementieren 
      JButton button = new JButton("Zeilen selektieren");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
// Beim Betätigen des Buttons werden die vom Filter definierten 
// Einträge selektiert
            tableSorter.setRowFilter(alterFilter); 
         }
      }); 
      add(pane, BorderLayout.CENTER);
      add(button, BorderLayout.SOUTH);
      setSize(350,175);
      setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTableCustomFiltering frame = 
        new JFramemitJTableCustomFiltering();
   }
} 
// Externe Klassen für die Definition von benutzerdefinierten 
// Modellen und Filter
class CustomTableModel extends DefaultTableModel {
// Konstruktordefinition
   public CustomTableModel(Object[][] rows, Object[] columns) {
        super(rows, columns);
   }
// Die Methode der Oberklasse überschreiben
   public Class getColumnClass(int col) {
      if((col>=0) && (col<getColumnCount())) {
         return getValueAt(0, col).getClass();
      }
      else {
         return Object.class;
      }
   }
}
class CustomRowFilter<TableModel,Integer> 
                         extends RowFilter<TableModel,Integer> {
// Die Methode der Oberklasse überschreiben 
   public boolean include(RowFilter.Entry<? extends TableModel, 
                          ? extends Integer> entry) {
      System.out.println(entry + "*" + entry.getValueCount());
      for(int i=0; i<entry.getValueCount(); i++) {
         if((entry.getValue(i)) instanceof java.lang.Integer) {
            String s = entry.getStringValue(i); 
            int alter = java.lang.Integer.parseInt(s); 
            if((alter>=11) && (alter<=22)) { 
// Wird true zurückgegeben, heißt es, dass die Zeile selektiert
// wird
               return true;
            }
         } 
      }
      return false;
   }
}
