import javax.swing.tree.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class JFramemitLookAndFeelundJTreeAnders extends JFrame 
                  implements ActionListener, TreeModelListener {
// JRadioButton-Komponente f�r die Auswahl des LookAndFeel 
// einrichten; ButtonGroup f�r das Ausschlie�en von RadioButtons
// erzeugen
   private ButtonGroup rbg = new ButtonGroup(); 
   private JRadioButton[] rb = new JRadioButton[6];
   private CustomButton button1 = new CustomButton(
     "CustomButton1");
   private CustomButton1 button2 = new CustomButton1(
     "CustomButton2");
   private JButton button = new JButton("StdButton");
   private JTree tree = new JTree();
   private UIDefaultsTreeModelundLookAndFeel model; 
//Konstruktordefinition
   public JFramemitLookAndFeelundJTreeAnders() {
      super("Standard und benutzerdefiniertes LookAndFeel");
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
      JPanel p = new JPanel();
      button.setBackground(Color.pink);
      Container cPanel = getContentPane();
      cPanel.setBackground(Color.lightGray);
      button1.setBackground(Color.pink);
      button2.setBackground(Color.lightGray);
      p2.setLayout(new FlowLayout());
      p1.setLayout(new FlowLayout());
      p.setLayout(new FlowLayout());
      cPanel.add(button, BorderLayout.WEST);
      cPanel.add(p2, BorderLayout.EAST);
      p2.add(button1);
      p2.add(button2);
      cPanel.add(button, BorderLayout.WEST);
      cPanel.add(p2, BorderLayout.EAST);
      cPanel.add(p, BorderLayout.SOUTH);
// Im System verf�gbare LookAndFeels lesen
      UIManager.LookAndFeelInfo[] plafs =
        UIManager.getInstalledLookAndFeels();
// RadioButton-Eintr�ge mit dem Namen der PLAFs einrichten
      for(int i=0; i<plafs.length; i++) {
         String plafName = plafs[i].getName();
         rb[i] = new JRadioButton(plafName);
         rbg.add(rb[i]);
         rb[i].addActionListener(this);
         p1.add(rb[i]);
      } 
// RadioButton-Eintr�ge mit den benutzerdefinierten LookAndFeels
// einrichten
      rb[4] = new JRadioButton("CustomLookAndFeel");
      rbg.add(rb[4]);
      rb[4].addActionListener(this);
      p.add(rb[4]);
      rb[5] = new JRadioButton("MyLookAndFeel");
      rbg.add(rb[5]);
      rb[5].addActionListener(this);
      p.add(rb[5]);
// Buttons und RadioButtons zu dem Fenster hinzuf�gen
      cPanel.add(p1, BorderLayout.NORTH);
// Modell f�r eine Baumstruktur erzeugen und diese zu einer 
// ScrollPane hinzuf�gen
      model = new UIDefaultsTreeModelundLookAndFeel();
      model.uiDefaultsUpdate(UIManager.getDefaults());
// Den TreeModelListener f�r das Modell registrieren
      model.addTreeModelListener(this);
      tree.setModel(model);      
      JScrollPane jsPane = new JScrollPane(tree);
      add(jsPane,BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600, 250);
      setVisible(true);
   }
// Beim Dr�cken der RadioButtons das entsprechende LookAndFeel 
// setzen
   public void actionPerformed(ActionEvent e) {
      try {
         String sBefehl = e.getActionCommand();
         if(sBefehl.equals("Metal")) { 
            UIManager.setLookAndFeel("javax.swing.plaf."
              + "metal.MetalLookAndFeel");
         }
         else if(sBefehl.equals("CDE/Motif")) { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf."
              + "motif.MotifLookAndFeel");
         }
         else if(sBefehl.equals("Windows")) { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf."
              + "windows.WindowsLookAndFeel");
         }
         else if(sBefehl.equals("Windows Classic")) { 
            UIManager.setLookAndFeel("javax.swing.plaf."
              + "synth.SynthLookAndFeel");
         }
         else if(sBefehl.equals("CustomLookAndFeel")) {
// Benutzerdefiniertes LookAndFeel �ber den Namen der 
// LookAndFeel-Klasse setzen
            UIManager.setLookAndFeel("CustomLookAndFeel");
         }
         else if(sBefehl.equals("MyLookAndFeel")) { 
// Benutzerdefiniertes LookAndFeel �ber ein LookAndFeel-Objekt
// setzen
            UIManager.setLookAndFeel(new MyLookAndFeel());
         }
// Jede JFrame-Komponente soll ihr LookAndFeel �ndern
         SwingUtilities.updateComponentTreeUI(this);
         model.uiDefaultsUpdate(UIManager.getDefaults());
         tree.scrollPathToVisible(new TreePath(model.getRoot()));
      }   
      catch(ClassNotFoundException e1) {
         System.out.println("Die LookAndFeel Klasse konnte nicht"
           + " gefunden werden: "+e1);
      }
      catch(InstantiationException e2) {
         System.out.println("Es kann keine neue Instanz der "
           + "LookAndFeel-Klasse gebildet werden: " + e2);
      }
      catch(IllegalAccessException e3) {
         System.out.println("Der Zugriff auf die LookAndFeel-"
           +"Klasse ist nicht erlaubt: " + e3);
      }
      catch(UnsupportedLookAndFeelException e4) {
         System.out.println("Die darunterliegende Systemplatform"
           + " unterst�tzt das LookAndFeel nicht: " + e4);
      }
   }
// Die Methoden von TreeModelListener implementieren
   public void treeNodesInserted(TreeModelEvent e) {
     System.out.println("Im Modell wurde ein Knoten eingefuegt");
   }
   public void treeNodesChanged(TreeModelEvent e) {
     System.out.println("Im Modell wurde ein Knoten veraendert");
   }
   public void treeNodesRemoved(TreeModelEvent e) {
      System.out.println("Im Model wurde ein Knoten geloescht");
   }   
   public void treeStructureChanged(TreeModelEvent e) {
      System.out.println("Das Modell wurde abgeaendert");
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitLookAndFeelundJTreeAnders frame = 
        new JFramemitLookAndFeelundJTreeAnders();
   }
}
