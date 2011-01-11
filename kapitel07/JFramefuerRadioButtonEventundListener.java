import java.awt.*;
import javax.swing.*;
public class JFramefuerRadioButtonEventundListener 
                                                extends JFrame {
// Globale Referenz vom Typ RadioButtonEventundListener
   private RadioButtonEventundListener rbel;
// Statusmeldungen werden in einer Liste hinterlegt
   private final List status = new List();
// Konstruktordefinition   
   public JFramefuerRadioButtonEventundListener() {
      super("Event-Objekte und Event-Listener");
      setBounds(30,30,300,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      status.setBackground(Color.pink); 
// RadioButtonEventundListener-Objekt erzeugen
      rbel = new RadioButtonEventundListener("RadioButton");
// Den RadioButtonEventListener als anonyme Klassse
// implementieren 
      RadioButtonEventundListener.RadioButtonListener l = 
        new RadioButtonEventundListener.RadioButtonListener() {
         public void eventErzeugt(RadioButtonEventundListener.
           RadioButtonEvent e) {
            status.add("Event vom Typ: "+ e.getTyp()
              +" umgesetzt"); 
         }   
      };
// Den RadioButtonEventListener registrieren
      rbel.addRadioButtonListener(l);
// Die Komponenten zum Fenster hinzufügen
      Container contentPane = getContentPane();
      contentPane.add(new 
        Label("Aktionen mit dem RadioButton durchfuehren"), 
          BorderLayout.NORTH);
      contentPane.add(status, BorderLayout.CENTER);
      contentPane.add(rbel, BorderLayout.SOUTH);
      setVisible(true);   
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramefuerRadioButtonEventundListener frame = 
        new JFramefuerRadioButtonEventundListener();
   }
}
