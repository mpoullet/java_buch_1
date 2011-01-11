import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
public class JFramemitDropTargetListener extends JFrame 
                          implements DropTargetListener, Texte {
    private DropTarget dropTarget;
    private JTextArea textArea;
    private DefaultListModel listModel = new DefaultListModel(); 
    private JList liste1, liste2;
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
// Konstruktordefinition
    public JFramemitDropTargetListener() {
        super("Drop-Test fuer eine JList-Komponente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new JLabel("Die Elemente der" 
          + " linken Liste auf die rechte Liste ziehen:"),
             BorderLayout.NORTH);       
// Die rechte Liste wird über ein Modell vom Typ der Klasse 
// DefaultListModel erzeugt, für die linke wird im Konstruktor
// eine Referenz vom Typ eines String-Array übergeben
        for(int i=0; i<text1.length; i++) {
            listModel.add(i,text1[i]);
        }
        liste1 = new JList(text2);
        liste1.setDragEnabled(true); 
	liste2 = new JList(listModel);
        liste2.setBackground(Color.white);
        panel1.add(new JLabel("Liste1: "));
        panel1.add(liste1); 
        panel2.add(new JLabel("Liste2: "));
        panel2.add(liste2);
        add(panel1, BorderLayout.WEST);
        add(panel2, BorderLayout.EAST);
// Die rechte Liste soll Daten empfangen, die Klasse DropTarget 
// handelt die DropEvents für diese Komponente mit Hilfe des 
// DropTargetListener
        dropTarget = new DropTarget(liste2, this);
        setSize(300,200);
        setVisible(true);
   }
// Die Methoden des DropTargetListener implementieren
   public void dragEnter(DropTargetDragEvent dropEvent) {
      System.out.println("Drag-Enter");
      if(dropEvent.getSource() != dropTarget)
// Die Drag-Operation wird abgelehnt, wenn das Event vom Typ 
// DropTargetDragEvent nicht von der erwarteten Komponente 
// ausgelöst wurde
         dropEvent.rejectDrag();
      else {
         dropEvent.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
         System.out.println("Beginn der Drag-Operation");
      }
   }
   public void dragExit(DropTargetEvent dte) {
      System.out.println("Drag-Exit");
   }
   public void dragOver(DropTargetDragEvent dropEvent) {
      System.out.println("Drag-Over");
   }
   public void dropActionChanged(DropTargetDragEvent dropEvent) {
        System.out.println("Drop-Action-Changed");
   }
// Die Methode drop() wird aufgerufen, wenn die Drag-Operation mit
// einer Drop-Operation beendet wird
   public void drop(DropTargetDropEvent dropEvent) {
      try {
// Den gezogenen Text abholen
         Transferable trans = dropEvent.getTransferable();
// Daten auswerten, das erwartete Datenformat ist vom Typ 
// DataFlavor
         DataFlavor[] flavors = trans.getTransferDataFlavors();
// Anzeige aller Datenformate
         System.out.print("Datenformate aus der "
           + "Zwischenablage: ");
         System.out.println("Anzahl "+flavors.length);
         for(int i=0; i<flavors.length; i++) { 
            System.out.println(flavors[i].getMimeType());
         }
         for(int i=0; i<flavors.length; i++) {
            if(flavors[i].isFlavorTextType()) {
               dropEvent.acceptDrop(DnDConstants.ACTION_COPY);
// Ist das Datenformat vom Typ stringFlavor, sollen die Daten in 
// die rechte Liste an Position 0 eingefügt werden 
               listModel.insertElementAt(trans.
               getTransferData(DataFlavor.stringFlavor).
                 toString(), 0);
// Der Instanz, von welcher die Daten abgeholt wurden, wird
// mitgeteilt, dass die Drop-Operation erfolgreich beendet wurde
               dropEvent.dropComplete(true);
               return;
            }
// Die gezogenen Daten sind nicht vom angegebenen Typ
            System.out.println("Fehlerhafter Drop: " 
              + dropEvent);
// Die Drop-Operation wird abgelehnt
            dropEvent.rejectDrop();
         }
      } 
      catch (Exception e) {
         e.printStackTrace();
         dropEvent.rejectDrop();
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitDropTargetListener frame = 
        new JFramemitDropTargetListener();
   }
}
