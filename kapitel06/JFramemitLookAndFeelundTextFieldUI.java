import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
public class JFramemitLookAndFeelundTextFieldUI extends JFrame {
   private CustomField text1 = new CustomField(10);
   private CustomField text2 = new CustomField(10);
   private JTextField text3 = new JTextField(10);
   private JTextField text4 = new JTextField(10);
// Konstruktordefinition
   public JFramemitLookAndFeelundTextFieldUI() {
      super("Die MVC-Architektur von Swing");
// Das UI-Delegationsobjekt daran hindern, den Hintergrund der 
// Standard-Texfelder zu malen
      text3.setOpaque(false);
      text4.setOpaque(false);
// Ein benutzerdefiniertes Modell für das erste Textfeld setzen
      text1.setDocument(new GrossBuchstaben());
      text1.setText("Feld1");
      text2.setText("Feld2");
      text3.setText("Feld3");
      text4.setText("Feld4");
// Das Modell des ersten Textfeldes ermitteln und dem vierten 
// Textfeld zuweisen
      Document modell = text1.getDocument();
      text4.setDocument(modell);
      getContentPane().setBackground(Color.lightGray);
      getContentPane().add(text1);
      getContentPane().add(text2);
      getContentPane().add(text3);
      getContentPane().add(text4);
      getContentPane().setLayout(new FlowLayout());
// Ein benutzerdefiniertes LookAndFeel für die Anzeige der 
// Textfelder setzen und die von der Methode setLookAndFeel() 
// geworfenen Exceptions mit einem try/catch-Block abfangen
      try {
         UIManager.setLookAndFeel("CustomFieldLookAndFeel");
                 SwingUtilities.updateComponentTreeUI (this);
      } 
      catch(Exception ex) {
         System.out.println (" Das LookAndFeel kann nicht "   
           + "geladen werden"+ex);
      }
      text1.setUI(new CustomFieldUI());
      text4.setUI(new CustomFieldUI());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(200, 200);
      setVisible(true);
   }
// Objekt der Klasse erzeugen
   public static void main (String args[]) {
      JFramemitLookAndFeelundTextFieldUI frame = 
        new JFramemitLookAndFeelundTextFieldUI();
   }
}
