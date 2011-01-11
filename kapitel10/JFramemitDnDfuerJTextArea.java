import java.awt.*;
import javax.swing.*;
public class JFramemitDnDfuerJTextArea extends JFrame {
// Vier mehrzeilige Textfelder erzeugen
    private JTextArea textArea1 = new JTextArea(
      "lernen");
    private JTextArea textArea2 = new JTextArea("Java4",3,3);
    private JTextArea textArea3 = new JTextArea("Java5",3,3);
    private JTextArea textArea4 = new JTextArea("Java6",3,3);
// Konstruktordefinition
    public JFramemitDnDfuerJTextArea() {
       super("Drag&Drop-Test");
// Eine Instanz der Klasse TransferHandler mit der Eigenschaft 
// "text" zu der ersten JTextArea-Komponente zuweisen und eine 
// mit der Eigenschaft "foreground" zu der zweiten und dritten
        TransferHandler transferHandler1 = new TransferHandler(
          "text");
        TransferHandler transferHandler2 = new TransferHandler(
          "foreground");
        textArea2.setForeground(Color.blue);
        textArea3.setForeground(Color.magenta);
        textArea1.setTransferHandler(transferHandler1);
        textArea2.setTransferHandler(transferHandler2);
        textArea3.setTransferHandler(transferHandler2);
// Die Drag-Fähigkeit für die erste, zweite und vierte 
// Komponente einschalten
        textArea1.setDragEnabled(true);
        textArea2.setDragEnabled(true);
// Der 4. TextArea wird kein TransferHandler zugewiesen, somit 
// bekommt diese eine Standard-Instanz der Klasse zugewiesen, 
// welche die Eigenschft "text" besitzt
        textArea4.setDragEnabled(true);
        getContentPane().setLayout(new FlowLayout());
        add(new JLabel("TextArea1: "));
        add(textArea1);
        add(new JLabel("TextArea2: "));
        add(textArea2);
        add(new JLabel("TextArea3: "));
        add(textArea3);
        add(new JLabel("TextArea4: "));
        add(textArea4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,100);
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitDnDfuerJTextArea frame = 
        new JFramemitDnDfuerJTextArea();
   }
}
