import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramemitDialogFenster extends JFrame {
   private JButton[] b = new JButton [6];
// Konstruktordefinition
   public JFramemitDialogFenster() {
      super("Dialog Klassen");
      setBounds(20,20,200,100);
      setBackground(Color.pink);
      getContentPane().setLayout(new GridLayout(3,2));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(int i=0; i<6; i++) {
         b[i] = new JButton("Dialog"+(i+1));
         b[i].setBackground(new Color(i*40,255,i));
         getContentPane().add(b[i]);
         final int c = i;
// Den ActionListener als anonyme Klasse implementieren
         b[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               switch (c) {
                  case 0: {
                     JOptionPane.showMessageDialog(
                       JFramemitDialogFenster.this,     
                         "InformationMessage","MessageDialog", 
                           JOptionPane.INFORMATION_MESSAGE,null);
                     break;
                  }
                  case 1: {
                     JOptionPane.showConfirmDialog(
                       JFramemitDialogFenster.this,"ErrorMessage"
                         , "ConfirmDialog", 
                         JOptionPane.YES_NO_OPTION, 
                           JOptionPane.ERROR_MESSAGE);
                     break;
                  }
                  case 2: {
                     String[]warnung = {"Option1","Option2"}; 
                     JOptionPane.showOptionDialog(
                       JFramemitDialogFenster.this, 
                         "WarningMessage","OptionDialog", 
                           JOptionPane.DEFAULT_OPTION, 
                             JOptionPane.WARNING_MESSAGE, 
                               null, warnung, warnung[0]);
                     break;
                  }
                  case 3: {
                     String[]eingabe = {"Option1","Option2",
                       "Option3"}; 
                     JOptionPane.showInputDialog(
                      JFramemitDialogFenster.this,"PlainMessage",
                         "InputDialog", JOptionPane.
                          PLAIN_MESSAGE,null,eingabe,eingabe[0]);
                     break;
                  }
                  case 4: {
                     String[]eingabe ={"Option1","Option2",         
                       "Option3"};    
                     JOptionPane.showInputDialog(
                       JFramemitDialogFenster.this,
                         "QuestionMessage","InputDialog",
                           JOptionPane.QUESTION_MESSAGE);
                     break;
                  }
                  case 5: {
                     JDialog dialog = new JDialog();
                     dialog.setBounds(10,10,100,100);
                     dialog.setVisible(true);
                     break;
                  }
               }
            }
         });
      } 
      setVisible(true);
   }
// Objekt der Klasse erzeugen 
   public static void main(String[] args) {
      JFramemitDialogFenster frame = new JFramemitDialogFenster();
   }
} 
