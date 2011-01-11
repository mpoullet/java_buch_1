import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JFramemitDnDfuerJLabel extends JFrame {
   private JTextArea textArea = new JTextArea("Java6");
   private JLabel label = new JLabel("lernen");
// Konstruktordefinition
   public JFramemitDnDfuerJLabel() {
      super("Drag&Drop-Test");
// Die Drag-Fähigkeit für die JTextArea-Komponente einschalten
      textArea.setDragEnabled(true);
// foreground-Eigenschaft für die Komponenten setzen
      textArea.setForeground(Color.blue);
      label.setForeground(Color.magenta);
// Eine Instanz der Klasse TransferHandler mit Angabe der 
// foreground-Eigenschaft im Konstruktoraufruf muss beiden 
// Komponenten zugewiesen werden, damit diese Eigenschaft 
// übertragen wird
      TransferHandler transferHandler = new TransferHandler(
        "foreground");
      textArea.setTransferHandler(transferHandler);
      label.setTransferHandler(transferHandler);
// Beim Anklicken mit der Maus wird eine Drag-Operation vom Typ 
// COPY für die JLabel-Komponente gestartet;
// der MouseAdapter wird mittels einer anonymen Klasse definiert
      label.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent me) {
            JComponent c = (JComponent)me.getSource();
            TransferHandler trans = c.getTransferHandler();
            trans.exportAsDrag(c, me, TransferHandler.COPY);
         }
      });
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("TextArea: "));
      add(textArea);
      add(new JLabel("Label: "));
      add(label);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setSize(300,75);
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitDnDfuerJLabel frame = 
        new JFramemitDnDfuerJLabel();
   }
}
