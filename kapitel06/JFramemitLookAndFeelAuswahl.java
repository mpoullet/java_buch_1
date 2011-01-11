import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
public class JFramemitLookAndFeelAuswahl extends JFrame 
                                    implements ActionListener {  
// Ein Array mit Elementen vom Typ JRadioButton für die Auswahl 
// des LookAndFeel einrichten, und diese zu einer ButtonGroup-
// Komponente zusammenfassen, die ein Ausschließen von Buttons 
// beim Anklicken ermöglicht. 
   private ButtonGroup rbg = new ButtonGroup(); 
   private JRadioButton[] rb = new JRadioButton[4];
// Komponenten für die Anzeige erstellen
   private JButton[] b = new JButton[2];
   private JPanel p = new JPanel();
   private JPanel p1 = new JPanel();
   private Font f = new Font("Times Roman",Font.BOLD,14);
   private ColorIcon[] cIcon = new ColorIcon[2];
   private FontIcon [] fIcon = new FontIcon[4]; 
   private JTree tree;
   private DefaultMutableTreeNode gliederung, stufe1, stufe2, 
     stufe3;
   private Canvas c;
// Konstruktordefinition
   public JFramemitLookAndFeelAuswahl() {
      super("LookAndFeel Auswahl");
      setBounds(15,15,300,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container cPanel = getContentPane();
      p.setLayout(new GridLayout(1,2));
      p1.setLayout(new GridLayout(4,1));
// Wurzel, Knoten und Blätter einer Baumstruktur definieren
      gliederung = new DefaultMutableTreeNode("Gliederung"); 
      for(int i=0; i<2; i++) {
         stufe1 = new DefaultMutableTreeNode(" " + (i+1));
         gliederung.add(stufe1);
         for(int j=0; j<2; j++) {
            stufe2 = new DefaultMutableTreeNode(" " 
              + (i+1)+(j+1));
            stufe1.add(stufe2);
            for(int k=0; k<3; k++) {
               stufe3 = new DefaultMutableTreeNode(" "  
                 + (i+1)+(j+1)+(k+1));
               stufe2.add(stufe3);
            }
         }
      }
// JTree-Komponente erzeugen und zu einer JScrollPane-Komponente 
// hinzufügen
      tree = new JTree(gliederung);
      JScrollPane jsPane = new JScrollPane(tree);
      cPanel.add(jsPane, BorderLayout.CENTER);
// Verfügbare LookAndFeels lesen
      UIManager.LookAndFeelInfo[] plafs = 
        UIManager.getInstalledLookAndFeels();
// RadioButtoneinträge mit dem Namen der PLAF's erstellen 
      for(int i=0; i<plafs.length; i++) {
         String plafName = plafs[i].getName();
         fIcon[i] = new FontIcon(f, plafName);
         rb[i] = new JRadioButton(""+(i+1), fIcon[i], false);
         rbg.add(rb[i]);
         rb[i].addActionListener(this);
         p1.add(rb[i]);
      } 
// Die Buttons und RadioButtons zum Fenster hinzufügen
      cPanel.add(p1, BorderLayout.WEST);
      for(int i=0; i<2; i++) {
         cIcon[i] = new ColorIcon(new Color(i*253,i+200,i+153));
         b[i] = new JButton(cIcon[i]);
         p.add(b[i]);
      }
      cPanel.add(p, BorderLayout.SOUTH);
      setVisible(true);
   } 
// Das asgewählte LookAndFeel setzen
   public void actionPerformed(ActionEvent e) {
      try {
         String sBefehl = e.getActionCommand();
         char[] zahl = sBefehl.toCharArray();
         switch(zahl[0]) {
            case '1':
               UIManager.setLookAndFeel(
                 "javax.swing.plaf.metal.MetalLookAndFeel");
               break;
            case '2':
               UIManager.setLookAndFeel(
                 "com.sun.java.swing.plaf.motif."
                   + "MotifLookAndFeel");
               break;
            case '3': 
               UIManager.setLookAndFeel(
                 "com.sun.java.swing.plaf.windows."
                   + "WindowsLookAndFeel");
               break;
            case '4': 
               UIManager.setLookAndFeel(
                 "javax.swing.plaf.synth.SynthLookAndFeel");
         }
// Jede im Fenster angezeigte Komponente soll ihr LookAndFeel 
// abändern
         SwingUtilities.updateComponentTreeUI(this);
      }   
      catch(Exception ex) {
         System.out.println(ex);
      }
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitLookAndFeelAuswahl frame =  
        new JFramemitLookAndFeelAuswahl();

   }
}
