import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JFramemitJTableUserSortingundFiltering 
                            extends JFrame implements Tabelle {
// Konstruktordefinition
   public JFramemitJTableUserSortingundFiltering() { 
      super("Filtern von Tabelleneinträgen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Definition der lokalen Klassen
// Die Methode getColumnClass() der Klasse DefaultTableModel 
// überschreiben und eine Instanz der Klasse erzeugen 
      TableModel tableModel = 
        new DefaultTableModel(rows, columns) {
          public Class getColumnClass(int column) {
            Class returnValue;
            if((column>=0) && (column<getColumnCount())) {
               returnValue = getValueAt(0, column).getClass();
            } 
            else {
               returnValue = Object.class;
            }
               return returnValue;
            }
         };
// Die Methode include() der Klasse RowFilter<TableModel,Integer>
// überschreiben und eine Instanz der Klasse erzeugen 
         final RowFilter<TableModel,Integer> alterFilter = 
           new RowFilter<TableModel,Integer>() { 
            public boolean include(Entry<? extends TableModel, 
              ? extends Integer> entry) {
               for(int i=0; i<entry.getValueCount(); i++) {
                  if((entry.getValue(i)) 
                    instanceof java.lang.Integer) {
                     String s = entry.getStringValue(i); 
                     int alter = java.lang.Integer.parseInt(s); 
                     if((alter>=11) && (alter<=22)) { 
                        return true;
                     }
                  }
               } 
               return false;
            }
         };
// Das Tabellenmodell wird in den Konstruktoren der Klassen 
// JTable und TableRowSorter<TableModel> per Referenz übergeben 
         JTable table = new JTable(tableModel); 
         final TableRowSorter<TableModel> tableSorter = 
           new TableRowSorter<TableModel>(tableModel);
         table.setRowSorter(tableSorter);
         JScrollPane pane = new JScrollPane(table);
// JButton-Komponente erzeugen und mittels einer anonymen Klasse
// den ActionListener für diese registrieren 
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
         setSize(350,150);
         setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTableUserSortingundFiltering frame = 
        new JFramemitJTableUserSortingundFiltering();
   }
}
