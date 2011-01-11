import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.*;
public class JFramemitLookAndFeelundStdButtonUI 
                      extends JPanel implements ActionListener {
// Den Namen des Standard-LookAndFeel ermitteln
   private static String stdLookandFeel = 
     UIManager.getCrossPlatformLookAndFeelClassName();
   private JButton b = new JButton("Button");
   private ButtonGroup buttonGroup = new ButtonGroup();
   private JRadioButton stdButton = 
     new JRadioButton("Std-LookAndFeel");
   private JRadioButton myButton = 
     new JRadioButton("My-LookAndFeel");
// Konstruktordefinition
   public JFramemitLookAndFeelundStdButtonUI() {
      stdButton.setSelected(true);
      stdButton.addActionListener(this);
      buttonGroup.add(stdButton);
      myButton.addActionListener(this);
      buttonGroup.add(myButton);
      add(stdButton);
      add(myButton);
      add(b);
   }
// Methode von ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
      String lnfName = null;
      if(e.getActionCommand().equals("My-LookAndFeel")) {
         lnfName = "MyLookAndFeel";
      } 
      else {
         lnfName = stdLookandFeel;
      }
// Die von der Methode setLookAndFeel() geworfenen Exceptions 
// mit einem try/catch-Block abfangen
      try {
         UIManager.setLookAndFeel(lnfName);
// Die Vaterkomponente der aktuellen Instanz ermitteln (es ist
// eine JFrame-Komponente) 
         Container c = getTopLevelAncestor();
// und anzeigen
         System.out.println(JFramemitLookAndFeelundStdButtonUI.
           this.getTopLevelAncestor());
// Das entsprechende LookAndFeel für alle ihre Kindkomponenten
// setzen
         SwingUtilities.updateComponentTreeUI(c);
      } 
      catch(Exception ex) {
         System.out.println("LookAndFeel: " + lnfName + "kann "
           + "nicht geladen werden");
      }
   }
// Objekt der Klasse erzeugen und in einem Fenster sichtbar machen
   public static void main(String args[]) {
      JFrame f = new JFrame("Standard und benutzerdefiniertes "
        + "LookAndFeel"); 
      JFramemitLookAndFeelundStdButtonUI p = 
        new JFramemitLookAndFeelundStdButtonUI();
      f.getContentPane().add (p, BorderLayout.CENTER);
// Ein JSlider-Objekt und ein JComboBox-Objekt zum Fenster 
// hinzufügen
      JSlider slider = new JSlider();
      JComboBox combo = new JComboBox();
// Den Schieber des JSlider-Objektes auf Position 25 setzen
      slider.setValue(25);
      f.getContentPane().add(combo, BorderLayout.SOUTH);
      f.getContentPane().add(slider, BorderLayout.NORTH);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize (275,150);
      f.setVisible(true);
   }
}