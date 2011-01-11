import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MalenmitderMaus extends JFrame 
                    implements FarbeundSchrift, ActionListener {
   private Font[] schrift = new Font[6];
   private JLabel status;
   private LabelmitMouseEvent schreibflaeche = 
     new LabelmitMouseEvent();
   private CanvasmitMouseEvent malflaeche = 
     new CanvasmitMouseEvent();
   private JButton[] bColor = new JButton[6];
   private JButton[] bFont = new JButton[6];  
// Konstruktordefinition 
   public MalenmitderMaus() {
      super("Malen und Schreiben auf eine Zeichenfläche");
      setBounds(40,40,300,250);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Layout-Definitionen 
      JPanel contentPane = new JPanel(); 
      JPanel contentPane1 = new JPanel();
      JPanel contentPane2 = new JPanel();
      contentPane.setLayout(new BorderLayout());
      contentPane1.setLayout(new GridLayout(1,3));
      contentPane2.setLayout(new GridLayout(2,1));
      contentPane1.add(new JLabel("Schrift"));
      contentPane1.add(new JLabel("Farbe"));
      contentPane1.add(new JLabel("Malen mit der Maus"));
      contentPane.add(contentPane1, BorderLayout.NORTH);
      malflaeche.setBackground(Color.pink);
      malflaeche.setSize(100,100);
      schreibflaeche.setBackground(Color.pink);
      schreibflaeche.setSize(100,100);
      contentPane2.add(malflaeche);
      schreibflaeche.setBorder(BorderFactory.createTitledBorder(
        "Schreibfläche anklicken"));
// Anzeigen der Hintergrundfarbe für die JLabel-Komponente
      schreibflaeche.setOpaque(true); 
      contentPane2.add(schreibflaeche);
      contentPane.add(contentPane2, BorderLayout.EAST);
// Eine Statuszeile zur Prüfung der Funktionalität von JToolBar- 
// Komponenten wird mit Hilfe einer JLabel-Komponente 
// eingerichtet
      status = new JLabel(" ");
      contentPane.add(status, BorderLayout.SOUTH);
// JButton-Objekte zur Benutzung in Toolbars erzeugen 
      for(int i=0; i<6; i++) {
         bColor[i] = new JButton(nameFarbe[i]);
         bColor[i].addActionListener(this);
         bColor[i].setBackground(farbe[i]);
      }
      for(int i=0; i<6; i++) {
         schrift[i] = new Font(nameSchrift[i], Font.BOLD, 24);
         bFont[i] = new JButton(nameSchrift[i]);
         bFont[i].setBackground(Color.pink);
         bFont[i].addActionListener(this);
      }
// JToolbar-Objekte erzeugen und ihnen die JButton-Objekte 
// zuordnen
      JToolBar toolbar1 = new JToolBar("Schrift");
      for(int i=0; i<6; i++)
         toolbar1.add(bFont[i]); 
      toolbar1.setOrientation(SwingConstants.VERTICAL);
      contentPane.add(toolbar1, BorderLayout.WEST);
      JToolBar toolbar2 = new JToolBar("Farbe");
      for(int i=0; i<6; i++)
         toolbar2.add(bColor[i]); 
      toolbar2.setOrientation(SwingConstants.VERTICAL);
      contentPane.add(toolbar2, BorderLayout.CENTER);
      setContentPane(contentPane);
      setVisible(true);
   } 
// Die Methode des Interface implementieren
   public void actionPerformed(ActionEvent ae) {      
// Welcher Button wurde gedrueckt??
      String sBefehl = ae.getActionCommand();
      for(int i=0; i<6; i++) {
         if(sBefehl.equals(nameSchrift[i])) { 
            status.setText("Schrift geändert: " + 
              schrift[i].getName());
// Schrift setzen
            schreibflaeche.defSchrift(schrift[i]);
         }
      } 
      for(int i=0; i<6; i++) {
         if(sBefehl.equals(nameFarbe[i])) { 
            status.setText("Farbe geändert: "+ nameFarbe[i]);
// Farbe setzen
            malflaeche.defFarbe(farbe[i]);
            schreibflaeche.defFarbe(farbe[i]);
         }
      } 
   }   
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      MalenmitderMaus frame = new MalenmitderMaus();
   }
}   
