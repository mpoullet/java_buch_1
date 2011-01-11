import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class JFramemitGenericStackfuerInversWort 
                      extends JFrame implements ActionListener {
// Globale Referenz vom Typ der parametrisierten Klasse 
// GenericStackfuerInversWort<String> 
   private GenericStackfuerInversWort<String> ws =  
      new GenericStackfuerInversWort<String>();
   private JLabel status = new JLabel(" ");
   private JButton[] komponenten = new JButton[26];
   private JButton wort = new JButton("Inverses Wort");
   private JButton loeschen = new JButton("Wort loeschen"); 
// Konstruktordefinition
   public JFramemitGenericStackfuerInversWort() {
      Container contentPane = getContentPane();
      JPanel panelMitte = new JPanel();
      JPanel panelSued = new JPanel();
      panelMitte.setLayout(new GridLayout(9,3,5,5));
      for(int i=0; i<26; i++) {
         char cBuchstabe = (char)('A'+i);
         komponenten[i] = new JButton(""+cBuchstabe);
         komponenten[i].addActionListener(this);
         panelMitte.add(komponenten[i]);
      } 
      wort.addActionListener(this);
loeschen.addActionListener(this);
      contentPane.add(new Label("Woerter bilden und drehen"), 
        BorderLayout.NORTH);
      contentPane.add(panelMitte, BorderLayout.CENTER);
      panelSued.add(wort);
      panelSued.add(status);
      panelSued.add(loeschen);
      contentPane.add(panelSued, BorderLayout.SOUTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300,250);
                  setVisible(true);
   }
// Die Methode des ActionListener implementieren
   public void actionPerformed(ActionEvent ae) {
// Welcher Button wurde gedrueckt?
      try {   
         String sBefehl = ae.getActionCommand();
         if(sBefehl.equals("Wort loeschen")) { 
               status.setText("");
         } 
         else if(sBefehl.equals("Inverses Wort")) {
            String sWort ="";
// Solange der Stack nicht leer ist,
            while(!ws.isEmpty()) {
// die im Stack gespeicherten Werte lesen
               sWort = sWort + ws.pop();
            } 
// Inverses Wort anzeigen
            status.setText(sWort);
// Ist der Stack leer?
            ws.pop();
         }
// Die Namen der ausgewählten Buttons im Stack speichern
         else {
            ws.push(sBefehl);
         }
      }
// Ausnahmen behandeln
      catch(FullStackException fse) {
// Den Messagetext der Ausnahme anzeigen
         System.out.println(fse.getMessage()); 
      }
      catch(EmptyStackException ese) {
// Diese Ausnahme definiert einen leeren Meldungstext   
         System.out.println(ese.toString()
           + ": Der Stapel ist jetzt leer"); 
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFrame frame = new JFramemitGenericStackfuerInversWort(); 
   }
}
