import java.awt.*;
import javax.swing.*;
public class JFramefuerUserKomponente extends JFrame 
                 implements UserEventundListener.ListenerBlau, 
                              UserEventundListener.ListenerRot {
// Globale Referenz vomTyp der Klasse UserKomponente 
   private UserKomponente c; 
// Ein Panel zur Aufnahme von Kindkomponenten erzeugen 
   private JPanel cPanel = new JPanel();
// Eine Status-Variable als Array vom Typ JLabel definieren
   private JLabel status[] = new JLabel[2];
// Konstruktordefinition 
   public JFramefuerUserKomponente() {
      super("Event-Objekte und Event-Listener");
      setBounds(20,20,600,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Ein Objekt der Klasse UserKomponente erzeugen
      c = new UserKomponente("RotBlau");
// und die Listener für diese Komponente registrieren
      c.addListenerBlau(this); 
      c.addListenerRot(this);
// Den Hintergrund der Komponente darstellen; dadurch dass die 
// Komponenetenklasse keine paint()-Methode überschreibt, 
// wird die update()-Methode des Standard UI-Delegates 
// vom Typ der Klasse LabelUI automatisch aufgerufen
      c.setOpaque(true); 
      cPanel.setLayout(new GridLayout(2,1));
      for(int i=0; i<2; i++) {
         status[i] = new JLabel("Status "+i);
         cPanel.add(status[i]);
      }
// Das Panel und die Komponente im Fenster anzeigen
      Container contentPane = getContentPane();
      contentPane.add(new Label("Komponente anklicken"), 
        BorderLayout.NORTH);
      contentPane.add(c, BorderLayout.CENTER);
      contentPane.add(cPanel, BorderLayout.SOUTH);
      setVisible(true);
   } 
// Die Methoden der Listener implementieren 
   public void selectBlau(UserEventundListener.EventBlau e) {
      int index =e.getComponent().toString().indexOf('[');
      String name =e.getComponent().toString().
        substring(0, index);
      status[0].setText(e.zaehler+". Ereignis vom Typ: "+
        e.getClass().getName()+" von "+name+": "+e.getName()+
          " empfangen");
   }            
   public void selectRot(UserEventundListener.EventRot e) {
      int index =e.getComponent().toString().indexOf('[');
      String name =e.getComponent().toString().
       substring(0, index);
       status[1].setText(e.zaehler+". Ereignis vom Typ: "+
         e.getClass().getName()+" von "+name+": "+e.getName()+
           " empfangen");
   }            
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramefuerUserKomponente frame = 
        new JFramefuerUserKomponente();
   }
}
