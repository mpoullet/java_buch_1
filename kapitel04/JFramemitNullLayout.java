import java.awt.*;
import javax.swing.*;
public class JFramemitNullLayout extends JFrame 
                                       implements LabelFarben {
   private static JLabel[] label = new JLabel[6];
   private int x = 0;
   private int y = 0;
// Konstruktordefinition
   public JFramemitNullLayout() {
      super("JFrame mit Null-Layout");
      setBounds(30,15,300,150);
// Layout auf null setzen
      setLayout(null); 
// Labels an bestimmten Positionen und mit beseimmter Größe
// hinzufügen
      for(int i=0; i<textLabel.length; i++) {
         label[i] = createJLabel(textLabel[i], farbeLabel[i],
           x, y, 50, 20);
         add(label[i]);
         x = x+50;
         y = y+20;
      } 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   public JLabel createJLabel(String text, Color farbe, int x, 
                              int y, int breite, int höhe) {
// Eine JLabel-Komponente erzeugen
      JLabel label = new JLabel(text);
// Ihren Text in der Mitte positionieren
      label.setHorizontalAlignment(JLabel.CENTER);
// Die Komponente undurchsichtig setzen
      label.setOpaque(true);
// Position und Größe der Komponente bestimmen 
      label.setBounds(x,y,breite,höhe);
// Farbe und Rand der Komponente bestimmen
      label.setBackground(farbe);
      label.setForeground(Color.black);
      label.setBorder(BorderFactory.createLineBorder(
        Color.black));
      return label;
   }
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitNullLayout frame = new JFramemitNullLayout();
   }   
}
