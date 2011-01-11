import java.awt.*;
import javax.swing.*;
public class JFramemitGridBagLayout extends JFrame 
                                       implements LabelFarben {
   private static SwingLabel[] label = new SwingLabel[6];
// Konstruktordefinition   	
   public JFramemitGridBagLayout() {
      super("GridBagLayout");
      setBounds(10,50,150,150);
      for(int i=0; i<textLabel.length; i++) {
         label[i] = new SwingLabel(textLabel[i],
           farbeLabel[i]);
      } 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
// Die Constraints für Komponenten definieren
   public void addJLabel(GridBagLayout gbLayout, JLabel l, 
     int fill, int gridX, int gridY, int gridWidth, 
       int gridHeight, double weightX, double weightY) {
      GridBagConstraints gbConstraints = 
        new GridBagConstraints();
// fill bestimmt ob vergrößert werden kann
      gbConstraints.fill = fill;
// gridx und gridy geben die Position links vom bzw. 
// über dem Anzeigebereich an
      gbConstraints.gridx = gridX;
      gbConstraints.gridy = gridY;
// gridwidth und gridheight für die Breite einer Spalte bzw.
// die Höhe einer Zeile in Pixeln 
      gbConstraints.gridwidth = gridWidth;
      gbConstraints.gridheight = gridHeight;
// weightx und weighty geben an, wie der freie Platz 
// horizontal und vertikal verteilt wird 
      gbConstraints.weightx = weightX;
      gbConstraints.weighty = weightY;
// Die Constraints für jede einzelne Komponente setzen
      gbLayout.setConstraints(l, gbConstraints);
// Die Komponente zum Container hinzufügen
      add(l);
   }
// Ein Objekt der Klasse erzeugen und zu diesem die JLabel-
// Komponenten hinzufügen 
   public static void main(String[] args) {
      JFramemitGridBagLayout frame = 
        new JFramemitGridBagLayout();
      GridBagLayout gbLayout = new GridBagLayout(); 
      frame.setLayout(gbLayout); 
      frame.addJLabel(gbLayout,label[0],GridBagConstraints.BOTH,
        0,0,3,1,1.0,1.0);
      frame.addJLabel(gbLayout,label[1],GridBagConstraints.BOTH,
        0,1,2,2,1.0,1.0);
      frame.addJLabel(gbLayout,label[2],GridBagConstraints.BOTH,
        2,1,1,1,1.0,0);
      frame.addJLabel(gbLayout,label[3],GridBagConstraints.BOTH,
        2,2,1,1,0,0);
      frame.addJLabel(gbLayout,label[4],GridBagConstraints.BOTH,
        0,4,3,1,0,0);
      frame.addJLabel(gbLayout,label[5],GridBagConstraints.BOTH,
        0,5,3,1,0,0);
      frame.setVisible(true);
   }
}
