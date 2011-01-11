import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
public class JFramemitDialogModalityBeispielen extends JFrame 
                  implements ActionListener, SwingConstants {
   private JTextField[] tf = new JTextField[3];
   private JTextField[] dtf = new JTextField[3];
   private static JToolBar toolBar = new JToolBar();
   private JFrame[] f = new JFrame[3];
   private JDialog[]d = new JDialog[3];
   private static Dialog.ModalityType []typ = 
     Dialog.ModalityType.values();
// Konstruktordefinition
   public JFramemitDialogModalityBeispielen () {
      super("JDialog ModalityTyp");
      setBounds(10,10,100,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
// Die zur Verfügung stehenden Modalitytypen am Bildschirm 
// anzeigen
      System.out.println(Arrays.asList(typ));
      for(int i=0; i<3; i++) {
// JFrame-Komponenten erzeugen
         f[i] = new JFrame("Fenster"+(i+1));
         f[i].setBounds(100*i,100*i,200,100);
// Zu jedem Fenster ein Textfeld hinzufügen 
         tf[i] = new JTextField("DialogModality "+(i+1));
         tf[i].setBackground(Color.pink);
         f[i].add(tf[i]); 
         f[i].setBackground(Color.pink);
         f[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f[i].setVisible(true);
// JToolBar-Komponente mit JButton-Komponenten erzeugen
         JButton button = new JButton("Fenster"+(i+1));
         button.setActionCommand(""+i);
         button.setBackground(new Color(200,i*40,i));
         button.addActionListener(this);
         toolBar.add(button);
         toolBar.setOrientation(VERTICAL);
      }
// Für das dritte Fenster einen ModalExclusionType setzen 
      f[2].setModalExclusionType(Dialog.
        ModalExclusionType.APPLICATION_EXCLUDE);
      add(toolBar);
   } 
// Die Methode des ActionListener implementieren
   public void actionPerformed(ActionEvent e) {
      String s = e.getActionCommand();
      System.out.println(s);
      int i = Integer.parseInt(s);
      switch(i) {
         case 0:
            d[i] = new JDialog(f[i], "Dialog"+(i+1)
              + typ[1].toString(), typ[1]);
            break;
         case 1:
            d[i] = new JDialog(f[i], "Dialog"+(i+1)
              + typ[2].toString(), typ[2]);
                break;
         case 2:
            d[i] = new JDialog(f[i], "Dialog" 
              + (i+1)+typ[1].toString(), typ[1]);
                break;
      }
// Zu jedem Dialogfenster ein Textfeld hinzufügen 
      d[i].setBounds(100*i+50,100*i+50,250,100);
      dtf[i] = new JTextField("DialogModality "+(i+1));
      dtf[i].setBackground(Color.gray);
      d[i].add(dtf[i]);
      d[i].setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitDialogModalityBeispielen JFrame = 
        new JFramemitDialogModalityBeispielen();
   }
}
