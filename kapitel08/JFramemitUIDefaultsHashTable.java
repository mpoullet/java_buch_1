import java.awt.*;
import javax.swing.*;
import java.util.*;
public class JFramemitUIDefaultsHashTable extends JFrame {
   private JButton [][]button  = new JButton[3][3];
   private JPanel panel = new JPanel();
// Konstruktordefinition 
   public JFramemitUIDefaultsHashTable() {
      super("UIDefaults Setzen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(int i=0; i<3; i++) {
         for(int j=0; j<3; j++) {
            button[i][j] = new JButton("Button"+i+j);
            button[i][j].setForeground(new Color(100*j,255,i));
            button[i][j].setBackground(new Color(j,100*i,255));
            panel.add(button[i][j]);
         }
      }
      getContentPane().add (panel);
      pack();
      setVisible(true);
   }
   public static void main (String[] args) {
// Den Namen der Schrift aus dem im Programmaufruf übergebenen 
// Argument lesen und damit eine 10-Point und PLAIN Font-Instanz 
// erzeugen
      Font font = new Font (args[0], Font.PLAIN, 10);
// Der Name der neuen Schrift wird für alle Swing-Komponenten 
// in die UIDefaults-Tabelle eingetragen
      Hashtable<Object,Object> defaults = UIManager.getDefaults();
      Enumeration<Object> keys = defaults.keys();
      while(keys.hasMoreElements()) {
         Object object = keys.nextElement();
         if((object instanceof String) && (((String) object).
           endsWith(".font"))) {
            defaults.put(object, font);
         }
      }
// Objekt der Klasse erzeugen
      JFramemitUIDefaultsHashTable frame = 
        new JFramemitUIDefaultsHashTable(); 
   }
}
