import java.awt.*;
import javax.swing.*;
public class JFramemitMyButtonUI extends JFrame {
// Konstruktordefinition
   public JFramemitMyButtonUI() {
      setTitle("Benutzedefinierter UI-Delegate");
// Es kann immer nur ein LookAndFeel das "aktuelle LookAndFeel" 
// sein
      try {
      // UIManager.setLookAndFeel(
      //   "javax.swing.plaf.metal.MetalLookAndFeel");
         UIManager.setLookAndFeel(
           "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
      // UIManager.setLookAndFeel(
      //   "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      // UIManager.setLookAndFeel(
      //   "javax.swing.plaf.synth.SynthLookAndFeel");
// Jede JFrame-Komponente soll ihr LookAndFeel ändern
         SwingUtilities.updateComponentTreeUI(this);
      }   
      catch(Exception ex) {
         System.out.println(ex);
      }
      getContentPane().setBackground(Color.gray);
      JButton jButton = new JButton("STD Button");
      MyButton myButton = new MyButton("My Button");
      getContentPane().setLayout(new FlowLayout());
      add(jButton);
      add(myButton);
   }
// Objekt der Klasse erzeugen
   public static void main(String args[]) {
      JFramemitMyButtonUI f = new JFramemitMyButtonUI();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      f.pack();
   }
}
