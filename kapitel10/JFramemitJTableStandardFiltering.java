import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
public class JFramemitJTableStandardFiltering extends JFrame 
                                            implements Tabelle {
// Konstruktordefinition
   public JFramemitJTableStandardFiltering() { 
      super("Filtern von Tabelleneintr�gen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine Referenzvariable vom Typ TableModel kann eine Referenz  
// auf eine Instanz der Klasse DefaultTableModel, die ein Java-
// Standard-Modell definiert, aufnehmen
      TableModel tableModel = 
        new DefaultTableModel(rows, columns);
// Das Tabellenmodell wird in den Konstruktoren der Klassen 
// JTable und TableRowSorter<TableModel> per Referenz �bergeben 
      JTable table = new JTable(tableModel); 
// Weil in einer anonymen Klasse angesprochen, als final 
// deklarieren
      final TableRowSorter<TableModel> tableSorter =  
        new TableRowSorter<TableModel>(tableModel);
// Die Instanz vom Typ RowSorter<TableModel> wird der Tabelle 
// zugewiesen, die ihrerseits in einer JScrollPane-Komponente 
// angezeigt wird
      table.setRowSorter(tableSorter);
      JScrollPane pane = new JScrollPane(table);
// Um die Eingabe eines Wertes f�r das Filtern von 
// Tabelleneintr�gen  zu erm�glichen, wird eine JTextField-
// Komponente, die mit Hilfe einer JLabel-Komponente beschriftet 
// wird, erstellt und beide Komponenten zu einem Panel hinzugef�gt
      final JTextField filterText = new JTextField("Jung");
      JPanel panel = new JPanel();
      JPanel panel1 = new JPanel();
      JLabel label = new JLabel(" Ausdruck eingeben: ");
      panel.add(label);
      panel.add(filterText);
      JButton button = new JButton("regexFilter");
// Der regexFilter selektiert bei einer Bet�tigung des Buttons 
// die Zeilen der Tabelle, welche den im Textfeld angegebenen 
// Ausdruck beinhalten
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String filter = filterText.getText();
            if(filter.length() == 0) {
               tableSorter.setRowFilter(null);
            }
            else {
               tableSorter.setRowFilter(
                 RowFilter.regexFilter(filter));
            }
         }
      });
// Der dateFilter selektiert Tabelleneintr�ge, welche 
// Datumsangeben vom spezifizierten Kriterium beinhalten
      JButton button1 = new JButton("dateFilter");
      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
// Alle Tabelleneintr�ge mit einem Geburtsdatum kleiner als das 
// aktuelle Datum werden selektiert
            tableSorter.setRowFilter(RowFilter.dateFilter(
            RowFilter.ComparisonType.BEFORE, new Date())); 
         }
      });
      JButton button2 = new JButton("andFilter");
      button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
// Zwei Instanzen vom Typ der parametrisierten Klasse 
// RowFilter<Object,Object> werden erzeugt und zu einem ArrayList
// -Objekt vom gleichen Typ hinzugef�gt
            List<RowFilter<Object,Object>> filter = 
              new ArrayList<RowFilter<Object,Object>>(2);
            filter.add(RowFilter.regexFilter("Jung")); 
            filter.add(RowFilter.dateFilter(
              RowFilter.ComparisonType.BEFORE, new Date()));
// Alle Tabelleneintr�ge, die ein Geburtsdatum gr��er als das 
// aktuelle Datum und den Namen "Jung" enthalten, werden 
// selektiert
            tableSorter.setRowFilter(
              RowFilter.andFilter(filter)); 
         }   
      });
      add(panel, BorderLayout.NORTH);
      add(pane, BorderLayout.CENTER);
      panel1.add(button);
      panel1.add(button1);
      panel1.add(button2);
      add(panel1, BorderLayout.SOUTH);
      setSize(350,200);
      setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitJTableStandardFiltering frame = 
        new JFramemitJTableStandardFiltering();
   }
}
