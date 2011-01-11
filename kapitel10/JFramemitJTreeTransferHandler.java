import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
public class JFramemitJTreeTransferHandler extends JFrame {
   private JTextArea textArea = new JTextArea(
     "Java lernen");
   private BaumStruktur schule = 
      new BaumStruktur();
// Konstruktordefinition
   public JFramemitJTreeTransferHandler() {
      super("Benutzerdefinierte Transfer-Handler");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Eine Instanz der Klasse JTreeTransferHandler der 
// JTree-Komponente zuweisen 
      JTreeTransferHandler trans = new JTreeTransferHandler();
      schule.tree.setTransferHandler(trans); 
//  Die Drag-and-Drop Fähigkeit für die Komponenten einschalten
      schule.tree.setDragEnabled(true);
      textArea.setDragEnabled(true);
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("JTextArea: "));
      add(textArea);
      add(new JLabel("JTree: "));
      add(schule.tree);
      setVisible(true);
      setSize(400,200);
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitJTreeTransferHandler frame = 
        new JFramemitJTreeTransferHandler();
   }
}
