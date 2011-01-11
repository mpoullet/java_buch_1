import java.awt.*;
import javax.swing.*;
public class JFramemitDnDfuerJList extends JFrame 
                                             implements Texte {
   private JTextArea textArea = new JTextArea(
      "Die\nVersion\nlernen",3,3);
   private JList liste;
// Konstruktordefinition
   public JFramemitDnDfuerJList() {
      super("Drag&Drop Test");
      liste = new JList(text1);
// Die Drag-Fähigkeit für die Komponenten einschalten
      liste.setDragEnabled(true);
      textArea.setDragEnabled(true);
      getContentPane().setLayout(new FlowLayout());
      add(new JLabel("TextArea: "));
      add(textArea);
      add(new JLabel("Liste: "));
      add(liste);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setSize(300,150);
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitDnDfuerJList frame = new JFramemitDnDfuerJList();
   }
}
