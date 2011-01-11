import java.awt.*;
import javax.swing.*;
public class JFramemitUIDefaultsLesen extends JFrame {
   private JButton [][]button  = new JButton[3][3];
   private JPanel panel = new JPanel();
   private static Color buttonForeground, buttonBackground;
   private static float[] foregroundKomponenten, 
  backgroundKomponenten;
   private float[] colorForegroundKomponenten = new float[3];
   private float[] colorBackgroundKomponenten = new float[3];
// statische Initialisierung
   static {
      UIDefaults ui = UIManager.getDefaults();
      buttonForeground = ui.getColor("Button.foreground");
      buttonBackground = ui.getColor("Button.background");
      foregroundKomponenten =  
        buttonForeground.getRGBColorComponents(null);
      backgroundKomponenten =  
        buttonBackground.getRGBColorComponents(null);
   }
// Konstruktordefinition 
   public JFramemitUIDefaultsLesen() {
      super("UIDefaults Lesen");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(int i=0; i<3; i++) {
         for(int j=0; j<3; j++) {
// forground- und background-Eigenschaften generieren
            colorForegroundKomponenten[i] =
            foregroundKomponenten[i]*(Math.round(Math.random())); 
            colorBackgroundKomponenten[j] = 
            backgroundKomponenten[j]*(Math.round(Math.random()));
            button[i][j] = new JButton("Button"+(i+j));
            button[i][j].setForeground(new Color(
            colorForegroundKomponenten[0],
            colorForegroundKomponenten[1], 
            colorForegroundKomponenten[2]));
// und für JButton-Komponenten setzen
            button[i][j].setBackground(new Color(
              colorBackgroundKomponenten[0],
                colorBackgroundKomponenten[1],
                  colorBackgroundKomponenten[2]));
            panel.add(button[i][j]);
         }
      }
      getContentPane().add(panel);
      pack();
      setVisible(true);
   }
// Objekt der Klasse erzeugen
   public static void main (String[] args) {
      JFramemitUIDefaultsLesen frame = 
        new JFramemitUIDefaultsLesen(); 
   }
}
